import java.util.List;
import java.util.Scanner;

public class GameUI {
	private static Scanner scanner = new Scanner(System.in);

	//display main menu and prompt for a choice
	public int showMainMenu() {
	    int choice = -1;
	    while (choice < 1 || choice > 2) {
	        System.out.println("Welcome to Pokémon Ga-Ole!");
	        System.out.println("1> Start Game");
	        System.out.println("2> Exit (All player Pokémon will be removed)");
	        System.out.print("Enter the number of your choice: ");
	        try {
	            choice = Integer.parseInt(scanner.nextLine());
	            if (choice < 1 || choice > 2){
	                System.out.println("Please enter 1 or 2 only!");
	            }
	        } 
	        catch (NumberFormatException e) {
	            System.out.println("Please enter numbers (1-2)!");
	        }
	    }
	    return choice;
	}
	
	//prompt for which stage to select
	public int reqStage() {
	    int stageChoice = -1;
	    while (stageChoice < 1 || stageChoice > 3) {
	        System.out.print("Enter the stage number you want to choose (1-3): ");
	        try {
	        	stageChoice = Integer.parseInt(scanner.nextLine());
	        	if (stageChoice < 1 || stageChoice > 3){
	                System.out.println("Please enter 1,2 or 3 only!");
	            }
	        } 
	        catch (NumberFormatException e) {
	            System.out.println("Please enter numbers (1-3)!");
	        }
	    }
	    return stageChoice;
	}
	
	//prompt for which pokemon to catch in catch time 1
	public int reqCatch() {
	    int catchChoice = -1;
	    while (catchChoice < 1 || catchChoice > 3) {  
	        System.out.print("Choose a Pokémon to catch!: ");
	        try {
	            catchChoice = Integer.parseInt(scanner.nextLine());
	            if (catchChoice < 1 || catchChoice > 3){
	                System.out.println("Please enter 1,2 or 3 only!");
	            }
	        } 
	        catch (NumberFormatException e) {
	            System.out.println("Please enter numbers (1-3)!");
	        }
	    }
	    return catchChoice;
	}
    
	//display all player owned pokemon and prompt for which to select for battle two times
    public int showDepartBattle(String ordinal, List<String> chosenBattlePokemon) {
    	System.out.println();
	    System.out.println("Choose " + ordinal + " Pokémon to send out for battle:");
	    for (int i = 0; i < chosenBattlePokemon.size(); i++) {
	        System.out.println((i + 1) + "> " + chosenBattlePokemon.get(i));
	    }

	    int battleChoice = -1;
	    while (battleChoice < 1 || battleChoice > chosenBattlePokemon.size()) {
	        System.out.print("Enter choice: ");
	        try {
	        	battleChoice = Integer.parseInt(scanner.nextLine());
	        	if (battleChoice < 1 || battleChoice > chosenBattlePokemon.size()) {
	                System.out.println("Please choose accordingly to the list given!");
	            }
	        } 
	        catch (NumberFormatException e) {
	            System.out.println("Please enter numbers only!");
	        }
	    }
	    return battleChoice;
	}
    
    //display end menu and prompt for a choice
    public int showEndMenu() {
	    int choice = -1;
	    while (choice < 1 || choice > 2) {
	        System.out.println("Continue Playing?");
	        System.out.println("1> Yes");
	        System.out.println("2> No (All player Pokémon will be removed)");
	        System.out.print("Enter the number of your choice: ");
	        try {
	            choice = Integer.parseInt(scanner.nextLine());
	            if (choice < 1 || choice > 2){
	                System.out.println("Please enter 1 or 2 only!");
	            }
	        } 
	        catch (NumberFormatException e) {
	            System.out.println("Please enter numbers (1-2)!");
	        }
	    }
	    return choice;
	}
}  