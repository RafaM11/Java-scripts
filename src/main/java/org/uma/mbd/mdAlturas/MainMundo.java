package org.uma.mbd.mdAlturas;

import org.uma.mbd.mdAlturas.alturas.*;

import java.io.FileNotFoundException;

public class MainMundo {
    public static void main(String args[]) throws FileNotFoundException {
        Mundo paises = new Mundo();
        paises.leePaises("recursos/mdAlturas/alturas.txt");
        for (Pais pais : paises.selecciona(new MayoresQue(1.77))) {
            System.out.println(pais);
        }
        System.out.println();
        for (Pais pais : paises.selecciona(new MenoresQue(1.77))) {
            System.out.println(pais);
        }
        System.out.println();
        for (Pais pais : paises.selecciona(new EnContinente("Europe"))) {
            System.out.println(pais);
        }

    }
}