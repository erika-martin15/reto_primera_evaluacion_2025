package Repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Clases.Pedido;
import Conector.ConectorBD;


public class RepositorioPedidos {
	
    RepositorioCliente repoCliente = new RepositorioCliente();


	public RepositorioPedidos() throws SQLException {
        ConectorBD.conectar();
    }

    public void insertarPedido(Pedido p) throws SQLException {
        String sql = "INSERT INTO Pedido (id_cliente, detalle_pedido, fecha_hora, precio_total) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = ConectorBD.getConexion().prepareStatement(sql)) {
            stmt.setInt(1, p.cliente.id);
            stmt.setString(2, p.detalle_pedido);
            stmt.setTimestamp(3, p.fecha_hora);
            stmt.setFloat(4, p.precio_total);
            stmt.executeUpdate();
        }
    }

    public ArrayList<Pedido> obtenerTodos() throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM Pedidos";
        try (Statement stmt = ConectorBD.getConexion().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {

                int id_cliente = rs.getInt("id_cliente");

                pedidos.add(new Pedido(
                    rs.getInt("id"),
                    repoCliente.obtenerClientePorId(id_cliente),
                    rs.getString("detalle_pedido"),
                    rs.getTimestamp("fecha_hora"),
                    rs.getFloat("precio_total")
                ));
            }
        }
        return pedidos;
    }
}
