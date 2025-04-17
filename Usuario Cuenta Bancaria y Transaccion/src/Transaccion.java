import java.time.LocalDateTime;


public class Transaccion {

    private double monto;
    private LocalDateTime fecha;
    private  String tipo;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;


    public Transaccion(double monto, LocalDateTime fecha, String tipo, Cuenta cuentaOrigen,Cuenta cuentaDestino) {
       setMonto(monto);
       setDate(fecha);
       setTipo(tipo);
       setCuentaOrigen(cuentaOrigen);
       setCuentaDestino(cuentaDestino);
    }



    public double getmonto() {
        return monto;
    }

    private void setMonto(double monto) {
        if(monto < 0){
            throw  new RuntimeException("EL monto no puede ser menor a cero");
        }
        this.monto = monto;
    }

    private LocalDateTime getDate() {
        return fecha;
    }

    private void setDate(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {

        return tipo;
    }

    /**
     * asigna el tipo de transaccion
     * @param tipo tiene que ser o PAGO o COBRO
     */
    private void setTipo(String tipo) {

        this.tipo = tipo;
    }

    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }
    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    private void setCuentaOrigen(Cuenta cuenta) {
        this.cuentaOrigen= cuenta;
    }
    private void setCuentaDestino(Cuenta cuenta) {
        this.cuentaDestino= cuenta;
    }
}
