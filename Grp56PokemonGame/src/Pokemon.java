public class Pokemon {
    private String name;
    private char grade;
    private String attackType;
    private String defenseType;
    private int level;
    private boolean isCaught;
    private int maxHp;
    private int currentHp;
    private int attack;
    private int defense;
    private boolean isFainted;

    //constructor
    public Pokemon(String name, char grade, String attackType, String defenseType, int level, int maxHp, int attack, int defense){
        this.name = name;
        this.grade = grade;
        this.attackType = attackType;
        this.defenseType = defenseType;
        this.level = level;
        this.isCaught = false;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.isFainted = false;
	}
    
	//getters
    public String getName() {
        return name;
    }
    public char getGrade() {
        return grade;
    }
    public String getAttackType() {
        return attackType;
    }
    public String getDefenseType() {
        return defenseType;
    }
    public int getLevel() {
        return level;
    }
    public boolean isCaught() {
        return isCaught;
    }
    public int getMaxHp() {
        return maxHp;
    }
    public int getCurrentHp() {
        return currentHp;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefense() {
        return defense;
    }
    public boolean isFainted() {
        return isFainted;
    }
    
    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setGrade(char grade){
        this.grade = grade;
    }
    
    public void setCaught(boolean isCaught){
        this.isCaught = isCaught;
    }
    
    public void setMaxHp(int hp){
        this.maxHp = hp;
        this.currentHp = hp;
    }
    
    public void setCurrentHp(int newHp) {
    	this.currentHp = newHp;
	}
    
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    
	public void setFainted(boolean isFainted) {
		this.isFainted = isFainted;
	}
    
    //other methods
	public void takeDamage(int damage) {
	    this.currentHp -= damage;
	    if (this.currentHp <= 0) {
	        this.currentHp = 0;
	        this.isFainted = true;
	    }
	}
	
    public int attack(Pokemon opponent) {
    	int damage = this.attack - (opponent.getDefense()/2);
        if (damage <= 0) {
            damage = 1;
        }
        opponent.takeDamage(damage);
        return damage;
    }
    
    public void levelUp(){
        this.level++;
        this.maxHp += 5;
        this.attack += 2;
        this.defense += 2;
        this.currentHp = this.maxHp;
        this.isFainted = false;
        System.out.println(this.name + " leveled up! " + this.name + " is healed to max HP and is level " + this.level + "!");
    }
    
    @Override
    public String toString() {
        return String.format("[%s | Grade: %c | Level: %d | Attack type: %s | Defense type: %s | HP: %d/%d | Attack: %d | Defense: %d]",
                this.name, this.grade, this.level, this.attackType, this.defenseType,this.currentHp, this.maxHp, this.attack, this.defense);
    }
}