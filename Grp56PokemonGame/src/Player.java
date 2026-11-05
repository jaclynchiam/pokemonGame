import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Pokemon> team; 
	private List<Pokemon> battleTeam;
	   

	// Constructor
	public Player() {
		this.team = new ArrayList<>(); // Initialize the team as an empty ArrayList
		this.battleTeam = new ArrayList<>(); // same for battle team
	}
	      
	// Getters
	public List<Pokemon> getTeam() {
		return team;
	}

	public List<Pokemon> getBattleTeam() {
		return battleTeam;
	}

	//Setter
	public void setBattleTeam(List<Pokemon> battleTeam) {
	    this.battleTeam = battleTeam;
	}
	    
	 // Method 
	public void addPokemon(Pokemon p) {
		this.team.add(p);
		System.out.println("<" + p.getName() + " has been added to " + " the team!" + ">");
		System.out.println();
	}
	
}