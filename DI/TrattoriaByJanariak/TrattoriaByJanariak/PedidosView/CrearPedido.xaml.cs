using System.Collections.ObjectModel;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using TrattoriaByJanariak.Modelos;
using TrattoriaByJanariak.Daos;

namespace TrattoriaByJanariak.PedidosView
{
    public partial class CrearPedido : Window
    {
        private ObservableCollection<PlatoCarrito> carrito = new ObservableCollection<PlatoCarrito>();

        public CrearPedido()
        {
            InitializeComponent();

            listaCarrito.ItemsSource = carrito;

            CargarPlatos("Entrantes");
        }

        private void BtnCategoria_Click(object sender, RoutedEventArgs e)
        {
            Button b = sender as Button;
            CargarPlatos(b.Content.ToString());
        }

        private void CargarPlatos(string categoria)
        {
            // Aquí metes tus productos según la categoría
            panelPlatos.ItemsSource = PlatoDao.ObtenerPlatosPorCategoria(categoria);
        }

        private void BtnAgregarPlato_Click(object sender, RoutedEventArgs e)
        {
            Button btn = sender as Button;
            Plato plato = btn.Tag as Plato;

            var existente = carrito.FirstOrDefault(p => p.Id == plato.Id);

            if (existente != null)
            {
                existente.Cantidad++;
            }
            else
            {
                carrito.Add(new PlatoCarrito
                {
                    Id = plato.Id,
                    Nombre = plato.Nombre,
                    Precio = plato.Precio,
                    Imagen = plato.Imagen
                });
            }

            listaCarrito.Items.Refresh();
            ActualizarTotal();
        }


        private void ActualizarTotal()
        {
            float total = carrito.Sum(x => x.TotalLinea);
            txtTotal.Text = $"Total: {total:C}";
        }



        private void BtnFinalizar_Click(object sender, RoutedEventArgs e)
        {
            if (carrito.Count == 0)
            {
                MessageBox.Show("El carrito está vacío.");
                return;
            }

            try
            {
                var pedidoDao = new PedidoDao();

                // 1️ Crear objeto Pedido
                Pedido pedido = new Pedido
                {
                    cliente = ClienteDao.ObtenerClientePorId(1),
                    Fecha_hora = DateTime.Now,
                    Detalle_pedido = GenerarDetalleCarrito(),
                    Precio_total = carrito.Sum(p => p.TotalLinea)
                };

                // 2️ Insertar pedido y obtener Id
                int idPedido = pedidoDao.InsertarPedido(pedido);

                // 3️ Insertar cada plato del carrito
                foreach (var plato in carrito)
                {
                    pedidoDao.InsertarPlatoPedido(idPedido, plato);
                }

                MessageBox.Show("Pedido creado correctamente.");
                this.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al crear el pedido: " + ex.Message);
            }
        }

        private string GenerarDetalleCarrito()
        {
            StringBuilder sb = new StringBuilder();
            foreach (var plato in carrito)
            {
                sb.AppendLine($"{plato.Nombre} x{plato.Cantidad}");
            }
            return sb.ToString();
        }
    }
}
