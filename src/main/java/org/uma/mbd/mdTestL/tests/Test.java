package org.uma.mbd.mdTestL.tests;

public class Test {
        private String alumno;
        private int aciertos;
        private int errores;

    public Test(String al, int ac, int er) {
        alumno = al;
        aciertos = ac;
        errores = er;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = obj instanceof Test;
        Test test = res?(Test)obj: null;
        return res && alumno.equalsIgnoreCase(test.alumno);
    }

    @Override
    public int hashCode() {
        return alumno.toLowerCase().hashCode();
    }

    public String getAlumno() {
        return alumno;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getErrores() {
        return errores;
    }

    public double calificacion(double valAc, double valEr) {
        if (valAc <= 0 || valEr > 0) {
            throw new RuntimeException("Valoraciones erróneas");
        }
        return aciertos*valAc+errores*valEr;
    }

    @Override
    public String toString() {
        return alumno.toUpperCase()+"["+aciertos+","+errores+"]";
    }
}
