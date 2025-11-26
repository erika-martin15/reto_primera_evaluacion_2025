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
		return "\nPedido\n"
				+ "|------------------|\n"
				+  "ID ---> " + id 
				+  "\n" + "Cliente ---> " + cliente.nombre
				+  "\n" + "Detalle Pedido ---> " + detalle_pedido
				+  "\n" + "Fecha Y Hora ---> " + fecha_hora 
				+  "\n" + "Precio Total ---> " + precio_total + "€"
				+  "\n|------------------|\n";
	}
	
}