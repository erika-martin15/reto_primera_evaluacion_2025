package Repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import Conector.ConectorBD;
import Clases.Cliente;

public class RepositorioCliente {
	
	public RepositorioCliente() {
        try {
            ConectorBD.conectar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertarCliente(Cliente c) {
        String sql = "INSERT INTO Clientes (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = ConectorBD.getConexion().prepareStatement(sql)) {
            stmt.setString(1, c.nombre);
            stmt.setString(2, c.apellido);
            stmt.setString(3, c.email);
            stmt.setString(4, c.telefono);
            stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Cliente> obtenerClientes() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";
        try (Statement stmt = ConectorBD.getConexion().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getString("Telefono")
                ));
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }

        return lista;
    }
    
    public Cliente obtenerClientePorId(int id_cliente) {
    Cliente cliente = null;
    String sql = "SELECT * FROM Clientes WHERE id = ?";
    
    try (PreparedStatement stmt = ConectorBD.getConexion().prepareStatement(sql)) {
        stmt.setInt(1, id_cliente); 
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
            cliente = new Cliente(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("email"),
                rs.getString("telefono")
            	);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    	}
    return cliente;
    }
}