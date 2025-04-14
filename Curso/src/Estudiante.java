public class Estudiante {
    private String nombre;
    private int numeroMatricula;
    private Curso[] cursosInscriptos = null;


    public Estudiante(String nombre, int numeroMatricula, int maximoCursos) {
        setNombre(nombre);
        setnumeroMatricula(numeroMatricula);
        this.cursosInscriptos = new Curso[maximoCursos];
        for (int i = 0; i < maximoCursos; i++) {
            this.cursosInscriptos[i] = null;
        }
    }

    /**
     * devuelve el nombre del alumno
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * devuelve el numero de matricula del estudiante
     *
     * @return
     */
    public int getNumeroMatricula() {
        return this.numeroMatricula;
    }

    /**
     * asigna nombre al estudiante
     *
     * @param nombre no puede estar vacío
     */
    private void setNombre(String nombre) {
        if (nombre.isBlank()) {
            throw new RuntimeException("EL nombre no puede ser nulo");
        }
        this.nombre = nombre;
    }


    /**
     * asigna numero de matricula del estudiante
     *
     * @param numeroMatricula no puede ser menor o igual a cero
     */
    private void setnumeroMatricula(int numeroMatricula) {
        if (numeroMatricula <= 0) {
            throw new RuntimeException("EL numero de matricula no puede ser menor a 0");

        }
        this.numeroMatricula = numeroMatricula;
    }

    public int getCursosInscriptos() {

        for (int i = 0; i < this.cursosInscriptos.length; i++) {
            if (this.cursosInscriptos[i] == null) {
                return i;
            }

        }
        return this.cursosInscriptos.length;
    }

    public void agregarCurso(Curso curso) {
        if (curso == null) {
            throw new RuntimeException("EL curso no existe");
        }
        cursosInscriptos[getCursosInscriptos()] = curso;
    }
}