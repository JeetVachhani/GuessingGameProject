
public interface BinaryTreeNodeInterface 
{
	// returns data based in the node, data will be a String alwsy
	// will return null if the node is empty
	public String getData();
	
	// sets the data in the currentNode
	// if node already had some data in it then the method will return true, will return false otherwise
	public void setData(String data);
	
	// sets the right child of the node
	public void setRight(BinaryTreeNodeInterface right);
	
	// sets the left child of the node
	public void setLeft(BinaryTreeNodeInterface left);
	
	// will return a boolean value which shows if the node has a left child
	public boolean hasLeft();
	
	// will return a boolean value which shows if the node has a right child
	public boolean hasRight();
	
	// will give you the left subtree rooted from the current node which you are in.
	// the node which is returned will most likely have children of its own, therefore it will be a subtree
	public BinaryTreeNodeInterface getLeftSubtree();
	
	// will give you the right subtree rooted from the current node which you are in.
	// the node which is returned will most likely have children of its own, therefore it will be a subtree
	public BinaryTreeNodeInterface getRightSubtree();
	
	// will return a boolean value based on if the node is a leaf or not
	// the node is a leaf if it has no children, therefore it will return true.
	public boolean isLeaf();

	

}
