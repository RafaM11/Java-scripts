package org.uma.mbd.mdBusV2.buses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Servicio {
    private String ciudad;
    private SortedSet<Bus> buses;

    public Servicio(String ciudad) {
        this.ciudad = ciudad;
        buses = new TreeSet<Bus>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public Set<Bus> getBuses() {
        return buses;
    }

    public void leeBuses(String file) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(file))) {
            leeBuses(sc);
        }
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

    public SortedSet<Bus> filtra(Criterio criterio, Comparator<Bus> cb) {
        SortedSet<Bus> busesFiltrados = new TreeSet<Bus>(cb);
        for (Bus bus : buses) {
            if (criterio.esSeleccionable(bus)) {
                busesFiltrados.add(bus);
            }
        }
        return busesFiltrados;
    }

    public void guarda(String file, Comparator<Bus> cb, Criterio criterio)  throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(file)) {
            guarda(pw, criterio, cb);
        }
    }

    public void guarda(PrintWriter pw, Criterio criterio, Comparator<Bus> cb) {
        pw.println(criterio);
        Set<Bus> busesPrint = filtra(criterio, cb);
        for (Bus bus : busesPrint) {
            pw.println(bus);
        }
    }
}