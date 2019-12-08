package DBBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import Beans.LoginBean;

public class LoginDBBean {
	private static LoginDBBean instance = new LoginDBBean();
	
	public static LoginDBBean getInstance(){
		return instance;
	}
	
	private LoginDBBean() {}
	
	private Connection getConnection() throws Exception {
	
		
		
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
		
		return ds.getConnection();	
	}
	
	public int idcheck(String id, String pass) {
		int check = -1;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			// 1단계 드라이버 로드
			// 2단계 db연결 => Connection con 객체 저장
			con = getConnection();

			// 3단계 sql id에 해당하는 pass 가져오기
			String sql = "select pass from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			// 4단계 rs=실행결과 저장
			rs = pstmt.executeQuery();

			// 5단계 rs첫행이동 데이터있으면"아이디있음"
			// 비밀번호맞음 check=1
			// 틀리면 check=0;
			// 없으면 아이디없음 check=-1
			if (rs.next()) {
				// 아이디있음
				if (pass.equals(rs.getString("pass"))) {
					// 로그인 성공
					check = 1;
				} else {
					// 비밀번호 틀림
					check = 0;
				}
			} else {
				// 아이디없음.
				// check=-1; //초기 설정과 같으므로 생략가능.
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 객체닫기
			// 객체생성 닫기(기억장소를 회수하는 작업)
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
	}// 아이디비밀번호체크메서드끝

	
	// ---------------------------------------
	public MemberBean getMember(String a) {
		MemberBean mb = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1단계 드라이버 로드
			// 2단계 db연결 => Connection con 객체 저장
			con = getConnection();

			// 3단계 sql id에 해당하는 pass 가져오기
			String sql = "select * from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, a);

			// 4단계 rs=실행결과 저장
			rs = pstmt.executeQuery();

			if (rs.next()) {
				mb = new LoginBean();
				mb.setId(rs.getString("id"));
				mb.setPass(rs.getString("pass"));
				mb.setName(rs.getString("name"));
				mb.setReg_date(rs.getTimestamp("reg_date"));
				mb.setAge(rs.getInt("age"));
				mb.setGender(rs.getString("gender"));
				mb.setEmail(rs.getString("email"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 객체닫기
			// 객체생성 닫기(기억장소를 회수하는 작업)
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
		return mb;
	}// getmember

	// --------------------------------------------

	public int updateMember(MemberBean mb) {
		// check==1이면 수정성공. main.jsp로 이동.
		// check==0이면 비밀번호 틀림. 뒤로 이동.
		// check==-1이면 아이디없음. 뒤로 이동.
		int check = -1;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			// 1단계 드라이버 로드
			// 2단계 db연결 => Connection con 객체 저장
			con = getConnection();

			// 3단계 sql id에 해당하는 pass 가져오기

			// 4단계 rs=실행결과 저장

			// 5단계 rs 첫행으로 이동 데이터 있으면 "아이디있음"
			// 비밀번호 비교 맞으면 CHECK=1
			// //3 sql 생성 id 해당하는 name, age, gender, email 수정
			// 4 실행

			String sql = "select pass from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb.getId());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (!mb.getPass().equals("")) {
					// 비밀번호 null check 코드가 길어진다.
					// 프론트에서 null값을 제어해주는 것이 좋다.
					// System.out.println("1" + mb.getPass());
					// System.out.println("2" +
					// rs.getString("pass"));//rs.next()가 없으면 값이 안나옴.
					if (mb.getPass().equals(rs.getString("pass"))) {
						sql = "update member set name=?,age=?,gender=?,email=? where id=?";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, mb.getName());
						pstmt.setInt(2, mb.getAge());
						pstmt.setString(3, mb.getGender());
						pstmt.setString(4, mb.getEmail());
						pstmt.setString(5, mb.getId());

						pstmt.executeUpdate();

						check = 1;
					}
				} else {
					check = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 객체닫기
			// 객체생성 닫기(기억장소를 회수하는 작업)
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
	}// updatemember

	public int deleteMember(String id, String pass) {
		int check = 9;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LoginBean mb = new LoginBean();

		try {

			con = getConnection();
			String sql = "select pass from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (pass.equals(rs.getString("pass"))) {
					sql = "delete from member where id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					check = 1;
				} else {
					// 비밀번호 없음
					check = 0;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 객체닫기
			// 객체생성 닫기(기억장소를 회수하는 작업)
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
	}// deletemember

	public List getMemberList() {
		// 배열(컬렉션) 객체 생성 - 여러개의 기억공간 사용+기억공간추가해서 사용
		List memberList = new ArrayList();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			String sql = "select * from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 배열객체 생성

			while (rs.next()) {
				LoginBean mb = new LoginBean();
				mb.setId(rs.getString("id"));
				mb.setPass(rs.getString("pass"));
				mb.setName(rs.getString("name"));
				mb.setReg_date(rs.getTimestamp("reg_date"));
				mb.setAge(rs.getInt("age"));
				mb.setGender(rs.getString("gender"));
				mb.setEmail(rs.getString("email"));
				memberList.add(mb);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 객체닫기
			// 객체생성 닫기(기억장소를 회수하는 작업)
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
		return memberList;
	}// getmemberlist

}

