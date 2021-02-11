package org.uma.mbd.mdJarras;

import org.uma.mbd.mdJarras.jarras.Jarra;
import org.uma.mbd.mdJarras.jarras.Mesa;

public class Main {
    public static void main(String[] args) {

        Mesa mesa = new Mesa(7, 5);

        mesa.llenaB();
        mesa.vaciaA();
        mesa.vuelcaBsobreA();
        mesa.llenaB();
        mesa.vuelcaBsobreA();
        mesa.vaciaA();
        mesa.vuelcaBsobreA();
        mesa.llenaB();
        mesa.vuelcaBsobreA();

        System.out.println(mesa.toString());



    }
}
