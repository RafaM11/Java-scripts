package org.uma.mbd.mdPartidos.partidos;

import java.util.*;

public class Token implements Comparable<Token> {
    private Partido partido;
    private double ratio;

    public Token(Partido partido, double ratio) {
        this.partido = partido;
        this.ratio = ratio;
    }

    public Partido getPartido() {
        return partido;
    }

    public double getRatio() {
        return ratio;
    }

    @Override
    public int compareTo(Token token) {
        int resultado = -1 * Double.compare(ratio, token.ratio);
        if (resultado == 0) {
            resultado = token.getPartido().getNombre().compareToIgnoreCase(partido.getNombre());
        }
        return resultado;
    }

    public static Set<Token> seleccionaTokens(Set<Token> tks, int numEsc) {
        Set<Token> tokens = new TreeSet<>();
        Iterator<Token> it = tks.iterator();
        for (int i = 0; i < numEsc; i++) { // Entre 0 e (i < numEsc) es lo mismo que entre 1 e (i = numEsc).
            tokens.add(it.next());
        }
        return tokens;
    }

    public static Map<Partido, Integer> generaResultados(Set<Token> tks) {
        // Creamos un mapa que va a recoger todas las correspondencias, pero al principio estará vacío.
        // Iteramos con un for-each desde un token inicial hasta el conjunto "tks" que pasamos por agumento.
        // Al principio el mapa va a estar vacío. En la primera iteración el bucle se va a ir al else y va a asignar
        // en el mapa al primer partido del conjunto la clave 1.
        // En la siguiente iteración suponemos que encontramos el partido de la primera iteración. Como el mapa en su
        // lista de claves ya contiene este partido, al mapa le añadimos este partido (clave) con su respectivo valor.
        // En este caso el valor va a ser 1 más el valor que tenga la clave. Así repetimos todas las iteraciones.

        Map<Partido, Integer> mapa = new TreeMap<>();
        for (Token tk : tks) {
            if (mapa.containsKey(tk.getPartido())) {
                mapa.put(tk.getPartido(), mapa.get(tk.getPartido()) + 1);
            } else {
                mapa.put(tk.getPartido(), 1);
            }
        }
        return mapa;
    }


}
