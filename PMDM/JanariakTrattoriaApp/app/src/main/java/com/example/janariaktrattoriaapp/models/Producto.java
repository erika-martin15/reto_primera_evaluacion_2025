package com.example.janariaktrattoriaapp.models;

import java.io.Serializable;

public class Producto implements Serializable {
    // Atributos
    private String nombre;
    private String descripcion;
    private String ingredientes;
    private double precio;
    private int recursoImagen;
    private String categoria;

    // Constructor
    public Producto(String nombre, String descripcion, String ingredientes, double precio, int recursoImagen, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
        this.precio = precio;
        this.recursoImagen = recursoImagen;
        this.categoria = categoria;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getIngredientes() {
        return ingredientes;
    }
    public double getPrecio() {
        return precio;
    }
    public int getRecursoImagen() {
        return recursoImagen;
    }
    public String getCategoria() {
        return categoria;
    }

    // Crearemos un método que cambie el formato al correcto en lo que se refiere al precio.
    public String getPrecioFormateado() {
        return String.format("%.2f €", precio); // "String.format()" permite crear cadenas de texto con un formato especídico. El "%" indica el comienzo del marcador de posición. ".2" dice cuántos decimales debe tener el número, y "f" que es de tipo float.
    }
}
