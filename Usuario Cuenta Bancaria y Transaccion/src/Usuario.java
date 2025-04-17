import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<Cuenta> cuentas;
    private long cuil;


    public Usuario(String nombre, long cuil, Cuenta cuenta) {
        setNombre(nombre);
        setcuil(cuil);
        this.cuentas = new ArrayList<Cuenta>();
        this.cuentas.add(cuenta);

    }

    /**
     * Recibe dos cuentas y, con sus respectivas validaciones, hace la logica de una autotransferencia
     * @param cuentaOrigen no puede no pertenecer a las cuentas del usuario
     * @param cuentaDestino no puede no pertenecer a las cuentas del usuario
     * @param monto debe ser mayor a cero y no puede ser a la misma cuenta
     */
    public void autoTransferencia(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto){
        if(cuentaOrigen.equals(cuentaDestino)){
            throw new RuntimeException("No puedes transferirte a la misma cuenta");
        }
        if((this.cuentas.contains(cuentaOrigen)) && (this.cuentas.contains(cuentaDestino))){
            LocalDateTime fechaActual = LocalDateTime.now();
            Transaccion pago = new Transaccion(monto, fechaActual,"PAGO a " + cuentaDestino.getNumeroCuenta(), cuentaOrigen, cuentaDestino);
            Transaccion cobro = new Transaccion(monto, fechaActual,"COBRO RECIBIDO DE  " + cuentaOrigen.getNumeroCuenta(), cuentaOrigen, cuentaDestino);

            cuentaOrigen.realizarPago(monto, pago);
            cuentaDestino.recibirPago(monto, cobro);

        }
    }

    /**
     * calcula el saldo totol del usuario
     * @return el contador que suma los saldos de todas las cuentas
     */
    public double saldoTotal(){
        double contador = 0;
        for(int i = 0; i < this.cuentas.size(); i++){
            contador += this.cuentas.get(i).getSaldo();
        }
        return contador;
    }




    public String getNombre() {
        return nombre;
    }

    /**
     * asigna el nombre al usuario
     * @param nombre no puede ser nulo
     */
    private void setNombre(String nombre) {
        if(nombre.isBlank()){
            throw new RuntimeException("El nombre no puede ser vacio");
        }
        this.nombre = nombre;
    }


    public long getcuil() {
        return cuil;
    }

    /**
     * asigna el cuil al usuario
     * @param cuil tiene que ser de 11 numeros
     */
    private void setcuil(long cuil) {
        String cuilString = String.valueOf(cuil);
        if(cuilString.length() != 11){
             throw new RuntimeException("El cuil debe tener 11 digitos");
        }
        this.cuil = cuil;
    }

    /**
     * inicializo la lista de cuentas
     * @param cuenta validada en su respectiva clase
     */

}
