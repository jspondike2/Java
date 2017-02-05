
public interface HashTableList
{
/* This is an application of hash Tables using our already constructed
 * text file reader program. It will parse the list as usual, and when
 * sorting the words, it will rely on the Hash Function in order to 
 * properly place the word in its location. (This is an array based
 * collection of Linked lists.)
 */
	boolean contains(String x);		//finds the location of where the value is to be placed
	void add(String x);				//adds the given value into the list, based off of the given Hash Function
}
