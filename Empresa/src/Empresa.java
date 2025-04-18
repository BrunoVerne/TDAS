import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Proyecto> proyectos;


    public Empresa(Proyecto proyecto) {
        this.proyectos = new ArrayList<Proyecto>();
        this.proyectos.add(proyecto);
    }

    /**
     * metodo que recibe un proyecto para ser agregado a la lista de proyectos
     * @param proyecto
     */
    public void agregarProyecto(Proyecto proyecto) {
        this.proyectos.add(proyecto);
    }

    /**
     * recibe un proyecto a borrar y lo borra si existe
     * @param proyectoABorrar debe existir en la lista de proyectos
     * @return el proyecto que fue borrado
     */
    public Proyecto borrarProyecto(Proyecto proyectoABorrar) {
        for (Proyecto proyecto : this.proyectos) {
            if (proyecto.equals(proyectoABorrar)) {
                this.proyectos.remove(proyectoABorrar);
                return proyectoABorrar;
            }
        }
        throw new RuntimeException("El proyecto no existe");
    }

    /**
     * devuelve boolean si existe o no proyecto
     * @param proyecto no debe ser nulo
     * @return true si el proyecto existem false en caso contrario
     */
    private boolean proyectoExiste(Proyecto proyecto) {
        if(proyecto == null){
            throw new RuntimeException("Ese proyecto es nulo");
        }
        return this.proyectos.contains(proyecto);
    }

    /**
     * metodo de asinacion de empleado a cierto proyecto, se le deben pasar por parametro el empleado y el proyecto
     * @param empleado no dede ser duplicado de uno que ya está
     * @param proyecto debe existir en la lista de proyectos
     */
    void asignarEmpleado(Empleado empleado, Proyecto proyecto) {
        if (!proyectoExiste(proyecto)) {
            throw new RuntimeException("Ese proyecto no existe");
        }
        if (proyecto.EmpleadoDuplicado(empleado)) {
            throw new RuntimeException("EL empleado ya está en la lista de empleados");

        }
        proyecto.agregarEmpleado(empleado);

    }

    /**
     * cambia el estado del proyecto
     * @param proyecto debe existir en la lista de proyectos
     */

    private void cambiarAFinalizado(Proyecto proyecto){
        if(!proyectoExiste(proyecto)){
            throw new RuntimeException("Ese proyecto no existe");

        }
        proyecto.cambiarAFinalizado();

    }

    /**
     * variable contador suma todos los costes de los proyectos en la lista de proyectos
     * @return
     */
    public double costeProyectosActuales(){
        double contador = 0.00;
        for(Proyecto proyecto : this.proyectos){
            if(!proyecto.proyectoFinalizado()){
                contador += proyecto.costeProyecto();
            }
        }
        return contador;
    }

    /**
     * informe que te muestra los estados de los proyectos de la lista proyectos
     * Si el proyecto está en transcurso, te mostrara el coste del proyecto y el nombre
     * Si el proyecto ya finalizó te lo avisará y te mostrará el nombre del proyecto
     */
    public void estadoProyectos(){
        for(Proyecto proyecto : this.proyectos) {
            if (proyecto.proyectoFinalizado()){
                System.out.println(proyecto.getNombreProyecto()+ "se encuentra finalizado");
            }
            else{
                System.out.println(proyecto.getNombreProyecto()+ " se encuentra en proceso con un coste de $"
                        + proyecto.costeProyecto());
            }

        }
    }


}

