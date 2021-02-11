package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.*;

public class IndiceLineas extends Indice {

    public Map<String, Set<Integer>> palabras;

    public IndiceLineas() {
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
                while (sc.hasNext()) {
                    String palabra = sc.next().toLowerCase();
                    if (!palabrasNoSig.contains(palabra)) {
                        Set<Integer> lineas = palabras.computeIfAbsent(palabra, k -> new TreeSet<>());
                        lineas.add(numeroLinea);
                    }
                }
            }
            numeroLinea++;
        }
    }

    public void presentarIndiceConsola() {
        for (String p : palabras.keySet()) {
            System.out.print(p + "\t" + "\t");
            for (int i : palabras.get(p)) {
                System.out.print(i + ".");
            }
            System.out.println();
        }
    }
}
