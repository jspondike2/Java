
public class PostFixException extends Exception
{

	/*
	 * This exception will be thrown if the evaluater
	 * method runs out of operands from the stack and
	 * still has operators remaining in the string. 
	 */
	public PostFixException()
	{
		//Default error message will just display "PostFixException"
		super();
	}
	public PostFixException(String x)
	{
		//Error message will be displayed along with "PostFixException"
		super(x);
	}
}
