using System.Text;
using System.Windows;

namespace TrattoriaByJanariak
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void BtnLogin_Click(object sender, RoutedEventArgs e)
        {
            string usuario = txtUsuario.Text;
            string password = txtPassword.Password;

            if (usuario == "admin" && password == "1234")
            {

                // Abrir otra ventana
                Home ventana = new Home();
                ventana.Show();
                this.Close();
            }
            else
            {
                MessageBox.Show("Usuario o contraseña incorrectos");
            }
        }
    }
}