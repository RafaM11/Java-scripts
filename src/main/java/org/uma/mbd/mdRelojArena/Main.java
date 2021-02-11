package org.uma.mbd.mdRelojArena;
import org.uma.mbd.mdRelojArena.reloj.MedidorTiempo;
import org.uma.mbd.mdRelojArena.reloj.RelojArena;

public class Main {
    public static void main(String[] args) {

        /*Construimos dos relojes cuyo argumento es la cantidad total de minutos (todo el tiempo está en la parte inferior) */
        MedidorTiempo medidor = new MedidorTiempo(7, 5);

        medidor.giraAmbos();
        medidor.pasaTiempo();
        medidor.giraDerecho();
        medidor.pasaTiempo();
        medidor.pasaTiempo();
        medidor.giraDerecho();
        medidor.pasaTiempo();

        System.out.println(medidor.toString());
    }
}
