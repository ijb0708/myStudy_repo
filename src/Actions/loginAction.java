package Actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBBeans.LoginDBBean;

public class loginAction implements Action{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pwd");
		
		LoginDBBean dbbean = LoginDBBean.getInstance();
		int check = dbbean.idcheck(id,pass);
		System.out.println(check);
		System.out.println(id);
		System.out.println(pass);
		
		if(check==2) {
			request.setAttribute("isMan", true);
			return "/jsp_test/contents/mainContent.jsp";
		}else if(check==1) {
			request.setAttribute("isMan", false);
			return "/jsp_test/contents/mainContent.jsp";
		}else {
			return "/jsp_test/logins/loginForm.jsp";
		}
	}

}
