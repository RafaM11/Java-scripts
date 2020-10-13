package org.uma.mbd.mdEstadística.estadística;

public class Estadistica {
    private int numElementos;
    private double sumaX;
    private double sumaX2;

    public void agrega(double d) {
        numElementos++;
        sumaX += d;
        sumaX2 += d * d;
    }

    /*public void agrega(double d){
        this.agrega(d, 1);
    }
    public void agrega(double d){
        agrega(d, 1);
    }
    public void agrega(double d, int nVeces){
        numElementos += nVeces;
        sumaX += d*nVeces;
        sumaX2 += d*d*nVeces;
    }
    Son lo mismo estos 4 métodos*/

    public double media(){
        return sumaX/numElementos;
    }

    public double varianza(){
        return sumaX2/numElementos - Math.pow(media(),2);
    }
    public double desviacionTipica(){
        return Math.sqrt(varianza());
    }

    @Override
    public String toString(){
        return "Estadística(" + numElementos + ", " + sumaX + ", " + sumaX2 + ")";
    }
}
