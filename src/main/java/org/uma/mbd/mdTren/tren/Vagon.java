package org.uma.mbd.mdTren.tren;

public class Vagon {
    private int capacidad;
    private int carga;

    public Vagon(int capacidad) {
        this.capacidad = capacidad;
        carga = 0;
    }

    public int carga(int ton) {
        int capacidadActual = capacidad - carga;
        if (ton > capacidadActual) {
            carga = capacidad;
            ton = ton - capacidadActual;
            return ton;
        } else {
            carga = ton;
            return 0;
        }
    }

    public int descarga(int ton) {
        if (ton > carga) {
            ton = ton - carga;
            carga = 0;
            return ton;
        } else {
            carga = carga - ton;
            return 0;
        }
        }

    public int getCarga() {
        return carga;
    }

    public int getCapacidad() {
        return capacidad - carga;
    }

    @Override
    public String toString() {
        return "V(" + carga + "/" + capacidad + ")";
    }

}
