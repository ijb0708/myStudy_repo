package Actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.memberBean;
import DBBeans.LoginDBBean;


public class registerAction implements Action {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");

		memberBean member = new memberBean();

		member.setId(request.getParameter("id"));
		member.setPwd(request.getParameter("pwd"));
		member.setEmail(request.getParameter("email"));
		member.setHp(request.getParameter("tel"));
		member.setScial_num(request.getParameter("scial_num"));
		member.setName(request.getParameter("name"));
		member.setAddress(request.getParameter("address"));
		
		LoginDBBean dbPro = LoginDBBean.getInstance();
		dbPro.insertMember(member);
		
		
		
		return "contents/mainContent.jsp";
		

	}

}
