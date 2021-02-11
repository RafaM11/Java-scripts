package org.uma.mbd.mdRectas.rectas;

public class Punto {
    private double x;
    private double y;

    public Punto() {
        x = y = 0;
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distancia(Punto punto) {
        return Math.sqrt(Math.pow((punto.x - x), 2) + Math.pow((punto.y - y), 2));
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void trasladar(double a, double b) {
        x += a;
        y += b;
    }

    public String toString() {
        return "P(" + getX() + ", " + getY() + ")";
    }
}