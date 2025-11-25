package com.example.janariaktrattoriaapp.utils;

import com.example.janariaktrattoriaapp.models.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestor central de la cesta de compra usando patrón Singleton
 * Solo existe una instancia en toda la aplicación
 */
public class GestorCarrito {

    // Instancia única (Singleton)
    private static GestorCarrito instancia;

    // Lista que almacena los productos de la cesta
    private List<Producto> productosCarrito;

    /**
     * Constructor privado para evitar instancias externas
     */
    private GestorCarrito() {
        productosCarrito = new ArrayList<>();
    }

    /**
     * Método para obtener la única instancia de GestorCarrito
     * Si no existe, la crea; si existe, devuelve la misma
     */
    public static synchronized GestorCarrito obtenerInstancia() {
        if (instancia == null) {
            instancia = new GestorCarrito();
        }
        return instancia;
    }

    /**
     * Añade un producto a la cesta
     */
    public void agregarProducto(Producto producto) {
        productosCarrito.add(producto);
    }

    /**
     * Elimina un producto de la cesta en una posición específica
     */
    public void eliminarProducto(int posicion) {
        if (posicion >= 0 && posicion < productosCarrito.size()) {
            productosCarrito.remove(posicion);
        }
    }

    /**
     * Obtiene todos los productos de la cesta
     */
    public List<Producto> obtenerProductos() {
        return productosCarrito;
    }

    /**
     * Calcula el precio total de todos los productos
     */
    public double obtenerPrecioTotal() {
        double total = 0;
        for (Producto producto : productosCarrito) {
            total += producto.getPrecio();
        }
        return total;
    }

    /**
     * Obtiene la cantidad de productos en la cesta
     */
    public int obtenerCantidad() {
        return productosCarrito.size();
    }

    /**
     * Vacía completamente la cesta
     */
    public void vaciarCarrito() {
        productosCarrito.clear();
    }
}
