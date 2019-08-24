

import java.io.File; 
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class DynamicGameTree implements GameTreeInterface
{
	
	BinaryNode root; // hold reference to the root of the dynamic binary tree
	BinaryNode currentNode; // holds current node reference in the tree

	
	public DynamicGameTree() // calls other constructor
	{
		this(null);

	}
	
	public DynamicGameTree(String data) // calls other constructor
	{
		this(data,null,null);
		
	}
	
	public void setLeftTree(String data) // makes a new left child
	{
		if (currentNode.getLeftSubtree() == null)
		{
			currentNode.setLeft(new BinaryNode(data)); // will only make it if noting else is there 
		}
	}
	
	public void setRightTree(String data) // makes a new right child
	{
		if (currentNode.getRightSubtree() == null) // will only make it if noting else is there 
		{
			currentNode.setRight(new BinaryNode(data));
		}
	}
	
	public DynamicGameTree(String data,BinaryTreeInterface leftChild, BinaryTreeInterface rightChild) // makes a new tree with root data and references to children
	{
		
		root = new BinaryNode(data,(BinaryNode) rightChild, (BinaryNode) leftChild);
		currentNode= root;
		
		
		
	}
	
	public int height(BinaryNode currentNode) // recursively calculates the height of the tree
	{
		
		if (currentNode ==  null)
		{
			return 0;
		}
		else
		{
			int leftHeight = height((BinaryNode)currentNode.getLeftSubtree()); 
            int rightHeight = height((BinaryNode)currentNode.getRightSubtree()); 
            
            if (leftHeight > rightHeight) 
                return (leftHeight + 1); 
             else 
                return (rightHeight + 1); 
            
		}
		
	}

	public void makeTree(String rootData, BinaryTreeInterface leftChild, BinaryTreeInterface rightChild) 
	{  // makes a new tree with root data and references to children
		
		
		root = new BinaryNode(rootData,(BinaryNode) rightChild, (BinaryNode) leftChild);
			
	}


	public String getDataInRoot() // returns data in the root (data field)
	{
		
		return root.getData();
	}
	
	public BinaryNode getNode() // returns currentNode data field
	{
		return currentNode;
		
	}

	public void setNodeData(String data) // sets data in current node data field
	{
	
		currentNode.setData(data);
	}

	
	public String getNodeData() // returns data from current node data field
	{	
		return currentNode.getData();
	}


	public void setAnswer(String yes, String no) // sets the answers to the currentNode, left represents answer : yes and right represents answer : no
	{
		
		BinaryNode left = new BinaryNode(yes); // makes a left child
		currentNode.setLeft(left); // inputs (yes) info into left child
		
		BinaryNode right = new BinaryNode(no); // makes a right child
		currentNode.setRight(right); // inputs (no) into into right child
				
	}


	public void goYesWay() // moves currentNode reference to the left, which represents the answer:yes
	{
		currentNode = (BinaryNode) currentNode.getLeftSubtree();
				
	}


	public void goNoWay() // moves currentNode reference to the right, which represents the answer: no
	{
		currentNode = (BinaryNode) currentNode.getRightSubtree();
			
	}


	public void restartGame() // resets the currentNode reference to the root so the game can be played again
	{
		currentNode = root;
		
	}

	public boolean isAnswer() // the leaf represents an final answer in the game, this method returns a boolean based on if we are at an answer node (which is a leaf)
	{
		return currentNode.isLeaf();
	}


	public void makeTree()  // makes a new tree without children and without data 
	{
		root = new BinaryNode();
		
	}

}
