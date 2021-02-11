package org.uma.mbd.mdAlturasV2.alturas;

import java.util.Objects;

public class Pais implements Comparable<Pais> {
    private String nombre;
    private String continente;
    private double altura;

    public Pais (String nombre, String continente, double altura) {
        this.nombre = nombre;
        this.continente = continente;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContinente() {
        return continente;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Pais) {
            Pais pais = (Pais) o;
            if (pais.getNombre().equalsIgnoreCase(nombre)) {
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
        return nombre.toLowerCase().hashCode();
    }

    public String toString() {
        return "Pais(" + nombre + ", " + continente + ", " + altura + ")";
    }

    @Override
    public int compareTo(Pais pais) {
        int resultado = Double.compare(altura, pais.altura);
        if (resultado == 0) {
            resultado = nombre.compareTo(pais.nombre);
        }
        return resultado;
    }
}
