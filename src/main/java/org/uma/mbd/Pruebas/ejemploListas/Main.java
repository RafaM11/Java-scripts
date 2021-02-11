package org.uma.mbd.Pruebas.ejemploListas;

import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        List<String> lista = new ArrayList<>();
        lista.add("hola");
        lista.add("que");
        lista.add("tal");
        lista.add(1, "amigo");
        System.out.println(lista.get(2));
        System.out.println(lista.size());
        lista.remove(0);
        lista.set(1, "mio");
        System.out.println(lista);

        for (int i = 0; i < lista.size(); i++) {
            String a = lista.get(i);
            System.out.println(a);
        }

    }
}
