package org.uma.mbd.Pruebas.libreria1.libreria;

import java.util.Arrays;

public class Libreria {
    private Libro[] libros;
    private int numLibros;
    private final static int TAM_DEFECTO = 16;

    public Libreria() {
        this(TAM_DEFECTO);
    }

    public Libreria(int tamaño) {
        libros = new Libro[tamaño];
        numLibros = 0;
    }

    private void aseguraQueCabe() {
        if(numLibros == libros.length) {
            libros = Arrays.copyOf(libros, numLibros*2);
        }
    }

    private int posicionLibro(String autor, String titulo) {
        int pos = 0;
        while (pos < numLibros && !(libros[pos].getAutor().equals(autor) && libros[pos].getTitulo().equals(titulo))) {
            pos++;
        }
        return (pos < numLibros) ? pos : -1;
    }

    public void addLibro(String autor, String titulo, double precioBase) {
        Libro libro = new Libro(autor, titulo, precioBase);
        addLibro(libro);
    }

    private void addLibro(Libro libro) {
        int pos = posicionLibro(libro.getAutor(), libro.getTitulo());
        if (pos >= 0) {
            libros[pos] = libro;
        } else {
            aseguraQueCabe();
            libros[numLibros] = libro;
            numLibros++;
        }
    }
}