/* ***************************************************
 * <your name> Blair Bourque
 * <the date> October 8, 2024
 * <the file name> List.java
 *
 * <a simple, short program/class description>
 * My implementation of linked list
 *************************************************** */

// the Node class
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

	private Node tempNode;
	private int tempInt;

	// constructor
	// remember that an empty list has a "size" of 0 and its "position" is at -1
	public List()
	{
		head = new Node();
		tail = new Node();
		curr = new Node();
		tempNode = new Node();
		num_items = 0;
	}

	// copy constructor
	// clones the list l and sets the last element as the current
	public List(List l)
	{
		head = new Node();
        tail = new Node();
        curr = new Node();
        tempNode = new Node();
        num_items = 0;
        Node current = l.head;
        while (current != null && num_items < MAX_SIZE) 
        {
            InsertAfter(current.getData());
            current = current.getLink();
        }
        Last();
	}

	// navigates to the beginning of the list
	public void First()
	{
		curr = head;
	}

	// navigates to the end of the list
	// the end of the list is at the last valid item in the list
	public void Last()
	{
		curr = tail;
	}

	// navigates to the specified element (0-index)
	// this should not be possible for an empty list
	// this should not be possible for invalid positions
	public void SetPos(int pos)
	{
		if(!IsEmpty())
		{
			if ((pos <= num_items) && (pos >= 0))
				curr = head;
				for (int i = 0; i < pos; i++)
				{
					curr = curr.getLink();
				}
		}
	}

	// Navigates to the previous element
	// This should not be possible for an empty list
	// There should be no wrap-around
	public void Prev() {
    if (IsEmpty() || curr == head) {
        // No previous node if the list is empty or we're at the head
        return;
    }

    Node prevNode = head;

    // Find the node just before the current one
    while (prevNode.getLink() != curr) {
        prevNode = prevNode.getLink();
    }

    // Set curr to the previous node
    curr = prevNode;
}

	// navigates to the next element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Next()
	{
		if(curr != null)
			curr = curr.getLink();
	}

	// returns the location of the current element (or -1)
	public int GetPos()
	{
		if (curr == null) {
			return -1;  // If the current node is null, return -1
		}

		tempInt = 0;
		tempNode = head;  // Start at the head of the list
		
		// Traverse through the list to find the position of curr
		while (tempNode != null && tempNode != curr) {
			tempNode = tempNode.getLink();
			tempInt++;
		}
	
		// If we’ve traversed the whole list and didn’t find curr, return -1
		if (tempNode == null) {
			return -1;
		}
	
		return tempInt;
	}

	// returns the value of the current element (or -1)
	public int GetValue()
	{
		if (curr == null )
			return -1;
		else
			return curr.getData();
	}

	// returns the size of the list
	// size does not imply capacity
	public int GetSize()
	{
		return(num_items);
	}

	// inserts an item before the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertBefore(int data)
	{
		if (!IsFull())
		{
			// Create a new node for insertion
			tempNode = new Node();
			tempNode.setData(data);
	
			// If the list is empty, simply insert at the head
			if (IsEmpty())
			{
				tempNode.setLink(null);  // New node will have no link, it's the only element
				head = tempNode;
				tail = tempNode;  // Since there's only one node, it is both head and tail
			}
			else if (curr == head)
			{
				// If inserting before the head, adjust the head pointer
				tempNode.setLink(head);
				head = tempNode;
			}
			else
			{
				// Find the previous node and insert the new node before the current node
				Node prev = head;
				while (prev.getLink() != curr)
				{
					prev = prev.getLink();
				}
				prev.setLink(tempNode);
				tempNode.setLink(curr);
			}
			
			num_items++;
			curr = tempNode;  // The new node becomes the current node
		}
	}

	// inserts an item after the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertAfter(int data){
	if (!IsFull())
    {
        // Create a new node for insertion
        tempNode = new Node();
        tempNode.setData(data);

        // If the list is empty, insert as the head and tail
        if (IsEmpty())
        {
            head = tempNode;
            tail = tempNode;  // Since there's only one node, it's both head and tail
        }
        else if (curr == tail)
        {
            // If inserting after the tail, adjust the tail pointer
            tail.setLink(tempNode);
            tail = tempNode;
        }
        else
        {
            // Insert the new node after the current node
            tempNode.setLink(curr.getLink());
            curr.setLink(tempNode);
        }

        num_items++;
        curr = tempNode;  // The new node becomes the current node
		}
	}



	// Removes the current element (collapsing the list)
	// This should not be possible for an empty list. If possible,
	// the following element becomes the new current element.
	public void Remove() {
    if (IsEmpty() || curr == null) {
        // Cannot remove from an empty list or if current is null
        return;
    }

    // If removing the head
    if (curr == head) {
        head = head.getLink();  // Move head to the next element
        if (head == null) {
            // If the head becomes null, the list is empty
            tail = null;
        }
        curr = head;  // Set current to the new head
    } 

    // If removing any other node
    else {
        Node prevNode = head;
        // Find the node right before current
        while (prevNode.getLink() != curr) {
            prevNode = prevNode.getLink();
        }

        // Bypass the current node
        prevNode.setLink(curr.getLink());

        // If removing the tail node, update tail reference
        if (curr == tail) {
            tail = prevNode;
        }

		// Move curr to the next node after the removed one
		curr = prevNode.getLink();

    }

    // Decrement the size of the list
    num_items--;

    // If the list is now empty, reset head, tail, and curr
    if (num_items == 0) {
        head = null;
        tail = null;
        curr = null;
    }
}


	// replaces the value of the current element with the specified value
	// this should not be possible for an empty list
	public void Replace(int data)
	{
		if (!IsEmpty())
			curr.setData(data);
	}

	// returns if the list is empty
	public boolean IsEmpty()
	{
		return (num_items == 0);
	}

	// returns if the list is full
	public boolean IsFull()
	{
		return (num_items >= MAX_SIZE);
	}

	// Returns true if two lists are equal (by value)
	public boolean Equals(List l) {
    // Check for null references
    if (l == null) {
        return false;  // If the list to compare is null, they are not equal
    }
    
    // Check for size equality
    if (this.GetSize() != l.GetSize()) {
        return false;  // Lists of different sizes cannot be equal
    }

    Node tempNode = head;         // Start at the head of the first list
    Node tempNode2 = l.head;      // Start at the head of the second list

    // Traverse both lists simultaneously
    while (tempNode != null) {    // Loop until the end of the first list
        
		// Check if the current nodes' data are equal
        if (tempNode.getData() != (tempNode2.getData())) {
            return false;          // If data is not equal, return false
        }

        // Move to the next node in both lists
        tempNode = tempNode.getLink();
        tempNode2 = tempNode2.getLink();
    }

    return true;                  // All elements are equal if we reach this point
}



	// returns the concatenation of two lists
	// l should not be modified
	// l should be concatenated to the end of *this
	// the returned list should not exceed MAX_SIZE elements
	// the last element of the new list is the current
	public List Add(List l)
	{
		// Start by making the result a copy of "this"
		List result = new List(this);
		tempNode = l.head;
		while (tempNode != null && result.num_items < MAX_SIZE)
		{
			result.InsertAfter(tempNode.getData());
			tempNode = tempNode.getLink();
		}
		// return result
		return result;
	}

	// returns a string representation of the entire list (e.g., 1 2 3 4 5)
	// the string "NULL" should be returned for an empty list
	public String toString()
	{
		if (IsEmpty())
			return "NULL";
		String result = "";
        Node current = head;
        while (current != null) {
            result += current.getData() + " ";
            current = current.getLink();
        }
        return result.trim();
	}
}
