package DBBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import Beans.itemBean;

public class MngrDBBean {
	// MngrDBBean ���� ��ü ���� <- �Ѱ��� ��ü�� �����ؼ� ����
	private static MngrDBBean instance = new MngrDBBean();

	// MngrDBBean��ü�� �����ϴ� �޼ҵ�
	public static MngrDBBean getInstance() {
		return instance;
	}

	private MngrDBBean() {
	}

	// Ŀ�ؼ� Ǯ���� Ŀ�ؼ� ��ü�� ���� �޼ҵ�

	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/jsptest");

		return ds.getConnection();
	}

	// ��ǰ ��� �޼ҵ�
	public void insertItem(itemBean item) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			
			conn = getConnection();
			String sql = "insert into item(item_code,title,price,remain,image,content) values(NO_SEQ.NEXTVAL,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, item.getName());
			pstmt.setString(2, item.getPrice());
			pstmt.setString(3, item.getRemain());
			pstmt.setString(4, item.getDtail_pic());
			pstmt.setString(5, item.getDscript());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}

	// ��ϵ� ��ǰ ����

	public int registedItemconfirm(String item_code) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		try {
			conn = getConnection();

			String sql = "select item_code from item where item_code=?";
			pstmt.executeQuery();

			if (rs.next())
				x = 1; // ���� ��ϵ�����
			else
				x = -1; // ��� �Ǿ����� ����
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	// ��ü ��ϵ� ��ǰ�� ���� ���� �޼ҵ�
	public int getItemCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from item");
			rs = pstmt.executeQuery();

			if (rs.next())
				x = rs.getInt(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	// ��ǰ �̸� ���� �޼ҵ�
	public String getItemName(String item_code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String x = "";

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select item_name from item where item_code = " + item_code);
			rs = pstmt.executeQuery();

			if (rs.next())
				x = rs.getString(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	// �ش� ������ �ڵ�� ��ǰ�� ������ ����
	// ��ǰ ������ ���� ���������� �о���̴� �޼ҵ�
	public itemBean getItem(String item_code) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		itemBean item = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from item where item_code = ?");
			pstmt.setString(1, item_code);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				item = new itemBean();

				item.setItem_code(rs.getString("item_code"));
				item.setName(rs.getString("name"));
				item.setThum_pic(rs.getString("thum_pic"));
				item.setDtail_pic(rs.getString("dtail_pic"));
				item.setPrice(rs.getString("price"));
				item.setRemain(rs.getString("remain"));
				item.setStart_time(rs.getString("start_time"));
				item.setEnd_time(rs.getString("end_time"));
				item.setDscript(rs.getString("dscript"));

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return item;
	}

	// ��ǰ ���� �ϴ� �޼ҵ�
	public void updateItem(itemBean item, String item_code) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql;

		try {
			conn = getConnection();

			sql = "update item set item_code=?,name=?,thum_pic=?,dtail_pic=?,price=?,remain=?,start_time=?,end_time=?,dscript=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, item.getItem_code());
			pstmt.setString(2, item.getName());
			pstmt.setString(3, item.getThum_pic());
			pstmt.setString(4, item.getDtail_pic());
			pstmt.setString(5, item.getPrice());
			pstmt.setString(6, item.getRemain());
			pstmt.setString(7, item.getStart_time());
			pstmt.setString(8, item.getEnd_time());
			pstmt.setString(9, item.getDscript());

			pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}

	// ��ǰ ����
	public void deleteItem(String item_code) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("delete from item where item_code=?");
			pstmt.setString(1, item_code);

			pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}
}
