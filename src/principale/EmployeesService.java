package principale;

public class EmployeesService {
	
	private InterfazRecuperable objDao;

	public void setObj(InterfazRecuperable obj) {
		this.objDao = obj;
	}

	public Object leerEmpleado(int id) {
		
		Object objeto_emp = null;
		objeto_emp = objDao.leerEmpleado(id);
		return objeto_emp;
	}

}
