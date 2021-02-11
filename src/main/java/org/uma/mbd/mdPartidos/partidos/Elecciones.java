package org.uma.mbd.mdPartidos.partidos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Elecciones {
    private List<Partido> partidos;

    static private Partido stringToPartido(String dato) {
        try (Scanner sc = new Scanner(dato)) {
            sc.useDelimiter("[,]+");
            String nombre = sc.next();
            int votos = sc.nextInt();
            Partido partido = new Partido(nombre, votos);
            return partido;
        } catch (NumberFormatException e) {
            throw new EleccionesException("Error en dato numérico en " + dato);
        } catch (NoSuchElementException e) {
            throw new EleccionesException("No hay más 'tokens'");
        }
    }

    public void leeDatos(String [] datos) {
        partidos = new ArrayList<>();
        for (int i = 0; i < datos.length; i++) {
            Partido p = stringToPartido(datos[i]);
            partidos.add(p);
        }
    }

    public void leeDatos(String nombreFichero) throws IOException {
        partidos = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(nombreFichero))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                Partido p = stringToPartido(linea);
                partidos.add(p);
            }
        }
    }

    public Map<Partido, Integer> generaResultados(CriterioSeleccion cs, int numEsc) {
        // Generamos un mapa "m" a partir de una llamada a la interfaz. Como tenemos que asignar escaños a todos los
        // partidos, el bucle for-each va a ir desde el primer partido hasta la lista de partidos.
        // Para asignar los escaños creamos una variable entera que nos devuelva el valor (escaños) de cada partido (clave)
        // o 0 en caso de que no encuentre este valor. Por último asignamos a cada partido esta variable entera.
        Map<Partido, Integer> m = cs.ejecuta(partidos, numEsc);
        for (Partido p : partidos) {
            int escanosPartido = m.getOrDefault(p, 0);
            m.put(p, escanosPartido);
        }
        return m;
    }

    public void presentaResultados(String nombreFichero, Map<Partido, Integer> map) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(nombreFichero)) {
            presentaResultados(pw, map);
        }
    }

    public void presentaResultados(PrintWriter pw, Map<Partido, Integer> map) {
        for (Partido p : partidos) {
            if (map.get(p) == 0) {
                pw.println(p + ", " + "Sin representación");
            } else {
                pw.println(p + ", " + map.get(p));
            }
        }
    }
}
