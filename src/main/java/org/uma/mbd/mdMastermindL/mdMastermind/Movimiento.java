package org.uma.mbd.mdMastermindL.mdMastermind;

import java.util.Objects;

public class Movimiento {
    private String cifras;
    private int colocadas;
    private int descolocadas;

    public Movimiento(String cifras, int colocadas, int descolocadas) {
        this.cifras = cifras;
        this.colocadas = colocadas;
        this.descolocadas = descolocadas;
    }

    public int getColocadas() {
        return colocadas;
    }

    public int getDescolocadas() {
        return descolocadas;
    }

    public String getCifras() {
        return cifras;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Movimiento) {
            Movimiento m = (Movimiento) o;
            if (m.getCifras().equalsIgnoreCase(cifras)) {
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
        return cifras.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "[" + cifras + ", " + colocadas + ", " + descolocadas + "]";
    }
}