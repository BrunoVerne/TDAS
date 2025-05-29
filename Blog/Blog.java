package ar.uba.fi.cb100.c2025_01.Blog;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.listas.ListaSimplementeEnlazada;

public class Blog {
    private ListaSimplementeEnlazada<Articulo> articulos;

    /**
     * crea el objeto blog sin ningun articulo
     */
    public Blog(){
        this.articulos = new ListaSimplementeEnlazada<>();
    }

    /**
     *agrega un articulo a la lista de articulos
     */
    public void agregarArticulo(Articulo articulo){
        this.articulos.add(articulo);
    }


    /**
     * @return todos los articulos que hay en el blog
     */
    public ListaSimplementeEnlazada<Articulo> getArticulos() {
        return articulos;
    }


    /**
     * recibe una lista de palabras  busca los articulos que la contengan parcial o totalmente
     * @param palabrasClaves no puede ser nulo
     * @return una lista de los articulos encontrados
     */
    public ListaSimplementeEnlazada<Articulo> buscarArticulos(ListaSimplementeEnlazada<String> palabrasClaves){
        ValidacionesUtiles.validarNoNulo(palabrasClaves, "palabras claves");
        ListaSimplementeEnlazada<Articulo> articulosEncontrados = new ListaSimplementeEnlazada<>();
        for(Articulo articulo : this.articulos){
            if(!contienePalabrasExcluyentes(articulo, palabrasClaves)){
                if(contieneTodasLasPalabras(articulo, palabrasClaves)){
                    articulosEncontrados.add(articulo);

                }
            }
        }
        return articulosEncontrados;
    }

    /**
     *
     * @param palabras no pueden ser nulas
     * @return true si contiene las palabras excluyentes, false de lo contrario
     */
    public boolean contienePalabrasExcluyentes(Articulo articulo, ListaSimplementeEnlazada<String> palabras){
        ValidacionesUtiles.validarNoNulo(palabras, "palabras");
        for(String palabraExcluyente : articulo.getPalabrasExcluyentes()){
            if(palabras.contains(palabraExcluyente)){
                return true;
            }
        }
        return false;
    }


    /**
     * recibe un articulo y una lista de palabras para ver si el articulo contiene todas las palabras dadas
     * @param articulo no puede ser nulo
     * @param palabras no pueden ser nulas
     * @return true si contiene todas las palabras buscadas, false de lo contrario
     */
    public boolean contieneTodasLasPalabras(Articulo articulo, ListaSimplementeEnlazada<String> palabras){
        ValidacionesUtiles.validarNoNulo(palabras, "palabras");
        for(String palabra: palabras){
            if(!articulo.getDescripcion().contains(palabra) && !articulo.getTitulo().contains(palabra)){
                return false;
            }
        }
        return true;
    }
}
