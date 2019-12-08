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
			String pass = member.getPasswd();
			
			pstmt = conn.prepareStatement("insert into member values()");
		}catch(Exception e){
			e.printStackTrace();
			
		}
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
			String sql = "select pwd, isman from member where id=?";
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
				if (pass.equals(rs.getString("pwd"))) {
					// 로그인 성공
					check = 1;
					if(rs.getString("isman").equals("o")) {
						return 2;
					}
					if(rs.getString("isman").equals("x")) {
						return 1;
					}	
				} else {
					// 비밀번호 틀림
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
	}// 아이디비밀번호체크메서드끝
	
	
	//아이디에 해당하는 회원정보 얻어내기
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
				member.setHp(rs.getInt("hp"));
				member.setIsman(rs.getString("isman"));
				member.setScial_num(rs.getInt("scial_num"));

			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			  if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return member;//데이터 저장빈 객체 member 리턴
	}
	
	//회원정보 수정 처리
	
	public int updateMember(memberBean member) {
		 Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs= null;
	        int x=-1;
	        try {
	        	conn = getConnection();
	        	
	        	String pass = member.getPasswd();
	        	
	        	pstmt = conn.prepareStatement("select pwd from member where id = ?");
	        	pstmt.setString(1, member.getId());
	        	rs=pstmt.executeQuery();
	        	
	        	if(rs.next()) {
	        		String dbpasswd = rs.getString("pwd");
	        		if(pass.equals(dbpasswd)) {
	        			pstmt = conn.prepareStatement("update member set pwd = ?,address=?,hp=? where id=?");
	        			 pstmt.setString(1, member.getPasswd());
	                     pstmt.setString(2, member.getAddress());
	                     pstmt.setInt(3, member.getHp());
	                     pstmt.setString(4, member.getId());
	                     pstmt.executeUpdate();
	                     x= 1;//회원정보 수정 처리 성공
	        		}else
						x= 0;//회원정보 수정 처리 실패
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

