package Actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBBeans.LoginDBBean;

public class loginAction implements Action{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		LoginDBBean dbbean = LoginDBBean.getInstance();
		int check = dbbean.idcheck(id,pass);
		
		System.out.println(check);
		
		return null;
	}

}
