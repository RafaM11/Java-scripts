package org.uma.mbd.mdLibreriaV2L.libreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria {
    private String[] autoresEnOferta;
    private double porDescuento;

    public LibreriaOferta(double porDescuento, String[] autoresEnOferta) {
        /* Si no ponemos super, estamos llamando a un constructor super por defecto sin argumentos (super()),
         en este caso, al de la clase de Libreria. Estaríamos llamando al constructor de la lista de libros. */

        this.porDescuento = porDescuento;
        this.autoresEnOferta = autoresEnOferta;
    }

    public void setOferta(double porDescuento, String[] autoresEnOferta) {
        this.porDescuento = porDescuento;
        this.autoresEnOferta = autoresEnOferta;
    }

    public String[] getOferta() {
        return autoresEnOferta;
    }

    public double getDescuento() {
        return porDescuento;
    }

    @Override
    public void addLibro(String autor, String titulo, double precioBase) {
        boolean esAutorEnOferta = esAutorEnOferta(autor);
        if (esAutorEnOferta) {
            Libro libro = new LibroEnOferta(autor, titulo, precioBase, porDescuento);
            addLibro(libro);
        } else {
            Libro libro = new Libro(autor, titulo, precioBase);
            addLibro(libro);
        }
    }

    private boolean esAutorEnOferta(String autor) {
        int pos = 0;
        while (pos < autoresEnOferta.length && !autoresEnOferta[pos].equalsIgnoreCase(autor)) {
            pos++;
        }
        return pos < autoresEnOferta.length;
    }

    @Override
    public String toString() {
        return porDescuento + "%" + Arrays.toString(autoresEnOferta) + super.toString();
    }
}