import java.util.*;

/**
 * Class that holds info for a cave.
 * @author Jonah Chun and Julius Quilarto
 *
 */

public class Cave {
	
	private String name;
	private ArrayList<Integer> connectedCaves;
	private int caveID;
	private boolean visited;
	
	/**
	 * Constructor that constructs cave that will be a room in the labyrinth
	 * @param num identification number and index in arraylist of caves
	 * @param theName name of the cave
	 * @param listOfCaves gives list of adjacent caves 
	 */
	
	public Cave(int num, String theName, ArrayList<Integer> listOfCaves) {
		this.caveID = num;
		this.name = theName;
		this.connectedCaves = listOfCaves;
		this.visited = false;
	}
	
	/**
	 * Returns number that identifies the cave
	 * @return number identifying the cave
	 */
	
	public int getCaveNum() {
		return this.caveID;
	}
	
	/**
	 * Returns name of cave if visited or "Unknown" if the cave has not been visited
	 * @return name of cave if visted or "Unknown" if cave not visited
	 */
	
	public String getName() {
		if (this.getVisited() == false) {
			return "Unknown";
		}
		
		else {
			return this.name;
		}
		
	}
	
	/**
	 * Returns list of integers that are connected to this cave
	 * @return list of integers connected to the cave
	 */
	
	public ArrayList<Integer> getConnectingCaves() {
		return this.connectedCaves;
	}
	
	/**
	 * Checks to see if room was visited or not
	 * @return status that room was visited or not
	 */
	
	public boolean getVisited() {
		return this.visited;
	}
	
	/**
	 * Changes status of room into a visited room
	 */
	
	public void markVisited() {
		this.visited = true;
	}
	

}
