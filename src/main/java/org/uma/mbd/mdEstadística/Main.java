package org.uma.mbd.mdEstadística;

import org.uma.mbd.mdEstadística.estadística.Estadistica;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Estadistica es = new Estadistica();
        Random rnd = new Random();

        for (int i = 0; i < 1000000; i++){
            es.agrega(rnd.nextGaussian());
        }

        System.out.println("Media: " + es.media());
        System.out.println("Desviación típica: " + es.desviacionTipica());
    }
}
