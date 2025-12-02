using MySql.Data.MySqlClient;
using TrattoriaByJanariak.Modelos;

namespace TrattoriaByJanariak.Daos
{
    class ClienteDao
    {

        public static List<Cliente> ObtenerClientes()
        {
            List<Cliente> clientes = new List<Cliente>();
            MySqlConnection con = Conexion.ObtenerConexion();
            String query = "SELECT id, nombre, apellido, email, telefono FROM clientes";
            MySqlCommand cmd = new MySqlCommand(query, con);
            MySqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                Cliente cliente = new Cliente
                {
                    Id = reader.GetInt32("id"),
                    nombre = reader.GetString("nombre"),
                    apellido = reader.GetString("apellido"),
                    email = reader.GetString("email"),
                    telefono = reader.GetString("telefono")
                };
                clientes.Add(cliente);
            }
            reader.Close();
            con.Close();
            return clientes;
        }

        public static Cliente ObtenerClientePorId(int id)
        {
            Cliente cliente = null;
            MySqlConnection con = Conexion.ObtenerConexion();
            String query = "SELECT id, nombre, apellido, email, telefono FROM clientes WHERE id = @id";
            MySqlCommand cmd = new MySqlCommand(query, con);
            cmd.Parameters.AddWithValue("@id", id);
            MySqlDataReader reader = cmd.ExecuteReader();
            if (reader.Read())
            {
                cliente = new Cliente
                {
                    Id = reader.GetInt32("id"),
                    nombre = reader.GetString("nombre"),
                    apellido = reader.GetString("apellido"),
                    email = reader.GetString("email"),
                    telefono = reader.GetString("telefono")
                };
            }
            reader.Close();
            con.Close();
            return cliente;
        }

        public static void InsertarCliente(Cliente cliente)
        {
            MySqlConnection con = Conexion.ObtenerConexion();
            String query = "INSERT INTO clientes (nombre, apellido, email, telefono) VALUES (@nombre, @apellido, @email, @telefono)";
            MySqlCommand cmd = new MySqlCommand(query, con);
            cmd.Parameters.AddWithValue("@nombre", cliente.nombre);
            cmd.Parameters.AddWithValue("@apellido", cliente.apellido);
            cmd.Parameters.AddWithValue("@email", cliente.email);
            cmd.Parameters.AddWithValue("@telefono", cliente.telefono);
            cmd.ExecuteNonQuery();
            con.Close();
        }

        public static void EliminarCliente(int id)
        {
            MySqlConnection con = Conexion.ObtenerConexion();
            String query = "DELETE FROM clientes WHERE id = @id";
            MySqlCommand cmd = new MySqlCommand(query, con);
            cmd.Parameters.AddWithValue("@id", id);
            cmd.ExecuteNonQuery();
            con.Close();
        }

        public static void ActualizarCliente(Cliente cliente)
        {
            MySqlConnection con = Conexion.ObtenerConexion();
            String query = "UPDATE clientes SET nombre = @nombre, apellido = @apellido, email = @email, telefono = @telefono WHERE id = @id";
            MySqlCommand cmd = new MySqlCommand(query, con);
            cmd.Parameters.AddWithValue("@nombre", cliente.nombre);
            cmd.Parameters.AddWithValue("@apellido", cliente.apellido);
            cmd.Parameters.AddWithValue("@email", cliente.email);
            cmd.Parameters.AddWithValue("@telefono", cliente.telefono);
            cmd.Parameters.AddWithValue("@id", cliente.Id);
            cmd.ExecuteNonQuery();
            con.Close();
        }

    }
}
