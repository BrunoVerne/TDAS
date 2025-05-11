package ar.uba.fi.cb100.c2025_01.parcialito2;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.listas.ListaSimplementeEnlazada;

public class Imagen {
    private ListaSimplementeEnlazada<Comentario> comentarios;
    private String url;

    public Imagen(String url){
        ValidacionesUtiles.validarNoNulo(url, "url");
        this.url = url;
        this.comentarios = new ListaSimplementeEnlazada<Comentario>();
    }

    public ListaSimplementeEnlazada<Comentario> getComentarios(){
        return this.comentarios;
    }

    public String getUrl(){
        return this.url;
    }




}
