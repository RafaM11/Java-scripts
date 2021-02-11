package org.uma.mbd.mdAmigoInvisible.amigos;

public class Persona implements Comparable<Persona> {
    public String nombre;
    public Persona amigo;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Persona getAmigo() {
        return amigo;
    }

    public void setAmigo(Persona am) {
        this.amigo = am;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Persona) {
            Persona persona = (Persona) o;
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
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
        return nombre.toUpperCase().hashCode();
    }

    @Override
    public int compareTo(Persona p) {
        return nombre.compareToIgnoreCase(p.getNombre());
    }

    @Override
    public String toString() {
        if (amigo == null) {
            return nombre + " --> sin amigo";
        } else {
            return nombre + " --> " + amigo.getNombre();
        }
    }
}
