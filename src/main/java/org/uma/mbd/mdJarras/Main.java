package org.uma.mbd.mdJarras;
import org.uma.mbd.mdJarras.jarras.Jarra;
import org.uma.mbd.mdJarras.jarras.Mesa;

public class Main {
    public static void main(String[] args) {

        Jarra jarraA = new Jarra(5);
        Jarra jarraB = new Jarra(7);
        Mesa m = new Mesa(jarraA, jarraB);

        jarraA.llena();
        jarraB.vacia();
        jarraB.llenarDesde(jarraA);
        jarraA.llena();
        jarraB.llenarDesde(jarraA);
        jarraB.vacia();
        jarraB.llenarDesde(jarraA);
        jarraA.llena();
        jarraB.llenarDesde(jarraA);

        System.out.println(m.toString());
        System.out.println(" ");
        System.out.println("El contenido total es de " + m.getContenido() + " litros");
    }
}
