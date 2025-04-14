public class Libreria {
    private Libro[] libros = null;


    public Libreria(Libro libro, int cantidadMaximaLibros) {
        this.libros = new Libro[cantidadMaximaLibros];
        for (int i = 0; i < cantidadMaximaLibros; i++) {
            this.libros[i] = null;
        }
        this.libros[0] = libro;
    }

    /**
     * @return cantidad de libros en la libreria
     */
    private int getcantidadLibros() {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] == null) {
                return i;
            }
        }
        return this.libros.length;
    }


    /**
     * @return cantidad maxima de libros
     */
    private int getcantidadMaximaLibros() {
        return this.libros.length;
    }

    /**
     * @return booleano de si esta llena o no
     */
    private boolean estaLlena() {
        return this.getcantidadLibros() == this.getcantidadMaximaLibros();
    }


    /**
     * Pide al usuario un libro
     *
     * @param libro no puede ser nulo
     *              asigna al array libros el nuevo libro
     */
    public void agregarLibro(Libro libro) {
        if (estaLlena()) {
            throw new RuntimeException("La libreria se encuentra llena");
        } else if (libro == null) {
            throw new RuntimeException("El libro no puede ser nulo");
        }
        this.libros[this.getcantidadLibros()] = libro;
    }


    /**
     * Pide el autor para buscarlo en la lista de libros
     *
     * @param autor no puede ser nulo
     * @return el libro del autor encontrado o sino devuelve nulo
     */
    public Libro buscarPorAutor(String autor) {
        if (autor.isBlank()) {
            throw new RuntimeException("El autor no puede ser nulo");

        }
        for (int i = 0; i < this.libros.length; i++) {
            if (this.libros[i].getAutor().equals(autor)) {
                return this.libros[i];
            }
        }
        return null;
    }


    public void prestarLibro(String titulo) {
        Libro libro = buscarPorTitulo(titulo);
        if (libro == null) throw new RuntimeException("Libro no encontrado");
        libro.prestar();
    }

    public void devolverLibro(String titulo) {
        Libro libro = buscarPorTitulo(titulo);
        if (libro == null) throw new RuntimeException("Libro no encontrado");
        libro.devolver();
    }

    /**
     * Pide el autor para buscarlo en la lista de libros
     *
     * @param titulo no puede ser nulo
     * @return el libro del autor encontrado o sino devuelve nulo
     */
    public Libro buscarPorTitulo(String titulo) {
        if (titulo.isBlank()) {
            throw new RuntimeException("El titulo no puede ser nulo");

        }
        for (int i = 0; i < this.libros.length; i++) {
            if (this.libros[i].getTitulo().equals(titulo)) {
                return this.libros[i];
            }
        }
        return null;
    }
}

