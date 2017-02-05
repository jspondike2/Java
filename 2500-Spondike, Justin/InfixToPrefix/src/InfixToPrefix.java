/* Justin Spondike
 * Date: 10/13/2016
 * EECS 2500 Linear Data Structures
 */
import java.util.Scanner;
public class InfixToPrefix
{
	public static void main(String args[]) throws StackUnderflow, PostFixException, ValueOverflowException
	 {
		/*
		 * This program will take an infix expression from the user and convert it to
		 * a postfix expression, and then evaluate it. This demonstrates a good use of
		 * the Stack concept and using a linked list of nodes (objects) within java to
		 * solve a problem.
		 */
		 Scanner scanner = new Scanner(System.in);		//creates a new scanner to analyze user input
		 boolean again = true;							//used to ask the user if they'd like to input multiple expressions (currently set to automatically accept another expression)
		 boolean proper;

		 do
		 {
			 String infix = scanner.nextLine();				//grabs the infix input from the user
			 if(infix.equalsIgnoreCase("exit"))break; 
			 String postfix = Converter.convertInfixToPostfix(infix);	//converts the infix from the user to postfix
			 System.out.println(postfix); 					//prints the conversion from infix to postfix
			 
			 try
			 {
				 System.out.println(evaluatePostfix(postfix));
			 }catch (ValueOverflowException | PostFixException | StackUnderflow e)
			 {
				e.printStackTrace();
			 }
			 
/*			 if(again)
			 do	//iterative question asking the user if they'd like to input another expression
			 {
				 proper = false;							//sets default to false
				 System.out.println("Would you like to make another computation? (Y or N)");	//asks if the user would like to do another computation
				 String answer = scanner.nextLine();		//grabs the users answer
				 if((answer.length()==1) && 
						 ((answer.toUpperCase().charAt(0)=='Y') 
								 || (answer.toUpperCase().charAt(0)=='N')))				//if their answer is not explicitly Y or N it will prompt for a proper response
				 {
					 if(answer.toUpperCase().charAt(0)=='Y') break;	//if the user answers Y it will leave the again as true and repeat the program
					 proper=true;									//a valid input was given and if this is running it means the answer was "N"
					 again=false;									//otherwise it will set again to false and terminate the program
				 }
				 else
				 {
					 System.out.println("Please answer with a valid input. Either Y or N.");
				 }
			 }while(proper==false);  */
		 }while(again);
		 scanner.close();
	 }
	 
	public static int evaluatePostfix(String postfix) throws PostFixException, StackUnderflow, ValueOverflowException
	 {
		 /*
		  * Evaluates the converted postfix expression.
		  * It passes through the string and saves integers
		  * in the stack and then harvests them as they are needed
		  * to satisfy the operators.
		  * Throws PostFixException and StackUnderflow exceptions when
		  * there are not enough operators in the string.
		  * handles operators: + - x / ^ Q C < > and %
		  * handles numbers from 1 to 2billion and any evaluated result
		  * 	may not exceed 2,147,483,647
		  */
		 
		 Stack stack = new Stack();						//creates a new stack for the evaluate method to use
		 int value=0;									//will hold the value of the expression
		 long bigCheck;
		 int numUn;										//holds the value of the first operand
		 int numDu;										//holds the value of the second operand
		 String operator;								//holds the value of the current operator
		 Scanner token = new Scanner(postfix);			//takes the postfix expression as input for the evaluate method
		 
		 while (token.hasNext())						//this loop will run so long as there are characters in the postfix string (token)
		 {
			 if(token.hasNextInt())						//if the next character in token is an integer this will run
			 {
				 stack.push(token.nextInt());				//places the integer from token onto the stack
			 }
			 else										//otherwise it will run an operator pattern
			 {
				 operator = token.next().toUpperCase();				//if the hasNextInt failed it means there must be an operator
				 
				if(operator.contains("+")||operator.contains("-")
				 ||operator.contains("X")||operator.contains("*")||operator.contains("/")
				 ||operator.contains("%")||operator.contains("^")
				 ||operator.contains("<")||operator.contains(">"))//if the operator is one which requires two operands it will harvest two operands from the stack
				{
					 numDu = (int)stack.top();				//grabs the value from the top of the stack (the top operand)
					 stack.pop();							//deletes the harvested operand
					 
					 numUn = (int)stack.top();				//grabs the value from the top of the stack (the top operand)
					 stack.pop();							//deletes the harvested operand
					 
					 switch(operator)						//switches among the operators depending on current value of operator
					 {
					 case "+": bigCheck = (long)numUn + (long)numDu; if((bigCheck>2000000000)||(bigCheck<(0-2000000000))) throw new ValueOverflowException("The addition of the given numbers will exceed +/-2 Billion.");
					 												 else value = numUn + numDu; break;		//if adding the two numbers will exceed the 2billion value limit of type int, throw an exception, otherwise process normally
					 case "-": bigCheck = (long)numUn - (long)numDu; if((bigCheck>2000000000)||(bigCheck<(0-2000000000))) throw new ValueOverflowException("The subtraction of the given numbers will exceed +/-2 billion.");
						 											 else value = numUn - numDu; break;		//if subtracting the two numbers will exceed the 2billion value limit of type int, throw an exception, otherwise process normally				
					 case "X": bigCheck = (long)numUn * (long)numDu; if((bigCheck>2000000000)||(bigCheck<(0-2000000000))) throw new ValueOverflowException("The multiplication of the given numbers will exceed +/-2 Billion.");
					 												 else value = numUn * numDu; break;		//if multiplying the two numbers will exceed the 2billion value limit of type int, throw an exception, otherwise process normally
					 case "*": bigCheck = (long)numUn * (long)numDu; if((bigCheck>2000000000)||(bigCheck<(0-2000000000))) throw new ValueOverflowException("The multiplication of the given numbers will exceed +/-2 Billion.");
					 												 else value = numUn * numDu;break;		//the two numbers will exceed the 2billion value limit of type int, throw an exception, otherwise process normally
					 case "/": if(!(numDu==0))value = numUn / numDu; else throw new PostFixException("Cannot divide by zero."); break;//the second number cannot be zero, or we would be diving by zeros
					 case "%": if(!(numDu==0))value = numUn / numDu; else throw new PostFixException("Cannot mod by zero."); value = numUn % numDu; break;//the second number cannot be zero, or we would be diving by zeros
					 case "^": value = (int) Math.pow(numUn, numDu); break;
					 case ">": value = (int)(numUn / (Math.pow(2, numDu))); break;
					 case "<": value = (int)(numUn * (Math.pow(2, numDu))); break;
					 }
					 stack.push(value);						//pushes the resulting value from the computation onto the stack
				}
				else if(operator.contains("Q")||operator.contains("C"))										//otherwise it will only grab one operand from the stack and operate accordingly.
				{
					 numUn = (int)stack.top();				//grabs the value from the top of the stack (the top operand)
					 stack.pop();							//deletes the harvested operand
					 
					 switch(operator)
					 {
					 case "Q": value = (int)Math.sqrt(numUn); break;	//uses the Math package to take the square root of the one operand
					 case "C": value = (int)Math.cbrt(numUn); break;	//uses logarithm of base 10 to find the cubed root of the one operand
					 }
					 stack.push(value);						//pushes the resulting value from the computation onto the stack
				}
			 }
		 }
		 token.close();	//closes the token scanner
		 return value;	//returns the final value of the postfix expression as an int
	 }


}