package ar.uba.fi.cb100.c2025_01.parcialito2;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.listas.ListaSimplementeEnlazada;

public class Editor {
    private String nombre;

    public Editor(String nombre) {
        setNombre(nombre);
    }

    private void setNombre(String nombre) {
        ValidacionesUtiles.validarNoNulo(nombre, "nombre");
        this.nombre = nombre;
    }

    public String getNombreDelEditor() {
        return this.nombre;
    }


    public Imagen SeleccionarImagen(ListaSimplementeEnlazada<Imagen> imagenesDisponibles, int cantidadComentarios) {
        ValidacionesUtiles.validarNoNulo(imagenesDisponibles, "imagenes disponibles");
        ValidacionesUtiles.validarMayorACero(cantidadComentarios, "cantidad de comentarios");
        Imagen imagenEncontrada = null;
        double promedioMaximo=0;
        for (Imagen imagen : imagenesDisponibles) {
            if(tieneComentariosSuficientes(imagen, cantidadComentarios)){
                double promedioPuntuaciondeComentarios = getPromedioPuntuacionDeComentarios(imagen);
                if(promedioPuntuaciondeComentarios > promedioMaximo){
                    promedioMaximo = promedioPuntuaciondeComentarios;
                    imagenEncontrada = imagen;

                }


            }

        }
        ValidacionesUtiles.validarNoNulo(imagenEncontrada, "imagen encontrada");
        return imagenEncontrada;

    }


    public boolean tieneComentariosSuficientes(Imagen imagen, int comentariosSuficientes){
        int contador = 0;
        for(Comentario comentario : imagen.getComentarios()){
            if(comentarioEsValido(comentario)){
                contador++;
            }
            if(contador >= comentariosSuficientes){
                return true;
            }
        }
        return false;
    }



    public double getPromedioPuntuacionDeComentarios(Imagen imagen){
        double Puntuaciontotal = 0;
        int cantidadComentarios=0;
        for(Comentario comentario : imagen.getComentarios()){
            if(comentarioEsValido(comentario)){
                cantidadComentarios++;
                Puntuaciontotal += comentario.getCalificacion();
            }
        }
        ValidacionesUtiles.validarMayorACero(cantidadComentarios, "cantidad de comentarios");
        return Puntuaciontotal / cantidadComentarios;
    }

    public boolean comentarioEsValido(Comentario comentario){
        return comentario.getCalificacion() > 0;
    }






}

