import java.io.FileNotFoundException;
import java.util.Vector;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class AnimalGame 
{
	private static boolean fileMade; // indicated weather a file has already been made, therefore the file wont we rewritten.
	private static boolean treeMade; // indicates if a tree has already been made, therefore the tree wont be re made
	private String savedDataFileName = "animalGuessingGameData.txt"; // text file name
	private static DynamicGameTree gameTree; // binary tree which holds the questions / answers (leaves)
	private static PrintWriter newDataFile; // 
	
	
	public AnimalGame() throws FileNotFoundException 
	{
		if (fileMade != true) // will create file based on the static variable
		{
			createFile();
			fileMade = true;
		}
		
		if (treeMade != true) // will make the tree based on the static variable
		{
			
			
			File gameFile = new File(savedDataFileName); 
			Scanner dataScanner = new Scanner(gameFile);
		
			
			
			gameTree = new DynamicGameTree(); 
			
			Vector<String> dataHolder = new Vector<String>(); // this vector holds the data in level order 
			
			
			while (dataScanner.hasNext()) // fills the vector 
			{
				dataHolder.add(dataScanner.nextLine());

			}
			
		
			gameTree.root = (BinaryNode) makeGameTree(gameTree.root, dataHolder, 0);
			
			treeMade = true;
		}
		

			
		
	}
	
	private void printTree(BinaryNode node) // prints tree in preorder pattern, for debugging
	{

		if (node == null)
		{
			return;
		}
		System.out.println(node.getData());
		printTree((BinaryNode)node.getLeftSubtree());
		printTree((BinaryNode)node.getRightSubtree());
		
	}
	
	
	private BinaryTreeNodeInterface makeGameTree(BinaryTreeNodeInterface root, Vector<String> savedData, int start) // this method makes a tree in level order
	{
		
		if (start < savedData.size())
		{

		
			if (!savedData.get(start).equals("||empty||")) // we only make a new node if the next line has a valid string. Node space will be saved since we do not make a node for empty spots
			{
				BinaryNode temp = new BinaryNode(savedData.get(start)); 
				root = temp;
				
				 root.setLeft(makeGameTree(root.getLeftSubtree(), savedData, 2 * start + 1)); // sets left child
		         root.setRight(makeGameTree(root.getRightSubtree(), savedData, 2 * start + 2)); // sets right child
				
			}
			
        
		}
	
		return root;
	
	}
	
	public void createFile() // this method writes the default questions and answers into the file if it is empty (in other words start a game without memory)
	{
		if (fileMade != true)
		{
			try
			{
				File gameFile = new File(savedDataFileName);
				Scanner dataScanner = new Scanner(gameFile);
				
				if (!dataScanner.hasNext()) // we only write into it if the file is empty
				{
		
					newDataFile = new PrintWriter(savedDataFileName);
				
					newDataFile.println("Is This Animal a Mammal?");
					newDataFile.println("The animal is a Bear");
					newDataFile.println("The animal is a Snake");
					
					newDataFile.flush();
					newDataFile.close();
				}
							
			} catch(FileNotFoundException newException) // if correct file cannot be found it will throw and exception
			{
				newException.printStackTrace();
				
			}
		
		}
		

	}
	
	
	public void play() 
	{
		gameTree.restartGame(); // resets currentNode to the root where the game begins 
		
		
		System.out.println("Reply to Each question with 'yes' or 'no'\n");
		Scanner responseScanner = new Scanner(System.in);
		
		
		while (!gameTree.isAnswer()) // the currentNode keeps going down the tree until it reaches a leaf
		{
			
			System.out.println(gameTree.getNodeData());
			
			String answer = responseScanner.next(); // Scanner records user's answer to the question
			answer = answer.toLowerCase();
			

			
			while (!answer.equals("yes") && !answer.equals("no")) // the answer to the question must be yes or no
			{
				System.out.println("Please enter a valid reply");
				answer = responseScanner.next();
				
				
			}
			
			if (answer.equals("no")) // moves the currentNode to the right child which represents no to the answer
			{
				gameTree.goNoWay();
				
				
			}
			else // moves the currentNode to the left child which represents yes as the answer
			{
				gameTree.goYesWay();
			}
	
		}
		
		assert gameTree.isAnswer(); // making sure we are at a leaf
		
		
		System.out.println(gameTree.getNodeData());
		System.out.println("Is this Correct?");
		
		
		String answer = responseScanner.next();
		answer = answer.toLowerCase(); 
		
		while (answer == "yes" || answer == "no") // answer must be yes or no
		{
			System.out.println("Please enter a valid reply");
			answer = responseScanner.next();
			
		}
		
		if (answer.equals("no")) // if the answer is wrong we must update the dynamic tree
		{
			growTree();
			System.out.println("The Game has been updated to include you Answer!");
		}
		else
		{
			System.out.println("Thank You for Playing!"); // if the answer is yes, the game ends
		}
		
		
		
		System.out.println("\nDo you want to play the game again?"); // asks if you want to replay game
		answer = responseScanner.next();
		answer = answer.toLowerCase(); 
		
		while (answer == "yes" || answer == "no") // answer must be yes or no
		{
			System.out.println("Please enter a valid reply");
			answer = responseScanner.next();
			
		}
		
		if (answer.equals("yes"))
		{
			play(); // will call play again if the user wants to play agin
		}
		else
		{
			System.out.println("Game Ended");
		}
		
		
	}
	
	public void growTree() 
	{
		String originalAnswer = gameTree.getNodeData(); // holds the orginal answer
		
		Scanner newScanner = new Scanner(System.in);
		System.out.println("Please given us the Answer so we can update the Game");
		String answer = newScanner.nextLine(); // holds the correct answer
		
		System.out.println("Also  please Give a question whose answer is 'yes' for " + answer + " and no for " + gameTree.getNodeData() + " .");	
		String question = newScanner.nextLine(); // holds a question which is yes for correct and no for incorrect answer
				
		gameTree.setNodeData(question); // reshapes the node to include this new questions and makes the childs the new and original answer
		
		gameTree.setAnswer(answer, originalAnswer);
	
		updateFile(); // file must be updates to keep 
	}
	
	public void updateFile() 
	{
		gameTree.restartGame(); // the currentNode is put back to the root of the tree so we can traverse the tree in level order
	
		
	
		try
		{
			newDataFile = new PrintWriter(savedDataFileName);			
			
		} catch(FileNotFoundException newException) // if correct file cannot be found it will throw and exception
		{
			newException.printStackTrace();
			
		}
		
		for (int i =1; i<= gameTree.height(gameTree.root); i++)
		{
			addCurrentFileData(gameTree.root, i);  // adds data to file level by level
			
		}
		
		newDataFile.flush();
		newDataFile.close();
		
		
	}
	
	private void addCurrentFileData(BinaryNode root, int level)

	{
		if (root == null)  // if there is no root present this string will be atached instead
		{
			newDataFile.println("||empty||");
	        return; 
		}
		
		if (level == 1) 
		{
	        newDataFile.println(root.getData());
		}
		else if (level > 1)
	    { 
			addCurrentFileData((BinaryNode)root.getLeftSubtree(), level-1); // algorithm which recursively adds level by level to the file
			addCurrentFileData((BinaryNode)root.getRightSubtree(), level-1); 
	    } 

		
	}
	
	
	public void clearGameKnowledge() // clears the games's knowledge back to the default settings 
	{
		try
		{

			newDataFile = new PrintWriter(savedDataFileName);
		
			newDataFile.println("Is This Animal a Mammal?");
			newDataFile.println("The animal is a Bear");
			newDataFile.println("The animal is a Snake");
			
			newDataFile.flush();
			newDataFile.close();
			
						
		} catch(FileNotFoundException newException) // if correct file cannot be found it will throw and exception
		{
			newException.printStackTrace();
			
		}
		
	
	}

	

}
