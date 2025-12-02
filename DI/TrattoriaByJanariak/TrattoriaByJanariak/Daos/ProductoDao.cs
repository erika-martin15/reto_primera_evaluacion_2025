using MySql.Data.MySqlClient;
using TrattoriaByJanariak.Modelos;

namespace TrattoriaByJanariak.Daos
{
    class ProductoDao
    {

        public static List<Producto> ObtenerProductos()
        {
            List<Producto> productos = new List<Producto>();
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "SELECT id, nombre, descripcion FROM productos";
            MySqlCommand cmd = new MySqlCommand(query, con);
            MySqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                Producto producto = new Producto
                {
                    Id = reader.GetInt32("id"),
                    nombre = reader.GetString("nombre"),
                    descripcion = reader.GetString("descripcion")
                };

                productos.Add(producto);
            }

            reader.Close();
            con.Close();
            return productos;
        }

        public static Producto ObtenerProductoPorId(int id)
        {
            Producto producto = null;
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "SELECT id, nombre, descripcion FROM productos WHERE id = @id";
            MySqlCommand cmd = new MySqlCommand(query, con);
            cmd.Parameters.AddWithValue("@id", id);
            MySqlDataReader reader = cmd.ExecuteReader();

            if (reader.Read())
            {
                producto = new Producto
                {
                    Id = reader.GetInt32("id"),
                    nombre = reader.GetString("nombre"),
                    descripcion = reader.GetString("descripcion")
                };
            }

            reader.Close();
            con.Close();
            return producto;
        }

        public static void InsertarProducto(Producto producto)
        {
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "INSERT INTO productos (nombre, descripcion) VALUES (@nombre, @descripcion)";
            MySqlCommand cmd = new MySqlCommand(query, con);

            cmd.Parameters.AddWithValue("@nombre", producto.nombre);
            cmd.Parameters.AddWithValue("@descripcion", producto.descripcion);

            cmd.ExecuteNonQuery();
            con.Close();
        }

        public static void EliminarProducto(int id)
        {
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "DELETE FROM productos WHERE id = @id";
            MySqlCommand cmd = new MySqlCommand(query, con);

            cmd.Parameters.AddWithValue("@id", id);
            cmd.ExecuteNonQuery();

            con.Close();
        }

        public static void ActualizarProducto(Producto producto)
        {
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "UPDATE productos SET nombre = @nombre, descripcion = @descripcion WHERE id = @id";
            MySqlCommand cmd = new MySqlCommand(query, con);

            cmd.Parameters.AddWithValue("@nombre", producto.nombre);
            cmd.Parameters.AddWithValue("@descripcion", producto.descripcion);
            cmd.Parameters.AddWithValue("@id", producto.Id);

            cmd.ExecuteNonQuery();
            con.Close();
        }

        public static List<Producto> ObtenerProductosPorCategoria(string categoria)
        {
            List<Producto> productos = new List<Producto>();
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "SELECT id, nombre, descripcion FROM productos WHERE categoria = @categoria";
            MySqlCommand cmd = new MySqlCommand(query, con);
            cmd.Parameters.AddWithValue("@categoria", categoria);
            MySqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                Producto producto = new Producto
                {
                    Id = reader.GetInt32("id"),
                    nombre = reader.GetString("nombre"),
                    descripcion = reader.GetString("descripcion")
                };

                productos.Add(producto);
            }

            reader.Close();
            con.Close();
            return productos;
        }
    }
}
