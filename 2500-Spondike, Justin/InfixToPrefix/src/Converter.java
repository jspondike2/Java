import java.util.Scanner;

public class Converter
{
	static String postfix="";
	static Stack stack = new Stack();
	
	public static String formatInfix(String infix) throws PostFixException
	{
		String propInfix = "( ";				//initializes the proper infix notation
		Character lastChar=' ';					//will hold the value of the last character in case of an integer longer than one digit
		Character currChar;						//holds the current value of the character
		final String test = "()QqCc+-%/xX<>*^ ";	//holds all valid characters
		for(int i = 0; i<infix.length(); i++)	//iterates through all characters in the given string	
		{
			currChar=infix.charAt(i);			//sets the current character for comparison
			if(currChar=='1'||currChar=='2'||currChar=='3'||currChar=='4'
			 ||currChar=='5'||currChar=='6'||currChar=='7'||currChar=='8'
			 ||currChar=='9'||currChar=='0')	//if the current character is an integer it will check to make sure the next one is also an integer
			{
				if(i==0)	propInfix += currChar;	//if i is zero then it is the first character, and has no lastChar, so just append it and move on
				else if	 (lastChar=='1'||lastChar=='2'||lastChar=='3'||lastChar=='4'
						||lastChar=='5'||lastChar=='6'||lastChar=='7'||lastChar=='8'
						||lastChar=='9'||lastChar=='0')//if there is a lastChar it will check to see if it was also an integer in which case
					{							 //	the number would have been more than 1 digit long, and will append the currChar
						propInfix += currChar;	 //	without the additional space
					}
					else propInfix += " " + currChar;	 //if the lastChar was not an integer then the currChar can just be appended with a space
			}
				else if(test.contains(""+currChar))
				propInfix += " " + currChar;		 //if the currChar is not an integer and it is a valid character, just append it with a space
					 else if(!test.contains(""+currChar))//ensures the input is a valid character
					 {
						 throw new PostFixException("Invalid Character!");
					 }
			lastChar=currChar;				 //set the lastChar to be equal to the currChar of this pass so it can be used in the next iteration
		}
		
		propInfix += " )";					//completes the proper infix notation by closing the original parenthesis
		System.out.println(propInfix);		//to check and make sure this is outputting a correct infix expression
		return propInfix;
	}
	public static String convertInfixToPostfix(String infix) throws StackUnderflow, PostFixException
	 {
		/*
		 * This takes the properly converted infix expression and converts it to an
		 * equivalent postfix expression, using a scanner and stack.
		 */
		 postfix="";										//creates a string to hold the postfix expression
		 stack = new Stack();								//creates a new stack for the program to use for converting
		 String propInfix = formatInfix(infix);				//uses the format method to stick the infix in proper notation for the convert method to run
		 Scanner scan = new Scanner(propInfix);				//creates a scanner to traverse the infix expression input by the user
		 String token;										//holds the current characters being considered by the converter
		 
		 while(scan.hasNext())								//while there are still characters left in the string
		 {
			 token = scan.next().toLowerCase();

			if	 (token.equals("+")||token.equals("-")		//if the next token is an operand it will run the Operator method
				||token.equals("x")||token.equals("*")||token.equals("/")
				||token.equals("%")||token.equals("^")
				||token.equals("<")||token.equals(">")
				||token.equals("q")||token.equals("c"))
			{
				processOperator(token);
			}
			else if(token.equals("(")) stack.push(token);							//if the token is a left parenthesis then it will push it onto the stack
			else if(token.equals(")")) rightParan();	//if the token is a right parenthesis then it will run the appropriate method

			//if none of the if statements above runs then the token is an integer and it is appended to the postfix expression
			else{
					postfix += token + " ";			//casts the integer to a string and appends it to the postfix expression
		 		}
		 }
		 
		 /*
		  * once everything has been pushed onto the stack
		  * top and pop it off so that it can be placed in the postfix representation
		  */
		 scan.close(); 
		 return postfix;
	 }

	private static void rightParan() throws StackUnderflow
	{
		//this method runs when there is a right parenthesis in the infix expression
		Object topToken = stack.top();			//it grabs the top value off the stack
		while(!(topToken.equals("(")))			//checks to make sure it is not yet the left parenthesis
		{
			postfix += topToken + " ";			//it will append the top value to the postfix expression
			stack.pop();						//and then pop that value off the stack
			topToken = ""+stack.top();			//it then converts the next top value to a string and sets it as the new top token
		}
		stack.pop();							//the final thing left on the stack will be the left parenthesis
												//so it is popped off the stack
	}
	
	private static void processOperator(String token) throws StackUnderflow
	{
		//this method runs when an operator is found in the infix expression
		Object topToken = stack.top();			//it grabs the top value off the stack and sets it to top token
		while(!stack.isEmpty() && 				//so long as the stack is not empty or the left parenthesis this will reiterate
				!(stack.top().equals("(")))
		{
			stack.pop();						//it will pop the top value (what is held in topToken)
			postfix += topToken + " ";			//append the top token to the post fix expression
			topToken = "" + stack.top();		//the top token is then reevaluated to the top value in the stack
		}
		stack.push(token);						//this then pushes the operator onto the stack
	}

}