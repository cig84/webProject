package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseDatosAutoCloseable {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		try(Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "database");
	  	    Statement stmt = conn.createStatement())
		{
			
			ArrayList<EmpleadoDTO> arrEmp = new ArrayList<EmpleadoDTO>();
			
				
			try(ResultSet rset = stmt.executeQuery("select * from EMPLOYEES where (SALARY > 3000) ORDER BY SALARY DESC"))
			{
			while (rset.next()) {
			     
			     EmpleadoDTO emp = new EmpleadoDTO(rset.getInt("EMPLOYEE_ID"), rset.getString("FIRST_NAME"), 
			    		 rset.getString("LAST_NAME"), rset.getString("EMAIL"), rset.getString("PHONE_NUMBER"), 
			    		 rset.getDate("HIRE_DATE"), rset.getString("JOB_ID"), rset.getInt("SALARY"), 
			    		 rset.getString("COMMISSION_PCT"), rset.getString("MANAGER_ID"), rset.getInt("DEPARTMENT_ID"));
			     arrEmp.add(emp);

			}
			
			System.out.println (arrEmp);
			    						   
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}

		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}

	}

}
