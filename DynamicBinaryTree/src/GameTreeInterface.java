
public interface GameTreeInterface extends BinaryTreeInterface
{
	// sets data in the current node.
	// will return true if another string is overridden and false if the node was empty
	public void setNodeData(String data); 
	
	// gives data which is currently present in the node. 
	// if nothing it there a exception will be thrown
	public String getNodeData();
	
	// will make the binary tree larger by adding another two options. 
	// the left will represent yes and right will represent no
	// the program will decide which way to go based on the answer
	public void setAnswer(String yes, String no);
	
	
	// will turn right or left based on how the question is answered
	// if the answer is yes first method will be called, if no the ladder.
	public void goYesWay();
	public void goNoWay();
	
	// will reset back to the root of the binary tree so that it can start the came all over again
	public void restartGame();
	
	// will give a boolean value based on if the current node which we are at is an answer.
	// the answer is always located at the leaf because then there are no more place to go on the decision tree
	public boolean isAnswer();
	
	
	
	
	

}
