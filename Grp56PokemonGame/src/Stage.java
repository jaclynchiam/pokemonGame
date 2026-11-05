import java.util.List;

public class Stage {
    private int stageNum;
    private char grade;
    private List<Pokemon> enemyPool;

    public Stage(int stageNum, char grade, List<Pokemon> enemyPool) {
        this.stageNum = stageNum;
        this.grade = grade;
        this.enemyPool = enemyPool;
    }

	public int getStageNum() {
		return stageNum;
	}

	public char getGrade() {
		return grade;
	}

	public List<Pokemon> getEnemyPool() {
		return enemyPool;
	}
		
	public void display() {
        System.out.println("You may encounter these Pokémon!?");
        for (Pokemon p : enemyPool) {
            System.out.println("[" + p.getName() + " | Grade: " + p.getGrade() + "]");
        }
    }
}