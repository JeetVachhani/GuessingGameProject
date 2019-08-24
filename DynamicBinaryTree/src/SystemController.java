

import java.io.FileNotFoundException;

public class SystemController {

	public static void main(String[] args)
	{
		try 
		{
			AnimalGame player1 = new AnimalGame(); // creates a new player 

			player1.play(); // class the play function to start the game
	
			
		} catch (FileNotFoundException e) // if correct file cannot be found it will throw and exception
		{
		
			e.printStackTrace();
		}
	

	}

}
