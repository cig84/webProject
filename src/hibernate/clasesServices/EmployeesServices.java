package hibernate.clasesServices;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.clasesDAO.EmployeesDAO;
import hibernate.clasesDAO.SessionManager;
import hibernate.dataBaseHR.Employees;

/**
 * 
 * @author Francesco
 * En esta clase declaramos los m�todos a los cuales el usuario puede acceder.
 * Esta clase inicializa un objeto EmployeesDAO que tiene acceso a la base de datos a trav�s de los
 * m�todos declarados en la misma clase.
 * Esta clase es la que se encarga de obtener una conecci�n a la base de datos llamando el metodo
 * correspondiente de la clase SessionManager, de declarar el inicio de una transacci�n y setear
 * la sessi�n abierta para el objeto EmployeesDAO creado. Tambi�n se encarga de hacer el commit o
 * el roolback de la transacc�on si hay alg�n fallo en la ejecuci�n, as� como de cerrar la sessi�n 
 * cuando el metodo llamado haya terminado su ejecuci�n, con o sin fallos.
 *
 */
public class EmployeesServices {
	
	private static EmployeesDAO empDAO;
	
	public EmployeesServices() {
		empDAO = new EmployeesDAO();
	}
	
	public boolean incrementarSalario(){
		/*
		 * Este m�todo incrementa el salario de todos los dependientes en la tabla Employees
		 * en la base de datos. Para hacer esto despu�s de haber configurado la connecci�n
		 * con la base de datos, llama al metodo obtenerEmpleados() del objeto empDAO, almacena el
		 * resultado en una lista de empleados y actualiza el salario de los empleados llamando el 
		 * metodo actualizarSalario() de la propia clase.
		 */
		boolean ok = false;
		Session session = null;
		Transaction trans = null;
		List<Employees> listaEmp = null;
		try {
			session = SessionManager.obtenerSession();
			trans = session.beginTransaction();
			empDAO.setSession(session);
//			listaEmp = empDAO.obtenerEmpleados();
			mostrarEmpleados(listaEmp);
			actualizarSalario(listaEmp);
			mostrarEmpleados(listaEmp);
			trans.commit();
			ok = true;
		}
		catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
		finally {
			SessionManager.cerrar(session);

		}
		return ok;
	}
	
	public List<Employees> obtenerEmpMejorPagados(){
		/*
		 * Este metodo devuelve una lista de empleados que almacena lo que devuelve el m�todo 
		 * empleadosMejorPagados() del objeto empDAO. El resultado ser� la lista de los empleados
		 * mejor pagados por cada departamento.
		 */
		Session session = null;
		Transaction trans = null;
		List<Employees> listaEmp = null;
		try {
			session = SessionManager.obtenerSession();
			trans = session.beginTransaction();
			empDAO.setSession(session);
//			listaEmp = empDAO.empleadosMejorPagados();
			trans.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
		finally {
			SessionManager.cerrar(session);

		}
		return listaEmp;
	}
	
	public List<Employees> obtenerEmplPorDept(int id) {
		/*
		 * Este m�todo devuelve una lista de empleados que almacena lo que devuelve el m�todo
		 * empleadosPorDept() del objeto emp.DAO. El resultado ser� la lista de los empleados
		 * que pertenecen a un dado departamento. El "id" del departamento ser� el parametro que
		 * pasaremos al m�todo empleadosPorDept.
		 */
		Session session = null;
		Transaction trans = null;
		List<Employees> listaEmp = null;
		try {
			session = SessionManager.obtenerSession();
			trans = session.beginTransaction();
			empDAO.setSession(session);
//			listaEmp = empDAO.empleadosPorDept(id);
			trans.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}
		finally {
			SessionManager.cerrar(session);
	
		}
		return listaEmp;
	}
	
	private void actualizarSalario(List<Employees> listaEmpleados) { // no devuelve nada porqu� la lista se actualiza
		/*
		 * Este m�todo recive la lista de empleados a los cuales hay que incrementar el salario.
		 * Dado que el salario almacenado en la base de datos es de tipo BigDecimal, para tener un valor
		 * mas preciso, se convierte en un int y se actualiza. Despu�s de convertirlo otra vez en un
		 * BigDecimal, se actualiza el valor de cada objeto de la lista.
		 */
		for(Employees emp : listaEmpleados) {
			int salarioAct = emp.getSalary().multiply(new BigDecimal(1.2)).intValue();
			BigDecimal salarioBig = new BigDecimal(salarioAct);
			emp.setSalary(salarioBig);
			
		}
		
	}
	
	public void mostrarEmpleados(List<Employees> listaEmpleados) {
		/*
		 * Este m�todo recorre una lista y imprime el valor de los objetos almacenados en la lista.
		 */
		for(Employees emp : listaEmpleados) {
			System.out.println(emp.toString());
		}
	}

}
