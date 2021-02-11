package org.uma.mbd.mdPartidos.partidos;

public class Partido implements Comparable<Partido> {
    private String nombre;
    private int votos;

    public Partido(String nombre, int votos) {
        this.nombre = nombre;
        this.votos = votos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVotos() {
        return votos;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Partido) {
            Partido partido = (Partido) o;
            if (partido.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return nombre.toUpperCase().hashCode();
    }

    @Override
    public String toString() {
        return nombre + " : " + votos;
    }

    @Override
    public int compareTo(Partido p) {
        return Integer.compare(p.votos, votos);
    }
    // Sé que el problema no pide en ningún momento que la clase Partido tenga un comparador. Pero no he podido
    // conseguir imprimir por pantalla los resultados sin implementar la interfaz Comparable en esta clase. Sin
    // implementar esta interfaz no podía crear un TreeMap en el método generaResultados de la clase Token y tenía
    // que resolver el problema mediante un HashSet, haciendo que los resultados no estuviesen ordenados.
}
