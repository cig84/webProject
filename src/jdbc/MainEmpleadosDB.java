package jdbc;

import java.util.ArrayList;
import java.util.List;

public class MainEmpleadosDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<EmpleadoDTO> empList = new ArrayList<EmpleadoDTO>();
		empList = EmpleadoDAO.recuperarTodos();
		System.out.println(empList);

	}

}
