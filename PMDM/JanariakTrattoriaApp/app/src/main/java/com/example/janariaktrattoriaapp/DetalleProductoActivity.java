package com.example.janariaktrattoriaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.janariaktrattoriaapp.models.Producto;
import com.example.janariaktrattoriaapp.utils.GestorCarrito;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class DetalleProductoActivity extends AppCompatActivity {
    private ImageView imageViewProducto;
    private TextView textViewNombre, textViewPrecio, textViewDescripcion;
    private TextView textViewIngredientes;
    private ExtendedFloatingActionButton botonAnadirCarrito;
    private ImageButton botonVolver;
    private Producto productoActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        // Inicializa las vistas
        imageViewProducto = findViewById(R.id.imagenViewDetalleProducto);
        textViewNombre = findViewById(R.id.textViewNombreDetalle);
        textViewPrecio = findViewById(R.id.textViewPrecioDetalle);
        textViewDescripcion = findViewById(R.id.textViewDescripcionDetalle);
        textViewIngredientes = findViewById(R.id.textViewIngredientes);
        botonAnadirCarrito = findViewById(R.id.botonAnadirCarrito);
        botonVolver = findViewById(R.id.botonVolver);

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra DetailActivity y vuelve a MainActivity
            }
        });

        // Recibe el producto desde el Intent
        productoActual = (Producto) getIntent().getSerializableExtra("PRODUCTO");

        if (productoActual != null) {
            // Rellena las vistas con los datos del producto
            textViewNombre.setText(productoActual.getNombre());
            textViewPrecio.setText(productoActual.getPrecioFormateado());
            textViewDescripcion.setText(productoActual.getDescripcion());
            textViewIngredientes.setText(productoActual.getIngredientes());
            imageViewProducto.setImageResource(productoActual.getRecursoImagen());
        } else {
            Toast.makeText(this, "Error al cargar el producto", Toast.LENGTH_SHORT).show();
            finish();
        }

        botonAnadirCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GestorCarrito.obtenerInstancia().agregarProducto(productoActual);
                Toast.makeText(DetalleProductoActivity.this,
                        productoActual.getNombre() + " añadido al carrito",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
