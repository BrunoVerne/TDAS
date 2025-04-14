public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private int copiasDisponibles;




    public Libro(String titulo, String autor, int anioPublicacion, int copiasDisponibles){
        setTitulo(titulo);
        setAutor(autor);
        setanioPublicacion(anioPublicacion);
        setcopiasDisponibles(copiasDisponibles);

    }

    /**
     * le quita una copia disponible al libro prestado
     */
    public void prestar(){
        this.setcopiasDisponibles(getcopiasDisponibles() - 1);
    }

    /**
     * le suma una copia al libro devuelto a la libreria
     */
    public void devolver(){
        this.setcopiasDisponibles(getcopiasDisponibles() + 1);
    }

    /**
     *
     * Devuelve atributo titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * devuelve atributo autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * devuelve atributo anioPublicacion
     */
    public int getanioPublicacion() {
        return anioPublicacion;
    }

    /**
     * devuelve atributo copiasDisponibles
     */
    public int getcopiasDisponibles() {
        return copiasDisponibles;
    }


    /**
     * Establece el año de publicación
     * @param titulo no debe vacio
     * @throws RuntimeException si el titulo es vacio
     */
    private void setTitulo(String titulo) {
        if (titulo.isBlank()){
            throw new RuntimeException("El titulo del libro no puede ser vacío ");
        }
        this.titulo = titulo;
    }

    /**
     * Establece el autor
     * @param autor no debe ser vacio
     * @throws RuntimeException si el autor es vacio
     */
    private void setAutor(String autor) {
        if (autor.isBlank()){
            throw new RuntimeException("El nombre de autor no puede ser vacío ");
        }
        this.autor = autor;
    }

    /**
     * Establece el año de publicación
     * @param anioPublicacion debe ser > 2025
     * @throws RuntimeException si el año es futuro
     */
    private void setanioPublicacion(int anioPublicacion) {
        if(anioPublicacion > 2025){
            throw new RuntimeException("NO puede ser publicado un año inexistente");
        }
        this.anioPublicacion = anioPublicacion;
    }

    /**
     * Establece las copiasDisponibles
     * @param copiasDisponibles debe ser >= 0
     * @throws RuntimeException si las copias son < 0
     */
    private void setcopiasDisponibles(int copiasDisponibles) {
        if(copiasDisponibles < 0){
            throw new RuntimeException("Las copias disponibles no pueden ser menores a 0");
        }
        this.copiasDisponibles = copiasDisponibles;
    }

    public void quitarCopia(){
        if(this.getcopiasDisponibles() == 0){
            throw new RuntimeException("No se puede borrar porque las copias disponibles no pueden ser menores a 0");
        }
        this.setcopiasDisponibles(getcopiasDisponibles() - 1);
    }






}