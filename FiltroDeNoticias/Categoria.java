package ar.uba.fi.cb100.c2025_01.FiltroDeNoticias;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;

public class Categoria {
    private String nombre;
    private String descripcion;

    public Categoria(String nombre, String descripcion) {
        ValidacionesUtiles.validarNoNulo(nombre, "nombre");
        ValidacionesUtiles.validarNoNulo(descripcion, "descripcion");
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Categoria other = (Categoria) obj;
        return this.nombre.equals(other.nombre) && this.descripcion.equals(other.descripcion);
    }

}
