package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class ServletRedirección
 */

public class ServletRedireccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getRootLogger();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRedireccion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext sc = request.getServletContext();
		String uri = (String) sc.getAttribute("uri");
		if(uri.contentEquals("/WebProject/ServletAutenticacion") || uri.contentEquals("/WebProject/")){
			response.sendRedirect("/WebProject/menu.html");
		}
		else response.sendRedirect(uri);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
