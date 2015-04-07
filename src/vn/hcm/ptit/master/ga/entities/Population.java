package vn.hcm.ptit.master.ga.entities;

import java.util.ArrayList;
import java.util.List;

public class Population {
	
	private int popularSize;
	private List<Individual> allIndividuals;
	
	public Population() {
		this.popularSize = 50;
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
			sumProbability += allIndividuals.get(i).getSelectionProbability(totalFitness);
		}
		return sumProbability;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < popularSize; i++) {
			builder.append("v" + i + "( ").append(allIndividuals.get(i).getChromosome().toString()).append(" )\n");
		}
		return builder.toString();
	}
}
