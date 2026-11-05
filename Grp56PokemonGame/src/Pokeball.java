public class Pokeball { 
    private String name;
    private double bonusRate;
    
    public Pokeball(String name, double rate) {
		this.name = name;
		this.bonusRate = rate;
	}

	public String getName() {
		return name;
	}

	public double getBonusRate() {
		return bonusRate;
	}
}