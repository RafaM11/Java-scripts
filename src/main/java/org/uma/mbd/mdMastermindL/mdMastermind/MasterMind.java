package org.uma.mbd.mdMastermindL.mdMastermind;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class MasterMind {
    protected int longitud;
    protected String secreto;
    public static final int TAM_POR_DEFECTO = 14;
    private static Random alea = new Random();

    public MasterMind() {
        generaCombinacionSecreta(TAM_POR_DEFECTO);
    }

    public MasterMind(int longitud) {
        this.longitud = longitud;
        generaCombinacionSecreta(longitud);
    }

    public MasterMind(String secreto) {
        this.secreto = secreto;
    }

    public int getLongitud() {
        return longitud;
    }

    public String getSecreto() {
        return secreto;
    }

    private void generaCombinacionSecreta(int longitud) {
            this.longitud = longitud;

            if (longitud < 0 || longitud > 10) {
                throw new MasterMindException("Longitud no válida.");

            } else {
                int[] numero = new int[longitud];
                numero[0] = alea.nextInt(10);

                for (int i = 1; i < longitud; i++) {
                    numero[i] = alea.nextInt(10);
                    for (int j = 0; j < i; j++) {
                        if (numero[i] == numero[j]) {
                            i--;
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < longitud; i++) {
                    sb.append(numero[i]);
                }
                secreto = sb.toString();
            }
    }

    private boolean validaCombinacion(String combinacion) {
        char[] caracter = combinacion.toCharArray();

            boolean cifrasRepetidas = false;
            for (int i = 0; i < combinacion.length(); i++) {
                for (int j = i + 1; j < combinacion.length(); j++) {
                    if (caracter[i] == caracter[j]) {
                        cifrasRepetidas = true;
                    }
                }
            }
            boolean esNumero = false;
            for (char x : combinacion.toCharArray()) {
                if (Character.isDigit(x)) {
                    esNumero = true;
                }
            }

        if (combinacion.length() == TAM_POR_DEFECTO && cifrasRepetidas == false && esNumero == true) {
            return true;
        } else {
            return false;
        }
    }

    public Movimiento intento(String cifras) {

        if (validaCombinacion(cifras)) {
            int colocadas = 0;
            int descolocadas = 0;
            char[] arrayCifras = cifras.toCharArray();
            char[] arraySecreto = secreto.toCharArray();

            for (int i = 0; i < cifras.length(); i++) {
                if (arrayCifras[i] == arraySecreto[i]) {
                    colocadas++;
                }
            }
            for (int i = 0; i < cifras.length(); i++) {
                for (int j = 0; j < secreto.length(); j++) {
                    if (arrayCifras[i] == arraySecreto[j] && i != j) {
                        descolocadas++;
                    }
                }
            }
            return new Movimiento(cifras, colocadas, descolocadas);
        } else {
            throw new MasterMindException("Cadena de cifras no válida.");
        }
    }
}