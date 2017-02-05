
public interface NodeInterface<T>
{
	void setLink(Node T);
	//Sets the link of the current Node to the given input
	Node getLink();
	//Retrieves the location of the next Node (or null)
	void setValue(Object T);
	//Sets the value of the current Node
	Object getValue();
	//Retrieves the value of the object saved in the current Node
}
