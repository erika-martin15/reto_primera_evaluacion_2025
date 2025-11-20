package Ficheros;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import Clases.Pedido;
import Repositorios.RepositorioPedidos;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class BackupPedidos {

	public static void generar(RepositorioPedidos repositorioPedidos) {
	    // Creamos un atributo que contenga la fecha actual.
	    	String fechaActual = LocalDate.now().toString();
	    try {
	        // Creamos el documento XML
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        Document doc = builder.newDocument();
	
	        // Elemento raíz <backup_pedidos> con atributo fecha
	        Element backupPedidos = doc.createElement("backup_pedidos");
	        backupPedidos.setAttribute("fecha", fechaActual);
	        doc.appendChild(backupPedidos);
	
	        // Obtenemos TODOS los pedidos
	        List<Pedido> listaPedidos = repositorioPedidos.obtenerTodos();
	
	        // Hacemos lo siguiente por cada pedido:
	        for (Pedido pedido : listaPedidos) {
	            // Creamos elemento <pedido> con atributo id
	            Element pedidoElement = doc.createElement("pedido");
	            pedidoElement.setAttribute("id", String.valueOf(pedido.getId()));
	            backupPedidos.appendChild(pedidoElement);
	
	            // Creamos <id_cliente>
	            Element idCliente = doc.createElement("id_cliente");
	            idCliente.setTextContent(String.valueOf(pedido.getCliente().getId()));
	            pedidoElement.appendChild(idCliente);
	
	            // Creamos <detalle_pedido> que contendrá los platos separados
	            Element detallePedido = doc.createElement("detalle_pedido");
	            pedidoElement.appendChild(detallePedido);
	
	            // Separamos los platos, que están en una cadena separada por comas
	            String detalleTexto = pedido.getDetalle_pedido(); // Por ejemplo: "pizza,hamburguesa,pasta"
	            String[] platos = detalleTexto.split(" \\+ "); // Dividimos por comas
	
	            // Por cada plato, creamos un elemento <plato>
	            for (String plato : platos) {
	                Element platoElement = doc.createElement("plato");
	                platoElement.setTextContent(plato.trim());
	                detallePedido.appendChild(platoElement);
	            }
	
	            // Creamos <fecha_hora>
	            Element fechaHora = doc.createElement("fecha_hora");
	            fechaHora.setTextContent(pedido.getFecha_hora().toString());
	            pedidoElement.appendChild(fechaHora);
	
	            // Creamos <precio_total>
	            Element precioTotal = doc.createElement("precio_total");
	            precioTotal.setTextContent(String.valueOf(pedido.getPrecio_total()));
	            pedidoElement.appendChild(precioTotal);
	        }
	
	        // Guardamos el XML en un archivo
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(new File("backup_pedidos.xml"));
	        transformer.transform(source, result);
	
	        System.out.println("Backup XML generado correctamente");
	
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}