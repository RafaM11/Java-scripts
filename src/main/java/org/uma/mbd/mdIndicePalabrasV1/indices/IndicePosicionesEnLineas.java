package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.*;

public class IndicePosicionesEnLineas extends Indice {
    public Map<String, Map<Integer, Set<Integer>>> palabras;

    public IndicePosicionesEnLineas() {
        super();
        palabras = new TreeMap<>();
    }

    public void agregarLinea(String texto) {
        super.agregarLinea(texto);
        palabras.clear();
    }

    public void resolver(String delimitadores, Collection<String> noSignificativas) {

        int numeroLinea = 1;

        Set<String> palabrasNoSig = new HashSet<>();
        for (String palabra : noSignificativas) {
            palabrasNoSig.add(palabra.toLowerCase());
            // Las añadimos en minúscula y usamos este criterio para todo el ejercicio.
        }

        for (String linea : texto) {
            try (Scanner sc = new Scanner(linea)) {
                sc.useDelimiter(delimitadores);
                int posicion = 1;
                while (sc.hasNext()) {
                    String palabra = sc.next().toLowerCase();
                    if (!palabrasNoSig.contains(palabra)) {
                        Map<Integer, Set<Integer>> mapa = palabras.computeIfAbsent(palabra, k -> new TreeMap<>());
                        Set<Integer> lineas = mapa.computeIfAbsent(numeroLinea, k -> new TreeSet<>());
                        lineas.add(posicion);
                    }
                    posicion++;
                }
            }
            numeroLinea++;
        }
    }

    public void presentarIndiceConsola() {
        for (String p : palabras.keySet()) {
            System.out.print(p);
            System.out.println();
            for (int i : palabras.get(p).keySet()) {
                System.out.print("\t" + "\t" + i + "\t");
                for (int j : palabras.get(p).get(i)) {
                    System.out.print(j + ".");
                }
                System.out.println();
            }
        }
    }
}