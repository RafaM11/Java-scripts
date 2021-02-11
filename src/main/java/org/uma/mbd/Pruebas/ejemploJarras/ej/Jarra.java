package org.uma.mbd.Pruebas.ejemploJarras.ej;

public class Jarra {
    private int contenido;
    final private int capacidad;

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

    public void llenaDesde(Jarra j) {
        int minimo = Math.min(this.capacidad - this.contenido, j.contenido);
        this.contenido += minimo;
        j.contenido -= minimo;
    }

    public String toString() {
        return "J(" + capacidad + ", " + contenido + ")";
    }
}
