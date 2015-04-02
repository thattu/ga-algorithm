package vn.hcm.ptit.master.ga.entities;

public class Individual {

	private Chromosome chromosome;
	private float value;
	
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

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
}
