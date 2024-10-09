class NodeTest {
    public static void main(String[] args) {

        int[] values = {1,2,3,4,5,6,7,8,9};
        
        Node head = buildBackwards(values);
    
        }

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
        printList(head)

    public static Node buildBackwards(int[] array){
        Node head = null, curr;
        int count = array.length;

        while(count > 0){
            curr = new Node();
            curr.setData(values[count - 1]);
            curr.setLink(head);
            head = curr;

            count--;
    }
    }


    public static void printList(Node temp){
        while (temp != null){
            System.out.print(temp);
            temp = temp.getLink();
        }
        System.out.println();
    }
}
