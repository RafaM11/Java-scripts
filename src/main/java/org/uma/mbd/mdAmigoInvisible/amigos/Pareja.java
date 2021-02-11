package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.Objects;

public class Pareja {
    private Persona uno;
    private Persona otro;

    public Pareja(Persona uno, Persona otro) {
        this.uno = uno;
        this.otro = otro;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Pareja) {
            Pareja p = (Pareja) o;
            if ((uno.equals(p.otro) && p.uno.equals(otro)) || (uno.equals(p.uno) && otro.equals(p.otro))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return uno.hashCode() + otro.hashCode();
    }

    @Override
    public String toString() {
        return "(" + uno.getNombre() + "," + otro.getNombre() + ")";
    }
}
