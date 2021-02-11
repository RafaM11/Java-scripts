 package org.uma.mbd.mdJarras.jarras;

public class Jarra {
    private final int capacidad;
    private int contenido;

    public Jarra(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getContenido() {
        return contenido;
    }

    public void llena() {
        contenido = capacidad;
    }

    public void vacia() {
        contenido = 0;
    }

    public void llenaDesde(Jarra jarra) {
        int minimo = Math.min(capacidad - contenido, jarra.contenido);
        contenido = contenido + minimo;
        jarra.contenido = jarra.contenido - minimo;
    }

    public String toString() {
        return "J(" + contenido + "/" + capacidad + ")";
    }
}
