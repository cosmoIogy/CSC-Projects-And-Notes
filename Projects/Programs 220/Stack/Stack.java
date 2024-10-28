/* ***************************************************
 * <Blair Bourque>
 * <10/25/24>
 * <Stack.java>
 *
 * <A file that has methods that will build a stack>
 *************************************************** */
public class Stack<grant> {
    private List<grant> list;

    // Default constructor initializes an empty list
    public Stack() {
        list = new List<>();
    }

    // Copy constructor initializes this stack as a clone of another stack
    public Stack(Stack<grant> s) {
        list = new List<>(s.list);
    }

    // Insert an item at the top of the stack
    public void Push(grant item) {
        list.First();        // Move to the top of the list
        list.InsertBefore(item); // Insert after the last element
    }

    // Delete an item from the top of the stack and return it
    public grant Pop() {
        list.First();          // Move to the start of the list
        grant item = list.GetValue(); // Get the value at the head
        list.Remove();         // Remove the item from the list
        return item;
    }

    // Return (but do not delete) the item at the top of stack
    public grant Peek() {
        list.First();           // Move to the start of the list
        return list.GetValue(); // Return the value at the head
    }

    // Return the size of the stack
    public int Size() {
        return list.GetSize();  // Use List's size method
    }

    // Return whether the stack is empty
    public boolean IsEmpty() {
        return list.IsEmpty();  // Check if the list is empty
    }

    // Return whether the stack is full
    public boolean IsFull() {
        return list.IsFull();   // Check if the list has reached max size
    }

    // Compare two stacks
    public boolean Equals(Stack<grant> s) {
        return list.Equals(s.list); // Use List's equality method
    }

    // Concatenate two stacks
    public Stack<grant> Add(Stack<grant> s) {
        Stack<grant> result = new Stack<>();
        result.list = list.Add(s.list); // Concatenate the lists and assign
        return result;
    }

    // Return a string representation of the stack
    public String toString() {
        return list.toString(); // Use List's toString method
    }
}
