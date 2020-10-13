package org.uma.mbd.mdJarras.jarras;

public class Mesa {
    private Jarra jarraA, jarraB;

    public Mesa(Jarra j1, Jarra j2) {
        jarraA = j1;
        jarraB = j2;
    }

    public void llenaA() {jarraA.llena();}
    public void llenaB() {jarraB.llena();}
    public void vaciaA() {jarraA.vacia();}
    public void vaciaB() {jarraB.vacia();}
    public void vuelcaAsobreB() {jarraB.llenarDesde(jarraA);}
    public void vuelcaBsobreA() {jarraA.llenarDesde(jarraB);}
    public int getContenidoA() {return jarraA.getContenido();}
    public int getContenidoB() {return jarraB.getContenido();}
    public int getCapacidadA() {return jarraA.getCapacidad();}
    public int getCapacidadB() {return jarraB.getCapacidad();}
    public int getContenido() {return jarraA.getContenido() + jarraB.getContenido();}
    public String toString() {return "Jarra A   ->  " + jarraA + "    //    Jarra B   ->  " + jarraB;}
}

