package Main;

import java.sql.Timestamp;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Clases.Cliente;
import Clases.Empleado;
import Clases.Pedido;
import Clases.Pedido_Plato;
import Clases.Plato;
import Conector.ConectorBD;
import Ficheros.BackupPedidos;
import Repositorios.RepositorioCliente;
import Repositorios.RepositorioEmpleados;
import Repositorios.RepositorioPedidos;
import Repositorios.RepositorioPlatos;

public class Main {

	@SuppressWarnings({ "static-access", "unused" })
	public static void main(String[] args) {
		try  {
			RepositorioPedidos repositorioPedidos = new RepositorioPedidos();
			RepositorioCliente repositorioCliente = new RepositorioCliente();
			RepositorioEmpleados repositorioEmpleados = new RepositorioEmpleados();
			BackupPedidos bkpPedidos = new BackupPedidos();

			ConectorBD bd = new ConectorBD();
			
			Scanner sc = new Scanner(System.in);
			int option;
			do {
			    System.out.println("\n ---Restaurante---");
			    System.out.println("0 --> SALIR ");
			    System.out.println("1 --> Ver clientes");
			    System.out.println("2 --> Ver empleados");
			    System.out.println("3 --> Insertar pedido");
			    System.out.println("4 --> Consultar pedidos");
			    System.out.println("5 --> Generar backup de pedidos");
			    System.out.println("-------------------------------\n");
			    option = -1;
			    String input = sc.nextLine();

			    try {
			        option = Integer.parseInt(input);
			    } catch (NumberFormatException e) {
			        System.out.println("Entrada inválida. Por favor, introduce un número.");
			        continue; 
			    }

			    if (option < 0 || option > 5) {
			        System.out.println("Opción no válida, por favor elige otra.");
			        continue;
			    }

			    switch (option) {
			        case 0 -> {
			            System.out.println("Cerrando el programa...");
			            break;
			        }
			        case 1 -> {
			            System.out.println("--- Lista de Clientes ---");
			            List<Cliente> clientes = repositorioCliente.obtenerClientes();
			            System.out.println(clientes);
			        	}
			       	case 2 -> {
			            System.out.println("--- Lista de Empleados ---");
			            List<Empleado> empleados = repositorioEmpleados.obtenerEmpleados();
			            System.out.println(empleados);
			       		}
			        case 3 -> {
			            insertarPedido();
			        	}
			        case 4 -> {
			            System.out.println("--- Lista de Pedidos ---");
			            ArrayList<Pedido> pedidos = repositorioPedidos.obtenerTodos();
			            System.out.println(pedidos);
			        	}
			        case 5 -> {
			            BackupPedidos.generar(repositorioPedidos);
			        	}
			    	}
				} while (option != 0);


			sc.close();
			bd.cerrarConexion();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Método para insertar un nuevo pedido
	private static void insertarPedido() {
	    RepositorioPlatos repositorioPlatos = null;
	    RepositorioPedidos repositorioPedidos = null;
	    RepositorioCliente repositorioCliente = null;
	    ArrayList<Plato> platos = null;
	    @SuppressWarnings("resource")
	    Scanner sc = new Scanner(System.in);

	    try {
	        repositorioCliente = new RepositorioCliente();
	        repositorioPedidos = new RepositorioPedidos();
	        repositorioPlatos = new RepositorioPlatos();
	        platos = repositorioPlatos.obtenerTodas();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return;
	    }

	    int opcion = 0;
	    ArrayList<Pedido_Plato> pedido_Platos = new ArrayList<>();
	    boolean cancelado = false; 

	    // Menú para elegir platos
	    do {
	        System.out.println("--- MENU ---");
	        System.out.println("1.- Elegir plato");
	        System.out.println("2.- Finalizar pedido");
	        System.out.println("3.- Cancelar pedido");
	        String input = sc.nextLine();
	                            
	        try {
	            opcion = Integer.parseInt(input);
	        } catch (NumberFormatException e) {
	            System.out.println("Entrada inválida. No se puede introducir letras. Volviendo al menú.");
	            continue;
	        }

	        switch (opcion) {
	            case 1:
	                System.out.println("--- CARTA ---");
	                for (Plato p : platos) {
	                    System.out.println(p.getId() + ". " + p.getNombre() + " - " + p.getPrecio() + "€");
	                }

	                System.out.print("Elige el id del plato que quieras: ");
	                String idInput = sc.nextLine();
	                int id_plato;
	                try {
	                    id_plato = Integer.parseInt(idInput);
	                } catch (NumberFormatException e) {
	                    System.out.println("Entrada inválida. Debes introducir un número de plato. Volviendo al menú.");
	                    break;
	                }

	                // Verificar que el id existe en la lista de platos
	                Plato elegido = platos.stream()
	                        .filter(p -> p.getId() == id_plato)
	                        .findFirst()
	                        .orElse(null);
	                if (elegido == null) {
	                    System.out.println("Plato no válido. Inténtalo de nuevo.");
	                    break;
	                }

	                // Guardar la cantidad
	                System.out.print("Dime la cantidad: ");
	                String cantidadInput = sc.nextLine();
	                int cantidad;
	                try {
	                    cantidad = Integer.parseInt(cantidadInput);
	                } catch (NumberFormatException e) {
	                    System.out.println("Entrada inválida. La cantidad debe ser un número. Volviendo al menú.");
	                    break;
	                }
	                if (cantidad <= 0) {
	                    System.out.println("Cantidad no válida. Debe ser mayor que 0.");
	                    break;
	                }

	                // Añadir al pedido el plato seleccionado
	                int id_cliente = 1; 
	                Pedido_Plato existente = pedido_Platos.stream()
	                        .filter(pp -> pp.getId_plato() == id_plato)
	                        .findFirst()
	                        .orElse(null);

	                if (existente != null) {
	                    existente.setCantidad(existente.getCantidad() + cantidad);
	                } else {
	                    Pedido_Plato pedido_Plato = new Pedido_Plato(id_cliente, id_plato, cantidad);
	                    pedido_Platos.add(pedido_Plato);
	                }
	                break;
	            case 2:
	                if (pedido_Platos.isEmpty()) {
	                    System.out.println("No puedes finalizar sin elegir al menos un plato.");
	                    opcion = 0;
	                } else {
	                    System.out.println("Pedido finalizado.");
	                }
	                break;
	            case 3:
	                System.out.println("Pedido cancelado.");
	                cancelado = true;
	                break;
	            default:
	                System.out.println("Opción no válida.");
	        }
	    } while ((opcion != 2 || pedido_Platos.isEmpty()) && !cancelado);
	    
	    if (cancelado) {
	        return;
	    }

	    // Calcula el detalle del pedido y el precio total
	    StringBuilder detalleBuilder = new StringBuilder();
	    float precio_total = 0;
	    LocalDateTime fecha_hora = LocalDateTime.now();
	    Timestamp timestamp = Timestamp.valueOf(fecha_hora);

	    for (Pedido_Plato pp : pedido_Platos) {
	        Plato plato = platos.stream()
	                .filter(p -> p.getId() == pp.getId_plato())
	                .findFirst()
	                .orElse(null);

	        if (plato != null) {
	            detalleBuilder.append(pp.getCantidad())
	                          .append(" x ")
	                          .append(plato.getNombre())
	                          .append("\n"); // cada plato en una línea
	            precio_total += plato.getPrecio() * pp.getCantidad();
	        }
	    }

	    String detalle = detalleBuilder.toString().trim();

	    // Mostrar una sola sección de detalles
	    System.out.println("\n--- Detalles del pedido ---");
	    System.out.println(detalle);
	    System.out.println("Fecha y hora del pedido: " + timestamp);
	    System.out.println("Precio total: " + precio_total + "€\n");

	    // Inserta el pedido en la base de datos
	    try {
	        Cliente cliente = repositorioCliente.obtenerClientePorId(1);
	        Pedido pedido = new Pedido(1, cliente, detalle, timestamp, precio_total);

	        repositorioPedidos.insertarPedido(pedido);
	        int id_pedido = repositorioPedidos.obtenerUltimoId();
	            
	        for (Pedido_Plato pp : pedido_Platos) { 
	            repositorioPedidos.insertarPedido_Plato(id_pedido, pp.getId_plato(), pp.getCantidad());
	        }

	        System.out.println("Pedido insertado correctamente.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}