package org.uma.mbd.mdAmigoInvisible.amigos;

import java.io.FileNotFoundException;
import java.time.chrono.IsoChronology;

public class ClubManager {
    private String fEntrada;
    private String delimitadores;
    private String fSalida;
    private boolean consola;
    private Club club;

    public ClubManager(Club club) {
        this.club = club;
    }

    public ClubManager setEntrada(String fEntrada, String delim) {
        this.fEntrada = fEntrada;
        this.delimitadores = delim;
        return this;
    }
    public ClubManager setSalida(String fSalida) {
        this.fSalida = fSalida;
        return this;
    }

    public ClubManager setConsola(boolean consola) {
        this.consola = consola;
        return this;
    }

    private void verify() {
        if (fEntrada == null) {
            throw new AmigoException("No hay fichero de entrada de datos.");
        }
        if (fSalida == null && !consola) {
            throw new AmigoException("No hay salida ni por fichero ni a consola.");
        }
    }

    public void build() throws FileNotFoundException {
        verify();
        club.lee(fEntrada, delimitadores);
        club.hacerAmigos();
        club.presentaAmigos(fSalida);
        if (consola) {
            for (Persona p : club.socios) {
                System.out.println(p);
            }
        }
    }
}
