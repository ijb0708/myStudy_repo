package Actions;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Beans.itemBean;

public class itemRegisterAction implements Action{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		String realPath ="";
		String savePath ="/img";
		String encType ="utf-8";
		int maxSize = 1*1024*1024;
		
		MultipartRequest img = null;
		
		ServletContext context = request.getSession().getServletContext();
		
		try {
			img = new MultipartRequest(request, realPath, maxSize, encType, new DefaultFileRenamePolicy());
			
		}
		
		itemBean item = new itemBean();
		item.setName(request.getParameter(""));
		item.setThum_pic(request.getParameter(""));
		item.setDtail_pic("");
		item.setPrice(Integer.parseInt(request.getParameter("")));
		return "contents/mainContent.jsp";
	}

}
