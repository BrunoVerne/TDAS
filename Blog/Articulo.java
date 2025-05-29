package ar.uba.fi.cb100.c2025_01.Blog;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.listas.ListaSimplementeEnlazada;

public class Articulo {
    private String titulo;
    private String descripcion;
    private ListaSimplementeEnlazada<String> palabrasExcluyentes;

    public Articulo(String titulo, String descripcion, ListaSimplementeEnlazada<String> palabrasExcluyentes) {
        ValidacionesUtiles.validarNoNulo(titulo, "titulo");
        ValidacionesUtiles.validarNoNulo(descripcion, "descripcion");
        ValidacionesUtiles.validarNoNulo(palabrasExcluyentes, "palabras excluyentes");
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.palabrasExcluyentes = palabrasExcluyentes;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ListaSimplementeEnlazada<String> getPalabrasExcluyentes() {
        return palabrasExcluyentes;
    }
}
