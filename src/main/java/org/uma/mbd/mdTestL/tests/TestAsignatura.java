package org.uma.mbd.mdTestL.tests;

import java.util.*;
import java.io.*;

public class TestAsignatura {
    private String nombre;
    private List<Test> examenes;
    private double valAciertos;
    private double valErrores;
    private final static int APROBADO = 5;

    public TestAsignatura(String n, double valAc, double valEr, List<String> datos) {
        nombre = n;
        valAciertos = valAc;
        valErrores = valEr;
        examenes = new ArrayList<>();
        extraeDatos(datos);
    }

    public TestAsignatura(String n, List<String> datos) {
        this(n,1,0,datos);
    }

    public TestAsignatura(String n, double valAc, double valEr, String nombreFichero) throws IOException {
       nombre = n;
       valAciertos = valAc;
       valErrores = valEr;
       examenes = new ArrayList<>();
       leeDatos(nombreFichero);
    }

    public TestAsignatura(String n, String nombreFichero) throws IOException {
        this(n,1,0,nombreFichero);
    }

    public void leeDatos(String nombreFichero) throws IOException {
        try (Scanner sc = new Scanner(new File(nombreFichero))) {
            leeDatos(sc);
        }
    }

    public void leeDatos(Scanner sc) {
        while (sc.hasNextLine()) {
            String datosAlumno = sc.nextLine();
            try {
                Test test = stringToTest(datosAlumno);
                examenes.add(test);
            } catch (InputMismatchException e) {
                throw new TestException(datosAlumno + " Error: dato no numérico");
            } catch (NoSuchElementException e) {
                throw new TestException(datosAlumno + " Error: Falta datos");
            }
        }
    }

    public void extraeDatos(List<String> datos) {
        for (String datosAlumno: datos) {
            try {
                Test test = stringToTest(datosAlumno);
                examenes.add(test);
            } catch (InputMismatchException e) {
                throw new TestException(datosAlumno + " Error: dato no numérico");
            } catch (NoSuchElementException e) {
                throw new TestException(datosAlumno + " Error: Falta datos");
            }
        }
    }

    private Test stringToTest(String datosAlumno) {
        try (Scanner sc = new Scanner(datosAlumno)) {
            sc.useDelimiter("[:+]+");
            String nomAlumno = sc.next();
            int pAc = sc.nextInt();
            int pEr = sc.nextInt();
            Test test = new Test(nomAlumno, pAc, pEr);
            return test;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int aprobados() {
        int cont = 0;
        for (Test test: examenes) {
            if (test.calificacion(valAciertos, valErrores) >= APROBADO ) {
                cont++;
            }
        }
        return cont;
    }

    public double notaMedia() {
        if (examenes.size() == 0) {
            throw new NoSuchElementException("No hay test");
        }
        double suma = 0;
        for (Test test : examenes) {
            suma += test.calificacion(valAciertos, valErrores);
        }
        return suma / examenes.size();
    }

    public void guardaNotaAlumnos(String fichero) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(fichero)) {
            guardaNotaAlumnos(pw);
        }
    }

    public void guardaNotaAlumnos(PrintWriter pw) {
        for (Test test : examenes) {
            double calificacion = test.calificacion(valAciertos, valErrores);
            pw.println(test.getAlumno() + "," + calificacion);
        }
    }
}