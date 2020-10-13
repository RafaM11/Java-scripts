package org.uma.mbd.mdRelojArena.reloj;

public class RelojArena {
    public int minutosSup, minutosInf, aux;

    public RelojArena(int minutos){
        minutosInf = minutos;
        minutosSup = 0;
    }

    public void gira(){
        aux = minutosSup;
        minutosSup = minutosInf;
        minutosInf = aux;
    }

    public void pasatiempo(){
        minutosInf = minutosInf + minutosSup;
    }

    public int getTiempoRestante(){
        return minutosSup;
    }

    public void pasatiempo(RelojArena reloj){

    }

}
