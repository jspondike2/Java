
public class Stack implements StackInterface<Object>
{
	Node top;
	public Stack()
	{
		
	}
	public boolean isEmpty()	//Returns whether or not the Stack isEmpty
	{
		return top==null;
	}
	public void push(Object x)	//adds an element to the top of the Stack
	{
		Node node = new Node(x, top);	//creates a new node and places it at the top of the stack using the custom constructor
		top=node;						//sets the top of the stack to the new node
	}
	public void pop() throws StackUnderflow	//deletes the top node if there is one, otherwise will throw an exception
	{
		if(!this.isEmpty())				//if there is no top node there will be an error
		{
			top=top.getLink();				//sets the top of the stack to whatever location is held by the next Node
		}
		else							//otherwise pop is not possible and a custom exception is thrown
		{
			throw new StackUnderflow("There are missing elements in the expression.");
		}	
	}
	public Object top() throws StackUnderflow //returns the value of the top node if there is one, otherwise will throw an exception
	{
		if(!this.isEmpty())				//if there is no top node there will be an error
		{
			return top.getValue();			//returns the value held inside the node
		}
		else							//otherwise top is not possible and a custom exception is thrown
		{
			throw new StackUnderflow("There are missing elements in the expression.");
		}
	}
}
