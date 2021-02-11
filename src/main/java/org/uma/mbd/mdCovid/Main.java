package org.uma.mbd.mdCovid;

import org.uma.mbd.mdCovid.covid.Region;
import org.uma.mbd.mdCovid.covid.Indicadores;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Indicadores ind = new Indicadores();
            ind.leeIndicadores("recursos/mdCovid/indicadores.txt");
            List<Region> lista = ind.getIndicadores();
            Comparator<Region> ccuci = (r1, r2) -> Double.compare(r1.getOcupUCIs(), r2.getOcupUCIs());
//            Comparator<Region> ccuci = Comparator.comparingDouble(r -> r.getOcupUCIs());
//            Comparator<Region> ccuci = Comparator.comparingDouble(Region::getOcupUCIs);
            Comparator<Region> cnom = (r1, r2) -> r1.getRegion().compareTo(r2.getRegion());
//            Comparator<Region> cnom = Comparator.comparing(r -> r.getRegion());
//            Comparator<Region> cnom = Comparator.comparing(Region::getRegion);
            Comparator<Region> cia14 = (r1, r2) -> Double.compare(r1.getIa14(), r2.getIa14());
//            Comparator<Region> cia14 = Comparator.comparingDouble(r -> r.getIa14());
//            Comparator<Region> cia14 = Comparator.comparingDouble(Region::getIa14);
            // lista.sort(ccuci.thenComparing(cnom)); /* Ordena por camas UCI y a igualdad ordena por nombre */
            lista.sort(cia14);
            for (Region region : lista) {
                System.out.println(region);
            }
        } catch (IOException e) {
            System.err.println("Error de E/S "+ e.getMessage());
        }
    }
}

// Varias formas de comparar. De la forma normal y con programación funcional.