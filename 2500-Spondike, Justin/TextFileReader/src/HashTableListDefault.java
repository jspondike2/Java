
public class HashTableListDefault implements HashTableList
{
/* This is an application of hash Tables using our already constructed
 * text file reader program. It will parse the list as usual, and when
 * sorting the words, it will rely on the Hash Function in order to 
 * properly place the word in its location. (This is an array based
 * collection of Linked lists.)
 */
	
	WordNode[] list;
	int hashLocation; 			//variable to hold the location of the previous Hash Location, so once found, it doesn't have to re-hash the input
	int referenceChanges=0;
	int wordChecks=0;
	
	public boolean contains(String x)
	{
		//Each Hash Table list is going to be unique depending on the function. So find is going to vary
		System.out.println("\"Find()\" must be implemented depending on Hash Function.");
		return false;
	}
	public void add(String x)
	{
		/* Adds words to the list of the specified Hash location
	 	 * in the same manner as the Unsorted Linked List.
	 	 */
		WordNode node = new WordNode(x, list[hashLocation]);		//creates a new node which holds the word (String text) and a link to the front of the list (WordNode list) within the array's location
		list[hashLocation]=node;									//sets the front of the location's list to the new node
		referenceChanges+=2;
	}
	public void printWords()
	{
		/* This will print out the first 100 words in the
		 * Hash table. It will begin with the array's index
		 * at 0, and will increment every time it reaches a
		 * null reference. Each time it comes upon a new 
		 * reference in the array (a new index) it will 
		 * traverse that list (located in the index) until
		 * it reaches the (default)maximum of 100 words.
		 */
		
		int numOfWords = 100;										//holds the desired number of words printed
		int wordsPrinted=0;											//holds the current number of words printed
		WordNode printLocation;										//holds a reference to the current node being considered for print
		
		System.out.println("The first "+numOfWords+" words in the Hash Table are: \n");
		
		for(int i = 0; i < list.length; i++)						//this will iterate through all Hash table indices
		{
			printLocation = list[i];
			while(wordsPrinted<numOfWords && printLocation!=null)	//when the number of words printed has surpassed the number that we initially set to be printed, it will stop. Also if it has reached the end of a Linked List
			{
				System.out.println(printLocation.getValue()+"    x"+printLocation.getCount());	//prints out the word in that node
				wordsPrinted++;										//increments the number of words printed
				printLocation = (WordNode) printLocation.getLink();	//moves the print location to the next node
			}
			if(wordsPrinted==numOfWords) return;
		}
	}
	public void printDistribution()
	{
		/* This method will print out the lengths of all the 
		 * linked lists that exist in the Hash Table. If 10
		 * words that have the same Hash Code, are all in the
		 * same linked list and that specific Hash location.
		 * This method will print the number of words in that 
		 * location.
		 */

		WordNode printLocation;										//holds a reference to the current node being considered for print
		
		System.out.println("The distribution of the words in the Hash Table are: \n");
		
		for(int i = 0; i < list.length; i++)						//this will iterate through all Hash table indices
		{
			int numOfWords=0;
			printLocation = list[i];
			while(printLocation!=null)								//when the number of words printed has surpassed the number that we initially set to be printed, it will stop. Also if it has reached the end of a Linked List
			{
				printLocation = (WordNode) printLocation.getLink();	//moves the print location to the next node
				numOfWords++;
			}
			System.out.println("["+i+"] : " + numOfWords);			//Prints the index and how many chains on that link
		}
		
	}
	public void printStats()
	{
		
		int min=0;													//holds the minimum number of words in the lists
		int max=0;													//holds the maximum number of words in the lists
		int runAvNoom=0;											//running sum that will hold the addition of all the linked lists number of words (what would be in the numerator of the average function)
		int runAvDeno=0;											//running sum that will hold the number of lists that were in the Hash table (what would be in the denominator of the average function)
		int totalNumOfWords=0;										//running sum of all of the words in the Hash Table (including duplicates)
		WordNode printLocation;										//holds a reference to the current node being considered for print		
		
		
		for(int i = 0; i < list.length; i++)						//this will iterate through all Hash table indices
		{
			int numOfWords=0;										//holds the number of words in the list
			printLocation = list[i];								//sets the beginning of the list at the current Hash Table index
			while(printLocation!=null)								//when the number of words printed has surpassed the number that we initially set to be printed, it will stop. Also if it has reached the end of a Linked List
			{
				totalNumOfWords+=printLocation.getCount();			
				printLocation = (WordNode) printLocation.getLink();	//moves the print location to the next node
				numOfWords++;										//increments the number of unique words in that list
			}
			if(i==0) min = max = numOfWords;						//max will be initialized with the number of words in the first list
			if(numOfWords==0)continue;								//this is in place, assuming we don't want to consider a list of zero to be considered the min (also doesn't contribute to the average length)
			if(min==0) min=numOfWords;								//this will ensure that the first time a list passes through the while loop that is not of length zero, the min will grab it's value (this will only ever happen once)
			if		(numOfWords<min) min=numOfWords;				//if i is not zero and the number of words is not zero then it will check to see if this is the shortest list we have seen so far
			else if (numOfWords>max) max=numOfWords;				//if i is not zero and the number of words is not zero then it will check to see if this is the longest list we have seen so far
			runAvNoom+=numOfWords;									//adds the number of words in that list to the running sum
			runAvDeno++;											//increments the number of lists there are
		}
		
		try
		{
			System.out.println("There were "+totalNumOfWords+" words in the passage, "+runAvNoom+" of which were unique.");
			System.out.println("The shortest list in the Hash table had "+min+" word(s) in it.\n"
							+ "The longest list in the Hash table had "+max+" word(s) in it.\n"
							+ "The average length of the lists in the Hash table was "+(runAvNoom/runAvDeno)+".\n"
							+ "There were "+referenceChanges+" reference changes, and "+wordChecks+" word checks.");
		}
		catch(ArithmeticException e)								//this exception will only ever be thrown when runAvDeno was never incremented, meaning there were no words in the document
		{
			System.out.println("There are no words in this passage.");
		}
	}
}



















