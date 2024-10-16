public class TreeNodeTest{
    public static void main(String[] args) {
        //create the root
        BinaryTreeNode root = new BinaryTreeNode('A');

        //create the left subtree
        root.setLeft(new BinaryTreeNode ('B'));
        root.getLeft().setRight(new BinaryTreeNode('E'));
        root.getLeft().getLeft().setRight(new BinaryTreeNode('G'));

        //create the right subtree
        root.setRight(new BinaryTreeNode('C'));
        root.getRight().setRight(new BinaryTreeNode('F'));
        root.getRight().getRight().setLeft(new BinaryTreeNode('H'));

        
        inOrder(root);
        preOrder(root);
        postOrder(root);
    }

public static void inOrder(BinaryTreeNode node){

    if(node == null){
        return;
    }
    //inOrder(node.getLeft());
    //processing is printing
    System.out.print(node);
    //inOrder(node.getRight());
}

public static void preOrder(BinaryTreeNode root){

    if(root == null){
        return;
    }

    System.out.print(root);
    //inOrder(temp.getLeft());
    //inOrder(temp.getRight());
}

public static void postOrder(BinaryTreeNode temp){

    if(temp == null){
        return;
    }

    //inOrder(temp.getLeft());
    //inOrder(temp.getRight());
    System.out.print(temp);
    }
}
