using MySql.Data.MySqlClient;

namespace TrattoriaByJanariak
{
    class Conexion
    {
        private static string connectionString = "server=localhost;database=JANARIAK;uid=root;pwd=1234;";

        public static MySqlConnection ObtenerConexion()
        {
            MySqlConnection conn = new MySqlConnection(connectionString);
            try
            {
                conn.Open();
                Console.WriteLine("Conexión abierta correctamente.");
            }
            catch (MySqlException ex)
            {
                Console.WriteLine("Error al conectar a MySQL: " + ex.Message);
            }
            return conn;
        }

    }
}
