package ar.uba.fi.cb100.c2025_01.IngenieroQuimico;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.listas.ListaSimplementeEnlazada;

public class Solucion {
    String codigo;
    ListaSimplementeEnlazada<Compuesto> compuestos;

    public Solucion(String codigo, ListaSimplementeEnlazada<Compuesto> compuestos) {
        ValidacionesUtiles.validarNoNulo(codigo, "codigo");
        this.codigo = codigo;
        this.compuestos = compuestos;
    }

    public String getCodigo() {
        return codigo;
    }

    public ListaSimplementeEnlazada<Compuesto> getCompuestos() {
        return compuestos;
    }
}
