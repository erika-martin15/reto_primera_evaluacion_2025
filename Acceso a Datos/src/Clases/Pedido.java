package Clases;

import java.sql.Timestamp;

public class Pedido {
	public int id;
	public Cliente cliente;
	public String detalle_pedido;
	public Timestamp fecha_hora;
	public float precio_total;
	
	// Constructor de Pedido
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

	// Representacion de Pedido
	@Override
	public String toString() {
	    String linea = "+----+----------------------+-----------------------------------------------+-----------------------------+---------------+";
	    StringBuilder sb = new StringBuilder();

	    sb.append("\n--- Pedido ---\n");
	    sb.append(linea).append("\n");
	    sb.append(String.format("| %-2s | %-20s | %-45s | %-27s | %-13s |\n",
	            "ID", "Cliente", "Detalle Pedido", "Fecha y Hora", "Precio Total"));
	    sb.append(linea).append("\n");

	    // Dividir el detalle en platos separados por '+'
	    String[] platos = detalle_pedido.split("\\+");

	    for (int i = 0; i < platos.length; i++) {
	        String plato = platos[i].trim();
	        if (i == 0) {
	            // Primera línea: mostramos todo
	            sb.append(String.format("| %-2d | %-20s | %-45s | %-27s | %-13.2f |\n",
	                    id, cliente.nombre, plato, fecha_hora, precio_total));
	        } else {
	            // Líneas siguientes: solo detalle del plato
	            sb.append(String.format("| %-2s | %-20s | %-45s | %-27s | %-13s |\n",
	                    "", "", plato, "", ""));
	        }
	    }

	    sb.append(linea).append("\n");
	    return sb.toString();
	}

}