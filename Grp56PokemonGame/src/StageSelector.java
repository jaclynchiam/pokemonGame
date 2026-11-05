import java.util.ArrayList;
import java.util.List;

public class StageSelector {
    private List<Stage> stages = new ArrayList<>();

    public StageSelector() {
        generateStages(); 
    }

    private void generateStages() {
    	PokemonGenerator generator = new PokemonGenerator();
        stages.add(new Stage(1, 'C', generator.generateGradePokemon('C', 5)));
        stages.add(new Stage(2, 'B', generator.generateGradePokemon('B', 5)));
        stages.add(new Stage(3, 'A', generator.generateGradePokemon('A', 5)));
    }
    
    public void displayAllStages() {
        for (Stage stage : stages) {
           	System.out.println();
            System.out.println("Stage " + stage.getStageNum() + " (Grade " + stage.getGrade() + "):");
            stage.display();
        }
    }
    
    public Stage getStage(int index) {
        return stages.get(index);
    }
}