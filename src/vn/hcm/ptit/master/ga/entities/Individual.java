package vn.hcm.ptit.master.ga.entities;

import vn.hcm.ptit.master.ga.commons.FitnessFunction;
import vn.hcm.ptit.master.ga.commons.RepresentationFunction;

public class Individual {

	private Chromosome chromosome;
	
	public Individual() {
	}

	public Individual(Chromosome chromosome) {
		this.chromosome = chromosome;
	}

	public int getLength() {
		return chromosome.getLength();
	}

	public void setLength(int length) {
		this.chromosome.setLength(length);
	}

	public Chromosome getChromosome() {
		return chromosome;
	}

	public void setChromosome(Chromosome chromosome) {
		this.chromosome = chromosome;
	}

	public double getValue() {
		return FitnessFunction.getInstance().calculate(RepresentationFunction.getInstance().convert(this.chromosome));
	}
	
	public double getSelectionProbability(double totalFitness) {
		return getValue() / totalFitness;
	}
}
