public class BinaryTreeNode {
    private char data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(){
        data = ' ';
        left = right = null;
    }

    public BinaryTreeNode(char data){
        this.data = data;
        left = right = null;
    }

    //accessor and mutators
    public void setData(char data){
        this.data = data;
    }

    public int getData(){
        return this.data;
    }

    public void setLeft(BinaryTreeNode binaryTreeNode){
        this.left = binaryTreeNode;
    }

    public BinaryTreeNode getLeft(){
        return this.left;
    }

    public void setRight(BinaryTreeNode binaryTreeNode){
        this.right = binaryTreeNode;
    }

    public BinaryTreeNode getRight(){
        return this.right;
    }

    public String toString(){
        return " " + "--> " + this.data;
    }
}
