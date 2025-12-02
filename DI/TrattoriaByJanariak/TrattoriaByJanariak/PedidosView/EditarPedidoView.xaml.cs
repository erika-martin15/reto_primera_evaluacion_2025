using System.Collections.ObjectModel;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using TrattoriaByJanariak.Modelos;
using TrattoriaByJanariak.Daos;

namespace TrattoriaByJanariak.PedidosView
{
    public partial class EditarPedidoView : Window
    {
        private int id_pedido;

        public EditarPedidoView(int idPedido)
        {
            InitializeComponent();
            id_pedido = idPedido;

            CargarPedido();
        }

        private void CargarPedido()
        {
            Pedido pedido = PedidoDao.ObtenerPedidoPorId(id_pedido);

            if (pedido == null)
            {
                MessageBox.Show("Pedido no encontrado");
                this.Close();
                return;
            }

            txtFechaHora.Text = pedido.Fecha_hora.ToString("yyyy-MM-dd HH:mm");
            txtClienteId.Text = pedido.cliente.Id.ToString();
            txtPrecioTotal.Text = pedido.Precio_total.ToString();
            txtDetallePedido.Text = pedido.Detalle_pedido;
        }

        private void BtnGuardar_Click(object sender, RoutedEventArgs e)
        {
            Pedido p = new Pedido
            {
                Id = id_pedido,
                cliente = ClienteDao.ObtenerClientePorId(int.Parse(txtClienteId.Text)),
                Precio_total = float.Parse(txtPrecioTotal.Text),
                Detalle_pedido = txtDetallePedido.Text,
                Fecha_hora = DateTime.Parse(txtFechaHora.Text)
            };

            PedidoDao.ActualizarPedido(p);

            MessageBox.Show("Pedido actualizado correctamente");
            this.Close();
        }
    }
}
