package com.example.janariaktrattoriaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.janariaktrattoriaapp.adapters.AdapterProducto;
import com.example.janariaktrattoriaapp.models.Producto;
import com.example.janariaktrattoriaapp.utils.GestorCarrito;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button botonEntrantes, botonPrincipales, botonPostres, botonBebidas, botonViewCarrito;
    private ImageButton botonVolverLogin;
    private RecyclerView recyclerViewProductos;
    private AdapterProducto adaptador;
    private List<Producto> todosLosProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa las vistas.
        botonEntrantes = findViewById(R.id.botonEntrantes);
        botonPrincipales = findViewById(R.id.botonPrincipales);
        botonPostres = findViewById(R.id.botonPostres);
        botonBebidas = findViewById(R.id.botonBebidas);
        botonViewCarrito = findViewById(R.id.botonViewCarrito);
        botonVolverLogin = findViewById(R.id.botonVolverLogin);
        recyclerViewProductos = findViewById(R.id.recyclerViewProductos);

        // Configura el RecyclerView.
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this));

        // Carga todos los productos.
        cargarTodosLosProductos();

        // Muestra los entrantes por defecto.
        mostrarProductosPorCategoria("Entrantes");

        // Botón para volver al login.
        botonVolverLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra MainActivity y vuelve a LoginActivity.
            }
        });

        // Botones de categorías.
        botonEntrantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarProductosPorCategoria("Entrantes");
            }
        });

        botonPrincipales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarProductosPorCategoria("Principales");
            }
        });

        botonPostres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarProductosPorCategoria("Postres");
            }
        });

        botonBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarProductosPorCategoria("Bebidas");
            }
        });

        botonViewCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CarritoActivity.class);
                startActivity(intent);
            }
        });
        // Vamos a hacer que, cuando el usuario pulse el botón de atrás en la barra de navegación, vuelva a la pantalla de Login y no salga de la aplicación.
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        actualizarBotonCarrito();
    }

    private void cargarTodosLosProductos() {
        todosLosProductos = new ArrayList<>();

        // ENTRANTES
        todosLosProductos.add(new Producto(
                "Provoletta",
                "Queso fundido con hierbas y un toque italiano que te transportará directamente a la Toscana",
                "• Queso provolone\n• Orégano fresco\n• Tomillo\n• Aceite de oliva virgen extra",
                8.50,
                R.drawable.provolone,
                "Entrantes"
        ));
        todosLosProductos.add(new Producto(
                "Focaccia",
                "Pan artesanal con aceite de oliva virgen extra y romero fresco del huerto",
                "• Harina de trigo\n• Aceite de oliva\n• Romero fresco\n• Sal marina",
                6.00,
                R.drawable.focaccia,
                "Entrantes"
        ));
        todosLosProductos.add(new Producto(
                "Carpaccio",
                "Finas láminas de res con parmesano reggiano y rúcula fresca",
                "• Lomo de res\n• Parmesano reggiano\n• Rúcula fresca\n• Aceite de oliva\n• Limón",
                12.50,
                R.drawable.carpaccio,
                "Entrantes"
        ));
        todosLosProductos.add(new Producto(
                "Tabla de Embutidos",
                "Selección italiana de jamones curados y quesos artesanales",
                "• Prosciutto di Parma\n• Salami Milano\n• Mortadela\n• Quesos variados\n• Aceitunas",
                14.00,
                R.drawable.tabla_embutidos,
                "Entrantes"
        ));

        // PRINCIPALES
        todosLosProductos.add(new Producto(
                "Lasaña Boloñesa",
                "Capas de pasta al horno cocinadas a la perfección con ragú tradicional",
                "• Pasta fresca\n• Carne de res\n• Tomate San Marzano\n• Bechamel\n• Parmesano\n• Albahaca",
                13.50,
                R.drawable.lasagna_carne,
                "Principales"
        ));
        todosLosProductos.add(new Producto(
                "Pizza Margarita",
                "Clásica y sencilla pizza napolitana. Nacida en Nápoles el año 1889, creada por el pizzaiolo Raffaele Esposito en honor a la reina Margherita de Saboya",
                "• Tomate San Marzano\n• Mozzarella fresca di bufala\n• Albahaca fresca\n• Aceite de oliva\n• Sal marina",
                11.00,
                R.drawable.pizza_margherita,
                "Principales"
        ));
        todosLosProductos.add(new Producto(
                "Risotto de Hongos",
                "Arroz cremoso y aromático con hongos porcini y trufa negra",
                "• Arroz Carnaroli\n• Hongos porcini\n• Trufa negra\n• Vino blanco\n• Parmesano\n• Mantequilla",
                14.50,
                R.drawable.risotto_hongos,
                "Principales"
        ));
        todosLosProductos.add(new Producto(
                "Spaghetti Carbonara",
                "La versión original romana, con salsa de huevo, guanciale y pecorino",
                "• Spaghetti\n• Guanciale (panceta curada)\n• Huevos\n• Queso pecorino romano\n• Pimienta negra",
                12.50,
                R.drawable.pasta_carbonara,
                "Principales"
        ));

        // POSTRES
        todosLosProductos.add(new Producto(
                "Tiramisú",
                "Postre italiano clásico de café y mascarpone con bizcochos savoiardi",
                "• Bizcochos savoiardi\n• Café expreso\n• Mascarpone\n• Huevos\n• Cacao en polvo\n• Amaretto",
                6.50,
                R.drawable.tiramisu,
                "Postres"
        ));
        todosLosProductos.add(new Producto(
                "Cannoli",
                "Crujiente galleta siciliana rellena de ricotta dulce con pistachos",
                "• Masa de cannoli\n• Ricotta fresca\n• Azúcar glass\n• Pistachos\n• Chips de chocolate",
                5.50,
                R.drawable.cannoli,
                "Postres"
        ));
        todosLosProductos.add(new Producto(
                "Panna Cotta",
                "Cremoso flan de nata con coulis de frutos rojos",
                "• Nata líquida\n• Azúcar\n• Gelatina\n• Vainilla\n• Frutos rojos\n• Menta",
                5.00,
                R.drawable.panna_cotta,
                "Postres"
        ));
        todosLosProductos.add(new Producto(
                "Copa de Helado",
                "Helado artesanal italiano con toppings variados a elegir",
                "• Helado de vainilla\n• Helado de chocolate\n• Helado de fresa\n• Nata montada\n• Sirope\n• Barquillo",
                4.50,
                R.drawable.helado,
                "Postres"
        ));

        // BEBIDAS
        todosLosProductos.add(new Producto(
                "Agua",
                "Natural o con gas, siempre refrescante",
                "• Agua mineral natural 500ml",
                1.50,
                R.drawable.agua,
                "Bebidas"
        ));
        todosLosProductos.add(new Producto(
                "Moretti",
                "Cerveza italiana de sabor suave y refrescante",
                "• Cerveza Moretti 330ml (4.6% vol.)",
                3.00,
                R.drawable.moretti_cerveza,
                "Bebidas"
        ));
        todosLosProductos.add(new Producto(
                "Prosecco",
                "Espumoso italiano, ligero y festivo. Perfecto para brindar",
                "• Prosecco DOC (copa 150ml)\n• 11% vol.",
                4.50,
                R.drawable.prosecco,
                "Bebidas"
        ));
        todosLosProductos.add(new Producto(
                "Limoncello",
                "Licor de limón tradicional y aromático de la costa Amalfitana",
                "• Limoncello artesanal (chupito 40ml)\n• 28% vol.\n• Limones de Amalfi",
                5.00,
                R.drawable.limoncello,
                "Bebidas"
        ));
    }

    private void mostrarProductosPorCategoria(String categoria) {
        List<Producto> productosFiltrados = new ArrayList<>();

        for (Producto producto : todosLosProductos) {
            if (producto.getCategoria().equals(categoria)) {
                productosFiltrados.add(producto);
            }
        }
        adaptador = new AdapterProducto(this, productosFiltrados);
        recyclerViewProductos.setAdapter(adaptador);
    }

    private void actualizarBotonCarrito() {
        int cantidad = GestorCarrito.obtenerInstancia().obtenerCantidad();
        botonViewCarrito.setText("Ver Carrito (" + cantidad + ")");
    }
}