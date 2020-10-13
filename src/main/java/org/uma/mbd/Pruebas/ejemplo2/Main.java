package org.uma.mbd.Pruebas.ejemplo2;

import org.uma.mbd.Pruebas.ejemplo2.coches.Vehiculo;

public class Main {
    public static void main(String[] args) {
        Vehiculo minivan = new Vehiculo(9, 15, 20);
        Vehiculo sportscar = new Vehiculo(10, 25, 30);

        double galones;
        int distancia = 250;

        galones = minivan.capacidadnueva(distancia);
        System.out.println("Para ir a " + distancia + " en minivan, se necesitan " + galones + " galones");
        galones = sportscar.capacidadnueva(distancia);
        System.out.println("Para ir a " + distancia + " en sportscar, se necesitan " + galones + " galones");
    }
}
