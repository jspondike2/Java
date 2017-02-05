/* Justin Spondike
 * Date: 11/16/2016
 * EECS 2500 Linear Data Structures
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class TextFileReader
{

	
	final private static String docLocation = "WarWithShakespeare.txt";
	final private static boolean LinkedLists = false;	//this enables the linked lists, originally made for this program
	final private static boolean HashLists = false;		//this enables the second portion of the programming assignment (Hash Tables)
	final private static boolean BinaryTree = true;		//enables the third portion of the text file reader assignm,ent (Binary Search Tree)
	
	/* This program will read a text file and parse every word and place it in a list.
	 * It will count how many times a word is present in the document and in some cases
	 * order the list (alphabetically and dynamically by occurrence). 
	 */ 
	public static void main(String[] args)
	{
		if(!LinkedLists)
		{
			long startTime = System.currentTimeMillis();//sets the start time of the program
			File x = new File(docLocation);				//sets the file object equal to the given input "docLocation"
			try
			{
				Scanner text = new Scanner(x);			//creates a scanner to parse the document
				readList(text);
				long endTime0 = System.currentTimeMillis();			//sets the end time of the program
				float time = (endTime0-startTime)/(float)1000;		//converts milliseconds into seconds
				System.out.println("The program took " + time  + " seconds to read the passage.\n"); //prints how long it took the program to run in seconds to read the passage
			}
			catch (FileNotFoundException e)
			{
				System.out.println("The file was not found.");	//Likely the only error that may be encountered
				System.exit(0); 								//exits the program so that it doesn't print out four "file not found" error messages
			}
		}
		if(LinkedLists)
			for(int whichList=0; whichList<6; whichList++)	//iterates through all of the different lists
			{
				long startTime = System.currentTimeMillis();//sets the start time of the program
				File x = new File(docLocation);				//sets the file object equal to the given input "docLocation"
				try											//tries to run, in case there is no file in the designated location
				{
					Scanner text = new Scanner(x);			//creates a scanner to parse the document
					switch(whichList)						//depending on the choice in the variable above it will run only one List (as specified)
					{
					case 0: readList(text);
								long endTime0 = System.currentTimeMillis();			//sets the end time of the program
								float time = (endTime0-startTime)/(float)1000;		//converts milliseconds into seconds
								System.out.println("The program took " + time  + " seconds to read the passage.\n");//prints how long it took the program to run in seconds to read the passage
								break;
					case 1: unsortedLL(text);
								long endTime1 = System.currentTimeMillis();			//sets the end time of the program
								float time1 = (endTime1-startTime)/(float)1000;		//converts milliseconds into seconds
								System.out.println("The program took " + time1 + " seconds to List the pasasage (Unsorted).\n");//prints how long it took the program to run in seconds the Unsorted list
								break;
					case 2: sortedLL(text);
								long endTime2 = System.currentTimeMillis();			//sets the end time of the program
								float time2 = (endTime2-startTime)/(float)1000;		//converts milliseconds into seconds
								System.out.println("The program took " + time2 + " seconds to Alphabetically Sort the passage.\n");//prints how long it took the program to run in seconds the alphabetical list
								break;
					case 3: speshulSortedLL(text);
								long endTime3 = System.currentTimeMillis();			//sets the end time of the program
								float time3 = (endTime3-startTime)/(float)1000;		//converts milliseconds into seconds
								System.out.println("The program took " + time3 + " seconds to Alphabetically Sort the passage, with the special check condition.\n");//prints how long it took the program to run in seconds the alphabetical list
								break;
					case 4: dynamicLL(text);
								long endTime4 = System.currentTimeMillis();			//sets the end time of the program
								float time4 = (endTime4-startTime)/(float)1000;		//converts milliseconds into seconds
								System.out.println("The program took " + time4 + " seconds to Dynamically sort the passage.\n");//prints how long it took the program to run in seconds the dynamically sorted linked list
								break;
					case 5: incrementativeLL(text);
								long endTime5 = System.currentTimeMillis();			//sets the end time of the program
								float time5 = (endTime5-startTime)/(float)1000;		//converts milliseconds into seconds
								System.out.println("The program took " + time5 + " seconds to Incrementatively Sort the passage.\n");//prints how long it took the program to run in seconds the incrementative list
								break;
					}
					text.close();
				}
				catch (FileNotFoundException e)
				{
					System.out.println("The file was not found.");	//Likely the only error that may be encountered
					System.exit(0); 								//exits the program so that it doesn't print out four "file not found" error messages
				}																																																		
			}
		if(HashLists)
		{
			for(int whichHash=1; whichHash<3; whichHash++)
			{
				long startTime = System.currentTimeMillis();//sets the start time of the program
				File x = new File(docLocation);				//sets the file object equal to the given input "docLocation"
				try											//tries to run, in case there is no file in the designated location
				{
					Scanner text = new Scanner(x);			//creates a scanner to parse the document
					switch(whichHash)
					{
					case 1: hashTableList1(text);
								long endTime1 = System.currentTimeMillis();			//sets the end time of the program
								float time1 = (endTime1-startTime)/(float)1000;		//converts milliseconds into seconds
								System.out.println("The program took " + time1  + " seconds to read the passage.\n");//prints how long it took the program to run in seconds to read the passage
								break;
					case 2: hashTableList2(text);
								long endTime2 = System.currentTimeMillis();			//sets the end time of the program
								float time2 = (endTime2-startTime)/(float)1000;		//converts milliseconds into seconds
								System.out.println("The program took " + time2  + " seconds to read the passage.\n");//prints how long it took the program to run in seconds to read the passage
								break;
					}
				}
				catch (FileNotFoundException e)
				{
					System.out.println("The file was not found.");	//Likely the only error that may be encountered
					System.exit(0); 								//exits the program so that it doesn't print out four "file not found" error messages
				}	
			}
		}
		if(BinaryTree)
		{
			long startTime = System.currentTimeMillis();			//sets the start time of the program
			File x = new File(docLocation);							//sets the file object equal to the given input "docLocation"
			try
			{
				Scanner text = new Scanner(x);						//creates a scanner to parse the document
				binaryTree(text);
				long endTime1 = System.currentTimeMillis();			//sets the end time of the program
				float time1 = (endTime1-startTime)/(float)1000;		//converts milliseconds into seconds
				System.out.println("The program took " + time1  + " seconds to read the passage.\n");//prints how long it took the program to run in seconds to read the passage
			}
			catch (FileNotFoundException e)
			{
				System.out.println("The file was not found.");		//Likely the only error that may be encountered
				System.exit(0); 									//exits the program
			}	
		}
	}

	private static String trim(String word)
	{
		/* This method takes the input word and runs through a system of if statements
		 * and loops, checking the front and back of the word for any punctuation. If
		 * any is found, it is deleted off of the word and the word is then returned.
		 */
		String s = "\"\':;-/.,?!<>_=+@#$%^&*()`~\\|[]{}�������";			//list of all possible punctuation (Old Trim)
//		String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";	//list of valid characters (New Trim) (requires logic reorginization)
		while(word.length()!=0&&(s.contains(""+word.charAt(0))||s.contains(""+word.charAt(word.length()-1)))) //if the word is longer than 0 and there is punctuation at the beginning or the end it will delete it
		{
			if(s.contains(""+word.charAt(0)))			//if the first character in a word is a piece of punctuation it will delete it
			{
				String tempWord="";						//uses this as the new word that is getting edited
				for(int i=1; i<word.length(); i++)		//this starts at the second character and parses each character
				{
					tempWord += ""+word.charAt(i);		//appending it to the temporary word
				}
				word = tempWord;						//the final result is the same word with no beginning punctuation
			}
			if(word.length()!=0&&s.contains(""+word.charAt(word.length()-1)))//deletes any ending punctuation
			{
				String tempWord="";						//uses this as the new word that is getting edited
				for(int i=0; i<word.length()-1; i++)	//starts at the beginning of the word and stops one character short of the end
				{
					tempWord += ""+word.charAt(i);		//appends each character to the temporary word, omitting the final character
				}
				word = tempWord;						//the final result is the same word with no ending punctuation
			}
		}
		word=word.toLowerCase();						//ensures the entire word is lower case
		if(word.length()==0) return ".";				//if the word is empty after deleting all punctuation
		return word;
	}
	private static void readList(Scanner text)
	{
		/* This is the control method.. It will read the passage and
		 * print out the first 100 words. The four lists will also have
		 * to print out the first 100 words as soon as they are done 
		 * sorting, so implementing it this way will allow for a more
		 * precise measurement.
		 */
		int numOfWords=0;
		while(text.hasNext())								//will continue to loop so long as there are words left in the file
		{
			String word = trim(text.next().toLowerCase());	//grabs and trims the next word in the document (useless for this method except to take time and set our control time)
			if(word.equals(".")) continue;					//if the word is a period it means the previous word was all punctuation and it was erased, so continue past this word and dont consider it
			numOfWords++;
		}
		System.out.println("There are "+numOfWords+" words in the file.");
	}
	public static void unsortedLL(Scanner text)
	{
		/* This method implements the Unsorted Linked List.
		 * It goes through the passage, grabbing each word
		 * and adds it to the front of the list. In order to
		 * decipher if the word is already in the list it must
		 * traverse the entire list to either Find it, or figure
		 * out that it isn't present.
		 */
		UnsortedLL list = new UnsortedLL();
		while(text.hasNext())								//will continue to loop so long as there are words left in the file
		{
			String word = trim(text.next()).toLowerCase();	//trims the next word and ensures the entire word is lower case
			if(word.equals(".")) continue;					//if the word is a period it means the previous word was all punctuation and it was erased, so continue past this word and dont consider it
			if(list.contains(word))							//if the word is present in the list
			{
				list.incrementWord(word);					//it will increment the count of the word
			}
			else list.add(word);							//otherwise it will add it to the list
		}
		System.out.println("There are "+list.distinctWords()+" different words in this passage.\n"
							+list.numOfWords()+" words in total.");		//print the number of words in the passage
		System.out.println("There were "+list.getChecks()+" word checks in running this list, and "
				+list.getRefChanges()+" reference changes.");//prints the word checks and reference changes
		list.print();										//prints the first 100 words in the list
	}
	public static void sortedLL(Scanner text)
	{
		/* This method implements the Sorted Linked List. 
		 * It will grab each new word that the program parses from the text file
		 * and throw it into a sorted linked list. When there is a word that is not
		 * present in the list it will find the proper placement of the word (alphabetically)
		 * If ever there is a word that is already present on the list it will increment the
		 * count of that word, not compromising the order of the list.
		 */
		SortedLL list = new SortedLL();
		while(text.hasNext())								//will continue to loop so long as there are words left in the file
		{
			String word = trim(text.next()).toLowerCase();	//trims the next word and ensures the entire word is lower case
			if(word.equals(".")) continue;					//if the word is a period it means the previous word was all punctuation and it was erased, so continue past this word and dont consider it
			if(list.contains(word))							//if the word is present in the list
			{
				list.incrementWord(word);					//it will increment the count of the word
			}
			else list.add(word);							//otherwise it will add it to the list
		}
		System.out.println("There are "+list.distinctWords()+" different words in this passage.\n"
							+list.numOfWords()+" words in total.");		//print the number of words in the passage
		System.out.println("There were "+list.getChecks()+" word checks in running this list, and "
							+list.getRefChanges()+" reference changes.");//prints the word checks and reference changes
		list.print();										//prints the first 100 words in the list
	}
	public static void speshulSortedLL(Scanner text)
	{
		/* This method implements the Special Sorted Linked List. 
		 * It will grab each new word that the program parses from the text file
		 * and throw it into a sorted linked list. When there is a word that is not
		 * present in the list it will find the proper placement of the word (alphabetically)
		 * If ever there is a word that is already present on the list it will increment the
		 * count of that word, not compromising the order of the list.
		 * This linked list however has a special case with the contains method.
		 * If the current word falls somewhere behind where the location marker already sits
		 * (from the last search) it will continue it's check from that point, rather than
		 * traverse the entire list again.
		 */
		SpeshulSortedLL list = new SpeshulSortedLL();
		while(text.hasNext())								//will continue to loop so long as there are words left in the file
		{
			String word = trim(text.next()).toLowerCase();	//trims the next word and ensures the entire word is lower case
			if(word.equals(".")) continue;					//if the word is a period it means the previous word was all punctuation and it was erased, so continue past this word and dont consider it
			if(list.contains(word))							//if the word is present in the list
			{
				list.incrementWord(word);					//it will increment the count of the word
			}
			else list.add(word);							//otherwise it will add it to the list
		}
		System.out.println("There are "+list.distinctWords()+" different words in this passage.\n"
							+list.numOfWords()+" words in total.");		//print the number of words in the passage
		System.out.println("There were "+list.getChecks()+" word checks in running this list, and "
				+list.getRefChanges()+" reference changes.");//prints the word checks and reference changes
		list.print();										//prints the first 100 words in the list
	}
	public static void dynamicLL(Scanner text)
	{
		/* This list will grab each new word that the program parses from the text file
		 * and throws it into an unsorted linked list. If ever there is a word that is
		 * already present on the list it will increment the counter of that word, 
		 * AND bring that word to the front of the list. This creates a dynamic list
		 * where the most prominent words are going to be closer to the front of the list.
		 */
		DynamicLL list = new DynamicLL();
		while(text.hasNext())								//will continue to loop so long as there are words left in the file
		{
			String word = trim(text.next()).toLowerCase();	//trims the next word and makes it lower case
			if(word.equals(".")) continue;					//if the word is a period it means the previous word was all punctuation and it was erased, so continue past this word and dont consider it
			if(list.contains(word))							//if the word is present in the list
			{
				list.incrementWord(word);					//it will increment the count of the word
			}
			else list.add(word);							//otherwise it will add it to the list
		}
		System.out.println("There are "+list.distinctWords()+" different words in this passage.\n"
							+list.numOfWords()+" words in total.");		//print the number of words in the passage
		System.out.println("There were "+list.getChecks()+" word checks in running this list, and "
				+list.getRefChanges()+" reference changes.");//prints the word checks and reference changes
		list.print();										//prints the first 100 words in the list
	}	
	public static void incrementativeLL(Scanner text)
	{
		/* This list will grab each new word that the program parses from the text file
		 * and throws it into an unsorted linked list. If ever there is a word that is
		 * already present on the list it will increment the counter of that word, 
		 * AND increment that words' placement in the list. This creates a dynamic list
		 * where the most prominent words are going to be closer to the front of the list.
		 */
		IncrementativeLL list = new IncrementativeLL();
		while(text.hasNext())								//will continue to loop so long as there are words left in the file
		{
			String word = trim(text.next()).toLowerCase();	//trims the next word and ensures the entire word is lower case
			if(word.equals(".")) continue;					//if the word is a period it means the previous word was all punctuation and it was erased, so continue past this word and dont consider it
			if(list.contains(word))							//if the word is present in the list
			{
				list.incrementWord(word);					//it will increment the count of the word
			}
			else list.add(word);							//otherwise it will add it to the list
		}
		System.out.println("There are "+list.distinctWords()+" different words in this passage.\n"
							+list.numOfWords()+" words in total.");		//print the number of words in the passage
		System.out.println("There were "+list.getChecks()+" word checks in running this list, and "
				+list.getRefChanges()+" reference changes.");//prints the word checks and reference changes
		list.print();										//prints the first 100 words in the list
	}
	public static void hashTableList1(Scanner text)
	{
		/* This list will utilize Hash Table in an attempt
		 * to see if adding this feature will improve the 
		 * sorting time over that of the Unsorted Linked
		 * List counterpart.
		 */
		HashList1 list = new HashList1(256);
		while(text.hasNext())								//will continue to loop so long as there are words left in the file
		{
			String word = trim(text.next()).toLowerCase();	//trims the next word and ensures the entire word is lower case
			if(word.equals(".")) continue;					//if the word is a period it means the previous word was all punctuation and it was erased, so continue past this word and dont consider it
			if(list.contains(word))							//if the word is present in the list
			{
				list.incrementWord();						//it will increment the count of the word
			}
			else list.add(word);							//otherwise it will add it to the list
		}

//		list.printWords();									//prints the first 100 words in the list (starting with array index 0)
//		list.printDistribution(); 							//prints the distribution of the words (how many are in each location)
		list.printStats();									//prints out the min, max, and mean values of the list lengths
	}
	public static void hashTableList2(Scanner text)
	{
		/* This list will utilize Hash Table in an attempt
		 * to see if adding this feature will improve the 
		 * sorting time over that of the Unsorted Linked
		 * List counterpart.
		 */
		HashList2 list = new HashList2(256);
		while(text.hasNext())								//will continue to loop so long as there are words left in the file
		{
			String word = trim(text.next()).toLowerCase();	//trims the next word and ensures the entire word is lower case
			if(word.equals(".")) continue;					//if the word is a period it means the previous word was all punctuation and it was erased, so continue past this word and dont consider it
			if(list.contains(word))							//if the word is present in the list
			{
				list.incrementWord();						//it will increment the count of the word
			}
			else list.add(word);							//otherwise it will add it to the list
		}

//		list.printWords();									//prints the first 100 words in the list (starting with array index 0)
//		list.printDistribution(); 							//prints the distribution of the words (how many are in each location)
		list.printStats();									//prints out the min, max, and mean values of the list lengths
	}
	public static void binaryTree( Scanner text)
	{
		/* This is not a list
		 */
		BiTree tree = new BiTree();
		while(text.hasNext())								//will continue to loop so long as there are words left in the file
		{
			String word = trim(text.next()).toLowerCase();	//trims the next word and ensures the entire word is lower case
			if(word.equals(".")) continue;					//if the word is a period it means the previous word was all punctuation and it was erased, so continue past this word and dont consider it
			tree.add(word);									//there is only one case for add. while searching for where a new word is supposed to go, it may finditself and then will increment within add.
		}

		tree.print();
		
	}
}