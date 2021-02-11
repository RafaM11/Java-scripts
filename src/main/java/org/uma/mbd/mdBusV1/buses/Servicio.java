package org.uma.mbd.mdBusV1.buses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Servicio {
    private String ciudad;
    private List<Bus> buses;

    public Servicio(String ciudad) {
        this.ciudad = ciudad;
        buses = new ArrayList<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void leeBuses(String file) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(file))) {
            leeBuses(sc);
        }
        // Sentencia try-with-resources (buscar y leer con detenimiento).
    }

    public void leeBuses(Scanner sc) {

        while (sc.hasNextLine()) {
            String datos = sc.nextLine();
            try {
                String[] datosSeparados = datos.split(",");

                int codBus = Integer.parseInt(datosSeparados[0]);
                String matricula = datosSeparados[1];
                int codLinea = Integer.parseInt(datosSeparados[2]);

                Bus bus = new Bus(codBus, matricula);
                bus.setCodLinea(codLinea);

                buses.add(bus);

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error, faltan datos en " + datos);
            } catch (NumberFormatException e) {
                System.out.println("Error en dato numérico en " + datos);
            }
        }
    }

    public List<Bus> filtra(Criterio criterio) {
        List<Bus> busesOK = new ArrayList<>();
        for (Bus bus : buses) {
            if (criterio.esSeleccionable(bus)) {
                busesOK.add(bus);
            }
        }
        return busesOK;
    }

    public void guarda(String file, Criterio  criterio)  throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(file)) {
            guarda(pw, criterio);
        }
        // Sentencia try-with-resources igual que en el método leeBuses.
    }

    public void guarda(PrintWriter pw, Criterio criterio) {
        pw.println(criterio);
        List<Bus> busesOK = filtra(criterio);
        for (Bus bus : busesOK) {
            pw.println(bus);
        }
    }
}