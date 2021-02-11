package org.uma.mbd.Pruebas.ejemploJarras;

import org.uma.mbd.Pruebas.ejemploJarras.ej.Jarra;
import org.uma.mbd.Pruebas.ejemploJarras.ej.Mesa;

public class Main {
    public static void main(String[] args) {

        Jarra j1 = new Jarra(7);
        Jarra j2 = new Jarra(5);
        Mesa m = new Mesa(j1, j2);

        j1.llena();
        j2.vacia();
        j2.llenaDesde(j1);
        j1.llena();
        j2.llenaDesde(j1);
        j2.vacia();
        j2.llenaDesde(j1);
        j1.llena();
        j2.llenaDesde(j1);

        System.out.println(m.toString());

    }
}
