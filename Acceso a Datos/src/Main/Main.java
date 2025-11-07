package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Clases.Cliente;
import Clases.Empleado;
import Clases.Pedido;
import Conector.ConectorBD;
import Repositorios.RepositorioCliente;
import Repositorios.RepositorioEmpleados;
import Repositorios.RepositorioPedidos;

public class Main {

	public static void main(String[] args) {
		try  {
			RepositorioPedidos repositorioPedidos = new RepositorioPedidos();
			RepositorioCliente repositorioCliente = new RepositorioCliente();
			RepositorioEmpleados repositorioEmpleados = new RepositorioEmpleados();

			ConectorBD bd = new ConectorBD();
			
			Scanner sc = new Scanner(System.in);
			int option;
			do {
				System.out.println("\n ---Restaurante---");
				System.out.println("0 --> SALIR ");
				System.out.println("1 --> Ver usuarios");
				System.out.println("2 --> Ver empleados");
				System.out.println("3 --> Insertar pedido");
				System.out.println("4 --> Consultar pedidos");
				System.out.println("5 --> Generar backup de pedidos");
				System.out.println("-------------------------------\n");
				option = Integer.parseInt(sc.nextLine());
				
				switch (option) {
				case 0 -> {
					System.out.println("Cerrando el programa...");
					break;
				}
				case 1 -> {
					System.out.println("--- Lista de Usuarios ---");
					List<Cliente> clientes = repositorioCliente.obtenerClientes();
					System.out.println(clientes);
					break;	
				}
				case 2 -> {
					System.out.println("--- Lista de Empleados ---");
					List<Empleado> empleado = repositorioEmpleados.obtenerEmpleados();
					System.out.println(empleado);
					break;
				}
				case 3 -> {
					/*  stmt.setInt(1, p.cliente.id);
		            stmt.setString(2, p.detalle_pedido);
		            stmt.setTimestamp(3, p.fecha_hora);
		            stmt.setFloat(4, p.precio_total);
		            stmt.executeUpdate();*/				
					
				}
				case 4 -> {
					System.out.println("--- Lista de Pedidos ---");
					ArrayList<Pedido> pedidos = repositorioPedidos.obtenerTodos();					
					System.out.println(pedidos);
					break;
				}
				
				case 5 -> {
	
				}
				
			}
				
				
			} while (option != 0);

			sc.close();
			bd.cerrarConexion();
				
		} catch (Exception e) {
			
		
		}
	}
		
}


