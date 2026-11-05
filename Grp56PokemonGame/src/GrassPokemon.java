public class GrassPokemon extends Pokemon {
    public GrassPokemon(String name, char grade, int level, int maxHp, int attack, int defense) {
        super(name, grade, "Grass", "Grass", level, maxHp, attack, defense);
    }
    
    @Override
    public int attack(Pokemon opponent) { //add type effectiveness
        int damage = this.getAttack() - (opponent.getDefense()/2);
        double multiplier = 1;
        if (opponent.getDefenseType().equals("Water")) {
            multiplier = 2;
            System.out.println("It's super effective!");
        } 
        
        else if (opponent.getDefenseType().equals("Fire")) {
            multiplier = 0.5;
            System.out.println("It's not very effective...");
        }
        
        int finalDamage = (int)(damage * multiplier) - (opponent.getDefense()/2);
        if (finalDamage <= 0) { //prevent negative attack and set 1 as minimum
        	finalDamage = 1;
        }
        opponent.takeDamage(finalDamage);
        return finalDamage;
    }
}