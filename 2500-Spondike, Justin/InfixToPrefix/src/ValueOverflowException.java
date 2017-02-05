
public class ValueOverflowException extends Exception
{
	/*
	 * This exception will be thrown if the evaluater
	 * method adds two integers and the result exceeds
	 * 2billion or negative 2billion
	 */
	public ValueOverflowException()
	{
		//Default error message will just display "PostFixException"
		super();
	}
	public ValueOverflowException(String x)
	{
		//Error message will be displayed along with "PostFixException"
		super(x);
	}
}
