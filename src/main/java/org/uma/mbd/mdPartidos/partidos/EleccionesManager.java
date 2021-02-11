package org.uma.mbd.mdPartidos.partidos;

import java.io.IOException;
import java.util.Map;

public class EleccionesManager {
    private String[] datos;
    private int numEsc;
    private CriterioSeleccion cs;
    private Elecciones elecciones;
    private String fEntrada;
    private String fSalida;
    private boolean consola;

    public EleccionesManager(Elecciones elecciones) {
        this.elecciones = elecciones;
    }

    public EleccionesManager setDatos(String[] datos) {
        this.datos = datos;
        return this;
    }

    public EleccionesManager setCriterioSeleccion(CriterioSeleccion cs) {
        this.cs = cs;
        return this;
    }

    public EleccionesManager setNumEsc(int numEsc) {
        this.numEsc = numEsc;
        return this;
    }

    public EleccionesManager setEntrada(String fEntrada) {
        this.fEntrada = fEntrada;
        return this;
    }

    public EleccionesManager setSalida(String fSalida) {
        this.fSalida = fSalida;
        return this;
    }

    public EleccionesManager setConsola(boolean consola) {
        this.consola = consola;
        return this;
    }

    private void verify() {
        if (datos == null && fEntrada == null) {
            throw new EleccionesException("No hay entrada de datos.");
        }
        if (datos != null && fEntrada != null) {
            throw new EleccionesException("La entrada de datos es única.");
        }
        if (cs == null) {
            throw new EleccionesException("No se ha escogido un criterio de selección.");
        }
        if (numEsc <= 0) {
            throw new EleccionesException("No hay escaños para repartir.");
        }
        if (fSalida == null && !consola) {
            throw new EleccionesException("No hay salida ni por fichero ni a consola.");
        }
    }

    public void build() throws IOException {
        verify();
        if (datos == null) {
            elecciones.leeDatos(fEntrada);
        } else {
            elecciones.leeDatos(datos);
        }
        Map<Partido, Integer> m = elecciones.generaResultados(cs, numEsc);

        elecciones.presentaResultados(fSalida, m);
        if (consola) {
            // Como la lista "partidos" es privada no podemos iterar hasta ella. Iteramos hasta el conjunto de claves
            // del mapa "m", que no es más que el conjunto de partidos políticos del ejercicio.
            for (Partido p : m.keySet()) {
                if (m.get(p) == 0) {
                    System.out.println(p + ", " + "Sin representación");
                } else {
                    System.out.println(p + ", " + m.get(p));
                }
            }
        }
    }
}
