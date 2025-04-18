public class Empleado {
    private String nombre;
    private long cuit;
    private double salario;
    private final  static double SALARIO_MINIMO = 300.000;




    public Empleado(String nombre, long cuit, double salario) {
        setNombre(nombre);
        setCuit(cuit);
        setSalario(salario);
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * asigna el nombre del empleado
     * @param nombre no puede estar vacio
     */
    private void setNombre(String nombre) {
        if(nombre.isBlank()) {
            throw new RuntimeException("El nombre no es válido");
        }
        this.nombre = nombre;

    }

    public long getCuit() {
        return cuit;
    }


    /**
     * asigna el atributo cuil del empleado
     * @param cuit debe tener 11 digitos y  debe ser positivo
     */
    private void setCuit(long cuit) {
        if(String.valueOf(cuit).length() != 11 || cuit < 0){
            throw new RuntimeException("El cuit es inválido");
        }
        this.cuit = cuit;
    }

    public double getSalario() {
        return salario;
    }

    /**
     * asigna atributo salario al empleado
     * @param salario no puede ser menor al salario minimo
     */

    private void setSalario(double salario) {
        if(salario < SALARIO_MINIMO){
            throw new RuntimeException("El salario no puede ser menor a lo establecido");
        }
        this.salario = salario;
    }
}
