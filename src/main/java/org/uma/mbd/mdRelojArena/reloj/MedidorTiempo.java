package org.uma.mbd.mdRelojArena.reloj;

public class MedidorTiempo {
    private RelojArena izdo;
    private RelojArena drcho;
    private int tiempoTotal = 0;

    public MedidorTiempo (int minutosIzdo, int minutosDrcho){
        izdo = new RelojArena(minutosIzdo);
        drcho = new RelojArena(minutosDrcho);
    }

    public void giraDerecho(){
        drcho.gira();
    }

    public void giraIzquierdo(){
        izdo.gira();
    }

    public void giraAmbos(){
        izdo.gira();
        drcho.gira();
    }

    public void pasaTiempo(){
        if(izdo.getTiempoRestante() == 0){
            tiempoTotal += drcho.getTiempoRestante();
            drcho.pasaTiempo();
        }
        else if (drcho.getTiempoRestante() == 0){
            tiempoTotal += izdo.getTiempoRestante();
            izdo.pasaTiempo();
        }
        else if (izdo.getTiempoRestante() != 0 &&  drcho.getTiempoRestante() != 0 && drcho.getTiempoRestante() < izdo.getTiempoRestante()){
            tiempoTotal += drcho.getTiempoRestante();
            izdo.pasaTiempo(drcho);
        }
        else if (izdo.getTiempoRestante() != 0 &&  drcho.getTiempoRestante() != 0 && drcho.getTiempoRestante() > izdo.getTiempoRestante()){
            tiempoTotal += izdo.getTiempoRestante();
            drcho.pasaTiempo(izdo);
        }
    }

    public int getTiempoTotal(){
        return tiempoTotal;
    }

    public String toString(){
        return "Medidor: " + izdo + drcho + ", Tiempo total: " + tiempoTotal;
    }
}

