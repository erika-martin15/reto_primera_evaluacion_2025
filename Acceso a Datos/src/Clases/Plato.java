package Clases;

public class Plato { 
	
	public int id_producto;
	public String nombre;
	public int precio;
    
    public Plato(int id_producto, String nombre, int precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.id_producto = id_producto;
	}
    
    public int getid_producto() {
		return id_producto;
	}

	public void setid_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getprecio() {
		return precio;
	}

	public void setGenero(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Platos [" + "nombre=" + nombre + ", genero=" + precio
				 + "id_cliente=" + id_producto + "]";
	}

}