package vn.hcm.ptit.master.ga.entities;

import java.util.ArrayList;
import java.util.List;

public class Chromosome {
	public static final int DEFAULT_LENGTH = 22;
	private int length;
	private List<Gene> chromosome;
	
	public Chromosome() {
		this.length = DEFAULT_LENGTH;
		this.chromosome = new ArrayList<Gene>();
	}
	
	public Chromosome(int length) {
		this.length = length;
		this.chromosome = new ArrayList<Gene>();
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public List<Gene> getChromosome() {
		return chromosome;
	}

	public void setChromosome(List<Gene> chromosome) {
		this.chromosome = chromosome;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(Gene gene : chromosome) {
			builder.append(gene.toString());
		}
		return builder.toString();
	}
}
