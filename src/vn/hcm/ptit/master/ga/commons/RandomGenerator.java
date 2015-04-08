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
	
	private Chromosome generateChromosome(int chromosomeLength) {
		Chromosome chromosome = new Chromosome(chromosomeLength);
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
	
	public Individual generateIndividual(int chromosomeLength) {
		Individual individual = new Individual();
		individual.setChromosome(generateChromosome(chromosomeLength));
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
	
	public Population generatePopulation(int populationSize) {
		Population population = new Population(populationSize);
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
	
	public double generateRandomRatio() {
		return (new Random()).nextDouble();
	}
	
	public Chromosome generateCrossoverMask() {
		Chromosome chromosome = new Chromosome();
		List<Gene> allGenes = new ArrayList<Gene>();
		int chromosomeLength = chromosome.getLength();
		int location = generateRandomLocation(chromosomeLength);
		for(int i = 0; i < chromosomeLength; i++) {
			if(i <= location) 
				allGenes.add(new Gene(true));
			else
				allGenes.add(new Gene(false));
		}
		chromosome.setChromosome(allGenes);
		return chromosome;
	}
	
	/*public static void main(String args[]) {
		Population p = getInstance().generatePopulation(50);
		System.out.println(p.toString());
		
	}*/
}
