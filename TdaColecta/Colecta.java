package ar.uba.fi.cb100.c2025_01.TdaColecta;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.listas.ListaSimplementeEnlazada;

public class Colecta {
    private ListaSimplementeEnlazada<Donacion> donaciones;
    private Double montoObjetivo;
    private double montoMaximoRecibido = 0;
    private Double montoMaximoAceptado;
    public Colecta(double montoObjetivo, double montoMaximoAceptado) throws Exception{
        ValidacionesUtiles.validarNoNulo(montoObjetivo, "monto objetivo");
        ValidacionesUtiles.validarMayorACero(montoObjetivo,"monto objetivo");

        ValidacionesUtiles.validarNoNulo(montoMaximoAceptado, "monto maximo aceptado");
        ValidacionesUtiles.validarMayorACero(montoMaximoAceptado, "monto maximo aceptado");

        this.montoObjetivo = montoObjetivo;
        this.montoMaximoAceptado = montoMaximoAceptado;
        this.donaciones = new ListaSimplementeEnlazada<>();

    }



    public ListaSimplementeEnlazada<Donacion> getDonaciones(){
        return this.donaciones;
    }
    public double getMontoMaximo(){
        ValidacionesUtiles.validarNoNulo(montoMaximoRecibido, "monto Maximo recibibido");
        return this.montoMaximoRecibido;
    }
    public double getmontoObjetivo(){
        return this.montoObjetivo;
    }

    public void donar(Donacion donacion) throws Exception{
        double montoDonacion = donacion.getmonto();
        if(montoDonacion > this.montoMaximoAceptado){
            throw new Exception("El monto donado es mayor al monto maximo aceptado");
        }
        if(montoDonacion > montoMaximoRecibido){
            montoMaximoRecibido = montoDonacion;
        }
        this.donaciones.add(donacion);
    }

    public double calcularRecaudacion(){
        double contadorDonaciones = 0;

        for( Donacion donacion : this.donaciones){
            contadorDonaciones += donacion.getmonto();
        }

        return contadorDonaciones;
    }

    public int getCantidadDonaciones(){
        return this.donaciones.size();
    }

    public double recaudacionFaltante(){
        double montoObtenido = this.calcularRecaudacion();
        if(montoObtenido > montoObjetivo){
            return 0;
        }
        return montoObjetivo - montoObtenido;
    }









}
