import java.util.*;
public class PokemonGenerator {
    private List<Pokemon> availablePokemon = new ArrayList<>();

    public PokemonGenerator() {
        //grade C
        availablePokemon.add(new GrassPokemon("Bulbasaur", 'C', 1,20,10,10));
        availablePokemon.add(new FirePokemon("Charmander", 'C', 1,20,10, 10));
        availablePokemon.add(new WaterPokemon("Squirtle", 'C', 1,20,10, 10));

        availablePokemon.add(new GrassPokemon("Chikorita", 'C', 1,15,13,12));
        availablePokemon.add(new FirePokemon("Cyndaquil", 'C', 1,15,13, 12));
        availablePokemon.add(new WaterPokemon("Totodile", 'C', 1,15,13, 12));

        availablePokemon.add(new GrassPokemon("Treecko", 'C', 1,25,7,10));
        availablePokemon.add(new FirePokemon("Torchic", 'C', 1,25,7, 10));
        availablePokemon.add(new WaterPokemon("Mudkip", 'C', 1,25,7, 10));
        
        //grade B
        availablePokemon.add(new GrassPokemon("Ivysaur", 'B', 5,30,15,15));
        availablePokemon.add(new FirePokemon("Charmeleon", 'B', 5,30,15,15));
        availablePokemon.add(new WaterPokemon("Wartortle", 'B', 5,30,15,15));

        availablePokemon.add(new GrassPokemon("Bayleef", 'B', 5,25,18,20));
        availablePokemon.add(new FirePokemon("Quilava", 'B', 5,25,18,20));
        availablePokemon.add(new WaterPokemon("Croconaw", 'B',5,25,18,20));

        availablePokemon.add(new GrassPokemon("Grovyle", 'B',5,35,12,15));
        availablePokemon.add(new FirePokemon("Combusken", 'B', 5,35,12,15));
        availablePokemon.add(new WaterPokemon("Marshtomp", 'B', 5,35,12,15));
        
        //grade A
        availablePokemon.add(new GrassPokemon("Venusaur", 'A',10,40,20, 20));
        availablePokemon.add(new FirePokemon("Charizard", 'A',10,40,20, 20));
        availablePokemon.add(new WaterPokemon("Blastoise", 'A',10,40,20, 20));

        availablePokemon.add(new GrassPokemon("Meganium", 'A',10,35,23, 22));
        availablePokemon.add(new FirePokemon("Typhlosion", 'A',10,35,23, 22));
        availablePokemon.add(new WaterPokemon("Feraligatr", 'A',10,35,23, 22));

        availablePokemon.add(new GrassPokemon("Sceptile", 'A',10,45,17, 20));
        availablePokemon.add(new FirePokemon("Blaziken", 'A', 10,45,17, 20));
        availablePokemon.add(new WaterPokemon("Swampert", 'A',10,45,17, 20));
    }
    
    public List<Pokemon> generateGradePokemon(char grade, int number){
    	List<Pokemon> sameGradePokemon = new ArrayList<>();
    	for (Pokemon p: availablePokemon) {
    		if (p.getGrade() == grade) {
    			sameGradePokemon.add(p);
    		}
    	}
    	
    	Collections.shuffle(sameGradePokemon);
    	
    	List<Pokemon> generatedPokemon = new ArrayList<>();
    	for (int i = 0; i < number && i < sameGradePokemon.size(); i++) {
    		generatedPokemon.add(sameGradePokemon.get(i));
    	}
    	return generatedPokemon;
    	}
    }