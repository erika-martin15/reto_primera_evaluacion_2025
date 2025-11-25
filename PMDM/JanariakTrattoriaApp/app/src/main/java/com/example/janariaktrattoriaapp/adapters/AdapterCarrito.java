package com.example.janariaktrattoriaapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.janariaktrattoriaapp.R;
import com.example.janariaktrattoriaapp.models.Producto;
import java.util.List;

public class AdapterCarrito extends RecyclerView.Adapter<AdapterCarrito.CarritoViewHolder> {
    private Context contexto; // El contexto de Android que utilizaremos para acceder a los recursos e "inflar" los layouts.
    private List<Producto> productosCarrito; // Una lista con los productos del carrito.
    private AlEliminarProductoListener listener; // Unión entre la Activity y el Adapter.

    /*
    * A través de una interfaz, nos comunicaremos con la Activity. Mientras que el Adapter solo muestra los datos y detecta los movimientos del usuario, la lógica
    * correrá a cargo del Activity. El Adapter enviará una notificación al Activity cuando haya completado la acción de eliminar el producto: él detecta el click del usuario,
    * elimina el producto y avisa al Activity (que será quién ejecute el método alEliminarProducto() y actualice los totales, etc.).
    * */
    public interface AlEliminarProductoListener {
        void alEliminarProducto();
    }

    // Constructor
    public AdapterCarrito(Context contexto, List<Producto> productosCarrito, AlEliminarProductoListener listener) {
        this.contexto = contexto;
        this.productosCarrito = productosCarrito;
        this.listener = listener;
    }

    // Los "NonNull" que nos encontramos a lo largo del texto indican que el parámetro/variable/método que le sigue no puede nunca ser nulo. Esto nos ayudará a evitar errores como el "NullPointerException".
    @NonNull
    // Llamamos al onCreateViewHolder cuando el RecyclerView necesita CREAR una nueva vista.
    @Override
    public CarritoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater convierte el XML en un objeto View.
        View vista = LayoutInflater.from(contexto).inflate(R.layout.objeto_carrito, parent, false);
        return new CarritoViewHolder(vista); // Creamos y devolvemos un ViewHolder con las referencias de las vistas.
    }

    // Llamamos a onBindViewHolder cada vez que el RecyclerView necesita MOSTRAR los datos de una vista.
    @Override
    public void onBindViewHolder(@NonNull CarritoViewHolder holder, int position) {
        Producto producto = productosCarrito.get(position); // Obtenemos el producto que se encuentra en la posición actual.

        // Rellenamos los datos del producto en las diferentes vistas.
        holder.textViewNombre.setText(producto.getNombre());
        holder.textViewPrecio.setText(producto.getPrecioFormateado());
        holder.imageView.setImageResource(producto.getRecursoImagen());

        // Tenemos que manejar cuando el usuario pulsa la "X" para eliminar un producto.
        holder.botonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int posicionActual = holder.getBindingAdapterPosition(); // Obtenemos la posición actual.
                if (posicionActual != RecyclerView.NO_POSITION) { // En caso de que la posición sea válida (que exista).
                    // Eliminamos el producto de la lista.
                    productosCarrito.remove(posicionActual);
                    // Notificamos al adapter que un elemento ha sido eliminado.
                    notifyItemRemoved(posicionActual);
                    // Notificamos a la actividad para que actualice el total.
                    if (listener != null) {
                        listener.alEliminarProducto();
                    }
                }
            }
        });
    }

    // Devolvemos el número total de elementos que están en la lista. El RecyclerView lo necesita para saber cuántas veces tiene que llamar al onBindViewHolder.
    @Override
    public int getItemCount() {
        return productosCarrito.size(); // Devolvemos el número como entero.
    }

    /*
    * Creamos una clase interna que extiende de ViewHolder. Este es un contenedor que guarda las referencias de todas las vistas. En vez de buscarlas con findViewById,
    * solo las buscaremos una única vez y las guardaremos aquí.
     * */
    public static class CarritoViewHolder extends RecyclerView.ViewHolder {
        // Creamos referencias a las vistas de objeto_carrito.xml.
        ImageView imageView;
        TextView textViewNombre;
        TextView textViewPrecio;
        Button botonEliminar;

        // Creamos un constructor que se ejecutará cuando se cree una nueva vista.
        public CarritoViewHolder(@NonNull View itemView) {
            super(itemView);
            // Buscamos y guardamos las referencias que se utilizarán en el onBindViewHolder.
            imageView = itemView.findViewById(R.id.imageViewProductoCarrito);
            textViewNombre = itemView.findViewById(R.id.textViewNombreProductoCarrito);
            textViewPrecio = itemView.findViewById(R.id.textViewPrecioProductoCarrito);
            botonEliminar = itemView.findViewById(R.id.botonEliminarDelCarrito);
        }
    }
}
