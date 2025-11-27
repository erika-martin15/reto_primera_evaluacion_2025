package Clases;

public class Cliente {
	public int id;
	public String nombre;
	public String apellido;
	public String email;
	public String telefono;
	
	public Cliente(int id, String nombre, String apellido, String email, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
	    String linea = "+----+----------------------+----------------------+-----------------------------+---------------+";
	    return "\n--- Cliente ---\n" +
	           linea + "\n" +
	           String.format("| %-2s | %-20s | %-20s | %-27s | %-13s |\n",
	                         "ID", "Nombre", "Apellido", "Email", "Telefono") +
	           linea + "\n" +
	           String.format("| %-2d | %-20s | %-20s | %-27s | %-13s |\n",
	                         id, nombre, apellido, email, telefono) +
	          linea + "\n";
	}
}