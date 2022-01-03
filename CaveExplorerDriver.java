import java.io.FileNotFoundException;
import java.util.Scanner;

public class CaveExplorerDriver {

	public static void main(SaveFile theSaveFile) throws FileNotFoundException {
		// TODO Auto-generated method stub
		SaveFile SaveFilePlaying = theSaveFile;
		boolean gameOver;
		Scanner playerInput = new Scanner(System.in);
		CaveExplorer theExplorer = new CaveExplorer(playerInput,SaveFilePlaying);
		while(theExplorer.isStillPlaying()) {
			gameOver = theExplorer.showLocation();
			if(gameOver == true) {
				System.out.println("Thanks for Playing. You Saved the Day.");
				System.out.println("Game Over!");
				break;
			}
			
			int theChoice = playerInput.nextInt();
			if (theChoice == 0) {
				System.out.println("Thanks for Playing. Your Progress Has Been Saved. Until Next Time!");
				System.out.println("Game Over!");
				theExplorer.saveProgress();
				break;
			}
			
			else {
				theExplorer.moveLocation(theChoice);
			}
		}
		

	}

}
