package vn.hcm.ptit.master.ga.entities;

public class Gene {
	private boolean geneValue;
	
	public Gene() {
		this.geneValue = true;
	}

	public Gene(boolean geneValue) {
		this.geneValue = geneValue;
	}

	public boolean isGeneValue() {
		return geneValue;
	}

	public void setGeneValue(boolean geneValue) {
		this.geneValue = geneValue;
	}
	
	@Override
	public String toString() {
		return geneValue ? "1" : "0";
	}
}