package ar.uba.fi.cb100.c2025_01.IngenieroQuimico;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;

public class Compuesto {
    private String nombre;
    private double cantidad;
    private UnidadDeMedida unidadDeMedida;

    public Compuesto(String nombre, double cantidad, UnidadDeMedida unidadDeMedida) {
        ValidacionesUtiles.validarNoNulo(nombre, "nombre");
        this.nombre = nombre;
        this.cantidad = 0;
        this.unidadDeMedida = unidadDeMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public UnidadDeMedida getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void cambiarUnidadDeMedida(UnidadDeMedida unidadDeMedida){
        this.unidadDeMedida = unidadDeMedida;
    }

    public void cambiarCantidad(double cantidad){
        ValidacionesUtiles.validarMayorACero(cantidad, "cantidad");
        this.cantidad = cantidad;

    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        Compuesto other = (Compuesto) obj;
        return this.unidadDeMedida == other.unidadDeMedida && this.nombre.equals(other.nombre) &&
                this.cantidad == other.cantidad ;
    }
}
