package org.uma.mbd.mdBusV1.buses;

public class Coincide implements Criterio {

    private Bus bus;

    public Coincide (Bus bus) {
        this.bus = bus;
    }

    public boolean esSeleccionable(Bus bus1) {
        return bus.equals(bus1);
    }

    @Override
    public String toString() {
        return "Autobús " + bus;
    }

}
