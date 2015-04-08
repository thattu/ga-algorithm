package vn.hcm.ptit.master.ga.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import vn.hcm.ptit.master.ga.entities.Chromosome;
import vn.hcm.ptit.master.ga.entities.Gene;
import vn.hcm.ptit.master.ga.entities.Individual;
import vn.hcm.ptit.master.ga.entities.Population;

public class RandomGenerator {
	
	private static RandomGenerator generator = new RandomGenerator();
	
	private RandomGenerator() {
	}
	
	public static RandomGenerator getInstance() {
		return generator;
	}
	
	private Chromosome generateChromosome() {
		Chromosome chromosome = new Chromosome();
		List<Gene> allGenes = new ArrayList<Gene>();
		for(int i = 0; i < chromosome.getLength(); i++) {
			allGenes.add(new Gene((new Random()).nextBoolean()));
		}
		chromosome.setChromosome(allGenes);
		return chromosome;
	}
	
	public Individual generateIndividual() {
		Individual individual = new Individual();
		individual.setChromosome(generateChromosome());
		return individual;
	}
	
	public Population generatePopulation() {
		Population population = new Population();
		List<Individual> allIndividuals = new ArrayList<Individual>();
		for(int i = 0; i < population.getPopularSize(); i++) {
			allIndividuals.add(generateIndividual());
		}
		population.setAllIndividuals(allIndividuals);
		return population;
	}
	
	public int generateRandomLocation(int length) {
		return (new Random()).nextInt(length);
	}
	
	public double generateRandomNumber() {
		return (new Random()).nextDouble();
	}
	
	public Chromosome generateCrossoverMask() {
		Chromosome chromosome = new Chromosome();
		List<Gene> allGenes = new ArrayList<Gene>();
		int chromosomeLength = chromosome.getLength();
		for(int i = 0; i < chromosomeLength; i++) {
			if(i <= generateRandomLocation(chromosomeLength)) 
				allGenes.add(new Gene(true));
			else
				allGenes.add(new Gene(false));
		}
		chromosome.setChromosome(allGenes);
		return chromosome;
	}
	
	/*public static void main(String[] args) {
		System.out.println(getInstance().generateCrossoverMask().toString());
	}*/
}
