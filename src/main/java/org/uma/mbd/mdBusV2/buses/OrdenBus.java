package org.uma.mbd.mdBusV2.buses;

import java.util.Comparator;

public class OrdenBus implements Comparator<Bus> {

    public int compare(Bus bus1, Bus bus2) {
        int resultado = 0;
        try {
            resultado = Integer.compare(bus1.getCodLinea(), bus2.getCodLinea());
            if (resultado == 0) {
                resultado = Integer.compare(bus1.getCodBus(), bus2.getCodBus());
            }
        } catch (ClassCastException e) {
            System.out.println("Los objetos no son comparables");
        }
        return resultado;
    }
}

/* Esta clase el ejercicio no pide crearla ya que el conjunto se ordena según el orden natural redefinido en la clase Bus.
Únicamente la he creado para practicar con otros criterios de ordenación diferentes al orden natural y entender mejor esta
parte del tema.
 */
