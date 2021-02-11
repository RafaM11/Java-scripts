package org.uma.mbd.Pruebas.pruebaBinario;
import java.util.Arrays;
import java.util.Random;

public class Cromosoma {
    protected static Random gna = new Random();
    protected static int GEN_POR_DEFECTO = 0;
    protected int[] datos;

    public Cromosoma(int longitud, boolean aleatorio) {
        if (longitud < 0) {
            throw new RuntimeException("Longitud negativa");
        }
        datos = new int[longitud];
        if (aleatorio == true) {
            for (int i = 0; i < longitud; i++) {
                datos[i] = gna.nextInt(1 + 1);
            }
        } else {
            for (int i = 0; i < longitud; i++) {
                datos[i] = GEN_POR_DEFECTO;
            }
        }
    }

    public static void main(String[] args) {

        Cromosoma c = new Cromosoma(10, true);
        System.out.println(c);
        System.out.println(c.copia());
    }

    public int gen(int i) {
        if (i < 0 || i > datos.length) {
            throw new RuntimeException("El índice está fuera del rango de valores válidos");
        }
        return datos[i];
    }

    public void gen(int i, int val) {
        if (i < 0 || i > datos.length) {
            throw new RuntimeException("El índice está fuera del rango de valores válidos");
        }
        if (val != 0 && val != 1) {
            throw new RuntimeException("'val' no es un valor válido");
        }
        datos[i] = val;
    }

    public void mutar(double probMutacion) {
        if (probMutacion > 1 || probMutacion < 0) {
            throw new RuntimeException("Probabilidad no válida");
        }
        if (gna.nextDouble() <= probMutacion) {
            for (int i = 0; i < datos.length; i++) {
                if (datos[i] == 0) {
                    datos[i] = 1;
                } else {
                    datos[i] = 0;
                }
            }
        }
    }

    public int longitud() {
        return datos.length;
    }

    public Cromosoma copia() {
        Cromosoma copia = new Cromosoma(datos.length, true);
        copia.datos = Arrays.copyOf(datos, datos.length);
        return copia;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < datos.length - 1; i++) {
            s.append(datos[i]).append(", ");
        }
        return "Cromosoma(" + s + datos[datos.length - 1] + ")";
    }

}