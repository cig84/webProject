package hibernate.clasesDAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import principale.InterfazRecuperable;




import hibernate.dataBaseHR.Employees;

/**
 * 
 * @author Francesco
 * En esta clase se definen los metodos para acceder a la base de datos. Esta clase implementa la
 * interfaz "interfazEmployeeDAO y extiende la super clase "SuperClaseDAO".
 *
 */

public class EmployeesDAO extends SuperClaseDAO implements InterfazRecuperable {

	@Override
	public Object leerEmpleado(int id) {
		
		Session session = null;
		Transaction trans = null;
		Employees emp = null;
		EmployeesDAO empDAO = new EmployeesDAO();
		try {
			session = SessionManager.obtenerSession();
			trans = session.beginTransaction();
			empDAO.setSession(session);
			emp = empDAO.read(id);
			System.out.println(emp.toString());
			trans.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
		finally {
			SessionManager.cerrar(session);

		}
		return emp;
	}
		
	public Employees read(int id) {
		
		Employees emp = (Employees) getSession().createSQLQuery("SELECT * from EMPLOYEES where EMPLOYEE_ID = " + id).addEntity(Employees.class).uniqueResult();
		return emp;
	}

}
