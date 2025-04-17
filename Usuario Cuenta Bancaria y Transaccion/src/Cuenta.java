import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private int numeroCuenta;
    private double saldo;
    private List<Transaccion> transacciones;

    public Cuenta(int numeroCuenta, double saldo) {
        setSaldo(saldo);
        setNumeroCuenta(numeroCuenta);
        this.transacciones =  new ArrayList<>();

    }


    /**
     * le quita el monto pagado al salgo de la cuenta validando fondos
     * @param monto no debe ser menor a cero validado en Clase usuario
     * @param transaccion debe poder realizarse validando que haya saldo suficiente
     */
    public void realizarPago(double monto, Transaccion transaccion){
        if(this.saldo -  monto < 0){
            throw new RuntimeException("No tiene dinero suficiente para realizar esa transferencia");
        }
        this.saldo = this.saldo - monto;
        agregarTransaccion(transaccion);
    }


    /**
     *
     * @param monto no debe ser menor a cero validado en Clase usuario
     * @param transaccion se l
     */
    public void recibirPago(double monto, Transaccion transaccion){
        //validar q la cuenta no se quede sin plata
        this.saldo = this.saldo  + monto;
        agregarTransaccion(transaccion);

    }



    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * valida la asignacion del numero de cuenta
     * @param numeroCuenta no debe ser negativo y debe tener 9 digitos
     */
    private void setNumeroCuenta(int numeroCuenta) {
        if((numeroCuenta < 0) ||  (String.valueOf(numeroCuenta).length() != 9)){
            throw new RuntimeException("Numero de cuenta invalido");
        }
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    /**
     * asigna el saldo a la cuenta
     * @param saldo debe ser positivo
     */
    private void setSaldo(double saldo) {
        if(saldo < 0){
            throw new RuntimeException("Saldo incorrecto");
        }
        this.saldo = saldo;
    }




    /**
     * Ususario agregar transaccion, pero metodo set lo define y la crea
     * @param transaccion validada en Clase Usuario
     */
    private void agregarTransaccion(Transaccion transaccion){
        this.transacciones.add(transaccion);
    }
}
