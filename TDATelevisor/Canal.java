package ar.uba.fi.cb100.c2025_01.TDATelevisor;

public class Canal {
    private int volumen;
    private int volumenMaximo = 0;

    public Canal(int volumen) throws Exception {
        setVolumen(volumen);
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
        if(volumenMaximo < volumen){
            volumenMaximo = volumen;
        }
    }

    public int getVolumenMaximoEscuchado(){
        return this.volumenMaximo;
    }

    public int getVolumenActual(){
        return this.volumen;
    }
}
