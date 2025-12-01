using Janariak.Modelos;
using MySql.Data.MySqlClient;
using System.Collections;
using System.Collections.Generic;

namespace Janariak.Daos
{
    class PedidoDao
    {
        public static List<Pedido> ObtenerPedidos()
        {
            List<Pedido> pedidos = new List<Pedido>();
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "SELECT id, id_cliente, detalle_pedido, fecha_hora, precio_total FROM pedidos";

            MySqlCommand cmd = new MySqlCommand(query, con);
            MySqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                Pedido pedido = new Pedido();
                pedido.Id = reader.GetInt32("id");
                pedido.cliente = ClienteDao.ObtenerClientePorId(reader.GetInt32("id_cliente"));
                pedido.Detalle_pedido = reader.GetString("detalle_pedido");
                pedido.Fecha_hora = reader.GetDateTime("fecha_hora");
                pedido.Precio_total = reader.GetFloat("precio_total");

                pedidos.Add(pedido);
            }

            reader.Close();
            con.Close();
            return pedidos;
        }

        public static void ActualizarPedido(Pedido pedido)
        {
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "UPDATE pedidos SET id_cliente = @id_cliente, detalle_pedido = @detalle_pedido, precio_total = @precio_total WHERE id = @id";
            MySqlCommand cmd = new MySqlCommand(query, con);
            cmd.Parameters.AddWithValue("@id_cliente", pedido.cliente.Id);
            cmd.Parameters.AddWithValue("@detalle_pedido", pedido.Detalle_pedido);
            cmd.Parameters.AddWithValue("@precio_total", pedido.Precio_total);
            cmd.Parameters.AddWithValue("@id", pedido.Id);
            cmd.ExecuteNonQuery();
            con.Close();
        }

        public int InsertarPedido(Pedido pedido)
        {
            int idPedido;
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "INSERT INTO pedidos (id_cliente, detalle_pedido, fecha_hora, precio_total) " +
                             "VALUES (@cliente, @detalle, @fecha, @total); SELECT LAST_INSERT_ID();";
            MySqlCommand cmd = new MySqlCommand(query, con);

                {
                    cmd.Parameters.AddWithValue("@cliente", pedido.cliente.Id);
                    cmd.Parameters.AddWithValue("@detalle", pedido.Detalle_pedido);
                    cmd.Parameters.AddWithValue("@fecha", pedido.Fecha_hora);
                    cmd.Parameters.AddWithValue("@total", pedido.Precio_total);
                    idPedido = Convert.ToInt32(cmd.ExecuteScalar());
                
            }
            return idPedido;
        }

        public void InsertarPlatoPedido(int idPedido, PlatoCarrito plato)
        {
            MySqlConnection con = Conexion.ObtenerConexion();

                string query = "INSERT INTO pedidos_platos (id_pedido, id_plato, cantidad) VALUES (@pedido, @plato, @cantidad)";
            MySqlCommand cmd = new MySqlCommand(query, con);
            cmd.Parameters.AddWithValue("@pedido", idPedido);
                    cmd.Parameters.AddWithValue("@plato", plato.Id);
                    cmd.Parameters.AddWithValue("@cantidad", plato.Cantidad);
                    cmd.ExecuteNonQuery();
                
            
        }

        public static Pedido ObtenerPedidoPorId(int id)
        {
            Pedido pedido = null;
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "SELECT id, id_cliente, detalle_pedido, fecha_hora, precio_total FROM pedidos WHERE id = @id";
            MySqlCommand cmd = new MySqlCommand(query, con);
            cmd.Parameters.AddWithValue("@id", id);
            MySqlDataReader reader = cmd.ExecuteReader();
            if (reader.Read())
            {
                pedido = new Pedido();
                pedido.Id = reader.GetInt32("id");
                pedido.cliente = ClienteDao.ObtenerClientePorId(reader.GetInt32("id_cliente"));
                pedido.Detalle_pedido = reader.GetString("detalle_pedido");
                pedido.Fecha_hora = reader.GetDateTime("fecha_hora");
                pedido.Precio_total = reader.GetFloat("precio_total");
            }
            reader.Close();
            con.Close();
            return pedido;
        }

        public static void EliminarPedido(int id)
        {
            MySqlConnection con = Conexion.ObtenerConexion();
            string query = "DELETE FROM pedidos WHERE id = @id";
            MySqlCommand cmd = new MySqlCommand(query, con);
            cmd.Parameters.AddWithValue("@id", id);
            cmd.ExecuteNonQuery();
            con.Close();
        }
    }
}
