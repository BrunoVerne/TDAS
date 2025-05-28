package ar.uba.fi.cb100.c2025_01.Moderador;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.listas.ListaSimplementeEnlazada;

public class Foro {
    private ListaSimplementeEnlazada<Mensaje> mensajes;
    private String nombreDelForo;
    private  ListaSimplementeEnlazada<String> tematicas;


    public Foro(ListaSimplementeEnlazada<Mensaje> mensajes, String nombreDelForo) {
        ValidacionesUtiles.validarNoNulo(nombreDelForo, "nombre del foro");
        this.nombreDelForo = nombreDelForo;
        this.mensajes = new ListaSimplementeEnlazada<>();
        this.tematicas = new ListaSimplementeEnlazada<>();
    }


    public void agregarTematica(String tematica){
        ValidacionesUtiles.validarNoNulo(tematica, "tematica");
        this.tematicas.add(tematica);
    }

    public ListaSimplementeEnlazada<String> getTematicas() {
        return tematicas;
    }

    public int getCantidadDeMensajes(){
        return this.mensajes.size();
    }

    public void eliminarMensajes(){
        for(int i = 0; i < this.getCantidadDeMensajes();i++){
            this.mensajes.remove(i);
        }
    }

    public ListaSimplementeEnlazada<Mensaje> getMensajes(){
        return this.mensajes;
    }

    public String getNombreDelForo() {
        return nombreDelForo;
    }
}
