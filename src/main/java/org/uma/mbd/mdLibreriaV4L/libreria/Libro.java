package org.uma.mbd.mdLibreriaV4L.libreria;

public class Libro {
    private static double IVA = 10;
    private final String autor;
    private final String titulo;
    private double precioBase;

    public Libro(String autor, String titulo, double precioBase) {
        this.autor = autor;
        this.titulo = titulo;
        this.precioBase = precioBase;
    }

    public static double getIVA() {
        return IVA;
    }

    public static void setIVA(double IVA) {
        Libro.IVA = IVA;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPrecioFinal() {
        return precioBase * (1 + IVA / 100);
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = obj instanceof Libro;
        Libro libro = res?(Libro)obj:null;
        return res && autor.equalsIgnoreCase(libro.autor) && titulo.equalsIgnoreCase(libro.titulo);
    }

    @Override
    public int hashCode() {
        return autor.toLowerCase().hashCode() + titulo.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "(" + autor + ";" + titulo + ";" + precioBase + ";" + IVA + "%;" + getPrecioFinal() + ")";
    }
}
