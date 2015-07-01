package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.result.NoMoreReturnsException;

/**
 * Servlet implementation class ServletCookie
 */

public class ServletCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getRootLogger();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Cookie ck = hayCookie(request, "nVeces");
		int veces = Integer.parseInt(ck.getValue());
    	if(veces<2){
    		veces++;
        	String val = String.valueOf(veces);
        	ck.setValue(val);
        	log.info(ck.getName() + " " + ck.getValue());
        	out.println(ck.getName() + " " + ck.getValue());
    		response.addCookie(ck);
    	}
    	else {
    		ck.setMaxAge(0);
    		log.info("La cookie " + ck.getName() + " ha sido borrada");
    		response.addCookie(ck);
    		response.sendRedirect("errorCookie.html");
    	}
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private Cookie hayCookie(HttpServletRequest request, String nombreCookie) {
		
		Cookie[] cookies = request.getCookies();
		Cookie ck = null;
		String nombreCk = nombreCookie;
		boolean encondtrada = false;
		int pos = 0;
		if(cookies != null){
			for(int i = 0; i < cookies.length; i++) {
				ck = cookies[i];
				if(! ck.getName().equals(nombreCk)) {
					ck = new Cookie(nombreCk,"0");
//					ck.setMaxAge(60*60*24);
				}
			}
		}
		else {
			ck = new Cookie(nombreCk,"0");
//			ck.setMaxAge(60*60*24);
		}
		
		return ck;
	
	}

}
