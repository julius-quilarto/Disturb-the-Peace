import java.util.ArrayList;
import java.io.File;
import java.lang.Integer;

/**
 * Class that holds important information for the game.
 * @author Julius Quilarto and Jonah Chun
 *
 */

public class SaveFile {
	private File theFile;
	private String fighterName;
	private ArrayList<Integer> fighterStats;
	private ArrayList<String> fighterSkills;
	private String healerName;
	private ArrayList<Integer> healerStats;
	private ArrayList<String> healerSkills;
	private String wizardName;
	private ArrayList<Integer> wizardStats;
	private ArrayList<String> wizardSkills;
	private String rogueName;
	private ArrayList<Integer> rogueStats;
	private ArrayList<String> rogueSkills;
	private String labyrinthName;
	private int labyrinthRoomNum;
	private String labyrinthTxtFile;
	private ArrayList<String> inventory;
	
	/**
	 * Constructs a class that will hold important information;
	 * @param fileName String with name of the text file that data will be read from
	 * written to.
	 */
	public SaveFile(String fileName) {
		this.theFile = new File(fileName);
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
		this.labyrinthName = null;
		this.labyrinthRoomNum = 0;
	}
	
	/**
	 * Method that gives text file being used.
	 * @return name of text file
	 */
	public File getFile() {
		return this.theFile;
	}
	
	/**
	 * Method that gives the name of the fighter character
	 * @return fighter character's name
	 */
	
	public String getFighterName() {
		return this.fighterName;
	}
	
	/**
	 * Method that sets the name of the fighter character
	 * @param theName name given to the fighter
	 */
	
	public void setFighterName(String theName) {
		this.fighterName = theName;
	}
	
	/**
	 * Method that gives a list of numbers that represent the stats of the fighter
	 * @return list of numbers representing fighter's capabilities
	 */
	
	public ArrayList<Integer> getFighterStats() {
		return this.fighterStats;
	}
	
	/**
	 * Method that sets a list of numbers that represent the stats of the fighter
	 * @param stats list of numbers representing fighter's capabilities
	 */
	
	public void setFighterStats(ArrayList<Integer> stats) {
		this.fighterStats = stats;
	}
	
	/**
	 * Method that gives a list of skills that the fighter can use
	 * @return list of skills fighter can use
	 */
	
	public ArrayList<String> getFighterSkills(){
		return this.fighterSkills;
	}
	
	/**
	 * Method that gives the name of the healer character
	 * @return healer character's name
	 */
	
	public String getHealerName() {
		return this.healerName;
	}
	
	/**
	 * Method that sets the name of the healer character
	 * @param theName name that will be given to the healer character
	 */
	
	public void setHealerName(String theName) {
		this.healerName = theName;
	}
	
	/**
	 * Method that gives a list of numbers that represent the stats of the healer
	 * @return list of numbers representing healer's capabilities
	 */
	
	
	public ArrayList<Integer> getHealerStats() {
		return this.healerStats;
	}
	
	/**
	 * Method that sets a list of numbers as the stats of the healer
	 * @param stats list of numbers representing capabilities of healer
	 */
	public void setHealerStats(ArrayList<Integer> stats) {
		this.healerStats = stats;
	}
	
	/**
	 * Method that gives a list of skills that the healer can use
	 * @return list of skills healer can use
	 */
	
	public ArrayList<String> getHealerSkills(){
		return this.healerSkills;
	}
	
	/**
	 * Method that gives the name of the wizard character
	 * @return wizard character's name
	 */
	
	public String getWizardName() {
		return this.wizardName;
	}
	
	/**
	 * Method that sets the name of the wizard character
	 * @param theName name that will be given to the wizard character
	 */
	
	public void setWizardName(String theName) {
		this.wizardName = theName;
	}
	
	/**
	 * Method that gives a list of numbers that represent the stats of the wizard
	 * @return list of numbers representing wizard's capabilities
	 */
	
	public ArrayList<Integer> getWizardStats() {
		return this.wizardStats;
	}
	
	/**
	 * Method that sets a list of numbers as the stats of the wizard
	 * @param stats list of numbers representing capabilities of wizard
	 */
	
	public void setWizardStats(ArrayList<Integer> stats) {
		this.wizardStats = stats;
	}
	
	/**
	 * Method that gives a list of skills that the wizard can use
	 * @return list of skills healer can use
	 */
	
	public ArrayList<String> getWizardSkills(){
		return this.wizardSkills;
	}
	
	/**
	 * Method that gives the name of the rogue character
	 * @return rogue character's name
	 */
	
	public String getRogueName() {
		return this.rogueName;
	}
	
	/**
	 * Method that sets the name of the rogue character
	 * @param theName name that will be given to the rogue character
	 */
	
	public void setRogueName(String theName) {
		this.rogueName = theName;
	}
	
	/**
	 * Method that gives a list of numbers that represent the stats of the rogue
	 * @return list of numbers representing wizard's capabilities
	 */
	
	public ArrayList<Integer> getRogueStats() {
		return this.rogueStats;
	}
	
	/**
	 * Method that sets a list of numbers as the stats for the rogue
	 * @param stats list of numbers representing capabilities of the rogue
	 */
	
	public void setRogueStats(ArrayList<Integer> stats) {
		this.rogueStats = stats;
	}
	
	/**
	 * Method that gives a list of skills that the rogue can use
	 * @return list of skills healer can use
	 */
	
	public ArrayList<String> getRogueSkills(){
		return this.rogueSkills;
	}
	
	/**
	 * Method that gives a list of the equipment that the characters can use
	 * @return list of equipment
	 */
	
	public ArrayList<String> getInventory(){
		return this.inventory;
	}
	
	/**
	 * Method that sets the list of equipment that the characters can use
	 * @param theItems list of equipment to be set
	 */
	
	public void setInventory(ArrayList<String> theItems) {
		this.inventory = theItems;
	}
	
	/**
	 * Method that gives name of the labyrinth the characters are in
	 * @return name of labyrinth
	 */ 
	
	public String getLabyrinthName() {
		return this.labyrinthName;
	}
	
	/**
	 * Method that sets the name of the labyrinth
	 * @param labName name of the labyrinth
	 */
	
	public void setLabyrinthName(String labName) {
		this.labyrinthName = labName;
	}
	
	/**
	 * Method that gives the room number of the labyrinth characters are in
	 * @return room number of labyrinth
	 */
	
	public int getLabyrinthRoomNum() {
		return this.labyrinthRoomNum;
	}
	
	/**
	 * Method that sets room number of the labyrinth characters are in
	 * @param theNum the room number
	 */
	
	public void setLabyrinthRoomNum(int theNum) {
		this.labyrinthRoomNum = theNum;
	}
	
	/**
	 * Method that gives the name of text file for labyrinth
	 * @return text file name of labyrinth
	 */
	
	public String getLabyrinthTxtFile() {
		return this.labyrinthTxtFile;
	}
	
	/**
	 * Method that sets name of text file for labyrinth
	 * @param labyrinthTxtFileName text file name of labyrinth
	 */
	
	public void setLabyrinthTxtFile(String labyrinthTxtFileName) {
		this.labyrinthTxtFile = labyrinthTxtFileName;
	}
	
}
