import java.util.ArrayList;
import java.util.List;

public class DepartBattle {
    private final List<Pokemon> temporaryList;

    public DepartBattle(List<Pokemon> available) {
        this.temporaryList = new ArrayList<>(available);
    }

    public List<String> getDisplayList() {
        List<String> chosenBattlePokemon = new ArrayList<>();
        for (Pokemon p : temporaryList) {
            chosenBattlePokemon.add(p + "");
        }
        return chosenBattlePokemon;
    }

    //removing first chosen pokemon, to prevent it being chosen again
    public Pokemon removeChosen(int index) {
        if (index >= 0 && index < temporaryList.size()) {
            return temporaryList.remove(index);
        }
        return null;
    }
}