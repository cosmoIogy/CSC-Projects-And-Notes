public class LinkedListWorksheet {
    public static void main(String[] args){
        Node n = new Node();
        n.setData(5);
        System.out.println(n);

        Node p = new Node();
        p.setData(10);

        n.setLink(p);
        System.out.println(p);
        
        Node temp = p.getLink();
        p.setLink(temp);

        for(int i = 15;i<=40;i+=5){
            temp.setLink(new Node());
            temp.setData(i);
            System.out.print(temp);   
        
        printList(n);
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
