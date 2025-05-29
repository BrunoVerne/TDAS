package ar.uba.fi.cb100.c2025_01.Profesor;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;

public class Nota {
    private int padron;
    private String materia;
    private double valor;

    public Nota(int padron, String materia, double valor) {
        ValidacionesUtiles.validarNoNulo(materia, "materia");
        ValidacionesUtiles.validarMayorACero(valor, "valor");
        ValidacionesUtiles.validarMayorACero(padron, "padron");
        this.padron = padron;
        this.materia = materia;
        this.valor = valor;
    }

    public int getPadron() {
        return padron;
    }

    public String getMateria() {
        return materia;
    }

    public double getValor() {
        return valor;
    }
}
