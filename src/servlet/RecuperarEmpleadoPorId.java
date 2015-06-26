package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class RecuperarEmpleadoPorId
 */

public class RecuperarEmpleadoPorId extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getRootLogger();
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperarEmpleadoPorId() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Las lineas seguidas por //*** son el codigo para utilizar las clases del 
		 * paquete jdbc que tiene ya los metodos para la conección y la consulta y 
		 * la clase EmpleadoDTO para guardar un registro de la tabla Employees */
		
		Connection cx = null;
		Statement st = null; 
		ResultSet rset = null; 
		PrintWriter out = null;
		String id = request.getParameter("Id"); //***
//		int foo = Integer.parseInt(id); //***
		
		try {
		cx = Pool.getConnection();
		st = cx.createStatement();
		rset = st.executeQuery("Select * from Employees where employee_id = " + id);
		String nombre = null;
		String apellido = null;
//		EmpleadoDTO emp = new EmpleadoDTO(); //***
//		BaseDatos base = new BaseDatos(); //***
//		emp = base.leerEmpleado(foo); //***
		if (rset.next()){
			nombre = rset.getString("first_name");
			apellido = rset.getString("last_name");
			log.info("Empleado " + nombre + " " + apellido + " recuperado");
		}
		else {
			log.info("No existe un empleado con este id");
			nombre = "No existe un empleado con este id";
		}
		response.setContentType("text/html"); //***
		out = response.getWriter(); //***
//		out.println(emp.toString()); //***
		out.println(nombre + " " + apellido);
		}
		catch(Exception e) {
			e.printStackTrace();
			log.error("Error en el hacer la consulta a la base de datos");
			out.println("Error en el hacer la consulta a la base de datos");
		}
		finally {
			Pool.liberarRecursos(cx, st, rset);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
