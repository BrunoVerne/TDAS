package ar.uba.fi.cb100.c2025_01.FiltroDeNoticias;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.listas.ListaSimplementeEnlazada;

public class Noticia {
    private String cuerpo;
    private String titulo;
    private ListaSimplementeEnlazada<Categoria> categorias;

    public Noticia(String cuerpo, String titulo) {
        ValidacionesUtiles.validarNoNulo(cuerpo, "cuerpo");
        ValidacionesUtiles.validarNoNulo(titulo, "titulo");
        this.cuerpo = cuerpo;
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void agregarCategoria(Categoria categoria){
        this.categorias.add(categoria);
    }
    public ListaSimplementeEnlazada<Categoria> getCategorias(){
        return this.categorias;
    }
}
