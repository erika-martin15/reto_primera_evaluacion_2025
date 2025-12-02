using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Media;

namespace TrattoriaByJanariak.Modelos
{
    public class PlatoCarrito
    {
        public int Id { get; set; }
        public string Nombre { get; set; }
        public float Precio { get; set; }
        public ImageSource Imagen { get; set; }

        // Cantidad solo en memoria
        public int Cantidad { get; set; } = 1;

        public string NombreConCantidad =>
            Cantidad > 1 ? $"{Nombre} x{Cantidad}" : Nombre;

        public float TotalLinea => Precio * Cantidad;
    }
}
