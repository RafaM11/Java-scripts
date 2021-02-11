package org.uma.mbd.mdBusV2.buses;
public class Bus implements Comparable<Bus> {
    private int codBus;
    private String matricula;
    private int codLinea;

    public Bus (int codBus, String matricula) {
        this.codBus = codBus;
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Bus) {
            Bus bus = (Bus) o;
            if (bus.getCodBus() == codBus && bus.getMatricula().equalsIgnoreCase(matricula)) {
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
        return Integer.hashCode(codBus);
    }

    public void setCodLinea(int codLinea) {
        this.codLinea = codLinea;
    }

    public int getCodBus() {
        return codBus;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getCodLinea() {
        return codLinea;
    }

    public String toString() {
        return "Bus(" + codBus + "," + matricula + "," + codLinea + ")";
    }

    @Override
    public int compareTo(Bus bus) {
        int resultado = Integer.compare(codLinea, bus.codLinea);
        if (resultado == 0) {
            resultado = Integer.compare(codBus, bus.codBus);
        }
        return resultado;
    }
}