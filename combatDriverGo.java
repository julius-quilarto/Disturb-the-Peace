import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Driver that runs the combat system of the project.
 */

/**
 * @author jonahchun, Julius Quilarto
 *
 */
public class combatDriverGo {

	/**
	 * @param args
	 */
	public static int main(Scanner theScanner, SaveFile theSaveFile) {
		System.out.println("Enter Combat.");
		//Scanner playerInput = theScanner;
		/*SaveFile theFile = new SaveFile("saveFile1.txt");
		try {
			SaveFileManipulator.readFileIn(theFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		combatMechanics x = new combatMechanics(theSaveFile, theScanner);
		//generate characters
		//generate enemies
		//x.StillFighting();
		//x.charactersLeft();
		//x.turnOrder();
		int result;
		
		//sc.next();
		while (x.inCombat == true) {
			x.charactersLeft();
			x.turnOrder();			
			
		}
		result = x.resultsHere();

		return result;
		
		// TODO Auto-generated method stub

	}

}
