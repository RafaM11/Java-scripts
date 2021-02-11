package org.uma.mbd.mdPartidos.partidos;

import java.util.*;

public class Proporcional implements CriterioSeleccion {

    private Set<Token> creaTokens(List<Partido> partidos, int numEsc) {
        // Creamos los tokens igual que en la clase "DHontSimple" pero con la nueva condición (cambian el índice j y el ratio).
        SortedSet<Token> tksTotal = new TreeSet<>();

        // Al igual que en la clase "DHont", calculamos el total de votos. Luego dividimos por el número de escaños a repartir.
        int totalVotos = 0;
        for (Partido p : partidos) {
            totalVotos += p.getVotos();
        }
        double vpe = totalVotos/numEsc;

        for (int i = 0; i < partidos.size(); i++) {
            for (int j = 0; j < numEsc - 1; j++) {
                Token t = new Token(partidos.get(i), partidos.get(i).getVotos() - (vpe * j));
                tksTotal.add(t);
            }
        }
        return tksTotal;
    }

    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {
        Set<Token> tksTotal = creaTokens(partidos, numEsc);
        Set<Token> tksSeleccion = Token.seleccionaTokens(tksTotal, numEsc);
        Map<Partido, Integer> proporcional = Token.generaResultados(tksSeleccion);
        return proporcional;
    }
}
