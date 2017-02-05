
public class WordNode extends Node
{
	/* A subclass of Node, specific for the uses of this program.
	 * The wordnode adds a count variable which can be incremented
	 * and manipulated to express the number of times that word has
	 * been seen in the passage.
	 */
	int count=0;					//counts how many times that word is present in the passage
	WordNode()						//default constructor
	{
		//this is the default constructor for a WordNode Object
	}
	WordNode(String x, WordNode y)	//constructor which contains the value and link to next node
	{
		/* This is another constructor where the value and link
		 * of the WordNode object can be created in the objects
		 * instantiation.
		 */
		value=x;					//sets the value of the node (the payload) to the desired input (x)
		link=y;						//sets the link of the node to the desired input (y)
		count++;					//increments the count of the new word to 1
	}
	public void incrememntCount()	//adds an occurrence of the word by incrementing the count variable
	{
		count++;					//increments the count of the word
	}
	public int getCount()			//returns how many times the word has been seen
	{
		return count;				//returns the current count of the object (how many times that word was seen)
	}
	public void setCount(int input)	//used to more easily implement the IncrementativeLL sets the count of the node
	{
		count=input;				//sets the count of the node to the given input
	}
}
