public class Node {
    private int data;
    private Node link;

    //constructor
    public Node(){
        data = 0;
        link = null;
    }

    //accessros and mutators

    public void setData(int data){
        this.data = data;
    }

    public void setLink(Node link){
        this.link = link;
    }


    public int getData(){
        return this.data;
    }

    public Node getLink(){
        return this.link;
    }

    //a toString function incase we want to print the node
    public String toString(){
        return "" + this.data + "-->";
    }



}


