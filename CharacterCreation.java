
public interface CharacterCreation {
	
	//character related 
	
	public String getName();
	
	public void setName(String Name);
	
	public int getStats();
	
	public int setStats(int atk, int magAtk, int def, int magDef, int spd, int SP, int acc);
	
	public int getSpecialMoves();
	
	public String toString();
	
	//item related
	
	public String getItemName();
	
	public void setItemName(String itemName);
	
	public String getDescription();
	
	public String setDescription(String description);
	
	//enemy related
	
	public String getBadName();
	
	public void setBadName(String Name);
	
	public int getBadStats();
	
	public void setBadStats(int atk, int magAtk, int def, int magDef, int spd, int SP, int acc);
	
	public int getBadMoves();
	
	//combat related
	

}
