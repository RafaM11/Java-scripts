/* package org.uma.mbd.mdBancoV1L.banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private final static int PRIMER_NUM_CTA = 1001;
    private String nombre;
    private int snc;
    private List<Cuenta> ctas;

    public Banco(String nombre) {
        this.nombre = nombre;
        snc = PRIMER_NUM_CTA;
        ctas = new ArrayList<>();
    }

    public int abrirCuenta(String nombreCliente, double saldo) {
        int numeroCuenta = snc;
        Cuenta cuenta = new Cuenta(nombreCliente, numeroCuenta, saldo);
        snc++;
        ctas.add(Cuenta);
        return numeroCuenta;
    }

    public int abrirCuenta(String nombreCliente) {
        return abrirCuenta(nombreCliente, 0);
    }

    public void cerrarCuenta(int numc) {
        int pos = posicionCuenta(numc);
        ctas.remove(pos);
        }

    private int posicionCuenta(int numeroCuenta) {
        int pos = 0;
        while (pos < ctas.size() && ctas.get(pos).getNumCuenta() != numeroCuenta) {
            pos++;
        }
        if (pos == ctas.size()) { /* Significa que hemos llegado al final y no la hemos encontrado */
         /*   throw new RuntimeException("Cuenta no existe " + numeroCuenta);
        }
        return pos;
    }

    public void ingreso(int numc, double cantidad) {
        int pos = posicionCuenta(numc);
        ctas.get(pos).ingreso(cantidad);
    }

    public double debito(int numc, double cantidad) {
        int pos = posicionCuenta(numc);
        Cuenta cta = ctas.get(pos);
        double real = Math.min(cantidad,cta.getSaldo());
        cta.debito(real);
        return real;
    }

    public double saldo(int numc) {
        int pos = posicionCuenta(numc);
        return ctas.get(pos).getSaldo();
    }

    public double transferencia(int numco, int numcd, double cantidad) {
        int pos = posicionCuenta(numcd);
        double real = debito(numco, cantidad);
        ingreso(numcd, real);
        return real;
    }

    @Override
    public String toString() {
        String salida = nombre + " : ";
        for(int = 0; i < ctas.size(); i++) {
            salida += ctas.get(i); //No es necesario añadir el toString() a ctas.get(i), con el signo + ya entiende que hay que convertirlo a String.
            if (i < ctas.size() - 1) {
                salida += " ";
            }
        }
        salida += "]"
        return salida;
    }
} */
