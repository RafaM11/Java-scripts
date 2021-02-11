package org.uma.mbd.mdUrna.urna;

import java.awt.*;
import java.util.NoSuchElementException;
import java.util.Random;

public class Urna {
    public enum ColorBola {Blanca, Negra};
    private int blancas, negras;
    private static Random alea = new Random();

    public Urna(int nBlancas, int nNegras) {
        if (nBlancas < 0 || nNegras < 0) {
            throw new IllegalArgumentException("Número negativo de bolas");
        }
        blancas = nBlancas;
        negras = nNegras;
    }

    public int totalBolas(){
        int suma = blancas + negras;
        return suma;
    }

    public void ponerBlanca() {
        blancas++;
    }

    public void ponerNegra() {
        negras++;
    }

    public ColorBola extraerBola(){
        ColorBola bolaSacada = null;
        if(totalBolas() == 0){
            throw new NoSuchElementException("No hay bolas");
        }
        int i = 1 + alea.nextInt(totalBolas());

        if(i <= blancas) {
            bolaSacada = ColorBola.Blanca;
            blancas--;
        } else {
            bolaSacada = ColorBola.Negra;
            negras--;
        }

        return bolaSacada;
    }

    public String toString() {
        return "U(" + blancas + ", " + negras + ")";
    }

}

