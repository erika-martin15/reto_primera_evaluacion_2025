package Repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Clases.Empleado;
import Conector.ConectorBD;

public class RepositorioEmpleados {
	
	public RepositorioEmpleados() {
        ConectorBD.conectar();
    }

    public List<Empleado> obtenerEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM Empleados";
        try (Statement stmt = ConectorBD.getConexion().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getString("puesto"),
                    rs.getInt("telefono"),
                    rs.getInt("salario")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
