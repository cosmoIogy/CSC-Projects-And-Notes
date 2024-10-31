/* ***************************************************************************
 * <Blair Bourque>
 * <10/29/24>
 * <Tree.java>
 *
 * <A program to manipulate/create a binary tree>
 * **************************************************************************/
class Tree
{
    private Node root;
    private int size;
    public static final int MAX_SIZE = 30;

    // Constructor. An empty tree has a size of 0.
    public Tree()
    {
        //set the root of a new tree to null
        root = null;
        //set size to 0
        size = 0;
    }

    // Copy constructor. Clones Tree t (i.e. its nodes, and its size)
    public Tree(Tree t)
    {
        //set the size of the new tree equal to the size of the input tree
        size = t.size;
        //recursively copy the root and its nodes
        root = mycopy(t.root);

    }

    // Private copy function that recursively copies Node a (along with
    // all its links, and returns that copy.
    private Node mycopy(Node a)
    {
       
        //if the node is not null
        if (a != null){
            //create a new node named copy with the same data as the input node
            Node copy = new Node(a.getData()); 

            //recursively copy the left and right subtrees 
            //by copying it from the ground up
            copy.setLeft(mycopy(a.getLeft()));
            copy.setRight(mycopy(a.getRight()));
            return copy;
        }
        else{
            //return null (for leafs with no left or right children)
            return null;
        }
        
    }

    // function that takes the key and calls the deleteKey function.
    // Should only work if the tree is not empty.
    public void Delete(int key)
    {
        //if it isn't empty
        if (!IsEmpty()){
            //recursively call the DeleteKey function with the root 
            //and the key you're trying to find
            root = DeleteKey(this.root, key);
            
        }
    }

    // private recursive function that takes a node, and the key to delete from
    // the subtrees attached to that node. It returns a copy of the tree
    // with the required node having been removed from the appropriate subtrees.
    private Node DeleteKey(Node a, int key) {
        //if a is null
        if (a == null) {
            //return null (key was not found :( )
            return a; 
        }
    
        //if the key is less than the data of the current node
        else if (key < a.getData()) {
            //set the left node of the current node of the result of the recursive function
            a.setLeft(DeleteKey(a.getLeft(), key));
            //return the tree
            return a;
        } 
        else if (key > a.getData()) {
            a.setRight(DeleteKey(a.getRight(), key));
            return a;
        } 
        
        //we have found the key in the tree

        //if the key has no left childen
        if (a.getLeft() == null) {

            //return the right child, 
            //which will replace the node of each node that was
            //in the call stack
            return a.getRight();
        } 

        //if the key has no right children
        else if (a.getRight() == null) {
            //return the left child of the key
            //which go back up the tree
            //and replace the node 
            //of each node in the call stack
            return a.getLeft();
        }
       
        //if the key has two children
        else {
            
            //set a new node called parent equal to the current node
            Node parent = a;
            //get the right child of the current node
            Node successor = a.getRight();
            //while the left child of the succ doesn't equal null
            while(successor.getLeft() != null)
            {
                //set parent equal to the successor
                parent = successor;
                //set the successor equal to the left node of the succ
                successor = successor.getLeft();
                
            }
            

            //if the parent is not equal current node
            //meaning that parent refernce changed to the left most node of the successor
            //and therefore you need to update the parents left child to the right children
            //of the succ
            if (parent != a)
            {
                //set the left child of the parent to the successors right child
                parent.setLeft(successor.getRight());
            }
            else
            //otherwise, the right child has no left child so you just set
            //the right child of the parent equal to the 
            //right child of the successor (to maintain the BST Structure)
                parent.setRight(successor.getRight());

            //set the data of the parent node equal to the data of the successor
            a.setData(successor.getData());
            //return the tree with the deleted key
            return a;
        }

    }
    

    // Private function to find the successor to a node. The successor
    // of a node in a binary tree is the node immediately larger than
    // the required node.
    private Node Successor(Node a)
    {      
        //if a is null
        if(a == null){
            return null;
        }

        //if there is a right subtree
        if(a.getRight() != null){
            Node current = a.getRight();
            while(current.getLeft() != null){
                current = current.getLeft();
            }
            return current;
        }

        // Case 2: No right subtree - start from the root
        Node successor = null;
        Node current = root;
        while (current != null) {
            if (a.getData() < current.getData()) {
                successor = current; // Update successor when moving left
                current = current.getLeft();
            } else if (a.getData() > current.getData()) {
                current = current.getRight();
            } else {
                break; // Node found
            }
        }
        return successor;
    }


    // Function to insert data into the tree in its appropriate location
    // by using the Add() recursive function. This should not be
    // possible for a tree that is already full. If the tree is empty,
    // then it does the insertion itself.
    public void Insert(int data)
    {
        //if the tree isn't full
        if (!IsFull()){
            //if the root is null
            if (root == null){
                //set the given node as the root
                root = new Node(data);
            }
            else{
                //recursively call the add function
                //to find where it belongs
                Add(data, root);
            }
        }
    }

    // Private recursive function that takes a Node attached to its own 
    // subtrees, and attaches the data to the tree in the proper location.
    private void Add(int data, Node a) {
        //if the data is greater than the current nodes data
        if (data > a.getData()) {
            //if the current node has no right children
            if (a.getRight() == null) {
                //set the right child of the current node equal to a new node with the given data
                a.setRight(new Node(data));
            } 
            else {
                //otherwise, call the function again but with the right child
                Add(data, a.getRight());
            }
        }
        //if the data is less than the current node data
        else if (data < a.getData()) {
            //if the current node has no left children
            if (a.getLeft() == null) {
                //set the left child of the current node equal to a new node with the given data
                a.setLeft(new Node(data));
            } 
            else {
                //otherwise, call the function again but with the left child of the current node
                Add(data, a.getLeft());
            }
        }
        //if the data is equal to the current node data
        else if( data == a.getData()){
            //if the current node has no left children
            if (a.getLeft() == null){
                //set the left child equal to a new node with the given data
                a.setLeft(new Node(data));
            }
            else{
                //otherwise, call the function again but with the left child of the current node
                Add(data, a.getLeft());
            }
        }
    }

    // function to return the size of the tree (i.e. the number of nodes
    // in the tree).
    public int Size() {
        //recursively call the size function to get the size
        return Size(root);
    }
    
    //private function that recurively calls itself to get the size
    private int Size(Node a) {
        //if the node is null
        if (a == null) {
            //return 0
            return 0;
        //otherwise,
        } else {
            //call the function again but add 1 for the root
            //call the function but with the left child 
            //it will create a call stack that goes all the way down and builds up the tree
            return 1 + Size(a.getLeft()) + Size(a.getRight());
        }
    }
    // Function to tell whether the tree is empty or not.
    public boolean IsEmpty()
    {
        //if there is a root
        if (root!= null){
            //return false
            return false;
        }
        //otherwise, return true
        return true;
    }

    // Function to tell whether the tree is full or not.
    public boolean IsFull(){
        //Get the size plus one and check if its greater than the max size
        return Size()+1 > MAX_SIZE;
        
    }

    // Function to return the InOrder traversal of the tree. It takes a
    // string as its argument, updates the string with the node
    // information, and then returns the updated string that should 
    // contain the inorder traversal of the tree.
    private String InOrder(Node a, String s) {
        //if the node is null
        if (a == null) {
            //return the string
            return s;
        }
        //set the string equal to the left most node first
        //it will go into a call stack and go up the tree to get the in order traversal
        s = InOrder(a.getLeft(), s);
        //add the root node
        s += a.toString() + " ";
        //get the right node of the current node and add it to the string
        s = InOrder(a.getRight(), s);
        
        //concatenate the results in the correct order and return.
        return s;
    }

    // Function to return the PreOrder traversal of the tree. It takes a
    // string as its argument, updates the string with the node
    // information, and then returns the updated string that should 
    // contain the preorder traversal of the tree.
    private String PreOrder(Node a, String s)
    {
        //if the current node is null
        if (a == null){
            //return the string
            return s;
        }

        else{
            //add the tree to the string
            s += a.toString() + " ";
            //get the left most node, and add it to the string
            //going up each time after the call stack is finished
            s = PreOrder(a.getLeft(), s);
            //get the right most node of the current node, 
            //goin up each time after the call stack is finished
            s = PreOrder(a.getRight(), s);

            //return the string
            return s;
        }
        
    }

    // Function to return the PostOrder traversal of the tree. It takes a
    // string as its argument, updates the string with the node
    // information, and then returns the updated string that should 
    // contain the postorder traversal of the tree.
    private String PostOrder(Node a, String s)
    {
        //if the current node is null
        if (a == null){
            //return the string
            return s;
        }

        else{
            //get the left most node, and add it to the string
            //going up each time after the call stack is finished
            s = PostOrder(a.getLeft(), s);
            //get the right most node of the current node, 
            //goin up each time after the call stack is finished
            s = PostOrder(a.getRight(), s);
            //add the tree to the string
            s+=a.toString() + " ";

            //return the string in the correct order
            return s;
        }
        
    }

    // A function that returns the maximum value in the tree. That value
    // is -1 for an empty tree.
    public int getMax(){
        //if the root is null
        if (root == null){
            //return -1;
            return -1;
        }
        else{
            //set a new node equal to the root
            Node tempRoot = root;
            //while the right child is not null
            while (tempRoot.getRight()!=null){
                //set temproot equal to the right child
                tempRoot = tempRoot.getRight();
            }
            //return the right most node
            return tempRoot.getData();
        }
    }

    // A function that returns the minimum value in the tree. That value
    // is -1 for an empty tree.
    public int getMin()
    {
        //if the root is null
        if (IsEmpty()){
            //return -1;
            return -1;
        }
        else{
            //set a new node equal to the root
            Node tempRoot = root;
            //while the root has a left child
            while (tempRoot.getLeft()!=null){
                //set temproot equal to the left child
                tempRoot = tempRoot.getLeft();
            }
            //return the min
            return tempRoot.getData();
        }
    }

    // A toString function that returns "NULL" if the tree is empty.
    // Otherwise, it returns the InOrder traversal of the tree.
    public String toString() {
        //if the tree is empty
        if (root == null) {
            //return NULL
            return "NULL";
        } else {
            // call the InOrder function with the root node.
            return InOrder(root, ""); 
        }
    }

    // A Print function that prints out the InOrder, PreOrder, and
    // PostOrder traversals of the tree (each one preceeded by the word
    // identifying what kind of traversal it is). It also calls the
    // private Print() function which prints out the tree sideways.
    public void Print()
    {
        //print out the inorder traversal with the root
        System.out.println("InOrder: " + InOrder(this.root,""));
        //print out the preorder traversal with the root
        System.out.println("PreOrder: " + PreOrder(this.root,""));
        //print out the postorder traversal with the root
        System.out.println("PostOrder: " + PostOrder(this.root,""));
        //print out the tree sideways
        Print(root, 0);
    }

    // A Print function that takes a node and an int to recursively print
    // out the tree sideways. The int "lev" determines how far away from
    // the root that particular node will be printed. (Refer to notes for 
    // details of this function).
    private void Print(Node n, int lev)
    {
        //while the node isn't null
        if (n != null){

            //go down the right subtree and increase
            Print(n.getRight(), lev+1); 
            //the number of tabs i'll have to make
            for (int i = 0; i < lev; i++)
                //print out the appropriate no. of tabs
                System.out.print("\t"); 
            //and the data, and move to next line
            System.out.println(n.getData());

            //go down the left subtree and increase tabs
            Print(n.getLeft(), lev+1); 
        }
    }

    

    // A function that returns if two trees are equal by value.
    public boolean Equals(Tree t)
    {

        //set two strings equals to the inorder for the current tree and the given tree
        String inorder = this.InOrder(this.root, "");
        String inorder2 = t.InOrder(t.root, "");

        //set two strings equals to the postorder for the current tree and the given tree
        String postorder = this.PostOrder(this.root, "");
        String postorder2 = t.PostOrder(t.root, "");

        //set two strings equals to the preorder for the current tree and the given tree
        String preorder = this.PreOrder(this.root, "");
        String preorder2 = t.PreOrder(t.root, "");
        

        //if their inorder, postorder, and preorder traversals are all equal
        if (inorder.equals(inorder2) && postorder.equals(postorder2) && preorder.equals(preorder2)){
            //return true
            return true;
        }
        //return false otherwise
       return false;
    }
}
