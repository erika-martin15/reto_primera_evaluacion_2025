package com.example.janariaktrattoriaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.janariaktrattoriaapp.adapters.AdapterCarrito;
import com.example.janariaktrattoriaapp.models.Producto;
import com.example.janariaktrattoriaapp.utils.GestorCarrito;
import java.util.List;
// Mostraremos TODOS los productos que el usuario de la aplicación ha añadido al carrito. Al implementar AdapterCarrito, debe tener el método alEliminarProducto().
public class CarritoActivity extends AppCompatActivity implements AdapterCarrito.AlEliminarProductoListener {
    private RecyclerView recyclerViewCarrito;
    private TextView textViewTotalProductos, textViewTotalPrecio;
    private Button botonVaciarCarrito;
    private ImageButton botonVolverMain;
    private AdapterCarrito adaptador;
    private List<Producto> productosCarrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito); // Cargamos el XML del carrito de compra.

        // Inicializamos las vistas.
        recyclerViewCarrito = findViewById(R.id.recyclerViewCarrito);
        textViewTotalProductos = findViewById(R.id.textViewTotalProductos);
        textViewTotalPrecio = findViewById(R.id.textViewTotalPrecio);
        botonVaciarCarrito = findViewById(R.id.botonVaciarCarrito);
        botonVolverMain = findViewById(R.id.buttonVolverMain);

        // Creamos el Listener del botón volver.
        botonVolverMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cerraremos la actividad actual y volveremos a la anterior.
            }
        });

        recyclerViewCarrito.setLayoutManager(new LinearLayoutManager(this)); // Configuraremos el RecyclerView, definiendo la lista para que se muestre de manera vertical.

        productosCarrito = GestorCarrito.obtenerInstancia().obtenerProductos(); // Obtendremos la instancia del gestor y la lista de los productos del carrito. GestorCarrito es una clase Singleton, que tiene una sola instancia. Por ello, todas las Activity acceden al mismo carrito.

        adaptador = new AdapterCarrito(this, productosCarrito, this); // Creamos el adapter y le pasamos la Activity actual, los datos a mostrar y a quién avisar cuando este elimine algo (también será esta Activity).
        recyclerViewCarrito.setAdapter(adaptador); // Asignamos el Adapter al RecyclerView, haciendo que use el Adapter para mostrar los datos.

        actualizarTotales(); // Calculamos y mostramos el total de productos y su precio.

        // Cuando pulsamos el botón "vaciarCarrito"
        botonVaciarCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GestorCarrito.obtenerInstancia().vaciarCarrito(); // Vaciamos el carrito en el Gestor, eliminando todos los productos.
                adaptador.notifyDataSetChanged(); // Avisamos al Adapter de que han cambiado TODOS los datos.
                actualizarTotales(); // Actualizamos los totales.
                Toast.makeText(CarritoActivity.this, "Carrito vaciado", Toast.LENGTH_SHORT).show();
                /*
                * Avisamos al usuario de que el carrito se ha vaciado. Tras buscar cómo mostrar un mensaje temporal y breve al usuario, encontramos "Toast". Este es un mensaje corto que aparece en pantalla
                * durante unos segundos y desaparece de manera automática. Todo esto superponiendose a la aplicación. Hay que pasarle el contexto(el Activity donde tiene que mostrarse), el mensaje y la duración.
                * Esta última puede ser "short" o "long". Para que aparezca, es obligatorio utilizar el método "show()".
                * */
            }
        });
    }

    // Con este método calcularemos los totales.
    private void actualizarTotales() {
        int cantidad = GestorCarrito.obtenerInstancia().obtenerCantidad(); // Obtenemos la cantidad de productos del Gestor.
        double precioTotal = GestorCarrito.obtenerInstancia().obtenerPrecioTotal();// Obtenemos el precio total sumando los precios individuales.

        textViewTotalProductos.setText("Total de productos: " + cantidad); // Actualizamos el TextView con la cantidad total.
        textViewTotalPrecio.setText(String.format("Total: %.2f €", precioTotal)); // Actualizamos el TextView con el precio total.

        if (cantidad == 0) { // En caso de que el carrito esté vacío, avisamos al usuario.
            Toast.makeText(this, "El carrito está vacío", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void alEliminarProducto() {
        actualizarTotales(); // Solo necesitaremos actualizar los totales.
    }
}
