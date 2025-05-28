package ar.uba.fi.cb100.c2025_01.IngenieroQuimico;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.listas.ListaSimplementeEnlazada;

public class IngenieroQuimico {

    public ListaSimplementeEnlazada<Solucion> BuscarSolucionesEquivalentes(Solucion solucionRequerida,
                                                                           ListaSimplementeEnlazada<Solucion> solucionesDisponibles)
    {
        ListaSimplementeEnlazada<Solucion> solucionesEncontradas = null;
        for(Solucion solucion : solucionesDisponibles){
            if(coincideCompuestos(solucion, solucionRequerida)){
                if(coincideCantidades(solucion.getCompuestos(), solucionRequerida.getCompuestos()));
                solucionesEncontradas.add(solucion);
            }
        }
        ValidacionesUtiles.validarNoNulo(solucionesEncontradas, "soluciones Encontradas");

        return solucionesEncontradas;

    }

    public boolean coincideCompuestos(Solucion solucion1, Solucion solucion2){
        for(Compuesto compuesto : solucion1.compuestos){
            if(!solucion2.getCompuestos().contains(compuesto)){
                return false;
            }
        }
        return true;
    }

    public boolean coincideCantidades(ListaSimplementeEnlazada<Compuesto> compuestos1,
                                      ListaSimplementeEnlazada<Compuesto> compuestos2){

        for(Compuesto compuesto : compuestos1){
            if(!compuestoCoincidente(compuesto, compuestos2)){
                return false;
            }
        }
        return true;


    }

    public boolean compuestoCoincidente(Compuesto compuestoACoincidir,
                                        ListaSimplementeEnlazada<Compuesto> compuestos){
        for(Compuesto compuesto : compuestos){
            if(compuesto.getNombre().equals(compuestoACoincidir.getNombre())){
                if(compuestoACoincidir.getUnidadDeMedida() != compuesto.getUnidadDeMedida() ||
                        compuestoACoincidir.getCantidad() > 2* compuesto.getCantidad() ||
                        compuestoACoincidir.getCantidad() < compuesto.getCantidad()) {
                    return false;
                }
            }
        }
        return true;
    }
}
