import java.util.ArrayList;
import java.util.List;

public class Game {
	private GameUI gameUI;
	private boolean samePlayer;
	private Player player;
	private Enemy enemy;
	private StageSelector stageSelector;
	private CatchTime catchTime;
	private DepartBattle battlePokemonSelector;
	private Battle battle;
	private Result result;
	private Evolution evolution;
	
	//Constructor/System logic
	public Game() {
		gameUI = new GameUI();
		samePlayer = true;
	}
	
	public void runLoop() { //To make sure player pokemon is saved for each round until exit
		while (samePlayer) {
			player = new Player();
			start();
		}
	}

	//Game logic
	public void start() {
		int menuChoice = gameUI.showMainMenu();
		
		if (menuChoice == 1) {
	        startGame();
	    } 
		
		else {
	        System.out.println("Thanks for playing! Exiting the game...");
	        samePlayer = false;
	    }
	}
	
	//select start game or continue game
	private void startGame() {
		
		//generating stages
		System.out.println();
		System.out.println("=====*=====Loading Stages=====*=====");
		stageSelector = new StageSelector();
		stageSelector.displayAllStages();
		
		//ask user to choose a stage
		int stageChoice = gameUI.reqStage();
		Stage selectedStage = stageSelector.getStage(stageChoice - 1); 
	
		//move stage enemy pool into enemy team
		enemy = new Enemy();
		for (Pokemon p : selectedStage.getEnemyPool()) {
		    enemy.addPokemon(p);
		}
		
		enemy.setBattleTeam(); //choose 2 enemy from the pool to sent to battle
		
		//catch time 1
		System.out.println();
		System.out.println("=====!=====Entering Catch Time=====!=====");
		System.out.println();
		catchTime = new CatchTime();
		catchTime.displayAvailablePokemon();
		
		//ask user to choose one pokemon to catch
		int catchChoice = gameUI.reqCatch();
		catchTime.catchTime1(catchChoice);
		for (Pokemon p : catchTime.getCaughtPokemon()) {
			player.addPokemon(p);
		}
		
		//gift overpower pokemon in first round for testing
		if (player.getTeam().size() < 2) {
		System.out.println("=====+=====New Player Reward=====+=====");
		System.out.println();
		Pokemon testerPokemon = new FirePokemon("Groudon", 'S', 1000, 1000, 1000, 1000);
		testerPokemon.setCaught(true);
		System.out.println("[New player reward:]");
		System.out.println(testerPokemon);
		player.addPokemon(testerPokemon);
		}
		
		//display enemy pokemon
		System.out.println("=====#=====Ready for Battle=====#=====");
		System.out.println();
		System.out.println("Two wild Pokémon appeared!");
		for (Pokemon p : enemy.getBattleTeam()) {
			System.out.println("[Enemy " + p + "]");
		}
		
		//player choose pokemon for battle
        battlePokemonSelector = new DepartBattle(player.getTeam());
        List<Pokemon> battleTeam = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            String ordinal = (i == 1) ? "1st" : "2nd";
            List<String> displayList = battlePokemonSelector.getDisplayList();

            int chosenPokemon = gameUI.showDepartBattle(ordinal, displayList);
            Pokemon chosen = battlePokemonSelector.removeChosen(chosenPokemon - 1);

            if (chosen != null) {
                battleTeam.add(chosen);
            }
        }

        player.setBattleTeam(battleTeam);
        
        //display chosen battle pokemon 
        System.out.println();
        System.out.println("Selected Battle Team:");
        for (Pokemon p : player.getBattleTeam()) {
            System.out.println(p); 
        }
   
        //start battle
		System.out.println();
        System.out.println("==========Battle start==========");
		System.out.println();
		
        battle = new Battle(player.getBattleTeam(), enemy.getBattleTeam());
        battle.startBattle();

        //check and run catch time2 if win battle, skip if lose (can only win if all enemy Pokemon fainted) 
        if (battle.isPlayerWin()) {
    		System.out.println();
        	System.out.println("=====!=====Entering Catch Time=====!=====");
    		System.out.println();
        	catchTime.catchTime2(enemy.getBattleTeam().get(0), enemy.getBattleTeam().get(1));
        }
        
        for (Pokemon p : catchTime.getct2CaughtPokemon()) {
        	p.setCurrentHp(p.getMaxHp());
        	p.setFainted(false); 
			player.addPokemon(p);
        }
        
        //show result and score
		System.out.println();
        System.out.println("=====*=====Loading Results=====*=====");
		System.out.println();
        result = new Result();
        int battleScore = result.calculateScore(battle.getTotalPlayerAttack(),battle.getTotalPlayerDamaged(),battle.isPlayerWin());
        result.showResult(battle.isPlayerWin(),battleScore, player.getBattleTeam(), catchTime.getCaughtPokemon());
        
        //check evolution, only will be triggered if any player battle pokemon reached level 5 or 10
        evolution = new Evolution();
        for (Pokemon p : player.getBattleTeam()) {
        	evolution.checkThenEvolve(p);
        }
        
        //ask if player want to play again
       	System.out.println();
        int playAgainChoice = gameUI.showEndMenu();
        if (playAgainChoice == 1) {
	        startGame();
	    } 
		
        else {
        	System.out.println("Thanks for playing! Exiting the game...");
        	samePlayer = false;
        }
	}
}