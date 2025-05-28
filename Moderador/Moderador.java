package ar.uba.fi.cb100.c2025_01.Moderador;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.listas.ListaSimplementeEnlazada;

import javax.sound.midi.InvalidMidiDataException;

public class Moderador {



    /*
       pre: Recibe una lista de foros, un autor y una tematica, ninguna puede ser nula
       post: devuelve el mensaje con mas valorado con el autor y la tematica pedida
     */
    public Mensaje getMensajeMasVotadoDelUsuarioSegunTematica(ListaSimplementeEnlazada<Foro> foros,
                                                      String autorBuscado, String tematicaBuscada){
        ValidacionesUtiles.validarNoNulo(autorBuscado, "autor buscado");
        ValidacionesUtiles.validarNoNulo(tematicaBuscada, "tematica buscada");
        ValidacionesUtiles.validarNoNulo(autorBuscado, "autor buscado");
        ListaSimplementeEnlazada<Foro> forosEncontrados = getForosCoincidentesPorTematica(foros, tematicaBuscada);
        ListaSimplementeEnlazada<Mensaje> mensajesCoincidentes = new ListaSimplementeEnlazada<>();
        for(Foro foro : forosEncontrados){
            mensajesCoincidentes.addAll(getMensajesCoincidentesConAutor(foro.getMensajes(), autorBuscado));
        }
        return getMensajeMasValorado(mensajesCoincidentes);

    }

    /*
    pre: recibe una lista de mensajes no nula
    post: devuelve el mensaje con el promedio de votos mas alto
     */
    private Mensaje getMensajeMasValorado(ListaSimplementeEnlazada<Mensaje> mensajes) {
        ValidacionesUtiles.validarNoNulo(mensajes, "mensajes");
        Mensaje mensajeMasValorado = null;
        for(Mensaje mensaje : mensajes){
            if(mensajeMasValorado == null || mensaje.getPromedioDeVotos() > mensajeMasValorado.getPromedioDeVotos()){
                mensajeMasValorado = mensaje;
            }
        }

        return mensajeMasValorado;
    }


    /*
    pre: recibe una tematica y una lista de foros no nulas
    post: devuelve los foros que coincida con la tematica pedida
     */
    public ListaSimplementeEnlazada<Foro> getForosCoincidentesPorTematica(ListaSimplementeEnlazada<Foro> foros,
                                                                          String tematica){
        ValidacionesUtiles.validarNoNulo(tematica, "tematica");
        ValidacionesUtiles.validarNoNulo(foros, "foros");
        ListaSimplementeEnlazada<Foro> forosEncontrados = new ListaSimplementeEnlazada<>();
        for(Foro foro : foros){
            if(contieneTematica(foro.getTematicas(), tematica)){
                forosEncontrados.add(foro);

            }
        }
        return forosEncontrados;
    }

    /*

     */
    private boolean contieneTematica(ListaSimplementeEnlazada<String> tematicas, String tematicaABuscar) {
        ValidacionesUtiles.validarNoNulo(tematicaABuscar, "tematica a buscar");
        for(String tematica : tematicas){
            if(tematica.equals(tematicaABuscar)){
                return true;
            }
        }
        return false;
    }


    /*
    pre: recibe una lista de mensajes y un autor que queremos buscar en los mensajes
    post: devuelve una lista de mensajes que fueron escritos por el autor pedido
     */
    public ListaSimplementeEnlazada<Mensaje> getMensajesCoincidentesConAutor(ListaSimplementeEnlazada<Mensaje> mensajes,
                                                                          String autorAbuscar){
        ValidacionesUtiles.validarNoNulo(mensajes, "mensajes ");
        ValidacionesUtiles.validarNoNulo(autorAbuscar, "autor a buscar");
        ListaSimplementeEnlazada<Mensaje> mensajesCoincidentes = new ListaSimplementeEnlazada<>();
        for(Mensaje mensaje : mensajes){
            if(mensaje.getUsuario().equals(autorAbuscar)){
                mensajesCoincidentes.add(mensaje);
            }
        }
        return mensajesCoincidentes;
    }




}
