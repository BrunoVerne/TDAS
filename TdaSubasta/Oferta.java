package ar.uba.fi.cb100.c2025_01.TdaSubasta;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;

public class Oferta {
    private final String nombreOfertante;
    private final float montoOfertado;

    public Oferta(String nombreOfertante, float ofertaRealizada){
        ValidacionesUtiles.validarNoNulo(nombreOfertante, "nombre del ofertante");
        ValidacionesUtiles.validarNoNulo(ofertaRealizada, "oferta realizada");
        ValidacionesUtiles.validarMayorACero(ofertaRealizada, "oferta realizada");
        this.nombreOfertante = nombreOfertante;
        this.montoOfertado = ofertaRealizada;

    }

    public String getNombreOfertante() {
        return nombreOfertante;
    }

    public float getMontoOfertado() {
        return montoOfertado;
    }
}
