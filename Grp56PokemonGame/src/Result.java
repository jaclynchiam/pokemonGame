import java.util.List;
import java.util.Scanner;

public class Result {
    private Scanner scanner = new Scanner(System.in);
    private Score scoreManager = new Score();
    
    public int calculateScore(int attack, int damageTaken,boolean playerWin) {
    	int battleScore = 1000; //minimum to prevent negative score
    	battleScore += (attack * 5) - (damageTaken);
    	if (playerWin) {
    	    battleScore += 1000;
    	}
    	return battleScore;
    }

    public void showResult(boolean playerWin, int battleScore, List<Pokemon> usedPokemons, List<Pokemon> obtainedPokemons) {
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        ScoreResult scoreResult = new ScoreResult(playerName, battleScore);
        scoreManager.loadScores();
        scoreManager.addScore(scoreResult);
        List<ScoreResult> top5 = scoreManager.getTop5Scores();

        if (playerWin) {
            System.out.println("\"Good job!\"");
        }

        System.out.println("\nYour battle score is: " + scoreResult.getScore());
        System.out.println("\nTop score list:");
        for (int i = 0; i < top5.size(); i++) {
        	System.out.printf("%d\t%s\n", i + 1, top5.get(i));
        }

        if (playerWin && obtainedPokemons != null && !obtainedPokemons.isEmpty()) {
            System.out.println("\n\"These are Pokémons you obtained this round:\"");
            for (Pokemon p : obtainedPokemons) {
                System.out.println(p);    
            }
        }
        
        System.out.println("\n\"All your Pokémon Level Up!\"");
        for (Pokemon p : usedPokemons) {
            p.levelUp();
            System.out.println(p);
        }
    }
}