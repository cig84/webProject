package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class BaseDatos{

	public EmpleadoDTO leerEmpleado(int id) {
		
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		EmpleadoDTO emp = null;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "database");
  	        stmt = conn.createStatement();
			rset = stmt.executeQuery("SELECT * from EMPLOYEES where EMPLOYEE_ID = " + id);
			while (rset.next()) {
			     
			     emp = new EmpleadoDTO(rset.getInt("EMPLOYEE_ID"), rset.getString("FIRST_NAME"), 
			    		 rset.getString("LAST_NAME"), rset.getString("EMAIL"), rset.getString("PHONE_NUMBER"), 
			    		 rset.getDate("HIRE_DATE"), rset.getString("JOB_ID"), rset.getInt("SALARY"), 
			    		 rset.getString("COMMISSION_PCT"), rset.getString("MANAGER_ID"), rset.getInt("DEPARTMENT_ID"));

			}
			    						   
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		  	   
		}   
		
		return emp;
	}

}