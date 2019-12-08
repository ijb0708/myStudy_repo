package DBBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import Beans.memberBean;

public class LoginDBBean {
	private static LoginDBBean instance = new LoginDBBean();
	
	public static LoginDBBean getInstance(){
		return instance;
	}
	
	private LoginDBBean() {}
	
	private Connection getConnection() throws Exception {
	
		
		
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/test");
		
		return ds.getConnection();	
	}
	
	public void insertMember(memberBean member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String pass = member.getPwd();
			
			pstmt = conn.prepareStatement("insert into member values (?,?,?,?,?,?,?,?)");
		
			System.out.println("ab");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getHp());
			pstmt.setString(5, member.getName());
			pstmt.setString(6, member.getScial_num());
            pstmt.setString(7, "x");
			pstmt.setString(8, member.getAddress());
			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
	}
	
	public int idcheck(String id, String pass) {
		int check = -1;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = getConnection();

			String sql = "select pwd, isman from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (pass.equals(rs.getString("pwd"))) {
					check = 1;
					if(rs.getString("isman").equals("o")) {
						return 2;
					}
					if(rs.getString("isman").equals("x")) {
						return 1;
					}	
				} else {
					check = 0;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			}
			if (con != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			}

		}
		return check;
	}
	
	
	public memberBean getMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		memberBean member = null;
		
		try {
			conn = getConnection();
			
			pstmt=conn.prepareStatement("select * from member where id= ?");
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member = new memberBean();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setHp(rs.getString("hp"));
				member.setIsMan(rs.getString("isman"));
				member.setScial_num(rs.getString("scial_num"));

			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			  if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return member;
	}
	
	
	public int updateMember(memberBean member) {
		 Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs= null;
	        int x=-1;
	        try {
	        	conn = getConnection();
	        	
	        	String pass = member.getPwd();
	        	
	        	pstmt = conn.prepareStatement("select pwd from member where id = ?");
	        	pstmt.setString(1, member.getId());
	        	rs=pstmt.executeQuery();
	        	
	        	if(rs.next()) {
	        		String dbpasswd = rs.getString("pwd");
	        		if(pass.equals(dbpasswd)) {
	        			pstmt = conn.prepareStatement("update member set pwd = ?,address=?,hp=? where id=?");
	        			 pstmt.setString(1, member.getPwd());
	                     pstmt.setString(2, member.getAddress());
	                     pstmt.setString(3, member.getHp());
	                     pstmt.setString(4, member.getId());
	                     pstmt.executeUpdate();
	                     x= 1;
	        		}else
						x= 0;
	        	}
	        	}catch(Exception ex) {
	                ex.printStackTrace();
	            } finally {
	            	if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	                if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	                if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	            }
	            return x;
	        
	}
	
}

