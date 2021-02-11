package org.uma.mbd.mdRelojArena.reloj;

public class RelojArena {
    private int tiempoTotal;
    public int tiempoRestante;

    public RelojArena(int minutos){
        tiempoTotal = minutos;
        tiempoRestante = 0;
    }

    public void gira(){
        int aux = tiempoTotal;
        tiempoTotal = tiempoRestante;
        tiempoRestante = aux;
    }

    public void pasaTiempo(){
        tiempoTotal += tiempoRestante;
        tiempoRestante = 0;
    }

    public int getTiempoRestante(){
        return tiempoRestante;
    }

    public void pasaTiempo(RelojArena reloj){
        if(tiempoRestante > reloj.tiempoRestante){
            tiempoTotal += reloj.tiempoRestante;
            tiempoRestante -= reloj.tiempoRestante;
            reloj.pasaTiempo();

        } else {
            tiempoTotal += tiempoRestante;
            tiempoRestante = 0;
            reloj.pasaTiempo();
        }
    }

    public String toString(){
        return "R(" + tiempoRestante + "/" + tiempoTotal + ")";
    }
}