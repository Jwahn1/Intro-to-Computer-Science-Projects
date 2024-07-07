public class Problem1 {
    public static void main(String [] args) {

//        int factorialSize = 4;
//        BinaryTree tree = new BinaryTree(factorialSize);//we're getting the factorial of 7
//        Node current = tree.getRoot();
//        Node right = null;
//        Node left = null;
//
//
//
//        for(int i = 0; i<3 ; i++){
//            left = new Node(1);
//            right = new Node(0);
//            tree.addNode(current,0,0);
//            current = current.getLeft();
//        }


        BinaryTree tree = new BinaryTree(7);//we're getting the factorial of 7
        tree.factorialTree(tree.getRoot(),tree);
        int i = factorial(tree.getRoot(),tree);
        int j = tree.getSize(tree.getRoot());
        int k = tree.getHeight(tree.getRoot());
        System.out.println(i+"\n"+j+"\n"+k);

    }

    public static int factorial(Node current,BinaryTree tree){
        int factorial = current.getValue();
        if(current.getLeft() == null || current.getRight() == null){
            return factorial*1;
        }else{
            factorial = factorial*factorial(current.getRight(),tree);
        }
        return factorial;
    }


}

