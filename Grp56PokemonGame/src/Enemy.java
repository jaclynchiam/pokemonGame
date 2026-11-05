import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy {
	private List<Pokemon> team; 
	private List<Pokemon> battleTeam;
	   

	// Constructor
	public Enemy() {
		this.team = new ArrayList<>(); // Initialize the team as an empty ArrayList
		this.battleTeam = new ArrayList<>(); // same for battle team
	}

	// Getter
	public List<Pokemon> getTeam() {
		return team;
	}

	public List<Pokemon> getBattleTeam() {
		return battleTeam;
	}

	// Method
	public void setBattleTeam() { //choose battle pokemon automatically
		battleTeam.clear();
		Random random = new Random();
		for (int i = 0; i <2; i++) {
			int index = random.nextInt(team.size());
			battleTeam.add(team.remove(index));	//prevent same enemy
		}
    }
	
	public void addPokemon(Pokemon p) {
		this.team.add(p);
	}
}