package org.uma.mbd.Pruebas.ejemploInterfaz;

import org.uma.mbd.Pruebas.ejemploInterfaz.ejInterfaz.Amigos;
import org.uma.mbd.Pruebas.ejemploInterfaz.ejInterfaz.Persona;

public class Main {
    public static void main(String[] args) {
        Persona[] personas = {
                new Persona("Juan", 25),
                new Persona("Maria", 32),
                new Persona("Marta", 28),
                new Persona("Julio", 33),
                new Persona("Manuel", 29),
                new Persona("Justino", 25) };

        Amigos amigos = new Amigos(personas);

        System.out.println("Empiezan con ma");
        Persona[] ps1 = amigos.empiezanCon("ma");
        for (Persona p : ps1) {
            System.out.println(p);
        }
        System.out.println("Mayores de 28");
        Persona[] ps2 = amigos.mayoresQue(28);
        for (Persona p : ps2) {
            System.out.println(p);
        }

        System.out.println("Menores de 27");
        Persona[] ps3 = amigos.mayoresQue(27);
        for (Persona p : ps3) {
            System.out.println(p);
        }

    }
}
