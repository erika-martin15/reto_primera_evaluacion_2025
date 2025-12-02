package Clases;

public class Empleado {
	public int id;
	public String nombre;
	public String apellido;
	public String email;
	public String puesto;
	public int telefono;
	public int salario;
	
	// Constructor de empleado
	public Empleado(int id, String nombre, String apellido, String email, String puesto, int telefono, int salario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.puesto = puesto;
		this.telefono = telefono;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	// Representación del empleado
	@Override
	public String toString() {
		String linea = "+----+----------------------+----------------------+-----------------------------+---------------+---------------+---------------+";
	    return "\n--- Empleado ---\n" +
	           linea + "\n" +
	           String.format("| %-2s | %-20s | %-20s | %-27s | %-13s | %-13s | %-13s |\n",
	                         "ID", "Nombre", "Apellido", "Email", "puesto", "telefono", "salario") +
	           linea + "\n" +
	           String.format("| %-2d | %-20s | %-20s | %-27s | %-13s | %-13s | %-13s |\n",
	                         id, nombre, apellido, email, puesto, telefono, salario) +
	          linea + "\n";
	}
}
