
public class SpeshulSortedLL extends SortedLL
{
	/* The alphabetical list is sorted such that once the location
	 * pointer passes the point where the word is supposed to be
	 * it no longer has to traverse the list. 
	 * For this special case, if the proceeding word happens to fall
	 * in the latter half of the alphabet (from the last search)
	 * the contains method will traverse the list starting from that
	 * already existing midpoint.
	 */
	SpeshulSortedLL()
	{
		//default constructor for the Special Sorted Linked List
	}
	public boolean contains(String word)
	{
		/* For this special case, if the proceeding word happens to fall
		* in the latter half of the alphabet (from the last search)
		* the contains method will traverse the list starting from that
		* already existing midpoint.
		*/
		
		if(list==null)return false;					//if the list is empty then the word cannot be in the list
		
		if(location!=null&&word.compareTo(""+location.getValue())>0)//if the word comes after the current location pointer, it will traverse the list
		{															//  starting at that point, rather than reseting the location and previous pointers
			String locValue=location.getValue()+"";
			while(location!=null)					//so long as the location is not pointing to nothing and we haven't passed where the word is supposed to be
			{
				locValue=location.getValue()+"";
				if(locValue.equals(word)){checks+=2; return true;}	//if the value in the current node is the same as the word then return true (adds 2 to the checks because of the two if statements)
				else if(locValue.compareTo(word)<0)		//if the word comes after the current value in the list it will output a negative integer and this if will increment the position of the location pointer
				{
					checks++;
					previous=location;
					location=(WordNode)location.getLink();
				}
				else {checks+=2; break;}								//if we've passed the location where the word should be located ( where .compareTo() returns a positive integer) it will break
			}
			return false;							//if it wasn't found return false
		}
		
		location=list;								//sets the location to the front of the list
		previous=null;
		String locValue=location.getValue()+"";
		while(location!=null)						//so long as the location is not pointing to nothing and we haven't passed where the word is supposed to be
		{
			locValue=location.getValue()+"";
			if(locValue.equals(word)){checks+=2; return true;}	//if the value in the current node is the same as the word then return true (adds 2 to the checks because of the two if statements)
			else if(locValue.compareTo(word)<0)			//if the word comes after the current value in the list it will output a negative integer and this if will increment the position of the location pointer
			{
				checks++;
				previous=location;
				location=(WordNode)location.getLink();
			}
			else {checks+=2; break;}								//if we've passed the location where the word should be located ( where .compareTo() returns a positive integer) it will break
		}
		return false;								//if it wasn't found return false
	}


}
