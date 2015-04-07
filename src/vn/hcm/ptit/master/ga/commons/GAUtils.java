package vn.hcm.ptit.master.ga.commons;

import java.util.Random;

import vn.hcm.ptit.master.ga.entities.Chromosome;
import vn.hcm.ptit.master.ga.entities.Gene;
import vn.hcm.ptit.master.ga.entities.Individual;
import vn.hcm.ptit.master.ga.entities.Population;

public class GAUtils {
	private static GAUtils gaUtils = new GAUtils();
	
	private GAUtils() {
	}
	
	public static GAUtils getInstance() {
		return gaUtils;
	}

	public static int getChangedPoint(Chromosome crossoverMask) {
		int count = 0;
		for(int i = 0; i < crossoverMask.getLength(); i++) {
			count++;
		}
		return count;
	}
	
	public static void crossover(Individual firstIndividual, Individual secondIndividual) {
		Chromosome firstChrom = firstIndividual.getChromosome();
		Chromosome secondChrom = secondIndividual.getChromosome();
		Chromosome crossoverMask = RandomGenerator.getInstance().generateCrossoverMask();
		
		int changedPoint = getChangedPoint(crossoverMask);
		for(int i = changedPoint; i < crossoverMask.getLength(); i++) {
			Gene tempGene = new Gene();
			tempGene = firstChrom.getChromosome().get(i);
			firstChrom.getChromosome().set(i, secondChrom.getChromosome().get(i));
			secondChrom.getChromosome().set(i, tempGene);
		}
	}
	
	public static void mutate(Individual individual) {
		Chromosome chromosome = individual.getChromosome();
		int index = RandomGenerator.getInstance().generateRandomLocation(chromosome.getLength());
		chromosome.getChromosome().get(index).mutate();
	}
	
	public static void select(Population population) {
		double r = (new Random()).nextDouble();
	}
	
	public static void main(String[] args) {
		System.out.println((new Random()).nextDouble());
	}
}
