import java.util.ArrayList;
import java.util.List;

public class Evolution {
	private List<EvolutionInfo> info = new ArrayList<>();
	
	//Grade B followed by Grade A
	public Evolution() { 
		info.add(new EvolutionInfo("Bulbasaur","Ivysaur",'B',5,10,5,5));
        info.add(new EvolutionInfo("Ivysaur","Venusaur",'A',10,10,5,5));
        
        info.add(new EvolutionInfo("Charmander","Charmeleon",'B',5,10,5,5));
        info.add(new EvolutionInfo("Charmeleon","Charizard",'A',10,10,5,5));
        
        info.add(new EvolutionInfo("Squirtle","Wartortle",'B',5,10,5,5));
        info.add(new EvolutionInfo("Wartortle","Blastoise",'A',10,10,5,5));

        info.add(new EvolutionInfo("Chikorita","Bayleef",'B',5,10,5,8));
        info.add(new EvolutionInfo("Bayleef","Meganium",'A',10,10,5,2));
        
        info.add(new EvolutionInfo("Cyndaquil","Quilava",'B',5,10,5,8));
        info.add(new EvolutionInfo("Quilava","Typhlosion",'A',10,10,5,2));
        
        info.add(new EvolutionInfo("Totodile","Croconaw",'B',5,10,5,8));
        info.add(new EvolutionInfo("Croconaw","Feraligatr",'A',10,10,5,2));

        info.add(new EvolutionInfo("Treecko","Grovyle",'B',5,10,5,5));
        info.add(new EvolutionInfo("Grovyle","Sceptile",'A',10,10,5,5));
        
        info.add(new EvolutionInfo("Torchic","Combusken",'B',5,10,5,5));
        info.add(new EvolutionInfo("Combusken","Blaziken",'A',10,10,5,5));
        
        info.add(new EvolutionInfo("Mudkip","Marshtomp",'B',5,10,5,5));
        info.add(new EvolutionInfo("Marshtomp","Swampert",'A',10,10,5,5));
	}

	//undergo evolution if player's battlePokemon reach level 5 or 10; no output when no evolution happen
	public void checkThenEvolve(Pokemon p) {
        for (EvolutionInfo e : info) {
            if (p.getName().equals(e.getCurrentName()) && p.getLevel() == (e.getEvolLevel())) {
            	
               	System.out.println();
        		System.out.println("\"Woah what's happening!\"");
            	System.out.println( p.getName() + " is evolving into " + e.getEvolName() + "!?");
                p.setName(e.getEvolName());
                p.setGrade(e.getEvolGrade());
                p.setMaxHp(p.getMaxHp() + e.getEvolBonusHP());
                p.setAttack(p.getAttack() + e.getEvolBonusAttk());
                p.setDefense(p.getDefense() + e.getEvolBonusDefense());

                System.out.println(p);
                System.out.println("Evolution success!");
                break;    
            }
        }
	}
}		            	