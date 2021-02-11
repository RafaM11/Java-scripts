package org.uma.mbd.mdBusV1.buses;

import java.io.FileNotFoundException;


public class MainPrueba {
    public static void main(String[] args) {

        Servicio servicio = new Servicio("Málaga");
        try {
            servicio.leeBuses("recursos/mdBusV1/buses.txt");
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no se encuentra en la ruta seleccionada.");
        }

        System.out.println(servicio.getBuses());

    }
}
