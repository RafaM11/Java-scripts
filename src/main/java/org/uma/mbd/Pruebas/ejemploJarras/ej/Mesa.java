package org.uma.mbd.Pruebas.ejemploJarras.ej;

public class Mesa {
    private Jarra jarraA;
    private Jarra jarraB;

    public Mesa (Jarra jarraA, Jarra jarraB) {
        this.jarraA = jarraA;
        this.jarraB = jarraB;
    }

    public void llenaA() {
        jarraA.llena();
    }

    public void llenaB() {
        jarraB.vacia();
    }

    public void vaciaA() {
        jarraA.vacia();
    }

    public void vaciaB() {
        jarraB.vacia();
    }

    public void vuelcaASobreB() {
        jarraB.llenaDesde(jarraA);
    }

    public void vuelcaBSobreA() {
        jarraA.llenaDesde(jarraB);
    }

    public int getContenidoA() {
        return jarraA.getContenido();
    }

    public int getContenidoB() {
        return jarraB.getContenido();
    }
    public int getCapacidadA() {
        return jarraA.getCapacidad();
    }

    public int getCapacidadB() {
        return jarraB.getCapacidad();
    }

    public int getContenido() {
        return getContenidoA() + getContenidoB();
    }

    public String toString() {
        return "(" + jarraA + ", " + jarraB + ")";
    }
}
