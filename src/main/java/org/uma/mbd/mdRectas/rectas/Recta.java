package org.uma.mbd.mdRectas.rectas;

public class Recta {
    private Vector direccion;
    private Punto pto;

    public Recta(Vector v, Punto p) {
        direccion = v;
        pto = p;
    }

    public Recta(Punto p1, Punto p2) {
        direccion = new Vector(p1, p2);
        pto = new Punto(p1.getX(), p1.getY());
    }

    public boolean pasaPor(Punto p) {
        Vector vector = new Vector(p, pto);
        if (direccion.paraleloA(vector)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean paralelaA(Recta r) {
        if (direccion.paraleloA(r.direccion)) {
            return true;
        } else {
            return false;
        }
    }

    public Recta paralelaPor(Punto p) {
        Recta r = new Recta(direccion, p);
        return r;
    }

    public Recta perpendicularPor(Punto p) {
        Recta r = new Recta(direccion.ortogonal(), p);
        return r;
    }

    public Punto interseccionCon(Recta r) {
        if (this.paralelaA(r)) {
            throw new RuntimeException("Rectas paralelas");
        }
        double d = direccion.getComponenteX() * r.direccion.getComponenteY() - r.direccion.getComponenteX() * direccion.getComponenteY();
        double d1 = direccion.getComponenteX() * pto.getY() - direccion.getComponenteY() * pto.getX();
        double d2 = r.direccion.getComponenteX() * r.pto.getY() - r.direccion.getComponenteY() * r.pto.getX();
        double ox = (d1 * r.direccion.getComponenteX() - d2 * direccion.getComponenteX())/d;
        double oy = (d1 * r.direccion.getComponenteY() - d2 * direccion.getComponenteX())/d;
        Punto p = new Punto(ox, oy);
        return p;
    }

    public double distanciaDesde(Punto p) {
        Recta r1 = new Recta(direccion, pto);
        Recta r2 = r1.perpendicularPor(p);
        Punto p1 = r1.interseccionCon(r2);
        double distancia = p.distancia(p1);
        return distancia;
    }

    public String toString() {
        return "R(" + direccion + ", " + pto + ")";
    }
}