package Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Actions.Action;


/**
 * Servlet implementation class WebController
 */
@WebServlet(
		urlPatterns = { 
				"/WebController", 
				"*.do"
		}, 
		initParams = { 
				@WebInitParam(name = "propertyConfig", value = "webMapping.properties")
		})

public class WebController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> commandMap = new HashMap<String, Object>();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		String props = config.getInitParameter("propertyConfig");
		String realFolder = "/property"; 
		ServletContext context = config.getServletContext();
		String realPath = context.getRealPath(realFolder) +File.separator+props;
							    
		Properties pr = new Properties();
		FileInputStream f = null;
		try{
			f = new FileInputStream(realPath); 
			pr.load(f);	
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (f != null) try { f.close(); } catch(IOException ex) {}
		}
		Iterator<?> keyIter = pr.keySet().iterator();
		while( keyIter.hasNext() ) {
			String command = (String)keyIter.next();
			String className = pr.getProperty(command);
			try{
				Class<?> commandClass = Class.forName(className);
				Object commandInstance = commandClass.getDeclaredConstructor().newInstance();
				commandMap.put(command, commandInstance);
			}catch (ClassNotFoundException|NoSuchMethodException|InvocationTargetException e) {
				e.printStackTrace();
			}catch (InstantiationException|IllegalAccessException e) {
				e.printStackTrace();
			}
		}	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}
	
	private void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String view = null;
		Action action=null;
		try {
			String command = request.getRequestURI();
	        if(command.indexOf(request.getContextPath()) == 0) 
	           command = command.substring(request.getContextPath().length());
	        action = (Action)commandMap.get(command);  
	        if(action == null) {
	        	action = (Action) commandMap.get("/main.do");
	        }
	        view = action.requestProcess(request, response);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		request.setAttribute("page", view);
	    RequestDispatcher dispatcher = 
	       request.getRequestDispatcher("/layout.jsp");
		dispatcher.forward(request, response);
	}
}
