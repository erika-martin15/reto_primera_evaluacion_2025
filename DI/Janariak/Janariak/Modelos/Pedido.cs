using Janariak.Modelos;
using System;
using System.Collections.Generic;
using System.Text;

namespace Janariak
{
    public class Pedido
    {
        public int Id { get; set; }
        public Cliente cliente{ get; set; }
        public string Detalle_pedido { get; set; }
        public DateTime Fecha_hora { get; set; }
        public float Precio_total { get; set; }

    }
}
