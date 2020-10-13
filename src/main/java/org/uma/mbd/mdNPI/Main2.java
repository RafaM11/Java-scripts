package org.uma.mbd.mdNPI;
import org.uma.mbd.mdNPI.npi.NPI;

public class Main2 {
    public static void main(String [] args) {
        // 3 * (6 - 2) + (2 + 7) / 5;
        // NPI 3 6 2 - * 2 7 + 5 / +
        NPI cpi = new NPI();
        cpi.entra(3);
        cpi.entra(6);
        cpi.entra(2);
        cpi.resta();
        cpi.multiplica();
        cpi.entra(2);
        cpi.entra(7);
        cpi.suma();
        cpi.entra(5);
        cpi.divide();
        cpi.suma();

        System.out.println("");
        System.out.println("Resultado " + cpi.getResultado());
        System.out.println("");
        System.out.println(cpi.toString());
    }
}