
public interface BinaryTreeInterface extends TreeInterface
{	
	// make a lone tree which has one node that has no children.
	//this serves as the starting point of a new binary tree
	public void makeTree();
	
	
	//makes a new tree which also has a left and or right child.
	// this method allows you to connect two binary trees with a selected root.	
	public void makeTree(String rootData, BinaryTreeInterface leftChild, BinaryTreeInterface rightChild);


}
