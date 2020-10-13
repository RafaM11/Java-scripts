package org.uma.mbd.Pruebas.ejemplo2.coches;

public class Vehiculo {
    public int pasajeros, capacidad, mpg;
    public Vehiculo(int p, int c, int m) {pasajeros = p; capacidad = c; mpg = m;}

    public int rango(){
        return mpg*capacidad;
    }
    public double capacidadnueva(int miles){
        return (double) miles/mpg;
    }
}
