using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Media;

namespace TrattoriaByJanariak.Modelos
{
    internal class Plato
    {

        public int Id { get; set; }
        public Producto producto { get; set; }
        public string Nombre { get; set; }
        public string Categoria { get; set; }
        public string Descripcion { get; set; }
        public float Precio { get; set; }
        public ImageSource Imagen { get; set; }

    }
}
