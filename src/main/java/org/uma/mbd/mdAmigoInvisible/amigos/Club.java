package org.uma.mbd.mdAmigoInvisible.amigos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Club {
    protected List<Persona> socios;

    public Club() {
        socios = new ArrayList<>();
    }

    public void lee(String fEntrada, String delim) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(fEntrada))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                leeSocios(linea, delim);
            }
        }
    }

    private void leeSocios(String linea, String delim) {
        try (Scanner scSocio = new Scanner(linea)) {
            scSocio.useDelimiter(delim);
            while (scSocio.hasNext()) {
                String nombre = scSocio.next();
                creaSocioDesdeString(nombre);
            }
        }
    }

    protected void creaSocioDesdeString(String nombre) {
        Persona persona = new Persona(nombre);
        socios.add(persona);
    }

    protected void hacerAmigos() {
        if (socios.size() <= 2) {
            throw new AmigoException("No hay suficientes personas para asignar amigos.");
        }

        List<Integer> posAmigos = new ArrayList<>();

        for (int i = 0; i < socios.size(); i++) {
            posAmigos.add(i);
        }
        while (hayCoincidencias(posAmigos)) {
            Collections.shuffle(posAmigos);
        }
        for (int i = 0; i < socios.size(); i++) {
            socios.get(i).setAmigo(socios.get(posAmigos.get(i)));
        }
    }

    private static boolean hayCoincidencias(List<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (i == lista.get(i)) {
                return true;
            }
        } return false;
    }

    public void presentaAmigos(String fSalida) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(fSalida)) {
            presentaAmigos(pw);
        }
    }

    private void presentaAmigos(PrintWriter pw) {
        Collections.sort(socios);
        for (Persona persona : socios) {
            pw.println(persona);
        }
    }
}
