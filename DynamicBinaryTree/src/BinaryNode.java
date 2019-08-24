public class BinaryNode implements BinaryTreeNodeInterface
{
	
	private String data; // holds string data
	private BinaryNode left; // holds reference to left child
	private BinaryNode right; // holds reference to right child
	


	public String getData() // returns String data
	{	
		return data;
	}
	
	public BinaryNode() // calls another constructor
	{
		this(null);
		
	}
	
	public BinaryNode(String givenData) // calls another constructor
	{
		this(givenData, null, null);
		
	}
	
	public BinaryNode(String givenData, BinaryNode givenRight, BinaryNode givenLeft) // sets up the variables
	{
		data = givenData;
		left = givenLeft;
		right = givenRight;
		
	}


	public void setData(String givenData) // rewrites the data section 
	{

		data = givenData;

	}


	public void setRight(BinaryTreeNodeInterface givenRight) 
	{
		// must cast the givenRight as Binary Node because it is type BinaryTreeNodeInterface 
		right = (BinaryNode) givenRight; 
	}


	public void setLeft(BinaryTreeNodeInterface givenLeft) 
	{
		// must cast the givenLeft as Binary Node because it is type BinaryTreeNodeInterface 
		left = (BinaryNode) givenLeft;
	
	}


	public boolean hasLeft() // returns a boolean based on if a left child is present
	{
		return left != null;
	}


	public boolean hasRight() // returns a boolean based on if a right child is present
	{
		return right != null;
	}


	public BinaryTreeNodeInterface getLeftSubtree() // returns left subtree which roots from the left child
	{
		 
		return left;
	}


	public BinaryTreeNodeInterface getRightSubtree() // returns right subtree which roots from the right child 
	{
		 
		return right;
	}

	public boolean isLeaf() // if there is no children we consider the BinaryNode to be a leaf
	{
		 
		return (left == null && right == null);
	}
	

}
