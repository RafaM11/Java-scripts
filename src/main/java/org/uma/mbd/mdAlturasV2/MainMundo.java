package org.uma.mbd.mdAlturasV2;

import org.uma.mbd.mdAlturasV2.alturas.*;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MainMundo {
    public static void main(String args[]) throws FileNotFoundException {
        Mundo paises = new Mundo();
        paises.leePaises("recursos/mdAlturas/alturas.txt");

        Comparator<Pais> apartadoA = Comparator.comparingDouble(Pais::getAltura);
        Comparator<Pais> apartadoB = Comparator.comparing(Pais::getNombre);
        Comparator<Pais> apartadoC = Comparator.comparing(Pais::getContinente).thenComparing(Pais::getNombre);
        Comparator<Pais> apartadoD = Comparator.comparing(Pais::getContinente).thenComparing(Comparator.comparing(Pais::getNombre).reversed());
        Comparator<Pais> apartadoE = Comparator.naturalOrder();
        Comparator<Pais> apartadoF = Comparator.comparing(Pais::getContinente).thenComparing(Comparator.naturalOrder());

        SortedSet<Pais> conjunto = new TreeSet<>(apartadoA);
        conjunto.addAll(paises.selecciona(new MayoresQue(1.77)));
        for (Pais pais : conjunto) {
            System.out.println(pais);
        }

//  Para obtener el conjunto de cada apartado únicamente introducir el comparador correspondiente en el argumento del TreeSet.
//  Se ha usado para resolver el ejercicio la condición que filtra los países por altura media mayor de 1.77, pero podría usarse cualquier otra.

    }
}