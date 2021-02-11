package org.uma.mbd.Pruebas.ejemplo1;
import org.uma.mbd.Pruebas.ejemplo1.miClase.miClase;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola mundo");
        miClase t1 = new miClase(15);
        miClase t2 = new miClase(28);

        System.out.println(t1.x + "-" + t2.x);
    }
}
