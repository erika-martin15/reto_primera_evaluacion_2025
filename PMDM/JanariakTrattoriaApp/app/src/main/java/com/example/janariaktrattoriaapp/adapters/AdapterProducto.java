package com.example.janariaktrattoriaapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.janariaktrattoriaapp.DetalleProductoActivity;
import com.example.janariaktrattoriaapp.R;
import com.example.janariaktrattoriaapp.models.Producto;
import java.util.List;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.ProductoViewHolder> {
    private Context contexto;
    private List<Producto> listaProductos;

    // Constructor
    public AdapterProducto(Context contexto, List<Producto> listaProductos) {
        this.contexto = contexto;
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el layout item_product.xml
        View vista = LayoutInflater.from(contexto).inflate(R.layout.objeto_producto, parent, false);
        return new ProductoViewHolder(vista);
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = listaProductos.get(position);

        holder.textViewNombre.setText(producto.getNombre());
        holder.textViewPrecio.setText(producto.getPrecioFormateado());
        holder.imageView.setImageResource(producto.getRecursoImagen());

        // Podemos crear una descripción corta para el producto.
        String descripcionCorta = producto.getDescripcion();
        if (descripcionCorta.length() > 50) { // Verificamos si la descripción que tiene actualmente tiene más de 50 caracteres.
            descripcionCorta = descripcionCorta.substring(0, 50) + "..."; // Si los tiene, con "substring(0, 50)" cortamos el contenido que se encuentre entre esos carácteres y le añadimos puntos suspensivos detrás.
        }
        holder.textViewDescripcion.setText(descripcionCorta);

        holder.itemView.setOnClickListener(new View.OnClickListener() { // El listener abarcará TODA la tarjeta.
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contexto, DetalleProductoActivity.class);
                intent.putExtra("PRODUCTO", producto);
                contexto.startActivity(intent);
            }
        });
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewNombre;
        TextView textViewDescripcion;
        TextView textViewPrecio;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);

            // Encuentra y guarda las referencias
            imageView = itemView.findViewById(R.id.imageViewProducto);
            textViewNombre = itemView.findViewById(R.id.textViewNombreProducto);
            textViewDescripcion = itemView.findViewById(R.id.textViewDescripcionProducto);
            textViewPrecio = itemView.findViewById(R.id.textViewPrecioProducto);
        }
    }
}