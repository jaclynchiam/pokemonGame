public class FirePokemon extends Pokemon {
    public FirePokemon(String name, char grade, int level, int maxHp, int attack, int defense) {
        super(name, grade, "Fire", "Fire", level, maxHp, attack, defense);
    }
    
    @Override
    public int attack(Pokemon opponent) { //add type effectiveness
        int damage = this.getAttack();
        double multiplier = 1;
        if (opponent.getDefenseType().equals("Grass")) {
            multiplier = 2;
            System.out.println("It's super effective!");     
        } 
        
        else if (opponent.getDefenseType().equals("Water")) {
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