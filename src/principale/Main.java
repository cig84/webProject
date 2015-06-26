package principale;

import jdbc.BaseDatos;
//import jpa.Principal;
import hibernate.clasesDAO.EmployeesDAO;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EmployeesService empSer = new EmployeesService();
//		InterfazRecuperable oJPA = new Principal();
		InterfazRecuperable oHiber = new EmployeesDAO();
//		InterfazRecuperable oJDBC = new BaseDatos();
		
//		empSer.setObj(oJDBC);
//		oJDBC = (InterfazRecuperable) empSer.leerEmpleado(150);
//		System.out.println(oJDBC.toString());
		
		empSer.setObj(oHiber);
		oHiber = (InterfazRecuperable) empSer.leerEmpleado(150);
		System.out.println(oHiber.toString());
	
//		empSer.setObj(oJPA);
//		oJPA = (InterfazRecuperable) empSer.leerEmpleado(150);
//		System.out.println(oJPA.toString());
	

	}

}
