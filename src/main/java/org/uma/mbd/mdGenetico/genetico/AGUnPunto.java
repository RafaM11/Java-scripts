package org.uma.mbd.mdGenetico.genetico;

import java.util.Random;

public class AGUnPunto extends AlgoritmoGenetico {

	/**
	 * @param tPoblacion    Tamaño de la población que va a utilizar.
	 * @param longCromosoma Longitud de los cromosomas de los individuos de dicha
	 *                      población.
	 * @param pasos         Número de pasos del algoritmo (generaciones).
	 * @param probMutacion  Probabilidad de mutar un gen en el cromosoma.
	 * @param problema      Problema que se debe resolver.
	 */
	public AGUnPunto(int tPoblacion, int longCromosoma, int pasos, double probMutacion, Problema problema) {
		super(tPoblacion, longCromosoma, pasos, probMutacion, problema);
	}

	/**
	 * @see AlgoritmoGenetico#recombinar(Cromosoma, Cromosoma)
	 */
	@Override
	protected Cromosoma recombinar(Cromosoma cromosoma1, Cromosoma cromosoma2) {

		Cromosoma auxiliar = new Cromosoma(cromosoma1.longitud(), true);
		int z = Cromosoma.gna.nextInt(cromosoma1.longitud());

		for (int i = 0; i < z; i++) {
			auxiliar.setGen(i, cromosoma1.getGen(i));
		}
		for (int i = z; i < cromosoma1.longitud(); i++) {
			auxiliar.setGen(i, cromosoma2.getGen(i));
		}
		return auxiliar;
	}
}