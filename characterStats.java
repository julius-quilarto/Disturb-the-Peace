import java.util.ArrayList;
import java.util.List;
/**
 * This class creates and holds the playable character profiles
 * (e.g. type, name, stats, combat spells, and other characteristics
 * and mechanics). 
 * @author jonahchun, Julius Quilarto
 *
 */
public class characterStats{ 
	protected String fighterName;
	protected ArrayList<Integer>fighterStats;
	protected ArrayList<String>fighterSkills;
	protected String healerName;
	protected ArrayList<Integer>healerStats;
	protected ArrayList<String>healerSkills;
	protected String wizardName;
	protected ArrayList<Integer>wizardStats;
	protected ArrayList<String>wizardSkills;
	protected String rogueName;
	protected ArrayList<Integer>rogueStats;
	protected ArrayList<String>rogueSkills;
	private ArrayList<String> inventory;
	protected String name;
	protected int attack;
	protected int magicAtk;
	protected int defense;
	protected int magicDef;
	protected int speed;
	protected int health;
	protected int accuracy;
	protected String combatSkills;
	protected int specialPoints;

	//generates an enemy unit
	protected ArrayList<Integer>enemyStats;
	protected ArrayList<String>enemySkills;
	protected String badName;

	/**
	 * Defines the parameters of the stats of characters and what letters
	 * each stat is denoted to in code reference.
	 * Also constructs a class with the characters and their stats.
	 * @param n
	 * @param a
	 * @param ma
	 * @param d
	 * @param md
	 * @param spd
	 * @param h
	 * @param ac
	 * @param sp
	 * @param spells
	 */
	public characterStats() {
		//name = n;
		//attack = a;
		//magicAtk = ma;
		//defense = d;
		//magicDef = md;
		//speed = spd;
		//health = h;
		//accuracy = ac;
		//specialPoints = sp;
		//combatSkills = spells;
		this.fighterName = null;
		this.fighterStats = new ArrayList<Integer>();
		this.fighterSkills = new ArrayList<String>();
		this.healerName = null;
		this.healerStats = new ArrayList<Integer>();
		this.healerSkills = new ArrayList<String>();
		this.wizardName = null;
		this.wizardStats = new ArrayList<Integer>();
		this.wizardSkills = new ArrayList<String>();
		this.rogueName = null;
		this.rogueStats = new ArrayList<Integer>();
		this.rogueSkills = new ArrayList<String>();
		this.inventory = new ArrayList<String>();
		//
		this.badName = null;
		this.enemySkills = new ArrayList<String>();
		this.enemyStats = new ArrayList<Integer>();

	}

	/**
	 * These eight methods gets/accesses the individual stats of 
	 * each character
	 * @return individual stat of each character
	 */

	public int getAtk() {
		return this.attack;
	}

	public int getMagicAtk() {
		return this.magicAtk;
	}

	public int getDefense() {
		return this.defense;
	}

	public int getMagicDef() {
		return this.magicDef;
	}

	public int getSpeed() {
		return this.speed;
	}

	public int getHP() {
		return this.health;
	}

	public int getSP() {
		return this.specialPoints;
	}

	public int getAccuracy() {
		return this.accuracy;
	}

	public ArrayList<String> getInventory() {
		return this.inventory;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * These eight methods will set the individual stats of each
	 * character.
	 */

	public void setAtk(int getAtk) {
		this.attack = getAtk;
	}

	public void setDef(int getDef) {
		this.defense = getDef;
	}

	public void setMagAtk(int getMagicAtk) {
		this.magicAtk = getMagicAtk;
	}

	public void setMagDef(int getMagicDef) {
		this.magicDef = getMagicDef;
	}

	public void setSpeed(int getSpd) {
		this.speed = getSpd;
	}

	public void setHP(int getHP) {
		this.health = getHP;
	}

	public void setSP(int getSP) {
		this.specialPoints = getSP;
	}

	public void setAccuracy(int getAcc) {
		this.accuracy = getAcc;
	}

	public void setInventory(ArrayList<String> getItems) {
		this.inventory = getItems;
	}

	public void setName(String nameTwo) {
		this.name = nameTwo;
	}


	/**
	 * adds the randomized stats to all characters' ArrayList of stats.
	 */
	public void addFighterStats() {
		//fighter
		fighterStats.add(100); //HP
		fighterStats.add(100); //SP
		fighterStats.add(50+(int)Math.floor(10+Math.random()*20)); //atk
		fighterStats.add(20+(int)Math.floor(10+Math.random()*20)); //magAtk
		fighterStats.add(50+(int)Math.floor(10+Math.random()*20)); //def
		fighterStats.add(20+(int)Math.floor(10+Math.random()*20)); //magDef
		fighterStats.add(50+(int)Math.floor(10+Math.random()*20)); //speed
		fighterStats.add(80+(int)Math.floor(10+Math.random()*20)); //acc
		
		System.out.println(fighterStats);
	}

	public void addHealerStats() {
		//healer
		healerStats.add(100); //HP
		healerStats.add(100); //SP
		healerStats.add(20+(int)Math.floor(10+Math.random()*20)); //atk
		healerStats.add(50+(int)Math.floor(10+Math.random()*20)); //magAtk
		healerStats.add(30+(int)Math.floor(10+Math.random()*20)); //def
		healerStats.add(50+(int)Math.floor(10+Math.random()*20)); //magDef
		healerStats.add(80+(int)Math.floor(10+Math.random()*20)); //speed
		healerStats.add(100+(int)Math.floor(10+Math.random()*20)); //acc
	}
	public void addWizardStats() {
		//wizard
		wizardStats.add(100); //HP
		wizardStats.add(100); //SP
		wizardStats.add(20+(int)Math.floor(10+Math.random()*20)); //atk
		wizardStats.add(80+(int)Math.floor(10+Math.random()*20)); //magAtk
		wizardStats.add(30+(int)Math.floor(10+Math.random()*20)); //def
		wizardStats.add(70+(int)Math.floor(10+Math.random()*20)); //magDef
		wizardStats.add(70+(int)Math.floor(10+Math.random()*20)); //speed
		wizardStats.add(75+(int)Math.floor(10+Math.random()*20)); //acc
	}
	public void addRogueStats() {
		//rogue
		rogueStats.add(100); //HP
		rogueStats.add(100); //SP
		rogueStats.add(40+(int)Math.floor(10+Math.random()*20)); //atk
		rogueStats.add(10+(int)Math.floor(10+Math.random()*20)); //magAtk
		rogueStats.add(40+(int)Math.floor(10+Math.random()*20)); //def
		rogueStats.add(60+(int)Math.floor(10+Math.random()*20)); //magDef
		rogueStats.add(100+(int)Math.floor(10+Math.random()*20)); //speed
		rogueStats.add(100+(int)Math.floor(10+Math.random()*20)); //accuracy
	}

	public void addEnemyStats() {
		//enemy
		enemyStats.add(100); //HP
		enemyStats.add(100); //SP
		enemyStats.add(50+(int)Math.floor(10+Math.random()*20)); //atk
		enemyStats.add(50+(int)Math.floor(10+Math.random()*20)); //magAtk
		enemyStats.add(30+(int)Math.floor(10+Math.random()*20)); //def
		enemyStats.add(30+(int)Math.floor(10+Math.random()*20)); //magDef
		enemyStats.add(75+(int)Math.floor(10+Math.random()*20)); //speed
		enemyStats.add(100+(int)Math.floor(10+Math.random()*20)); //accuracy
	}

	public void addStartItems() {
		inventory.add("healPotion");
		inventory.add("healPotion");
		inventory.add("healPotion");
		inventory.add("atkPotion");
		inventory.add("atkPotion");
		inventory.add("atkPotion");
	}

	/**
	 * Getter methods for the stats of the characters.
	 * @return
	 */

	public ArrayList<Integer> getFightStats(){
		return fighterStats;

	}

	public ArrayList<Integer> getHealStats(){
		return healerStats;
	}

	public ArrayList<Integer> getWizardStats(){
		return wizardStats;
	}

	public ArrayList<Integer> getRogueStats(){
		return rogueStats;
	}
	
	public ArrayList<Integer> getEnemyStats(){
		return enemyStats;
	}

	/**
	 * These methods relate to the creation and generating of 
	 * the character's skills that use SP.
	 */

	public void createFightSkills() {
		fighterSkills.add("cleave"); //deals 1.5x damage
		fighterSkills.add("weaken"); //inflicts weaken
		fighterSkills.add("defend"); //defense + 2
		fighterSkills.add("smite"); //deals 50 damage to foe
	}

	public void createHealerSkills() {
		healerSkills.add("heal"); //heals 20 HP
		healerSkills.add("buffAtk"); //attack + 2 to character
		healerSkills.add("buffMagAtk"); //magAtk + 2 to character
		healerSkills.add("poison"); //poisons foes
	}

	public void createRogueSkills() {
		rogueSkills.add("weaken"); //inflicts weaken
		rogueSkills.add("blind"); //inflicts blind
		rogueSkills.add("poison"); //inflicts poisoned
		rogueSkills.add("tear"); //halves the foe's current HP
	}

	public void createWizardSkills() {
		wizardSkills.add("fireball"); //deals 50 damage to enemy
		wizardSkills.add("lightningBolt"); //deals 2x damage
		wizardSkills.add("weaken"); //inflicts weaken
		wizardSkills.add("poison"); //inflicts poison

	}
	
	public void createEnemySkills() {
		enemySkills.add("weaken");
	}


	/**
	 * generates the fighter character, including its name, stats, and skills.
	 * @param nameOne
	 * @param fightingStats
	 * @param fightingSkills
	 */
	public void generateFighter(String nameOne, ArrayList<Integer>fightingStats, ArrayList<String>fightingSkills) {
		this.fighterName = nameOne;
		this.fighterStats = fightingStats;
		addFighterStats();
		this.fighterSkills = fightingSkills;
		System.out.println(fighterName);
		System.out.println(fighterStats);
		System.out.println(fighterSkills);
	}

	public ArrayList<String> getFightSkills() {
		return fighterSkills;
	}

	public ArrayList<String> getHealSkills(){
		return healerSkills;
	}

	public ArrayList<String> getRogueSkills(){
		return rogueSkills;
	}

	public ArrayList<String> getWizardSkills(){
		return wizardSkills;
	}
	
	public ArrayList<String> getEnemySkills(){
		return enemySkills;
	}

	/**
	 * generates the healer character, along with its name, stats, and skills. 
	 * @param nameOne
	 * @param healingStats
	 * @param healingSkills
	 */
	public void generateHealer(String nameOne, ArrayList<Integer>healingStats, ArrayList<String>healingSkills) {
		this.healerName = nameOne;
		this.healerStats = healingStats;
		addHealerStats();
		this.healerSkills = healingSkills;
		System.out.println(healerName);
		System.out.println(healerStats);
		System.out.println(healerSkills);
	}

	/**
	 * Generates the wizard character, along with its name, stats, and skills. 
	 * @param nameOne
	 * @param magicStats
	 * @param magicSkills
	 */
	public void generateWizard(String nameOne, ArrayList<Integer>magicStats, ArrayList<String>magicSkills) {
		this.wizardName = nameOne;
		this.wizardStats = magicStats;
		addWizardStats();
		this.wizardSkills = magicSkills;
		System.out.println(wizardName);
		System.out.println(wizardStats);
		System.out.println(wizardSkills);
	}

	/**
	 * Generates the rogue character, along with its name, stats, and skills. 
	 * @param nameOne
	 * @param sneakStats
	 * @param sneakSkills
	 */
	public void generateRogue(String nameOne, ArrayList<Integer>sneakStats, ArrayList<String>sneakSkills) {
		this.rogueName = nameOne;
		this.rogueStats = sneakStats;
		addRogueStats();
		this.rogueSkills = sneakSkills;
		System.out.println(rogueName);
		System.out.println(rogueStats);
		System.out.println(rogueSkills);
	}

	/**
	 * Generates the team's inventory. 
	 */
	public void generateInventory(ArrayList<String>items) {
		this.inventory = items;
		addStartItems();
		System.out.println(inventory);
	}
	
	public void generateEnemy(String name, ArrayList<Integer>stats, ArrayList<String>skills) {
		this.badName = name;
		this.enemyStats = stats;
		addEnemyStats();
		this.enemySkills = skills;
		createEnemySkills();
		System.out.println(name);
		System.out.println(stats);
		System.out.println(skills);
	}


}
