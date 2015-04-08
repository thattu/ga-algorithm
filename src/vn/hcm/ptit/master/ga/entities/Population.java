package vn.hcm.ptit.master.ga.entities;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Population {
	public static final int DEFAULT_POPULATION_SIZE = 30;
	private int popularSize;
	private List<Individual> allIndividuals;
	private DecimalFormat decimalFormat = new DecimalFormat("#.######");
	
	public Population() {
		this.popularSize = DEFAULT_POPULATION_SIZE;
		this.allIndividuals = new ArrayList<Individual>();
	}
	
	public Population(int populationSize) {
		this.popularSize = populationSize;
		this.allIndividuals = new ArrayList<Individual>();
	}

	public int getPopularSize() {
		return popularSize;
	}

	public void setPopularSize(int popularSize) {
		this.popularSize = popularSize;
	}

	public List<Individual> getAllIndividuals() {
		return allIndividuals;
	}

	public void setAllIndividuals(List<Individual> allIndividuals) {
		this.allIndividuals = allIndividuals;
	}

	public void addNewIndividual(Individual newIndividual) {
		this.allIndividuals.add(newIndividual);
	}
	
	public Individual getIndividual(int index) {
		return this.allIndividuals.get(index);
	}
	
	public double getTotalFitness() {
		double sum = 0;
		for(Individual individual : allIndividuals) {
			sum += individual.getValue();
		}
		return sum;
	}
	
	public double getCumulativeProbability(int indexOfChromosome) {
		double sumProbability = 0;
		double totalFitness = getTotalFitness();
		for(int i = 0; i <= indexOfChromosome; i++) {
			sumProbability += allIndividuals.get(i).getValue();
		}
		return sumProbability / totalFitness;
	}
	
	public Individual getMaxIndividual() {
		Individual maxIndividual = getIndividual(0);
		for(Individual individual : allIndividuals) {
			if(individual.getValue() > maxIndividual.getValue()) {
				maxIndividual = individual;
			}
		}
		return maxIndividual;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < popularSize; i++) {
			builder.append("v" + i + "( ").append(allIndividuals.get(i).getChromosome().toString());
			builder.append(" - Value: " + decimalFormat.format(getIndividual(i).getValue()) + "\n");
			//builder.append(" - p" + i + " = " + getCumulativeProbability(i)).append(" )\n");
		}
		return builder.toString();
	}
}
