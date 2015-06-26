package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.group.interceptors.TwoPhaseCommitInterceptor.MapEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class SesionesActivas
 */
public class SesionesActivas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getRootLogger();
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SesionesActivas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		ServletContext sc = getServletContext();
		HashMap<String, HttpServlet> sesMap = (HashMap<String, HttpServlet>) sc.getAttribute("SessionsMap");
		Iterator it = sesMap.entrySet().iterator();
		Map.Entry<String, HttpServlet> e = null;
		while(it.hasNext()){
			e = (Entry<String, HttpServlet>) it.next();
			log.info("La sesión " + e.getValue() + " con id " + e.getKey() + " está asociada al usuario " + request.getSession().getAttribute("nombre"));
			pw.println("La sesión " + e.getValue() + " con id " + e.getKey() + " está asociada al usuario " + request.getSession().getAttribute("nombre"));
		}
		if (sesMap.isEmpty()){
			log.info("No hay sesiones activas");
			pw.println("No hay sesiones activas");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
