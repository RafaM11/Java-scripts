package org.uma.mbd.mdMastermindL.mdMastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MasterMindMemoria extends MasterMind {

    private List<Movimiento> movimientos = new ArrayList<>();

        public MasterMindMemoria() {
            super();
        }

        public MasterMindMemoria(int longitud) { super(longitud); }

        public MasterMindMemoria(String secreto) { super(secreto); }

        @Override
        public Movimiento intento(String cifras) {
            Movimiento movimiento = super.intento(cifras);

            if (movimientos.contains(movimiento)) {
                throw new MasterMindException("No está permitido repetir cifras.");
            }
            movimientos.add(movimiento);
            return movimiento;
        }

        public List<Movimiento> movimientos() {
            return movimientos;
        }
}