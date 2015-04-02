package vn.hcm.ptit.master.ga.commons;

public class FitnessFunction {
	
	private static FitnessFunction fitnessFunction = new FitnessFunction();
	
	private FitnessFunction() {
	}
	
	public static FitnessFunction getInstance() {
		return fitnessFunction;
	}
	
	public double calculate(double value) {
		return value * Math.sin(value * 10 * Math.PI) + 1.0 ;
	}
}
