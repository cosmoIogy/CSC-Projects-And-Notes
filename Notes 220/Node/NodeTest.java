class NodeTest {
    public static void main(String[] args) {

        int[] values = {1,2,3,4,5,6,7,8,9};
        
        BinaryTreeNode head = buildBackwards(values);        

        // curr = new Node();

        // //create a node
        // Node n = new Node();
        // System.out.println(n);
        // n.setData(5);
        // System.out.println(n);

        // Node p = new Node();
        // p.setData(10);
        
        // //set the link portion of the n node to p thereby linking them
        // p.setLink(p);

        // //change the data portion of the second node
        // p.setData(15);

        // p = new Node();
        // n.getLink().setLink(p);

        // p.setLink(new Node());
        // p.getLink().setData(100);

        //print the linked list
        //printList(head);
        printRList(head);

    }

    public static BinaryTreeNode buildBackwards(int[] values){
        BinaryTreeNode head = null, curr;
        int count = values.length;

        while(count > 0){
            curr = new BinaryTreeNode();
            curr.setData(values[count - 1]);
            curr.setLink(head);
            head = curr;

            count--;
        }
        return head;
    }

    public static void printList(BinaryTreeNode temp){
        while (temp != null){
            System.out.print(temp);
            temp = temp.getLink();
        }
        System.out.println();
    }

    public static void printRList(BinaryTreeNode temp){
        //base case
        if (temp == null){
            System.out.println();
        }

        //general case
        System.out.print(temp.getData() + "-->");
        printRList(temp.getLink());
    }
}
