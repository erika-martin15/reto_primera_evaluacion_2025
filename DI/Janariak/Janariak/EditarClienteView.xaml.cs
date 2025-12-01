using Janariak.Daos;
using Janariak.Modelos;
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
    /// <summary>
    /// Lógica de interacción para EditarClienteView.xaml
    /// </summary>
    public partial class EditarClienteView : Window
    {

        private int id_cliente;
        public EditarClienteView(int id_Cliente)
        {
            InitializeComponent();
            id_cliente = id_Cliente;

            CargarCliente();
        }

        private void BtnGuardar_Click(object sender, RoutedEventArgs e)
        {
            Cliente cliente = new Cliente
            {
                Id = id_cliente,
                nombre = txtNombre.Text,
                apellido = txtApellido.Text,
                email = txtEmail.Text,
                telefono = txtTelefono.Text
            };

            ClienteDao.ActualizarCliente(cliente);
            this.Close();
        }

        private void CargarCliente()
        {
            Cliente cliente = ClienteDao.ObtenerClientePorId(id_cliente);
            if (cliente != null)
            {
                txtNombre.Text = cliente.nombre;
                txtApellido.Text = cliente.apellido;
                txtEmail.Text = cliente.email;
                txtTelefono.Text = cliente.telefono;
            }
            else
            {
                MessageBox.Show("Cliente no encontrado");
                this.Close();
            }
        }
    }
}
