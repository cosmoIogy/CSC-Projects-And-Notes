class NodeTest {
    public static void main(String[] args) {
        //create a node
        Node n = new Node();
        System.out.println(n);
        n.setData(5);
        System.out.println(n);

        Node p = new Node();
        p.setData(10);
        
        //set the link portion of the n node to p thereby linking them
        n.setLink(p);

        //change the data portion of the second node
        p.setData(15);

        p = new Node();
        n.getLink().setLink(p);

        p.setLink(new Node());
        p.getLink().setData(100);

        //print the linked list
        printList(n);
    }
    public static void printList(Node temp){
        while (temp != null){
            System.out.print(temp);
            temp = temp.getLink();
        }
        System.out.println();
    }
}
