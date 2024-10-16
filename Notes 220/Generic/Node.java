class Node{
    private grant data;
    private Node link;

    public Node(){
        this.data = null;
        this.link = null;
    }
    //accessor and mutators
    public void setData(grant data){
        this.data = data;
    }

    public grant getData(){
        return this.data;
    }
}

class NodeTest{
    public static void main(String[] args) {
        Node<Integer> a = new Node<Integer>();
        Node<Character> b = new Node<Character>();

        a.setData(5);
        b.setData('6');
    }
}