package org.uma.mbd.mdLibreria.libreria;

import java.util.Arrays;

public class Libreria {
    private Libro [] libros;
    private int numLibros;
    private static final int TAM_DEFECTO = 16;

    public Libreria() {
        this(TAM_DEFECTO);
    }

    public Libreria(int tam) {
        libros = new Libro[tam];
        numLibros = 0;
    }

    private void aseguraQueCabe() {
        if (numLibros == libros.length) {
            libros = Arrays.copyOf(libros, numLibros*2);
        }
    }

    private int posicionLibro(String autor, String titulo) {
        int pos = 0;
        while (pos < numLibros && !(libros[pos].getAutor().equals(autor) && libros[pos].getTitulo().equals(titulo))) {
            pos++;
        }
        return (pos < numLibros) ? pos: -1;
    }


    public void addLibro(String autor, String titulo, double precioBase) {
        Libro libro= new Libro(autor, titulo, precioBase);
        addLibro(libro);
    }

    private void addLibro(Libro libro) {
        int pos = posicionLibro(libro.getAutor(), libro.getTitulo());
        if (pos >= 0) {
            // el libro está en la posición pos
            libros[pos] = libro;
        } else {
            aseguraQueCabe();
            libros[numLibros] = libro;
            numLibros++;
        }
    }

    public void remLibro(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        if (pos >= 0) {
            for (int i = pos; i < numLibros - 1; i++) {
                libros[i] = libros[i+1];
            }
            libros[numLibros-1] = null;
            numLibros--;
        }
    }

    public double getPrecioBase(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        return (pos >= 0)? libros[pos].getPrecioBase() : 0;
    }

    public double getPrecioFinal(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        return (pos >= 0)? libros[pos].getPrecioFinal() : 0;
    }

    @Override
    public String toString() {
        String salida = "[";
        for (int i = 0; i < numLibros; i++) {
            salida += libros[i];
            if (i < numLibros-1) {
                salida += ",";
            }
        }
        salida += "]";
        return salida;
    }
}
