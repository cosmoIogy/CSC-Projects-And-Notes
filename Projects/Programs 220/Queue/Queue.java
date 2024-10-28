/* ***************************************************
 * <Blair Bourque>
 * <10/25/24>
 * <Stack.java>
 *
 * <A file that has methods that will build a queue>
 *************************************************** */

 public class Queue<grant> {
    private List<grant> list;

    // Default constructor initializes an empty list
    public Queue() {
        list = new List<>();
    }

    // Copy constructor initializes this queue as a clone of another queue
    public Queue(Queue<grant> q) {
        list = new List<>(q.list);
    }

    // Insert an item at the end of the queue
    public void Enqueue(grant item) {
        list.Last();        // Move to the end of the list
        list.InsertAfter(item); // Insert after the last element
    }

    // Delete an item from the beginning of the queue and return it
    public grant Dequeue() {
        list.First();          // Move to the start of the list
        grant item = list.GetValue(); // Get the value at the head
        list.Remove();         // Remove the item from the list
        return item;
    }

    // Return (but do not delete) the item at the beginning of the queue
    public grant Peek() {
        list.First();           // Move to the start of the list
        return list.GetValue(); // Return the value at the head
    }

    // Return the size of the queue
    public int Size() {
        return list.GetSize();  // Use List's size method
    }

    // Return whether the queue is empty
    public boolean IsEmpty() {
        return list.IsEmpty();  // Check if the list is empty
    }

    // Return whether the queue is full
    public boolean IsFull() {
        return list.IsFull();   // Check if the list has reached max size
    }

    // Compare two queues
    public boolean Equals(Queue<grant> q) {
        return list.Equals(q.list); // Use List's equality method
    }

    // Concatenate two queues
    public Queue<grant> Add(Queue<grant> q) {
        Queue<grant> result = new Queue<>();
        result.list = list.Add(q.list); // Concatenate the lists and assign
        return result;
    }

    // Return a string representation of the queue
    public String toString() {
        return list.toString(); // Use List's toString method
    }
}