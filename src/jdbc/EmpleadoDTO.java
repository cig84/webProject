package jdbc;

import java.util.Date;

public class EmpleadoDTO {
	
	int id_empleado;
	String nombre;
	String apellido;
	String email;
	String teléfono;
	Date fecha_in;
	String id_job;
	float salario;
	String comisiones;
	String id_manager;
	int id_departamento;
	
	public EmpleadoDTO(){
		
	}
	
	public EmpleadoDTO(int id_empleado, String nombre, String apellido, String email,
						String teléfono, Date hire_Date, String id_job, float salary,
						String commission_Pct, String manager_Id, int id_departamento) {
		
		this.id_empleado = id_empleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.teléfono = teléfono;
		this.fecha_in = hire_Date;
		this.id_job = id_job;
		this.salario = salary;
		this.comisiones = commission_Pct;
		this.id_manager = manager_Id;
		this.id_departamento = id_departamento;
		
	}
	
	@Override
	public String toString() {
		
		return (this.id_empleado + " " + this.nombre + " " 
		+ this.apellido + " " + this.salario + " " + this.id_departamento + "\n");
	}

}
