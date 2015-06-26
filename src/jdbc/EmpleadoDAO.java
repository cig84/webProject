package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpleadoDAO {
	
	private static EmpleadoDTO componerObjeto (ResultSet rs) throws SQLException
	{
		EmpleadoDTO empleado = null;
		
		int employee_Id = rs.getInt(1);
		String first_Name = rs.getString(2);
		String last_Name = rs.getString(3);
		String email = rs.getString(4);
		String phone_Number = rs.getString(5);
		Date hire_Date = rs.getDate(6);
		String job_Id = rs.getString(7);
		float salary = rs.getFloat(8);
		String commission_Pct = rs.getString(9);
		String manager_Id = rs.getString(10);
		int department_Id = rs.getInt(11);
		
		empleado = new EmpleadoDTO(employee_Id, first_Name, last_Name, email, 
				phone_Number, hire_Date, job_Id, salary, commission_Pct, manager_Id, 
				department_Id);
		
		return empleado;
	}
	
	public static List<EmpleadoDTO> recuperarTodos() {
		
		List<EmpleadoDTO> listaEmp = new ArrayList<EmpleadoDTO>(); 
		return listaEmp;
	}

}
