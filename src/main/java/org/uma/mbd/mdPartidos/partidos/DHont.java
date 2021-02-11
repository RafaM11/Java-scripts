package org.uma.mbd.mdPartidos.partidos;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DHont extends DHontSimple {
    private double minPor;

    public DHont(double mp) {
        minPor = mp;
        if (mp < 0 || mp > 15) {
            throw new EleccionesException("Porcentaje no válido.");
        }
    }

    private List<Partido> filtraPartidos(List<Partido> partidos) {
        // Primero contabilizamos el total de votos con una variable que llamamos "totalVotos". Únicamente hay que hacer
        // un bucle for-each y sumar todos los enteros. Como solo extraemos el número de votos estos votos no van asociados
        // a ningún partido y la suma de todos es el total.

        int totalVotos = 0;
        for (Partido p : partidos) {
            totalVotos += p.getVotos();
        }

        // Si un partido tiene un número de votos por debajo del 15% es porque su total de votos es menor del total por 0.15.
        // Por tanto, creamos una variable double que llamamos "limite" y va a funcionar como umbral o límite que deberán superar
        // los partidos que no quieran quedarse fuera.

        double limite = totalVotos * (minPor/100);

        // Recorremos la lista con un iterador y eliminamos de ella aquellos partidos que no cumplan la condición.

        Iterator<Partido> it = partidos.iterator();
        while (it.hasNext()) {
            Partido p = it.next();
            if (p.getVotos() < limite) {
                it.remove();
            }
        }
        return partidos;
    }

    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {
        List<Partido> p = filtraPartidos(partidos);
        return super.ejecuta(p, numEsc);
    }
}
