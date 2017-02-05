
public interface StackInterface<T>
{
	void pop() throws StackUnderflow;
	//Throws a StackUnderflow exception if Stack isEmpty
	//otherwise it will delete the first element on the stack (top)
	T top() throws StackUnderflow;
	//Throws StackUnderflow exception if Stack isEmpty
	//Otherwise will return the value of the top node
	boolean isEmpty();
	//returns whether or not the Stack is empty
}
