package ar.uba.fi.cb100.c2025_01.TdaTren;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.listas.ListaSimplementeEnlazada;
import ar.uba.fi.cb100.c2025_01.estructuras.vector.Vector;

import java.util.Iterator;

public class Tren {
    private ListaSimplementeEnlazada<Vagon> vagones;
    private Vector<Locomotora> locomotoras;

    public Tren(Locomotora locomotora) throws Exception{
        this.locomotoras = new Vector<>(3,locomotora);
        this.vagones = new ListaSimplementeEnlazada<>();

    }



    public float capacidadMaximaDeCarga(){
        float contadorCarga = 0;
        for(Vagon vagon : this.vagones){
            contadorCarga += vagon.getCargaMaxima();
        }
        return contadorCarga;
    }

    public float capacidadRestante(){
        return this.capacidadMaximaDeCarga() - this.cantidadActualCargada();
    }

    public void retirarVagonesVacios(){
        Iterator<Vagon> iterador = this.getVagones().iterator();
        while(iterador.hasNext()){
            Vagon vagon = iterador.next();
            if(vagon.estaVacio()){
                iterador.remove();
            }
        }
    }

    public void agregarCarga(float carga) throws Exception{
        ValidacionesUtiles.validarNoNulo(carga, "carga");
        ValidacionesUtiles.validarMayorACero(carga, "carga");
        int i = 0;
        if(carga > this.capacidadRestante()){
            throw new RuntimeException("La cantidad a agregar excede a la cantidad restante para agregar al tren");
        }
        Iterator<Vagon> iterador = this.getVagones().iterator();
        while((iterador.hasNext()) && carga > 0){
            Vagon vagon = iterador.next();
            float cargaDisponible = vagon.cargaDisponible();
            if(carga > cargaDisponible){
                vagon.setCarga(carga);
                carga -= cargaDisponible;
            }else{
                vagon.setCarga(carga);
                carga = 0;
            }

        }

    }

    public ListaSimplementeEnlazada<Vagon> getVagones(){
        return this.vagones;
    }



    public float cantidadActualCargada(){
        float contadorCarga = 0;
        for(Vagon vagon : this.vagones){
            contadorCarga += vagon.getCargaActual();
        }
        return contadorCarga;
    }

    public int cantidadVagonesParaAgregar(){
        return this.locomotoras.getLongitud()*10 -  this.getCantidadVagones();
    }

    public int getCantidadVagones(){
        return this.vagones.size();
    }

    public void AgregarVagon(Vagon vagon){
        if(this.cantidadVagonesParaAgregar() > 0){
            this.vagones.add(vagon);
        }
    }

    public void agregarLocotomora(Locomotora locomotora) throws Exception {
        this.locomotoras.agregar(locomotora);
    }




}

