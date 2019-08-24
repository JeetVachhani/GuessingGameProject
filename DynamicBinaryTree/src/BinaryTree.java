
public class BinaryTree implements BinaryTreeInterface
{

	BinaryNode root;
	
	public BinaryTree() // calls other constructor
	{
		this(null);
	}
	
	public BinaryTree(String data) // makes a new binary tree with given data
	{
		root = new BinaryNode(data);
	}
	
	public String getDataInRoot() // returns data in the root
	{
		return root.getData();
	}


	public void makeTree() // calls other makeTree() method
	{
		makeTree(null, null, null);
		
	}
	
	


	public void makeTree(String rootData, BinaryTreeInterface leftChild, BinaryTreeInterface rightChild) 
	{
		
		// we must use casts on the the given children because we are not certain if its a BinaryNode class
		root = new BinaryNode(rootData,(BinaryNode) rightChild, (BinaryNode) leftChild);
		
	}

}
