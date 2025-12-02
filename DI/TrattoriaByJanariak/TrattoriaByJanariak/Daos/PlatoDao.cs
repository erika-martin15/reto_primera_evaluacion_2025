using System.IO;
using System.Windows.Media.Imaging;
using MySql.Data.MySqlClient;
using TrattoriaByJanariak.Modelos;

namespace TrattoriaByJanariak.Daos
{
    class PlatoDao
    {
        public static List<Plato> ObtenerPlatos()
        {
            List<Plato> platos = new List<Plato>();
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "SELECT id, id_producto, nombre, precio FROM platos";

            MySqlCommand cmd = new MySqlCommand(query, con);
            MySqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                Plato plato = new Plato
                {
                    Id = reader.GetInt32("id"),
                    producto = ProductoDao.ObtenerProductoPorId(reader.GetInt32("id_producto")),
                    Nombre = reader.GetString("nombre"),
                    Precio = reader.GetFloat("precio")
                };

                platos.Add(plato);
            }

            reader.Close();
            con.Close();
            return platos;
        }

        public static Plato ObtenerPlatoPorId(int id)
        {
            Plato plato = null;
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "SELECT id, id_producto, nombre, precio FROM platos WHERE id = @id";

            MySqlCommand cmd = new MySqlCommand(query, con);
            cmd.Parameters.AddWithValue("@id", id);
            MySqlDataReader reader = cmd.ExecuteReader();

            if (reader.Read())
            {
                plato = new Plato
                {
                    Id = reader.GetInt32("id"),
                    producto = ProductoDao.ObtenerProductoPorId(reader.GetInt32("id_producto")),
                    Nombre = reader.GetString("nombre"),
                    Precio = reader.GetFloat("precio")
                };
            }

            reader.Close();
            con.Close();
            return plato;
        }

        public static void InsertarPlato(Plato plato)
        {
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "INSERT INTO platos (id_producto, nombre, precio) VALUES (@id_producto, @nombre, @precio)";
            MySqlCommand cmd = new MySqlCommand(query, con);

            cmd.Parameters.AddWithValue("@id_producto", plato.producto.Id);
            cmd.Parameters.AddWithValue("@nombre", plato.Nombre);
            cmd.Parameters.AddWithValue("@precio", plato.Precio);

            cmd.ExecuteNonQuery();
            con.Close();
        }

        public static void ActualizarPlato(Plato plato)
        {
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "UPDATE platos SET id_producto = @id_producto, nombre = @nombre, precio = @precio WHERE id = @id";
            MySqlCommand cmd = new MySqlCommand(query, con);

            cmd.Parameters.AddWithValue("@id_producto", plato.producto.Id);
            cmd.Parameters.AddWithValue("@nombre", plato.Nombre);
            cmd.Parameters.AddWithValue("@precio", plato.Precio);
            cmd.Parameters.AddWithValue("@id", plato.Id);

            cmd.ExecuteNonQuery();
            con.Close();
        }

        public static void EliminarPlato(int id)
        {
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "DELETE FROM platos WHERE id = @id";
            MySqlCommand cmd = new MySqlCommand(query, con);

            cmd.Parameters.AddWithValue("@id", id);
            cmd.ExecuteNonQuery();
            con.Close();
        }

        public static List<Plato> ObtenerPlatosPorCategoria(string categoria)
        {
            List<Plato> platos = new List<Plato>();
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "SELECT id, nombre, descripcion, precio FROM platos WHERE categoria = @categoria";
            MySqlCommand cmd = new MySqlCommand(query, con);
            cmd.Parameters.AddWithValue("@categoria", categoria);
            MySqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                Plato plato = new Plato
                {
                    Id = reader.GetInt32("id"),
                    Nombre = reader.GetString("nombre"),
                    Categoria = categoria,
                    Descripcion = reader.GetString("descripcion"),
                    Precio = reader.GetFloat("precio"),
                    Imagen = new BitmapImage(new Uri(
                    Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "Resources", categoria, reader.GetString("nombre") + ".jpg"),
                    UriKind.Absolute))
                };
                platos.Add(plato);
            }

            reader.Close();
            con.Close();
            return platos;
        }
    }
}
