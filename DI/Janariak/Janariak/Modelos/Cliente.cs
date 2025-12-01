using Janariak.Modelos;
using System;
using System.Collections.Generic;
using System.Text;

namespace Janariak.Modelos
{
    public class Cliente
    {
        public int Id { get; set; }
        public string nombre { get; set; }
        public string apellido { get; set; }
        public string email { get; set; }
        public string telefono { get; set; }

    }
}
