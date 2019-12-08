package DBBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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

}

