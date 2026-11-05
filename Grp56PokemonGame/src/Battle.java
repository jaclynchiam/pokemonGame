import java.util.List;

public class Battle {
    private List<Pokemon> playerTeam;
    private List<Pokemon> enemyTeam;
    private Pokemon currentPlayerPokemon;
    private Pokemon currentEnemyPokemon;
    private int totalPlayerAttack = 0;
    private int totalPlayerDamaged = 0;
    private boolean playerWin;

    //constructor
    public Battle(List<Pokemon> playerTeam, List<Pokemon> enemyTeam) {
        this.playerTeam = playerTeam;
        this.enemyTeam = enemyTeam;
        this.currentPlayerPokemon = getFirstAlive(playerTeam);
        this.currentEnemyPokemon = getFirstAlive(enemyTeam); 
    }
    
    //getter
	//for battle
	public Pokemon getPlayerPokemon() {
        return currentPlayerPokemon;
    }

    public Pokemon getEnemyPokemon() {
        return currentEnemyPokemon;
    }
    
  //for result score calculation
    public int getTotalPlayerAttack() {
		return totalPlayerAttack;
	}

	public int getTotalPlayerDamaged() {
		return totalPlayerDamaged;
	}
    
	//methods
	 //start Battle
    public void startBattle() {
    	//print out current player team and enemy team
        System.out.println("Go " + currentPlayerPokemon.getName() + "!");
        System.out.println("Enemy sent out " + currentEnemyPokemon.getName() + "!");
        
        //display info
        displayPlayerPokemon(currentPlayerPokemon);
        displayEnemyPokemon(currentEnemyPokemon);
        
        //when player team and enemy team still have active pokemon to attack
        while (!allFainted(playerTeam) && !allFainted(enemyTeam)) {
            
        	playerTurn();
            //if one enemy pokemon fainted, print enemy fainted message and get the next alive enemy pokemon
            if (currentEnemyPokemon.isFainted()) {
                System.out.println("Enemy " + currentEnemyPokemon.getName() + " fainted!");
                currentEnemyPokemon = getFirstAlive(enemyTeam);
                
                //if still have enemy pokemon alive, print enemy send out message
                if (currentEnemyPokemon != null) {
                    System.out.println("Enemy sends out " + currentEnemyPokemon.getName() + "!");
                    displayEnemyPokemon(currentEnemyPokemon);
                } 
                
                //if no, it means no alive enemy left, so return with battlewin message 
                else {
                    Battlewin();
                    return;
                }
                //if still have continue battle
                continue;
            }
            
            //almost same logic as player turn
            enemyTurn();
            if (currentPlayerPokemon.isFainted()) {
                System.out.println("Oh no, " + currentPlayerPokemon.getName() + "  has fainted!");
                currentPlayerPokemon = getFirstAlive(playerTeam);
                if (currentPlayerPokemon != null) {
                    System.out.println("You send out " + currentPlayerPokemon.getName() + "!");
                    displayPlayerPokemon(currentPlayerPokemon);
                } 
                else {
                    Battlelose();
                    return;
                }
            }
        }
    }
	
    //display information while every battle
    public void displayPlayerPokemon(Pokemon p) {
        System.out.println("[" + p.getName() + " | Grade: " + p.getGrade() + " | HP: " + p.getCurrentHp() + "/" + p.getMaxHp() + "]");
    }
    
    public void displayEnemyPokemon(Pokemon p) {
        System.out.println("[Enemy " + p.getName() + " | Grade: " + p.getGrade() + " | HP: " + p.getCurrentHp() + "/" + p.getMaxHp() + "]");
    }
    
    //player turn to attack
    //if dont have any player pokemon or enemy pokemon stop immediately
    public void playerTurn() {
        if (currentPlayerPokemon == null || currentEnemyPokemon == null) return;
        //print your turn message 
    	System.out.println();
        System.out.println("Your turn to attack!");
        System.out.println(currentPlayerPokemon.getName() + " attacked Enemy " + currentEnemyPokemon.getName());
        int damage = currentPlayerPokemon.attack(currentEnemyPokemon);
        totalPlayerAttack += damage;
        System.out.println("Enemy " + currentEnemyPokemon.getName() + " took " + damage + " damage. ");
        displayEnemyPokemon(currentEnemyPokemon);    
    }
    
    //enemy turn to attack
    //same logic as above
    public void enemyTurn() {
        if (currentPlayerPokemon == null || currentEnemyPokemon == null) return;
        //print message enemy turn to attack
    	System.out.println();
        System.out.println("Enemy turn to attack!");
        System.out.println("Enemy " + currentEnemyPokemon.getName() + " attacked " + currentPlayerPokemon.getName());
        int damage = currentEnemyPokemon.attack(currentPlayerPokemon);
        totalPlayerDamaged += damage;
        System.out.println(currentPlayerPokemon.getName() + " took " + damage + " damage.");
        displayPlayerPokemon(currentPlayerPokemon);
    }
    
    //if battleWin print message
    public void Battlewin() {
    	playerWin = true;
    	System.out.println();
        System.out.println("Victory! All opponents’ Pokémon fainted!");
        System.out.println("Catch Time Activated!");
    }
    
    //if battleLose print message
    public void Battlelose() {
    	playerWin = false;
    	System.out.println();
        System.out.println("You lost! All your Pokémon fainted.");
        System.out.println("Loading to result page…");
        System.out.println();
    }
            
    // loop through all the pokemon to check if all fainted or not
    private boolean allFainted(List<Pokemon> team) {
        for (Pokemon p : team) {
            if (!p.isFainted()) return false;
        }
        return true;
    }
    
    // loop through all the pokemon to get the first alive pokemon
    private Pokemon getFirstAlive(List<Pokemon> team) {
        for (Pokemon p : team) {
            if (!p.isFainted()) return p;
        }
        //if no alive pokemon left, no pokemon is returned 
        return null;
    }
    
    //additional method to trigger catchtime2
    public boolean isPlayerWin() {
        return playerWin;
    }
}