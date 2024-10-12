/* ***************************************************
 * <Blair Bourque>
 * <10/8/24>
 * <List.java>
 *
 * <A file that has methods that will build a linked list>
 *************************************************** */

//the Node class

class Node
{
	private int data;
	private Node link;

	// constructor
	public Node()
	{
		this.data = 0;
		this.link = null;
	}

	// accessor and mutator for the data component
	public int getData()
	{
		return this.data;
	}

	public void setData(int data)
	{
		this.data = data;
	}

	// accessor and mutator for the link component
	public Node getLink()
	{
		return this.link;
	}

	public void setLink(Node link)
	{
		this.link = link;
	}
}

// the List class
public class List
{
	public static final int MAX_SIZE = 50;

	private Node head;
	private Node tail;
	private Node curr;
	private int num_items;

	// constructor
	// remember that an empty list has a "size" of 0 and its "position" is at -1
	public List()
	{	
		//make head, tail, and curr to null and set the number of items to 0
		head = null;
		tail = null;
		curr = null;
		num_items = 0;
	}

	// copy constructor
	// clones the list l and sets the last element as the current
	public List(List l) {
		// Create a new list
		head = tail = curr = null;
		
		//set the new node equal to the original head
		Node originalCurr = l.head;
		//count until the end of the list
		for (int i = 0; i < l.GetSize() ; i++){
			//insert the data at the current position
			InsertAfter(originalCurr.getData());
			//get the link of the next position (key)
			originalCurr = originalCurr.getLink();
		}
	}
	// navigates to the beginning of the list
	public void First()
	{	
		//set curr equal to the head
		curr = head;
	}

	public void Last() {
		if (!IsEmpty()) {
			// Set the current position to the last element (tail)
			curr = tail; 
		}
	}

	// navigates to the specified element (0-index)
	// this should not be possible for an empty list
	// this should not be possible for invalid positions
	public void SetPos(int pos)
	{
		if (!IsEmpty()){
			//check for valid positions
			if(pos>=0 && pos<=this.GetSize()-1){
				//set the head to curr
				Node tempCurr = head;
				//navigates to the specified element according to index
				for(int i = 0; i<pos;i++){
					tempCurr = tempCurr.getLink();
				}
				//set curr to tempCurr (current element)
				curr = tempCurr;
			}
		}
	}

	// navigates to the previous element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Prev() {
		//if not empty and curr is not equal to head
		if (!IsEmpty() && curr != head) {
			//set temprev to head
			Node tempPrev = head;
			//while the link of the head doesn't equal the current element
			while (tempPrev.getLink() != curr) {
				//get the link
				tempPrev = tempPrev.getLink();
				
			}
			//set curr equal to the one right before the current
			curr = tempPrev;
			
			
		}
	}

	// navigates to the next element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Next()
	{	//if not empty and curr doesnt equal the tail (null)
		if (!IsEmpty() && curr != tail) {
			//curr is equal to the link of curr
			curr = curr.getLink();
		}
	}
		
	

	// returns the location of the current element (or -1)
	public int GetPos(){
		//if the curr is head and tail
    	if (curr == head && curr == tail) {
			//pos is at -1
        	return -1;
    	} 
		//if curr is at the tail
		else if (curr == tail) {
			//location is at the size -1
        	return GetSize()-1;
    	} 
		else {
			//initialize count 
       		int count = 0;
			//make a new node equal to the head
        	Node tempCurr = head;
			//while the head isn't equal to the current element
        	while (tempCurr != curr) {
				//get the link and incremenent
            	tempCurr = tempCurr.getLink();
            	count++;
        	}
		//return count
        return count;
    	}
	}


	// returns the value of the current element (or -1)
	public int GetValue()
	{
		//while curr is not null
		if (curr!= null){
			//data is equal to the data of the curr element
			int data = curr.getData();
			return data;
		}
		else{
			//if curr is null, value is -1
			return -1;
		}
	}

	// returns the size of the list
	// size does not imply capacity
	public int GetSize(){
		//if head is equal to tail and head is equal to curr
		if(head == tail && head == curr){
			//return 0
			return 0;
		}
		else{
			//initialize count to 0
    		int count = 0;
			//set tempcurr to head so it doesn't change head
    		Node tempCurr = head;
			//while tempcurr is not null
    		while (tempCurr != null ) {
				//incremment count and get the link 
       			count++;
        		tempCurr = tempCurr.getLink();
    		}
		
    		return count;
		}
	}

	// inserts an item before the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertBefore(int data) {
		//if not full
		if (!IsFull()) {
			//make a new node
			Node newNode = new Node();
			//set the data to the input data
			newNode.setData(data);
	
			//if note empty and curr is head
			if (IsEmpty() || curr == head) {
				//set the link of the new node to head
				newNode.setLink(head);
				//move over the head and curr to the new node
				head = newNode;
				curr = newNode;
			} 
			else {
				//make newhead equal to the current head
				Node newHead = head;
				//while the newHead link is not curr
				while (newHead.getLink() != curr) {
					//get the link
					newHead = newHead.getLink();
				}
				//set the link of the new node to the curr element
				newNode.setLink(curr);
				///set the link of the one before the current equal to the new node
				newHead.setLink(newNode);
				//set curr to newNode
				curr = newNode;
			}
	
			//add to num of items
			num_items++;
		}
	}
	// inserts an item after the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertAfter(int data) {
		//if not full
		if (!IsFull()) {
			//make a new node
			Node item = new Node();
			//set the data
			item.setData(data);
			//if head, tail, and curr is null
			if (head == null && tail == null && curr == null) 
			{
				//set them all equal to the new node
				head = tail = curr = item;
			} 
			//if the link of tail is null and the link of curr is null
			else if (tail.getLink() == null && curr.getLink() == null) {
				//set the link of the curr element to item
				curr.setLink(item);
				//update the tail to the new item
				tail = item; 
				//update the curr to the item
				curr = item;
			} 
			//if inserting in the middle of the list
			else {
				//new node is equal to link of curr
				Node address = curr.getLink();
				//set the link of curr to the new item
				curr.setLink(item);
				//set the link of item to the address
				item.setLink(address);
				//if the curr element is tail
				if (curr == tail) {
					//update the tail to the new item
					tail = item; 
				}
				//set curr to item
				curr = item;
			}
			//increment num_items
			num_items++;
		}
	}

	// removes the current element (collapsing the list)
	// this should not be possible for an empty list. If possible,
	// following element becomes new current element.
	public void Remove() {
		//if not empty
		if (!IsEmpty()) {
			//if curr is equal to tail
			if (curr == tail) {
				//if curr is head
				if (curr == head) {
					//set head, tail, and curr to null
					head = tail = curr = null;
				} 
				else {
					//set prev to head
					Node prev = head;
					//while the link of prev is not curr
					while (prev.getLink() != curr) {
						//get the link
						prev = prev.getLink();
					}
					//remove the item by setting the link of the item before it to null
					prev.setLink(null);
					//update tail to prev
					tail = prev;
					//set curr to prev
					curr = prev;
				}
			} 
			//if curr is head
			else if (curr == head) {
				//make a new node that is the link of head
				Node nextElement = head.getLink();
				//set the link of head to null
				head.setLink(null);
				//make the new head the new node
				head = nextElement;
				//make the new curr the new node
				curr = nextElement;
			} 
			else {
				//set a node equal to prev
				Node prev = head;
				//while the link is not curr
				while (prev.getLink() != curr) {
					//get the link
					prev = prev.getLink();
				}
				//set node next to link of curr element
				Node next = curr.getLink();
				//set the link of previous to next (removing the specified element)
				prev.setLink(next);
				//update curr to next
				curr = next;
			}
			//decrement
			num_items--;
		}
	}


	// replaces the value of the current element with the specified value
	// this should not be possible for an empty list
	public void Replace(int data)
	{
		//if not empty
		if(!IsEmpty()){
			//set the data of the curr element
			curr.setData(data);
		}
	}

	// returns if the list is empty
	public boolean IsEmpty()
	{
		//if head, tail, and curr is null then its empty
		return (head == null && tail == null && curr == null);
	
	}

	// returns if the list is full
	public boolean IsFull()
	{
		//if the num of items is less than the max size
		return ( num_items>= MAX_SIZE);
	}

	// returns if two lists are equal (by value)
	public boolean Equals(List l)
	{
		//if the size of the current list is not equal to the size of the inputted list
		if (this.GetSize() != l.GetSize()) {
			//its not equal
			return false;
		}
		//temporary variable for the head node of this list
		Node thisCurrent = this.head; 
		//temporary variable for the head node of the other list
		Node lCurrent = l.head;       
	
		//while the heads are not null
		while (thisCurrent != null && lCurrent != null) 
		{
			//if the data is not equal in the two lists
			if (thisCurrent.getData() != lCurrent.getData()) 
			{
				//its not equal
				return false;
			}
			//get the links of the each list
			thisCurrent = thisCurrent.getLink();
			lCurrent = lCurrent.getLink();
		}
		
		//if it ends at the same time, then its equal
		return thisCurrent == null && lCurrent == null;
	}

	// returns the concatenation of two lists
	// l should not be modified
	// l should be concatenated to the end of *this
	// the returned list should not exceed MAX_SIZE elements
	// the last element of the new list is the current
	public List Add(List l)
	{
		//make a new list for the result that takes the current list as its input
		List result = new List(this);
		//get the head of the inputted list
		Node current = l.head;
		//while i is less than the size of l
		for (int i = 0; i < l.GetSize(); i++){
			//insert the data at that node into the result
			result.InsertAfter(current.getData());
			//get the link
			current = current.getLink();
		}
		//return result
		return result;
	}

	// returns a string representation of the entire list (e.g., 1 2 3 4 5)
	// the string "NULL" should be returned for an empty list
	public String toString()
	{	
		//if empty
		if (IsEmpty()){
			//return null
			return "NULL";
		}
		//make a string
		String result = "";
		//make a new node equal to head of current list
		Node current = head;
		//while the current is not null
		while (current != null) {
			//add data of the current node to the result
    		result += current.getData() + " ";
			//get the link
    		current = current.getLink();
		}
		//return the result
		return result;
	}
	
}
