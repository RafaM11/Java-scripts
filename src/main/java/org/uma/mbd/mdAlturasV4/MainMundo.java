/*

package org.uma.mbd.mdAlturasV4;

import org.uma.mbd.mdAlturasV4.alturas.Mundo;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

public class MainMundo {
    public static void main(String args[]) throws FileNotFoundException {
        Mundo mundo = new Mundo();
        mundo.leePaises("recursos/mdAlturas/alturas.txt");

//        for (String continente : mundo.getContinentes()) {
//            System.out.println(continente);
//        }

//        System.out.println(mundo.todosMayores(1.65));

//        System.out.println(mundo.masBajoDeContinente("Europe"));

//        System.out.println(mundo.paisMayorAltura());

//        for (Pais pais : mundo.conjuntoOrdPaisesDelContinente("Europe")) {
//            System.out.println(pais);
//        }

//        for (Map.Entry<String, List<Pais>> par : mundo.paisesPorContinente().entrySet()) {
//            System.out.println(par.getKey());
//            for (Pais pais : par.getValue()) {
//                System.out.println("\t" + pais);
//            }
//        }

        Map <String, Set<Double>> map = mundo.alturasPorContinente();
        for (String continente : mundo.alturasPorContinente().keySet()) {
            System.out.println(continente + " " + map.get(continente));
        }

    }
}*/