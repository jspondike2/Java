
public class BiTree
{
	TreeNode tree;								//creates the root of the tree
	private TreeNode currentNode;				//creates a pointer to traverse the current node in the list
	private TreeNode previousNode;				// and a previous node to point at the node above the current node
	int numOfNodes=0;							//holds the number of nodes in the list (used for print)
	int numOfWords=0;							//holds a running sum of all the words in the tree
	int printed=0;								//holds teh amount of how many words have been printed
	final private int DesiredPrint=100;			//the number of words that the user would like printed from the tree
	int refChanges=1;							//reference changes start at one, because in order to use a Binary Tree, the root must be made (one reference change)
	int comparisons=0;							//the number of comparisons the binary search tree makes
	boolean printValues=false;					//controls whether or not the values within the tree are printed
	
	BiTree()									//default constructor
	{
		
	}
	
	public void add(String word)				
	{
		currentNode=tree;						//sets the start pointer to the root of the tree
		previousNode=null;						//initializes the "Laggard" to null
		while(currentNode!=null)				//so long as the current node hasn't fallen off the tree, keep moving down
		{
			if(currentNode.getValue().equals(word))
			{
				currentNode.increment();		//increment if the words are the same
				comparisons++;
				return;
			}
			comparisons++;						//from if statement
			previousNode = currentNode; 		//previous pointer follows behind the current node pointer

					//if the word is less than the current word, go left, otherwise go right
			currentNode = ((word.compareTo((String)currentNode.getValue())<0) ? currentNode.getLeft() : currentNode.getRight());
			comparisons++;
		}

		if(previousNode==null)					//if the previous pointer is null as well as the current, then there are no nodes on the list and 
			tree = new TreeNode(word);			// the root will be created (reference change already accounted for in instantiation of Binary Tree)
		else
		{
			TreeNode node = new TreeNode(word);	//if previous is not null then there is at least one node on the tree so the object will be added to the bottom of the tree
			if(word.compareTo((String)previousNode.getValue())<0)
					previousNode.setLeft(node);	//if the new object is less than the current object the current node will set its left link to the new node
			else	previousNode.setRight(node);//if the new object is greater than the current object, the right link will be set to the new node
			comparisons++;						//from if statement
			refChanges++;						//from the previousNode setlink
		}
//		numOfNodes++; (because print is supposed to increment this counter this is commented out)
	}
	
	public void print()							//prints the elements in the tree (IN-ORDER)
	{
		if(printValues)
			System.out.println("The first " + DesiredPrint + " elements in the tree are:\n");
		PrintTree(tree);
//		System.out.println("\nThis tree had "+numOfNodes+" unique elements (nodes).");
		System.out.println("\nThe passage had "+numOfNodes+" unique words. "
							+ numOfWords + " words in total.\n"
							+"There were "+refChanges+" reference changes, and "+comparisons+" word checks.");
	}

	private	void PrintTree(TreeNode node) 
	{
		/* Recursive implementation, used for printing a desired
		 * number of items in an IN-ORDER fashion.
		 */
		if (node.getLeft() != null) PrintTree(node.getLeft());	//if there is a left node it will go left
		if(printValues && !(printed == DesiredPrint))							//if the number of items printed has already surpassed the desired number of printed values, stop printing
		{
			System.out.println(node.getValue());				//print the value within the node
			printed++;											//as soon as the value was printed it will increment the counter
		}
		numOfNodes++; numOfWords+=node.getCount();				//grabs the data from the tree (number of unique items, and how many total items)
		if (node.getRight() != null) PrintTree(node.getRight());//if there is a right node it will go right
	}

	
}
