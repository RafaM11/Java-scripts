package org.uma.mbd.mdRectas.rectas;

public class Vector {
    private Punto extremo;

    public Vector(double Vx, double Vy) {
        extremo = new Punto(Vx, Vy);
    }

    public Vector(Punto extremo) {
        this.extremo = extremo;
    }

    public Vector(Punto p, Punto extremo) {
        p = new Punto(p.getX(), p.getY());
        this.extremo = extremo;
        double xDif = extremo.getX() - p.getX();
        double yDif = extremo.getY() - p.getY();
        this.extremo = new Punto(xDif, yDif);
    }

    public double getComponenteX() {
        return extremo.getX();
    }

    public double getComponenteY() {
        return extremo.getY();
    }

    public double modulo() {
        return Math.sqrt(Math.pow(getComponenteX(), 2) + Math.pow(getComponenteY(), 2));
    }

    public Vector ortogonal() {
        Punto pOrtogonal = new Punto(-1 * extremo.getY(), extremo.getX());
        Vector vOrtogonal = new Vector(pOrtogonal);
        return vOrtogonal;
    }

    public boolean paraleloA(Vector vector) {
        if (getComponenteX() * vector.getComponenteY() == getComponenteY() * vector.getComponenteX()) {
            return true;
        } else {
            return false;
        }
    }

    public Punto extremoDesde(Punto org) {
        org = new Punto(org.getX() + extremo.getX(), org.getY() + extremo.getY());
        return org;
    }

    @Override
    public String toString() {
        return "V(" + extremo.getX() + ", " + extremo.getY() + ")";
    }
}