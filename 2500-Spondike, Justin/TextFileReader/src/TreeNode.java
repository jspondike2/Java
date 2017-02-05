/* An extension of the Node class.
 * This adaptation is designed for use in Binary Tree
 * sorting operations. It contains two reference 
 * pointers (left & right).
 */
public class TreeNode extends Node
{
	private int count = 0;					//
	private TreeNode left;					//
	private TreeNode right;					//

	TreeNode(Object x)						//constructor
	{
		this.setValue(x);					//sets the value of the node to the Object it was passed
		count++;
	}
	public void setLeft(TreeNode node)		//sets the left pointer to the node it was passed
	{
		left=node;
	}
	public void setRight(TreeNode node)		//sets the right pointer to the node it was passed
	{
		right=node;
	}
	public TreeNode getLeft()				//returns the current node at wchich the left reference is pointing
	{
		if(left==null)return null;			//if the reference is empty, return a null pointer
		return left;
	}
	public TreeNode getRight()				//returns the current node at wchich the right reference is pointing
	{
		if(right==null)return null;			//if the reference is empty, return a null pointer
		return right;
	}
	public void increment()					//increments the count of the node
	{
		count++;
	}
	public int getCount()					//returns the internal count of the node
	{
		return count;
	}
}
