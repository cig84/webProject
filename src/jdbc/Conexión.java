package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexión {
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;
	
	public Connection obtenerConexión() throws ClassNotFoundException {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "database");
  	        stmt = conn.createStatement();
  	        rset = stmt.executeQuery(InstruccionesSQL.querySalario);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;   
	}
	public static void liberarRecursos (Connection conn, Statement stmt, ResultSet rset)
	{
		if (rset != null) 	{ try { rset.close(); } catch (Exception e1) { e1.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}
	
}
