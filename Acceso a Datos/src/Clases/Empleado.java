package Clases;

public class Empleado {
	public int id;
	public String nombre;
	public String apellido;
	public String email;
	public String puesto;
	public int telefono;
	public int salario;
	
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

	@Override
	public String toString() {
		return "\nEmpleado\n"
				+ "|------------------|"
				+ "\n" + "ID ---> " + id 
				+ "\n" + "Nombre ---> " + nombre 
				+ "\n" + "Apellido ---> " + apellido 
				+ "\n" + "Email ---> "  + email 
				+ "\n" + "Puesto ---> " + puesto 
				+ "\n" + "Telefono ---> " + telefono 
				+ "\n" + "Salario ---> " + salario + "€"
				+ "\n|------------------|\n";
	}
}
