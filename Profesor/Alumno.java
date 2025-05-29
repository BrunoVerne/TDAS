package ar.uba.fi.cb100.c2025_01.Profesor;

public class Alumno {
    private int padron;
    private String nombre;

    public Alumno(int padron, String nombre) {
        this.padron = padron;
        this.nombre = nombre;
    }

    public int getPadron() {
        return padron;
    }

    public String getNombre() {
        return nombre;
    }
}
