import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CatchTime {

	//attributes
	private Pokeball pokeballType;
	private List <Pokemon> availablePokemon;
	private List<Pokemon> caughtPokemon;
	private List<Pokemon> ct2caughtPokemon;
	
	
	//constructor
	public CatchTime() { 
		PokemonGenerator generator = new PokemonGenerator();
	    this.availablePokemon = generator.generateGradePokemon('C', 3); // generate 3 grade c pokemon
	    this.caughtPokemon = new ArrayList<>(); // store all catch results
	    this.ct2caughtPokemon = new ArrayList<>();  //store catch time 2 results for transferring
	}
	

	//getter
	public List<Pokemon> getAvailablePokemon() {
	    return availablePokemon;
	}
	
	public List<Pokemon> getCaughtPokemon(){
		return caughtPokemon;
	}
	
	public List<Pokemon> getct2CaughtPokemon(){
		return ct2caughtPokemon;
	}


	//display available pokemon for catch time 1
	public void displayAvailablePokemon() {		
		//show 3 available pokemon
		//display the available pokemon and information for user view the available pokemon
		System.out.println("3 Pokémon appeared!");
		System.out.println();
		
		//print out the available pokemon from the arrayList
		for(int i=0; i<availablePokemon.size();i++) {
			Pokemon p = availablePokemon.get(i); //get the available pokemon
			System.out.printf("%d> [%s | Grade: %s | Attack Type: %s | Defense Type: %s ]%n", (i + 1), p.getName(), p.getGrade(),p.getAttackType(),p.getDefenseType());
		}
	}
	
	//catch time 1
	public void catchTime1(int choice) {
		//get the chosen pokemon
		    Pokemon chosenPokemon = availablePokemon.get(choice - 1);
		    
		 // Add to caughtPokemon and set caught true
		    chosenPokemon.setCaught(true);
		    caughtPokemon.add(chosenPokemon); //add the caught pokemon to the list
		    
		    System.out.println("You caught [" + chosenPokemon.getName() + " | Grade: " + chosenPokemon.getGrade() + "]");
	}

	//catch time 2
	public void catchTime2(Pokemon targetPokemon1, Pokemon targetPokemon2) {
		System.out.println("Picking a pokeball...");
	
		 // Randomly pick a ball
	    List<Pokeball> ballOptions = new ArrayList<>();
	    ballOptions.add(new Pokeball("Pokeball", 30));
	    ballOptions.add(new Pokeball("Great Ball", 50));
	    ballOptions.add(new Pokeball("Ultra Ball", 70));
	    ballOptions.add(new Pokeball("Master Ball", 100));
	    
	    
		//use this to randomly pick a pokeball in catchtime2 
		Random r = new Random();
		
		this.pokeballType = ballOptions.get(r.nextInt(ballOptions.size()));
	    System.out.println("You used " + pokeballType.getName() + "!");
		
	
		//then use catchtime to auto catch the pokemon
	    catchTime(targetPokemon1,pokeballType);
	    catchTime(targetPokemon2,pokeballType);		
	}

	//for catch time 2 only
	private void catchTime(Pokemon targetPokemon, Pokeball pokeball) {
		
	    double catchRate = calculateCatchRate(targetPokemon, pokeball);
		double catchChance = Math.random(); // random number between 0.0 and 1.0
	
		if (catchChance < catchRate) {
		    System.out.println("GOTCHA! " + targetPokemon.getName() + " was caught!");
		    targetPokemon.setCaught(true);
		    ct2caughtPokemon.add(targetPokemon);
		    caughtPokemon.add(targetPokemon);
	
		} 
		
		else {
		    System.out.println("Oh no! " + targetPokemon.getName() + " broke free and fled...");
		}
		
		
	}
	
	
	//done calculate catch rate part
	public double calculateCatchRate(Pokemon targetPokemon, Pokeball pokeball) {
	    double baseRate;
	
	    switch (targetPokemon.getGrade()) {
	        case 'A': baseRate = 0.3; break; //grade A catch rate = 30%
	        case 'B': baseRate = 0.5; break; //grade B catch rate = 50%
	        case 'C': baseRate = 0.7; break; //grade C catch rate = 70%
	        default: throw new IllegalArgumentException("Invalid Pokémon grade: " + targetPokemon.getGrade());
	    }
	
	    double ballRate = pokeballType.getBonusRate() / 100.0;
	
	    return baseRate * ballRate;
	}
}