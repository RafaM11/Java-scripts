package org.uma.mbd.mdPartidos.partidos;

import java.util.*;

public class DHontSimple implements CriterioSeleccion {

    private static Set<Token> creaTokens(List<Partido> partidos, int numEsc) {
        // Creamos un conjunto de tipo Sorted que recoja todos los tokens ordenados.
        SortedSet<Token> tksTotal = new TreeSet<>();

        // Iteramos desde 0 hasta el total de los partidos y desde 1 hasta el total del número de escaños.
        // Añadimos al conjunto creado anteriormente un token en cada iteración.
        // Para añadir este token tenemos que crearlo, obviamente. Un token se compone de un partido y de un ratio.
        // El partido será el de la posición i de la lista en cada iteración. El ratio será el número de votos
        // entre el número j (valores 1, 2, 3... hasta el número de escaños total).

        for (int i = 0; i < partidos.size(); i++) {
            for (int j = 1; j <= numEsc; j++) {
                Token t = new Token(partidos.get(i), partidos.get(i).getVotos()/j);
                tksTotal.add(t);
            }
        }
        return tksTotal;
    }

    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {
        Set<Token> tksTotal = creaTokens(partidos, numEsc);
        Set<Token> tksSeleccion = Token.seleccionaTokens(tksTotal, numEsc);
        Map<Partido, Integer> dHontSimple = Token.generaResultados(tksSeleccion);
        return dHontSimple;
    }


}
