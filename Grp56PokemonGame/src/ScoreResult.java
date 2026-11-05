public class ScoreResult {
     private String playerName;
     private int score;
     
     public ScoreResult (String playerName, int score) {
    	 this.playerName = playerName;
    	 this.score = score; 
     }
     
     public String getPlayerName() {
    	 return playerName;
     }
     
     public int getScore() {
    	 return score;
     }
     
     @Override 
     public String toString() {
    	 return playerName + " " + score;
     }
}