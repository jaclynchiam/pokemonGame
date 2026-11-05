public class EvolutionInfo {
	private String currentName;
	private String evolName;
	private char evolGrade;
	private int evolLevel;
	private int evolBonusHP;
	private int evolBonusAttk;
	private int evolBonusDefense;
	
	//constructor
	public EvolutionInfo(String currentName, String evolName, char evolGrade, int evolLevel, int evolBonusHP, int evolBonusAttk,int evolBonusDefense) {
		this.currentName = currentName;
		this.evolName = evolName;
		this.evolGrade = evolGrade;
		this.evolLevel = evolLevel;
		this.evolBonusHP = evolBonusHP;
		this.evolBonusAttk = evolBonusAttk;
		this.evolBonusDefense = evolBonusDefense;
	}

	//getter
	public String getCurrentName() {
		return currentName;
	}

	public String getEvolName() {
		return evolName;
	}
	
	public char getEvolGrade() {
		return evolGrade;
	}

	public int getEvolLevel() {
		return evolLevel;
	}

	public int getEvolBonusHP() {
		return evolBonusHP;
	}

	public int getEvolBonusAttk() {
		return evolBonusAttk;
	}

	public int getEvolBonusDefense() {
		return evolBonusDefense;
	}
}