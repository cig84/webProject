package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class ServletErrores
 */

public class ServletErrores extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getRootLogger();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletErrores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception");
		String nombreServlet = (String) request.getAttribute("javax.servlet.error.servlet_name");
		if(exception != null){
			log.info(exception + " ha ocurrido en " + nombreServlet);
		}
		else {
			log.info("Ha ocurrido una exception, pero no en el servlet");
		}
		response.sendRedirect("/WebProject/error.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
