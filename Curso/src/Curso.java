public class Curso {
    private Estudiante[] estudiantes;
    private int maximoEstudiantes;

    public Curso(Estudiante[] estudiantes, int maximoEstudiantes) {
        setmaximoEstudiantes(maximoEstudiantes);
        this.estudiantes = new Estudiante[maximoEstudiantes];
        for (int i = 0; i < estudiantes.length; i++) {
            this.estudiantes[i] = null;
        }

    }

    /**
     * asigna maximo de estudiantes
     *
     * @param maximoEstudiantes no puede ser menor a 0
     */
    private void setmaximoEstudiantes(int maximoEstudiantes) {
        if (maximoEstudiantes <= 0) {
            throw new RuntimeException("El minimo de estudiantes es 1");
        }
        this.maximoEstudiantes = maximoEstudiantes;
    }


    /**
     * devuelve la cantidad de estudiantes
     */
    public int getcantidadEstudiantes() {
        for (int i = 0; i < estudiantes.length; i++) {
            if (this.estudiantes[i] == null) {
                return i;
            }
        }
        return this.estudiantes.length;
    }

    /**
     * analiza si el curso esta lleno
     */
    private boolean cursoLLeno() {
        return this.getcantidadEstudiantes() == this.estudiantes.length;
    }

    /**
     * agrega un estyduabte ak curso
     */
    public void agregarEstudiante(Estudiante estudiante) {
        if (this.cursoLLeno()) {
            throw new RuntimeException("El curso ya se encuentra lleno");
        }
        this.estudiantes[getcantidadEstudiantes()] = estudiante;
    }

    /**
     * muestra todos los estudiantes del curso, el curso no puede estar vacio
     */
    public void listarEstudiantesInscriptos() {
        if (this.getcantidadEstudiantes() == 0) {
            throw new RuntimeException("NO hay estudiantes inscriptos en este curso");
        }
        for (int i = 0; i < getcantidadEstudiantes(); i++) {
            System.out.println(estudiantes[i].getNombre());
        }

    }

    /**
     * borra ultimo estudiante de la lista de estudiantes
     */

    public Estudiante borrarEstudiante(Estudiante estudianteABorrar){
        if (estudianteABorrar == null) {
            throw new RuntimeException("El estudiante no existe");
        }

        if (this.getcantidadEstudiantes() == 0) {
            throw new RuntimeException("No hay estudiantes en este curso");
        }

        int indice = 0;
        boolean encontrado = false;

        // Buscar el estudiante en el arreglo
        do {
            if (this.estudiantes[indice] == estudianteABorrar) {
                encontrado = true;
            } else {
                indice++;
            }
        } while (!encontrado && indice < this.getcantidadEstudiantes());

        if (!encontrado) {
            throw new RuntimeException("No se ha encontrado ese estudiante");
        }

        // Correr elementos para eliminar al estudiante
        for (int i = indice; i < this.getcantidadEstudiantes() - 1; i++) {
            this.estudiantes[i] = this.estudiantes[i + 1];
        }

        // Limpiar la última posición
        this.estudiantes[this.getcantidadEstudiantes() - 1] = null;

        return estudianteABorrar;
    }
}
