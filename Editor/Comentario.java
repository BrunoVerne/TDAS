package ar.uba.fi.cb100.c2025_01.parcialito2;


import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;

public class Comentario {
    private String contenido;
    private int calificacion;

    public Comentario(String comentario) throws Exception{
        setComentario(comentario);
        this.calificacion = 0;
    }

    private void setComentario(String comentario) throws Exception{
        ValidacionesUtiles.validarNoNulo(comentario, "comentario");
        this.contenido = comentario;
    }

    public String getContenido(){
        return this.contenido;
    }
    public int getCalificacion(){
        return this.calificacion;
    }

    public void calificar(int calificacion) throws Exception{
        ValidacionesUtiles.validarNoNulo(calificacion, "calificacion");
        if((calificacion) > 10 || (calificacion < 1)){
            throw new Exception("La calificacion no puede ser mayor a 10 o menor que 0");
        }

        this.calificacion = calificacion;
    }
}
