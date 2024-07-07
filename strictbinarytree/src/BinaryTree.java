
public class BinaryTree {

    private Node Root;


    public BinaryTree(int value){
        Root = new Node(value);
    }

    public Node getRoot() {
        return Root;
    }

    public void addNode(Node current,int valueLeft,int valueRight){
        Node left = new Node(valueLeft);
        Node right = new Node(valueRight);

        current.setLeft(left);
        current.setRight(right);
    }
    public  void factorialTree(Node current, BinaryTree tree) {
        int factorial = current.getValue();
        if(factorial == 2){
            Node left = new Node(1);
            Node right = new Node(1);
            current.setLeft(left);
            current.setRight(right);
            factorialTree(left,tree);
            factorialTree(right,tree);
        }else if(factorial >=3 ){
            Node left = new Node(factorial-2);
            Node right = new Node(factorial-1);
            current.setLeft(left);
            current.setRight(right);
            factorialTree(left,tree);
            factorialTree(right,tree);
        }
    }

    public int getHeight(Node Current){
        int height = 0;
       if(Current.getLeft() == null &&  Current.getRight() == null){
           return 0;
       }
      return height += Math.max(getHeight(Current.getLeft()),getHeight(Current.getRight()))+1;

    }
    public int getSize(Node Current){
        if(Current == null){
            return 0;
        }
        return getSize(Current.getLeft())+ getSize(Current.getRight()) + 1;
    }


}
