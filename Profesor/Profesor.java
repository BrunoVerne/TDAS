package ar.uba.fi.cb100.c2025_01.Profesor;

import ar.uba.fi.cb100.c2025_01.ValidacionesUtiles;
import ar.uba.fi.cb100.c2025_01.estructuras.listas.ListaSimplementeEnlazada;

import java.util.ArrayList;
import java.util.List;

public class Profesor {

    /**
     * recube uba lista de alumnos y una lista de promedios
     * @return los mejores alumnos de cada materia, si se repite el alumno, no lo agrega
     */
    public ListaSimplementeEnlazada<Alumno> buscarMejoresAlumnos(ListaSimplementeEnlazada<Alumno> alumnos,
                                                                 ListaSimplementeEnlazada<Nota> promedios){
        ListaSimplementeEnlazada<Alumno> mejoresAlumnos = new ListaSimplementeEnlazada<>();
        ListaSimplementeEnlazada<String> materias = buscarMaterias(promedios);
        for(String materia : materias){
            Alumno mejorPromedio = buscarAlumnoPorPadron(buscarMejorPromedio(materia, promedios),alumnos);
            if(!mejoresAlumnos.contains(mejorPromedio)){
                mejoresAlumnos.add(mejorPromedio);
            }
        }
        return mejoresAlumnos;
    }

    /**
     * recibe una lista de notas
     * @return las materias encontradas en esa lista de notas
     */
    public ListaSimplementeEnlazada<String> buscarMaterias(ListaSimplementeEnlazada<Nota> notas){
        ListaSimplementeEnlazada<String> listaDeMaterias = new ListaSimplementeEnlazada<>();
        for(Nota nota : notas){
            String materia = nota.getMateria();
            if(!listaDeMaterias.contains(materia)){
                listaDeMaterias.add(materia);
            }
        }
        ValidacionesUtiles.validarNoNulo(listaDeMaterias, "Lista de materias encontradas");
        return listaDeMaterias;
    }

    /**
     * recibe un String materia y una lista de promedios,
     * devuelve el padron del mejor promedio
     */
    public int buscarMejorPromedio(String materia, ListaSimplementeEnlazada<Nota> promedios){
        Integer mejorPromedio = null;
        for(Nota nota : promedios){
            if(nota.getMateria().equals(materia)){
                if(mejorPromedio == null || nota.getValor() > mejorPromedio){
                    mejorPromedio = nota.getPadron();
                }
            }
        }
        ValidacionesUtiles.validarNoNulo(mejorPromedio, "mejor promedio");
        return mejorPromedio;
    }

    /**
     * recibe un numero de padron y un listado de alumnos
     * @return el alumno encontrado con el padron, si no lo encuentra tira excepcion
     */
    public Alumno buscarAlumnoPorPadron(int padron, ListaSimplementeEnlazada<Alumno> alumnos){
        Alumno alumnoencontrado = null;
        for(Alumno alumno : alumnos){
            if(alumno.getPadron() == padron){
                alumnoencontrado = alumno;
            }
        }
        ValidacionesUtiles.validarNoNulo(alumnoencontrado, "alumno");
        return alumnoencontrado;
    }
}
