package vn.hcm.ptit.master.ga.commons;

import vn.hcm.ptit.master.ga.entities.Chromosome;
import vn.hcm.ptit.master.ga.entities.Gene;
import vn.hcm.ptit.master.ga.entities.Individual;
import vn.hcm.ptit.master.ga.entities.Population;

public class GAUtils {
	public static final double P_C = 0.25;
	public static final double P_M = 0.01;
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
	
	public static int getIndividualLocation(Population population) {
		double r = RandomGenerator.getInstance().generateRandomNumber();
		double totalFitness = population.getTotalFitness();
		for(int i = 1; i < population.getPopularSize(); i++) {
			double curSelectionProbability = population.getAllIndividuals().get(i).getSelectionProbability(totalFitness);
			double prevSelectionProbability = population.getAllIndividuals().get(i - 1).getSelectionProbability(totalFitness);
			if(r >= prevSelectionProbability && r < curSelectionProbability) {
				return i - 1;
			} else if (r >=  curSelectionProbability) {
				return i;
			}
		}
		return 0;
	}
	
	public static void reLocatePopulation(Population population) {
		Population newPopulation = new Population();
		for(int i = 0; i < newPopulation.getPopularSize(); i++) {
			
		}
	}
	/*public static void main(String[] args) {
		System.out.println((new Random()).nextDouble());
	}*/
}
