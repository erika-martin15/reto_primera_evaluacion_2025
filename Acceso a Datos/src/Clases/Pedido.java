package Clases;

import java.sql.Timestamp;

public class Pedido {
	public int id;
	public Cliente cliente;
	public String detalle_pedido;
	public Timestamp fecha_hora;
	public float precio_total;
	
	public Pedido(int id, Cliente cliente, String detalle_pedido, Timestamp fecha_hora, float precio_total) {
		super();
		this.id = id; 
		this.cliente = cliente;
		this.detalle_pedido = detalle_pedido;
		this.fecha_hora = fecha_hora;
		this.precio_total = precio_total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDetalle_pedido() {
		return detalle_pedido;
	}

	public void setDetalle_pedido(String detalle_pedido) {
		this.detalle_pedido = detalle_pedido;
	}

	public Timestamp getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(Timestamp fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public float getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(float precio_total) {
		this.precio_total = precio_total;
	}

	@Override
	public String toString() {

	    // Calcular anchos dinamicos
	    int anchoId = 4;
	    int anchoCliente = Math.max(20, cliente.nombre.length() + 2);
	    int anchoDetalle = Math.max(20, detalle_pedido.length() + 2);
	    int anchoFecha = 27;
	    int anchoPrecio = 13;

	    // Construir linea superior segun los anchos
	    String linea = "+" +
	            "-".repeat(anchoId + 2) + "+" +
	            "-".repeat(anchoCliente + 2) + "+" +
	            "-".repeat(anchoDetalle + 2) + "+" +
	            "-".repeat(anchoFecha + 2) + "+" +
	            "-".repeat(anchoPrecio + 2) + "+";

	    // Formatear tabla
	    return "\n--- Producto ---\n" +
	            linea + "\n" +
	            String.format("| %-" + anchoId + "s | %-" + anchoCliente + "s | %-" + anchoDetalle + "s | %-" + anchoFecha + "s | %-" + anchoPrecio + "s |\n",
	                    "ID", "Cliente", "Detalle Pedido", "Fecha y Hora", "Precio Total") +
	            linea + "\n" +
	            String.format("| %-" + anchoId + "d | %-" + anchoCliente + "s | %-" + anchoDetalle + "s | %-" + anchoFecha + "s | %-" + anchoPrecio + ".2f |\n",
	                    id, cliente.nombre, detalle_pedido, fecha_hora.toString(), precio_total) +
	            linea + "\n";
	}

}