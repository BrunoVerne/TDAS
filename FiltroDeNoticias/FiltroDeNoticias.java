package ar.uba.fi.cb100.c2025_01.FiltroDeNoticias;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.listas.ListaSimplementeEnlazada;

public class FiltroDeNoticias {

    public void removerNoticias(ListaSimplementeEnlazada<Noticia> noticias,
                                ListaSimplementeEnlazada<Categoria> conCategorias){

        for(Noticia noticia : noticias){
            if(coincideTodasLasCategorias(noticia.getCategorias(), conCategorias)){
                noticias.remove(noticia);
            }
        }

    }

    public boolean coincideTodasLasCategorias(ListaSimplementeEnlazada<Categoria> categorias,
                                              ListaSimplementeEnlazada<Categoria> categoriasAcoincidir){

        for(Categoria categoria : categorias){
            if(!categoriasAcoincidir.contains(categoria)){
                return false;
            }
        }
        return true;

    }
}
