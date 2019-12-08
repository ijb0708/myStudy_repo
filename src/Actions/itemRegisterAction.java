package Actions;

import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Beans.itemBean;
import Beans.memberBean;
import DBBeans.LoginDBBean;

public class itemRegisterAction implements Action{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String filename="";
		String realFolder ="";
		String saveFolder ="/img";
		String encType ="utf-8";
		int maxSize = 1*1024*1024;
		
		MultipartRequest img = null;
		
		ServletContext context = request.getSession().getServletContext();
		realFolder = context.getRealPath(saveFolder);
		try {
			img = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
			Enumeration<?> files = img.getFileNames();
			
			while(files.hasMoreElements()) {
				String name = (String)files.nextElement();
				
				filename = img.getFilesystemName(name);
			}}catch(Exception e) {
				e.printStackTrace();
			}
			
		
		
		itemBean item = new itemBean();
		
		item.setName(request.getParameter("title"));
		item.setPrice(request.getParameter("price"));
		item.setRemain(request.getParameter("remain"));
		item.setDscript(request.getParameter("dscript"));
	
		
		
		
		return "contents/mainContent.jsp";
		
		
	

	}

}
