
public class Node implements NodeInterface<Object>
{
	Object value;
	Node link;
	//Default value and link of a new node is null

	public Node()	//Default constructor	
	{

	}
	public Node(Object x, Node y)	//Constructor mainly used for push when we know where the link is going to be
	{
		value=x;
		link=y;
	}
	public Node getLink()	//Returns "link", the location of the next node
	{
		return link;
	}
	public void setLink(Node y)	//Sets the location of the new Node equal to the Node y
	{
		link = y;
	}
	public Object getValue()	//Returns "value", the value of the object saved in the Node
	{
		return value;
	}
	public void setValue(Object x)	//Sets the value of the Node equal to the given Object x
	{
		value = x;	
	}
}
