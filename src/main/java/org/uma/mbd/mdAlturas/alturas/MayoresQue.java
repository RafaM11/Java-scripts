package org.uma.mbd.mdAlturas.alturas;

public class MayoresQue implements Seleccion {
    private double alturaMin;

    public MayoresQue(double alturaMin) {
        this.alturaMin = alturaMin;
    }

    @Override
    public boolean test(Pais pais) {
        return pais.getAltura() >= alturaMin;
    }
}
