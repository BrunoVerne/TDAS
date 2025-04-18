import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    String nombreProyecto;
    private List<Empleado> empleadosAsignados;
    private int diasDeTrabajo;
    public enum Estado {
        EN_PROGRESO,
        COMPLETADO
    }
    private Estado estadoActual;

    public Proyecto(String nombreProyecto, Empleado empleado, int diasDeTrabajo){
        this.estadoActual = Estado.EN_PROGRESO;
        this.empleadosAsignados = new ArrayList<Empleado>();
        this.empleadosAsignados.add(empleado);
        setdiasDeTrabajo(diasDeTrabajo);
        setnombreProyecto(nombreProyecto);
    }

    public void setnombreProyecto(String nombreProyecto) {
        if(nombreProyecto.isBlank()){
            throw new RuntimeException("El nombre no puede ser nulo");
        }
        this.nombreProyecto = nombreProyecto;
    }

    private void setdiasDeTrabajo(int diasDeTrabajo) {
        if(diasDeTrabajo < 0){
            throw new RuntimeException("La cantidad de dias no pueden ser menores a cero");

        }
        this.diasDeTrabajo = diasDeTrabajo;
    }

    /**
     * metodo que recibe un empleado para ser agregao al proyecto, en void para que solo sea manejable desde la clase Empresa
     * @param empleado es agregado al proyecto, validaciones ele empleado en su respectiva clase
     */
    void agregarEmpleado(Empleado empleado){
        this.empleadosAsignados.add(empleado);
    }

    /**
     * devuelve el costo total de cada proyecto usando los dias de trabajo y el salario de los trabajadores
     */
    public double costeProyecto(){
        double contador = 0.00;
        for(int i = 0; i < this.empleadosAsignados.size(); i++){
            contador += this.empleadosAsignados.get(i).getSalario();
        }
        return contador / 30 * this.diasDeTrabajo;
    }

    public boolean EmpleadoDuplicado(Empleado empleado){
        return this.empleadosAsignados.contains(empleado);
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public int getDiasDeTrabajo() {
        return diasDeTrabajo;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }


    /**
     * cambia el estado del proyecto a COMPLETADO
     */
    void cambiarAFinalizado(){
        this.estadoActual = Estado.COMPLETADO;
    }
    void cambiarAEnPrgreso(){
        this.estadoActual = Estado.EN_PROGRESO;
    }


    /**
     * analiza si el proyecto esta terminado
     * @return boolean true si esta finalizado boolean false si no lo está
     */
    public boolean proyectoFinalizado(){
        return this.estadoActual == Estado.COMPLETADO;
    }


}
