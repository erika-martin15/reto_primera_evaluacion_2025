using Janariak.Modelos;
using Janariak.Daos;
using Janariak.PedidosView;
using System;
using System.Collections.Generic;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Janariak
{
    public partial class Home : Window
    {
        public Home()
        {
            InitializeComponent();
            btnVerPedidos.Click += BtnVerPedidos_Click;
            btnVerClientes.Click += BtnVerClientes_Click;
            btnSalir.Click += BtnSalir_Click;
            
        }

        private void BtnVerPedidos_Click(object sender, RoutedEventArgs e)
        {
            List<Pedido> pedidos = PedidoDao.ObtenerPedidos();
            dgObjetos.ItemsSource = pedidos;
        }

        private void BtnVerClientes_Click(object sender, RoutedEventArgs e)
        {
            List<Cliente> clientes = ClienteDao.ObtenerClientes();
            dgObjetos.ItemsSource = clientes;
        }

        private void BtnSalir_Click(object sender, RoutedEventArgs e)
        {
            Application.Current.Shutdown();
        }

        private void BtnEliminar_Click(object sender, RoutedEventArgs e)
        {
            Button boton = sender as Button;
            if (boton == null) return;

            var objeto = boton.DataContext;

            // Comprobar si es Cliente
            if (objeto is Cliente cliente)
            {
                int id = cliente.Id;
                // Metodo que elimina al cliente
                ClienteDao.EliminarCliente(id);
                MessageBox.Show("Cliente eliminado con Id: " + id);
            }
            // Comprobar si es Pedido
            else if (objeto is Pedido pedido)
            {
                int id = pedido.Id;
                // Metodo que elimina el pedido
                PedidoDao.EliminarPedido(id);
                MessageBox.Show("Pedido eliminado con Id: " + id);
            }
            else
            {
                MessageBox.Show("Objeto desconocido");
            }

        }
        private void BtnEditar_Click(object sender, RoutedEventArgs e)
        {
            Button boton = sender as Button;
            if (boton != null)
            {
                var objeto = boton.DataContext;
                if (objeto is Cliente cliente)
                {
                    cliente = boton.DataContext as Cliente;

                    if (cliente != null)
                    {
                        // Abrimos el formulario pasando la id
                        EditarClienteView ventana = new EditarClienteView(cliente.Id);
                        ventana.ShowDialog();
                    }

                }
                else { 
                    Pedido pedido = boton.DataContext as Pedido;

                    if (pedido != null)
                    {
                        // Abrimos el formulario pasando la id
                        EditarPedidoView ventana = new EditarPedidoView(pedido.Id);
                        ventana.ShowDialog();
                    }
                }

                
                
            }
        }

        private void BtnCrearPedidos_Click(object sender, RoutedEventArgs e)
        {
            CrearPedido ventana = new CrearPedido();
            ventana.ShowDialog();
        }

        private void BtnRefrescar_Click(object sender, RoutedEventArgs e)
        {

        }
    }
}
