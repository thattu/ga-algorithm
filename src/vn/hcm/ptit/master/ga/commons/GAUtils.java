package vn.hcm.ptit.master.ga.commons;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

	private static int getChangedPoint(Chromosome crossoverMask) {
		int count = 0;
		for(int i = 0; i < crossoverMask.getLength(); i++) {
			if(crossoverMask.getChromosome().get(i).isGeneValue())
				count++;
		}
		return count;
	}
	
	private static void crossover(Individual firstIndividual, Individual secondIndividual) {
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
	
	private static void mutate(Individual individual) {
		Chromosome chromosome = individual.getChromosome();
		int index = RandomGenerator.getInstance().generateRandomLocation(chromosome.getLength());
		chromosome.getChromosome().get(index).mutate();
	}
	
	private static int getIndividualLocation(Population population) {
		double r = RandomGenerator.getInstance().generateRandomRatio();
		for(int i = 1; i < population.getPopularSize(); i++) {
			double curSelectionProbability = population.getCumulativeProbability(i);
			double prevSelectionProbability = population.getCumulativeProbability(i - 1);
			if(r >= prevSelectionProbability && r < curSelectionProbability) {
				return i - 1;
			} 
		}
		return 0;
	}
	
	public static Population reLocatePopulation(Population population) {
		Population newPopulation = new Population(population.getPopularSize());
		for(int i = 0; i < population.getPopularSize(); i++) {
			newPopulation.addNewIndividual(population.getIndividual(getIndividualLocation(population)));
		}
		return newPopulation;
	}
	
	public static void generateMutationRatio(Population population) {
		for(Individual individual : population.getAllIndividuals()) {
			individual.regenerateSelectionRatio();
		}
	}
	
	private static List<Integer> getCrossoverIndividualList(Population population) {
		List<Integer> indexList = new ArrayList<Integer>();
		for(int i = 0; i < population.getPopularSize(); i++) {
			if (population.getIndividual(i).getRatio() < P_C) {
				indexList.add(i);
			}
		}
		if(indexList.size() % 2 != 0) {
			int index = 0;
			do {
				index = RandomGenerator.getInstance().generateRandomLocation(population.getPopularSize());
			} while (population.getIndividual(index).getRatio() < P_C);
			indexList.add(index);
		}
		return indexList;
	}
	
	public static void doCrossover(Population population) {
		List<Integer> indexList = getCrossoverIndividualList(population);
		for(int i = 0; i < indexList.size() - 1; i = i + 2) {
			crossover(population.getIndividual(i), population.getIndividual(i + 1));
		}
	}
	
	public static void doMutation(Population population) {
		generateMutationRatio(population);
		for(Individual individual : population.getAllIndividuals()) {
			if(individual.getRatio() <= P_M) 
				mutate(individual);
		}
	}
	
	public static void writeToFile(String content, String filePath) {
		Path path = Paths.get(filePath);
		try {
			Files.write(path, content.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
