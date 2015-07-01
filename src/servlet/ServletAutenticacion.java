package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class Autenticacion
 */
public class ServletAutenticacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogManager.getRootLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAutenticacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext sc = request.getServletContext();
		Connection cx = null;
		Statement st = null; 
		ResultSet rset = null; 
		PrintWriter out = null;
		String UserName = request.getParameter("User_Name");
		String UserPassword = request.getParameter("User_Pass");
		response.setContentType("text/html");
		out = response.getWriter();
		HttpSession ses = request.getSession(false);
		if(ses == null){
			try {			
				cx = Pool.getConnection();
				st = cx.createStatement();
				rset = st.executeQuery("Select * from Users where user_name = '" + UserName + "'");
				if (rset.next()){
					String psw = rset.getString("user_pass");
					String nombre = rset.getString("user_name");
					if (UserPassword.equals(psw)){
						ses = request.getSession();
						ses.setAttribute("nombre", nombre);
						log.info("Bienvenido " + ses.getAttribute("nombre"));
						out.println("Bienvenido " + ses.getAttribute("nombre"));
						log.info("La sesi�n con id " + request.getSession().getId() + " est� asociada al usuario " + ses.getAttribute("nombre"));
						out.println("La sesi�n con id " + request.getSession().getId() + " est� asociada al usuario " + ses.getAttribute("nombre"));
						out.println("\n Gracias por logearse, dentro de poco ser� redirigido al men� principal");
						response.setHeader("Refresh", "5; URL=/WebProject/ServletRedireccion");
//						response.sendRedirect("/WebProject/ServletRedireccion");
					}	
					else {
						log.info("Contrase�a no valida para este usuario");
						out.println("Contrase�a no valida para este usuario");
						response.sendRedirect("/WebProject/");
					}
				}
				else {
					log.info("No existe un usuario con este nombre");
					out.println("No existe un ususario con este nombre");
				}
			
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
		else{
			log.info("Hay una sesi�n con id " + request.getSession().getId() + " ya asociada al usuario " + ses.getAttribute("nombre"));
			out.println("Hay una sesi�n con id " + request.getSession().getId() + " ya asociada al usuario " + ses.getAttribute("nombre"));
			
			
		}
	}

}
