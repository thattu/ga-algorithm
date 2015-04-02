package vn.hcm.ptit.master.ga.commons;

import vn.hcm.ptit.master.ga.entities.Chromosome;

public class RepresentationFunction {
	private final int BINARY = 2;
	private static RepresentationFunction representationFunction = new RepresentationFunction();
	
	private RepresentationFunction() {
	}
	
	public static RepresentationFunction getInstance() {
		return representationFunction;
	}
	
	public double convert(Chromosome chromosome) {
		long decimalValue = Long.parseLong(chromosome.toString(), BINARY);
		return (-1.0) + decimalValue * (3 / (Math.pow(BINARY, 22) - 1));
	}
}
