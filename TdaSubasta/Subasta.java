package ar.uba.fi.cb100.c2025_01.TdaSubasta;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.listas.ListaSimplementeEnlazada;

public class Subasta {
    ListaSimplementeEnlazada<Oferta> ofertas;
    float precioBase = 0;
    String descripcionDelArticulo;
    EstadoSubasta EstadoSubasta;

    public ListaSimplementeEnlazada<Oferta> getOfertas() {
        return this.ofertas;
    }

    public float getPrecioBase() {
        return this.precioBase;
    }

    public String getDescripcionDelArticulo() {
        return this.descripcionDelArticulo;
    }

    public Subasta(String descripcionDelArticulo, Double precioBase){
        ValidacionesUtiles.validarNoNulo(descripcionDelArticulo, "descripcion del articulo");
        this.descripcionDelArticulo = descripcionDelArticulo;

        if(precioBase == null){
            this.precioBase = 0;
        }
        else{
            ValidacionesUtiles.validarMayorACero(precioBase, "precio base");
        }


        this.EstadoSubasta = ar.uba.fi.cb100.c2025_01.TdaSubasta.EstadoSubasta.PENDIENTE;
        this.ofertas = new ListaSimplementeEnlazada<>();
    }

    public void abrirSubasta() throws Exception{
        if(!this.EstadoSubasta.equals(ar.uba.fi.cb100.c2025_01.TdaSubasta.EstadoSubasta.PENDIENTE)){
            throw  new Exception("No es posible abrir sesta subasta");
        }
        this.EstadoSubasta = ar.uba.fi.cb100.c2025_01.TdaSubasta.EstadoSubasta.ABIERTA;

    }

    public void RealizarOferta(Oferta oferta) throws Exception{
        if(!this.EstadoSubasta.equals(ar.uba.fi.cb100.c2025_01.TdaSubasta.EstadoSubasta.ABIERTA)){
            throw new Exception("Solo es posible realizar ofertas en subastas abiertas");
        }

        if(this.ofertas.isEmpty()){
            if(oferta.getMontoOfertado() < this.getPrecioBase()){
                throw new Exception("El monto ofertado no puede ser menor al precio base");

            }
        }else{
            float montoMinimo = this.ofertas.getLast().getMontoOfertado();
            if(oferta.getMontoOfertado() <= montoMinimo || oferta.getMontoOfertado() <= this.getPrecioBase()){
                throw new Exception("El monto ofertado no puede ser menor o igual  a:" + montoMinimo );
            }

        }
        this.ofertas.add(oferta);


    }

    public float getMontoMaximoOfertado(){
        return this.ofertas.get(this.getCantidadDeOfertas() - 1).getMontoOfertado();
    }

    public String getNombreDelMaximoOfertor() throws Exception {
        return this.ofertas.getLast().getNombreOfertante();
    }

    public int getCantidadDeOfertas(){
        return this.ofertas.size();
    }

    public void cerrarSubasta() throws Exception{
        if(!this.EstadoSubasta.equals(ar.uba.fi.cb100.c2025_01.TdaSubasta.EstadoSubasta.ABIERTA)){
            throw new Exception("Solo es posible cerrar subastas abiertas");
        }
        this.EstadoSubasta = ar.uba.fi.cb100.c2025_01.TdaSubasta.EstadoSubasta.CERRADA;
    }

}




