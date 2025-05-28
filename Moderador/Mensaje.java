package ar.uba.fi.cb100.c2025_01.Moderador;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.listas.ListaSimplementeEnlazada;

public class Mensaje {
    private ListaSimplementeEnlazada<Integer> votosDelMensaje;
    private String texto;
    private String usuario;

    public Mensaje(ListaSimplementeEnlazada<Integer> votosDelMensaje, String texto, String usuario) {
        ValidacionesUtiles.validarNoNulo(texto, "texto");
        ValidacionesUtiles.validarNoNulo(usuario, "usuario");
        this.texto = texto;
        this.usuario = usuario;
        this.votosDelMensaje = new ListaSimplementeEnlazada<>();
    }




    public void agregarVoto(int voto){
        if( voto>10 || voto < 1 ){
            throw new RuntimeException("El voto debe estar entre 1 y 10");
        }
        this.votosDelMensaje.add(voto);
    }
    public ListaSimplementeEnlazada<Integer> getVotosDelMensaje() {
        return votosDelMensaje;
    }

    public int getCantidadVotos(){
        return this.votosDelMensaje.size();
    }

    public double getPromedioDeVotos(){
        double contador = 0;
        for(int i = 0; i < this.getCantidadVotos(); i++ ){
            contador += this.votosDelMensaje.get(i);
        }
        return contador / this.getCantidadVotos();
    }

    public String getTexto() {
        return texto;
    }

    public String getUsuario() {
        return usuario;
    }
}
