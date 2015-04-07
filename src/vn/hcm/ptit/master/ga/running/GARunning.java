package vn.hcm.ptit.master.ga.running;

import vn.hcm.ptit.master.ga.commons.RandomGenerator;
import vn.hcm.ptit.master.ga.entities.Population;

public class GARunning {
	
	public static void main(String[] args) {
		Population population = new Population();
		population = RandomGenerator.getInstance().generatePopulation();
		
		
	}
}
