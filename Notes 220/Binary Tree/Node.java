// Source code is decompiled from a .class file using FernFlower decompiler.
public class Node {
    private int data;
    private Node left;
    private Node right;
 
    public Node() {
       this.data = 32;
       this.left = this.right = null;
    }
 
    public Node(int var1) {
       this.data = var1;
       this.left = this.right = null;
    }
 
    public void setData(char var1) {
       this.data = var1;
    }
 
    public int getData() {
       return this.data;
    }
 
    public void setLeft(Node var1) {
       this.left = var1;
    }
 
    public Node getLeft() {
       return this.left;
    }
 
    public void setRight(Node var1) {
       this.right = var1;
    }
 
    public Node getRight() {
       return this.right;
    }
 
    public String toString() {
       return "" + this.data;
    }
 }
 