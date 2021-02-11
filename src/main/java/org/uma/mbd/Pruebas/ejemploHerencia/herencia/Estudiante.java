package org.uma.mbd.Pruebas.ejemploHerencia.herencia;

public class Estudiante extends Persona {
    private int codigoEstudiante;
    private float notaFinal;

    public Estudiante(String nombre, String apellidos, int edad, int codigoEstudiante, float notaFinal) {
        super(nombre, apellidos, edad);
        this.codigoEstudiante = codigoEstudiante;
        this.notaFinal = notaFinal;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public float getNotaFinal() {
        return notaFinal;
    }
}