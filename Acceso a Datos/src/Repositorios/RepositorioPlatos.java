package Repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Clases.Plato;
import Conector.ConectorBD;

public class RepositorioPlatos {
	
	public RepositorioPlatos() throws SQLException {
        ConectorBD.conectar();
    }

    public void insertarPelicula(Plato p) throws SQLException {
        String sql = "INSERT INTO peliculas (nombre, precio) VALUES (?, ?)";
        try (PreparedStatement stmt = ConectorBD.getConexion().prepareStatement(sql)) {
            stmt.setString(1, p.nombre);
            stmt.setInt(2, p.precio);
            stmt.executeUpdate();
        }
    }

    public ArrayList <Plato> obtenerTodas() throws SQLException {
        ArrayList<Plato> lista = new ArrayList<>();
        String sql = "SELECT * FROM platos";
        try (Statement stmt = ConectorBD.getConexion().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Plato(
                	rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("precio")
                ));
            }
        }
        return lista;
    }
}
