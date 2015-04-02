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

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < popularSize; i++) {
			builder.append("v" + i + "( ").append(allIndividuals.get(i).getChromosome().toString()).append(" )\n");
		}
		return builder.toString();
	}
}
