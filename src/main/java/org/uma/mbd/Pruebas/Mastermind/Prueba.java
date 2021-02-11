package org.uma.mbd.Pruebas.Mastermind;

import java.util.Random;

public class Prueba {

    private static Random alea = new Random();

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        int numero[] = new int[4];
        numero[0] = alea.nextInt(10);

        for (int i = 1; i < 4; i++) {
            numero[i] = alea.nextInt(10);
            for (int j = 0; j < i; j++) {
                if (numero[i] == numero[j]) {
                    i--;
                }
                sb.append(numero[i]);
            }
        }

        System.out.println(sb.toString());
    }
}