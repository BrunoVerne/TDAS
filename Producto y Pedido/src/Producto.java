public class Producto {
    private int codigo;
    private double precio;
    private String nombre;

    public Producto(int codigo, double precio, String nombre) {
        setPrecio(precio);
        setCodigo(codigo);
        setNombre(nombre);
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    private void setCodigo(int codigo) {
        if(codigo < 0){
            throw new RuntimeException("EL codigo no puede ser menor a 0");
        }
        this.codigo = codigo;
    }

    private void setPrecio(double precio) {
        if(precio < 0){
            throw new RuntimeException("EL precio no puede ser menor a 0");
        }
        this.precio = precio;
    }

    private void setNombre(String nombre) {
        if(nombre.isBlank()){
            throw new RuntimeException("EL nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }
}
