package org.uma.mbd.mdJarras.jarras;

public class Jarra {
    final int capacidad;
    int contenido;

    public Jarra(int cap_Jarra){
        capacidad = cap_Jarra;
        contenido = 0;
    }

    public int getCapacidad(){return capacidad;}
    public int getContenido(){return contenido;}
    public void llena(){contenido = capacidad;}
    public void vacia(){contenido = 0;}

    public void llenarDesde(Jarra jarraA){
        int minimo = Math.min(capacidad - contenido, jarraA.contenido);
        contenido += minimo;
        jarraA.contenido -= minimo;
    }

    @Override
    public String toString(){
        return "Capacidad: " + capacidad + "," + " Contenido: " + contenido + "     (Litros)";
    }
}
