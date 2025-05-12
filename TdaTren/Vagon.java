package ar.uba.fi.cb100.c2025_01.TdaTren;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.listas.ListaSimplementeEnlazada;
import ar.uba.fi.cb100.c2025_01.estructuras.vector.Vector;

public class Vagon {
    private float cargaMaxima;
    private float cargaActual;


    public Vagon(float cargaMaxima){
        ValidacionesUtiles.validarNoNulo(cargaMaxima, "carga maxima");
        ValidacionesUtiles.validarMayorACero(cargaMaxima, "capacidad maxima");
        this.cargaMaxima = cargaMaxima;
        this.cargaActual = 0;
    }

    public float getCargaActual() {
        return cargaActual;
    }


    public void setCarga(float carga) throws Exception{
        ValidacionesUtiles.validarNoNulo(carga, "carga");
        ValidacionesUtiles.validarMayorACero(carga, "carga");
        if(cargaDisponible() < carga){
            throw new Exception("La carga a agregar excede a la carga disponible");
        }
        this.cargaActual += carga;
    }

    public boolean estaVacio(){
        return this.getCargaActual() == 0;
    }

    public float cargaDisponible(){
        return this.getCargaMaxima() - this.getCargaActual();
    }

    public float getCargaMaxima() {
        return cargaMaxima;
    }




}
