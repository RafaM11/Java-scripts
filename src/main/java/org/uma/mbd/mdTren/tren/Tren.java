package org.uma.mbd.mdTren.tren;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Tren {

    private int numVagones;
    private int capVagones;
    private List<Vagon> vagones;

    public Tren(int numVagones, int capVagones) {
        this.numVagones = numVagones;
        this.capVagones = capVagones;
        /* Creamos la lista de tamaño igual al número de vagones que llevará el tren*/
        vagones = new ArrayList<>(numVagones);
        /* Rellenamos la lista de vagones con un bucle for*/
        for (int i = 0; i < numVagones; i++)
            vagones.add(new Vagon(capVagones));
    }

    public void carga(int ton) {
        int i = 0;
        int cargaSiguiente = 0;

        while (i < numVagones && ton != 0) {
            cargaSiguiente = vagones.get(i).carga(ton);
            i++;
            ton = cargaSiguiente;
        }

        while (ton != 0 && numVagones <= i) {
                vagones.add(new Vagon(capVagones));
                numVagones++;
                cargaSiguiente = vagones.get(i).carga(ton);
                ton = cargaSiguiente;
                i++;
            }
        }

    public void gasta(int ton) {
        int i = 0;
        int cargaSiguiente = 0;

        while (i < vagones.size() && ton != 0) {
            cargaSiguiente = vagones.get(i).descarga(ton);
            i++;
            ton = cargaSiguiente;
        }

        while (ton != 0 && i >= numVagones) {
            throw new IllegalArgumentException("No hay tantas toneladas para descargar");
        }
    }

    public void optimiza() {
        int i = 0;
        while (i < vagones.size()) {
            if (vagones.get(i).getCarga() == 0) {
                vagones.remove(i);
                numVagones--;
            } else {
                i++;
            }
        }
    }

    public String toString() {
        return vagones.toString();
    }
}

