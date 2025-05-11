package ar.uba.fi.cb100.c2025_01.TdaColecta;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;

public class Donacion {
    private double monto;

    public Donacion(double monto){
        ValidacionesUtiles.validarNoNulo(monto, "monto");
        ValidacionesUtiles.validarMayorACero(monto, "monto");
        this.monto = monto;
    }

    public double getmonto(){
        return this.monto;
    }
}
