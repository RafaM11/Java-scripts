package org.uma.mbd.mdGenetico.genetico;

public class Poblacion {
	private Individuo[] individuos;

	/**
	 * 
	 * @param tamaño
	 *            Número de individuos de la población.
	 * @param longitud
	 *            Tamaño de los cromosomas de los individuos de la población.
	 * @param problema
	 *            Problema a resolver.
	 * @throws RuntimeException
	 *             si el tamaño de la población o la longitud de los cromosomas
	 *             indicados no son válidos.
	 */
	public Poblacion(int tamaño, int longitud, Problema problema) throws RuntimeException {
		if (tamaño < 0) {
			throw new RuntimeException("El tamaño de la población no es válido.");
		}
		if (longitud < 0) {
			throw new RuntimeException("La longitud de los cromosomas debe ser positiva.");
		}
			individuos = new Individuo[tamaño];
			for (int i = 0; i < tamaño; i++) {
				Individuo individuo = new Individuo(longitud, problema);
				individuos[i] = individuo;
		}
	}

	/**
	 * Devuelve el número de individuos.
	 * 
	 * @return Número de individuos en la población.
	 */
	public int numIndividuos() {
		return individuos.length;
	}

	/**
	 * Devuelve el individuo con fitness mayor de la población.
	 * 
	 * @return Individuo con mejor fitness.
	 */
	public Individuo mejorIndividuo() {
		Individuo mejorIndividuo = individuos[0];
		for(int i = 0; i < numIndividuos(); i++) {
			if(individuos[i].getFitness() > mejorIndividuo.getFitness()) {
				mejorIndividuo = individuos[i];
			}
		} return mejorIndividuo;
	}

	/**
	 * Devuelve el i-ésimo individuo de la población.
	 * 
	 * @param i
	 *            Posición del individuo a devolver.
	 * @return Individuo en la posición i.
	 * @throws RuntimeException
	 *             si el índice está fuera del rango de valores válidos.
	 */
	public Individuo getIndividuo(int i) throws RuntimeException {
		if (i < 0 || i > individuos.length) {
			throw new RuntimeException("El índice está fuera del rango de valores válidos.");
		}
		return individuos[i];
	}

	/**
	 * Si el individuo que se pasa como argumento tienen mejor fitness que el
	 * peor de los individuos de la población, entonces el peor es sustituido
	 * por el que se pasa.
	 * 
	 * @param ind
	 *            Individuo con el que se sustituye el peor de los individuos si
	 *            este es mejor.
	 */

	public void reemplaza(Individuo ind) {
		Individuo peorIndividuo = individuos[0];
		int posPeorIndividuo = 0;

		for(int i = 0; i < numIndividuos(); i++) {
			if(individuos[i].getFitness() < peorIndividuo.getFitness()) {
				peorIndividuo = individuos[i];
				posPeorIndividuo = i;
			}
		}
		if (ind.getFitness() > peorIndividuo.getFitness()) {
			individuos[posPeorIndividuo] = ind;
		}
	}
}