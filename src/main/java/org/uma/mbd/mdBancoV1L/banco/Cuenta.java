package org.uma.mbd.mdBancoV1L.banco;

public class Cuenta {
    public int numCuenta;
    public String titular;
    public double saldo;

    public Cuenta(String titular, int numCuenta, double saldo) {
        this.titular = titular;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
    }

    public Cuenta(String titular, int numCuenta) {
        this(titular, numCuenta, 0);
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void ingreso(double cantidadIngresada) {
        saldo = saldo + cantidadIngresada;
    }

    public void debito(double cantidadRetirada) {
        saldo = saldo - cantidadRetirada;
    }

    @Override
    public String toString() {
        return "[(" + titular + "/" + numCuenta + ") -> " + saldo + "]";
    }


}
