import java.io.*;
import java.util.*;

public class Score {
	private List<ScoreResult> topScores = new ArrayList<>();
	private final String file = "scores.txt";
	
	public void loadScores() {
	    topScores.clear();
	    File f = new File(file);
	    if (!f.exists()) return;

	    try (Scanner sc = new Scanner(f)) {
	        while (sc.hasNextLine()) {
	            String line = sc.nextLine();
	            String[] parts = line.trim().split(" ");
	            if (parts.length >= 2) {
	                String name = parts[0];
	                try {
	                    int score = Integer.parseInt(parts[1]);
	                    topScores.add(new ScoreResult(name, score));
	                } catch (NumberFormatException ignored) {}
	            }
	        }
	    } 
	    catch (IOException e) {
	        System.out.println("Error reading score file: " + e.getMessage());
	    }
	}

    public void addScore(ScoreResult sr) {
        topScores.add(sr);
        writeToFile();
    }

    public List<ScoreResult> getTop5Scores() {
        sortList();
        int end = Math.min(5, topScores.size());
        return new ArrayList<>(topScores.subList(0, end));
    }

    public void sortList() {
    	topScores.sort(Comparator.comparingInt(ScoreResult::getScore).reversed());
    }

    public void writeToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
        	for (ScoreResult sr : topScores) {
                writer.println(sr.toString());
            }
        } 
        catch (IOException e) {
            System.out.println("Error writing to score file: " + e.getMessage());
        }
    }
}