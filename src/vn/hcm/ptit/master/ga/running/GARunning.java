package vn.hcm.ptit.master.ga.running;

import java.text.DecimalFormat;

import vn.hcm.ptit.master.ga.commons.GAUtils;
import vn.hcm.ptit.master.ga.commons.RandomGenerator;
import vn.hcm.ptit.master.ga.entities.Individual;
import vn.hcm.ptit.master.ga.entities.Population;

public class GARunning {

	public static void main(String[] args) {
		final int GENERATION_NUMBER = 10;
		StringBuilder stringBuilder = new StringBuilder();
		final String DOUBLE_LINE = "\n==============================================================\n";
		final String STAR_LINE = "\n********************************************************************\n";
		DecimalFormat decimalFormat = new DecimalFormat("#.######");
		
		Population population = new Population();
		population = RandomGenerator.getInstance().generatePopulation(50);
		stringBuilder.append("Initialize population: \n").append(population.toString());
		stringBuilder.append(DOUBLE_LINE);
		stringBuilder.append("This program will stop after " + GENERATION_NUMBER + " generations.\n");
		stringBuilder.append(DOUBLE_LINE);
		
		System.out.println(population.toString());
		
		for(int i = 1; i <= GENERATION_NUMBER; i++) {
			
			System.out.println("Generation " + i + "\n");
			stringBuilder.append("Generation " + i + "\n");
			population = GAUtils.reLocatePopulation(population);
			stringBuilder.append("Population before selection: \n");
			stringBuilder.append(population.toString());
			System.out.println(population.toString());
			
			GAUtils.doCrossover(population);
			stringBuilder.append(DOUBLE_LINE).append("Population after do crossover: \n").append(DOUBLE_LINE);
			stringBuilder.append(population.toString());
			
			GAUtils.doMutation(population);
			stringBuilder.append(DOUBLE_LINE).append("Population after do mutation: \n").append(DOUBLE_LINE);
			stringBuilder.append(population.toString());
			
			Individual maxIndividual = population.getMaxIndividual();
			stringBuilder.append("\nMAX : " + maxIndividual.getChromosome().toString() + " - Value: " + decimalFormat.format(maxIndividual.getValue()));
			stringBuilder.append(STAR_LINE);
			System.out.println("\nMAX: " + maxIndividual.getChromosome().toString() + " - Value: " + decimalFormat.format(maxIndividual.getValue()));
		}
		
		GAUtils.writeToFile(stringBuilder.toString(), "D:\\output.txt");
	}
}
