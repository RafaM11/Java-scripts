package org.uma.mbd.mdAlturasV2.alturas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.PatternSyntaxException;

public class Mundo {
    private List<Pais> paises;

    public Mundo() {
        paises = new ArrayList<>();
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void leePaises(String file) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(file))) {
            leePaises(sc);
        }
        // Sentencia try-with-resources (Leer con detenimiento).
        // No hay que capturar la excepción FileNotFoundException con un try-catch en el Main porque ya la lanza con throws.
    }

    private void leePaises(Scanner sc) {

        while (sc.hasNextLine()) {
            String datos = sc.nextLine();
            try {
                String[] datosSeparados = datos.split(",");

                String nombre = datosSeparados[0];
                String continente = datosSeparados[1];
                double altura = Double.parseDouble(datosSeparados[2]);

                Pais pais = new Pais(nombre, continente, altura);

                paises.add(pais);

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error, faltan datos en " + datos);
            } catch (NumberFormatException e) {
                System.out.println("Error en dato numérico en " + datos);
            }
        }
    }

    public List<Pais> selecciona(Seleccion sel) {
        List<Pais> paisesOK = new ArrayList<>();
        for (Pais pais : paises) {
            if (sel.test(pais)) {
                paisesOK.add(pais);
            }
        }
        return paisesOK;
    }
}