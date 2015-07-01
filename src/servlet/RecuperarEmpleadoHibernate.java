package servlet;

import hibernate.clasesDAO.EmployeesDAO;
import hibernate.dataBaseHR.Employees;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import principale.EmployeesService;
import principale.InterfazRecuperable;
import java.lang.Integer;




/**
 * Servlet implementation class recuperarEmpleadoHibernate
 */

public class RecuperarEmpleadoHibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getRootLogger();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperarEmpleadoHibernate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeesService empSer = new EmployeesService();
		InterfazRecuperable oHiber = new EmployeesDAO();
		empSer.setObj(oHiber);
		String id = null;
		
		ServletContext sc = request.getServletContext();
		SessionFactory sf = (SessionFactory) sc.getAttribute("sf");
//		Session ses = sf.openSession();
//		log.info("La sesión está abierta");
//		ses.close();
//		log.info("La sesión está cerrada");
		
		try{
			id = request.getParameter("Id");	
			int foo = Integer.parseInt(id);
			Employees emp = (Employees) empSer.leerEmpleado(foo);
			response.setContentType("text/html");
			log.info("Empleado " + emp +" recuperado");
			PrintWriter out = null;
			out = response.getWriter();
			out.println(emp.toString());
		}
		catch(Exception e){
			e.printStackTrace();
			log.error("Error en el hacer la consulta a la base de datos");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
