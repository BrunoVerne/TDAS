public class Pedido {
    Producto[] listaproductos;

    public Pedido(Producto[] listaproductos, int cantidadmaxima){
        this.listaproductos = new Producto[cantidadmaxima];
        for(int i =0;i < cantidadmaxima;i++){
            this.listaproductos[i] = null;

        }
    }

    private boolean estaLLeno(){
        return this.listaproductos.length == this.getcantidadProductos();
    }

    public void agregarProducto(Producto producto){
        if(producto == null){
            throw new RuntimeException("El producto no puede ser nulo");
        } else if (estaLLeno()) {
            throw new RuntimeException("EL carrito ya esta lleno");
        }
        this.listaproductos[getcantidadProductos()] = producto;
    }

    private int getcantidadProductos(){
        for(int i = 0; i < this.listaproductos.length; i++){
            if (this.listaproductos[i] == null){
                return i;
            }

        }
        return this.listaproductos.length;
    }

    public void eliminarProducto(Producto producto){
        if(producto == null){
            throw new RuntimeException("El producto no puede ser nulo");

        }
        boolean encontrado = false;
        int indice =0;
        while((indice < this.getcantidadProductos() && !encontrado)){
            if(this.listaproductos[indice].equals(producto)){
                encontrado = true;

            }
            indice++;
        }

        if(!encontrado){
            throw new RuntimeException("El producto ingresado no se encuentra en el carrito");
        }

        for(int i = indice - 1; i < this.getcantidadProductos() - 1;i++){
            this.listaproductos[i] = this.listaproductos[i +1];
        }
        this.listaproductos[getcantidadProductos() - 1] = null;
    }

    public double PrecioTotal(){
        double contador = 0.00;
        for(int i = 0; i < this.getcantidadProductos(); i++){
            contador += this.listaproductos[i].getPrecio();
        }
        return contador;
    }

    public void resumenPedido(){
        for(int i = 0; i < getcantidadProductos(); i++){
            System.out.println(this.listaproductos[i].getNombre());
        }
    }


}
