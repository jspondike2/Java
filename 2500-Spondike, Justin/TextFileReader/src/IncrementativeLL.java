
public class IncrementativeLL extends ListDefaults
{
/* This list will grab each new word that the program parses from the text file
 * and throws it into an unsorted linked list. If ever there is a word that is
 * already present on the list it will increment the counter of that word, 
 * AND increment that words' placement in the list. This creates a dynamic list
 * where the most prominent words are going to be closer to the front of the list.
 */
	public IncrementativeLL()
	{
		// This default constructor creates an IncrementativeLL object.	
	}
	public void incrementWord(String word)
	{
		/* The incrementatively sorted linked list has a custom increment 
		 * method. When it increments the word, it moves that word one
		 * place forward in the list as well as increment the count of the word.
		 */
		location.incrememntCount();						//increments the count of the word
		if(location==list)return; 						//if the location is still the first word on the list then just increment the word and no reference changes need to be made
		
		String tempWord = ""+location.getValue();		//creates a separate variable to hold the contents of the first node
		int	   tempCount= location.getCount();			//holds the count of the first node
		location.setValue(previous.getValue());			//changes the contents of the first node to now equal the second node
		location.setCount(previous.getCount());
		previous.setValue(tempWord);					//changes the contents of the second node to now equal the saved contents of the first node
		previous.setCount(tempCount);
	}
}
