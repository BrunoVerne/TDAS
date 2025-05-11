package ar.uba.fi.cb100.c2025_01.TDATelevisor;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.vector.Vector;

public class Televisor {
    private Vector<Canal> canales;
    private final int CANTIDADMAXIMADECANALES = 140;
    private int indiceCanal;
    private EstadoVolumen estadoVolumen;
    private int volumen;

    public Televisor(Canal canal, EstadoVolumen estadoVolumen, int volumen) throws Exception{
        this.canales = new Vector<Canal>(CANTIDADMAXIMADECANALES, canal);
        for(int i = 1; i < CANTIDADMAXIMADECANALES; i++){
            this.canales.agregar(i,null);
        }

        this.indiceCanal = 0;
        this.estadoVolumen = estadoVolumen;

        if(validaVolumen(volumen)){
            this.volumen = volumen;
        }
        else{
            throw  new Exception("El volumen debe estar entre 0 y 100");
        }

    }

    public int getNumeroCanal(){
        return this.indiceCanal;
    }

    public void siguienteCanal() throws Exception{
        if(!existeCanal(this.indiceCanal + 1)){
            throw new Exception("Ese canal no existe en esta televisión");

        }
        this.indiceCanal +=1;
        this.canales.obtener(this.indiceCanal).setVolumen(this.volumen);

    }

    public int ultimoVolumenEscuchado(int posicion) throws Exception{
        return this.canales.obtener(posicion).getVolumenActual();
    }
    public int ultimoVolumenMaximoEscuchado(int posicion) throws Exception{
        return this.canales.obtener(posicion).getVolumenMaximoEscuchado();
    }


    public void anteriorCanal() throws Exception {
        if(this.indiceCanal != 0){
            this.indiceCanal -= 1;
        }
        this.canales.obtener(this.indiceCanal).setVolumen(this.volumen);

    }

    public void ElegirCanal(int posicion)throws Exception{
        if(!existeCanal(posicion - 1)){
            throw new Exception("Ese canal no existe en esta television");
        }
        this.indiceCanal = posicion - 1;
    }



    private boolean existeCanal(int posicion){
        return posicion < this.cantidadCanales() && posicion > 0;
    }

    public void mutearTelevisor(){
        this.estadoVolumen = EstadoVolumen.MUTEADO;
    }

    public void prenderVolumen(){
        this.estadoVolumen = EstadoVolumen.PRENDIDO;
    }

    public EstadoVolumen getEstadoVolumen(){
        return this.estadoVolumen;
    }

    public int cantidadCanales(){
        return this.canales.getLongitud();
    }

    private boolean validaVolumen(int volumen ){
        return volumen >= 0 && volumen <= 100;
    }

    public void cambiarVolumen(int nuevoVolumen) throws Exception{
        if(validaVolumen(nuevoVolumen)){
            this.volumen = nuevoVolumen;
            this.canales.obtener(this.indiceCanal).setVolumen(this.volumen);
        }
        else {
            throw new Exception("EL volumen debe estar entre 0 y 100");
        }
    }

    public Canal CanalMasAltoEscuchado() throws Exception{
        Canal canalMasAltoEscuchado = null;
        int volumenMasAlto = 0;
        for(int i = 0; i < this.cantidadCanales();i++){
            if(this.canales.obtener(i).getVolumenMaximoEscuchado() > volumenMasAlto){
                canalMasAltoEscuchado = this.canales.obtener(i);
            }
        }
        ValidacionesUtiles.validarNoNulo(canalMasAltoEscuchado, "canal mas alto escuchado");
        return canalMasAltoEscuchado;
    }

    public Vector<Canal> getCanales(){
        return this.canales;
    }













}
