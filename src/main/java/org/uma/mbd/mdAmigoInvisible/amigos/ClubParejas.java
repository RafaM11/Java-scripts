package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;

public class ClubParejas extends Club {
    private Set<Pareja> parejas = new HashSet<>();

    @Override
    public void creaSocioDesdeString(String nombre) {
        String[] miembrosPareja = nombre.split("-");

        String nombre1 = miembrosPareja[0];
        Persona p1 = new Persona(nombre1);
        socios.add(p1);

        if (miembrosPareja.length == 2) {
            String nombre2 = miembrosPareja[1];
            Persona p2 = new Persona(nombre2);
            socios.add(p2);
            Pareja p = new Pareja(p1, p2);
            parejas.add(p);
        }
    }

    @Override
    public void hacerAmigos() {
        super.hacerAmigos();
        Iterator<Persona> it = socios.iterator();
        while (it.hasNext()) {
            Persona persona = it.next();
            Pareja pareja = new Pareja(persona, persona.amigo);
            if (parejas.contains(pareja)) {
                hacerAmigos();
            }
        }
    }
}