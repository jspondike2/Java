
public class StackUnderflow extends Exception
{
	/*
	 * This Exception is used when there aren't 
	 * any elements in a stack and the program
	 * tries to use the pop or top methods
	 */
	public StackUnderflow()
	{
		//Default error message will just display "StackUnderflow"
		super();
	}
	public StackUnderflow(String x)
	{
		//Error message will be displayed along with "StackUnderflow"
		super(x);
	}
}