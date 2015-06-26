package servlet;

import hibernate.clasesDAO.SessionManager;
import hibernate.dataBaseHR.Departments;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

/**
 * Servlet implementation class ListaDepartamentos
 */

public class ListaDepartamentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getRootLogger();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaDepartamentos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Session sesion = SessionManager.obtenerSession();
		List<Departments> ld = sesion.createSQLQuery("Select * from departments").addEntity(Departments.class).list();
		Departments dep = null;
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<select>");
		Iterator it = ld.iterator(); 
		while(it.hasNext()){
			dep = (Departments) it.next();
			pw.println("<option value = " + dep.getDepartmentId() + "> " + dep.getDepartmentName() + "</option>");
		}
		pw.println("</select>");
		RequestDispatcher rd = request.getRequestDispatcher("/SesionesActivas");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
