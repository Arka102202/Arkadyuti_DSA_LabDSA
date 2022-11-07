import java.util.HashSet;

public class FindPairWithGivenSum {
    static Node root = null;
    static int a = -1;
    static HashSet<Integer> set = new HashSet<>();
    static Node createBST(int val, Node node){
        if (node == null) node = new Node(val);
        else {
            if (val < node.val) node.left = createBST(val, node.left);
            if (val > node.val) node.right = createBST(val,node.right);
        }
        return node;
    }
    static boolean hasPair(Node node, int val){
        if (node != null){
            if (!set.add(node.val)) {
                a = val - node.val;
                return true;
            }
            set.add(val - node.val);
            return hasPair(node.left, val) || hasPair(node.right, val);
        }
        return false;
    }

    public static void main(String[] args) {

        root = createBST(40,root);
        root = createBST(20,root);
        root = createBST(60,root);
        root = createBST(10,root);
        root = createBST(30,root);
        root = createBST(50,root);
        root = createBST(70,root);
        int input = 130;
        if (hasPair(root,input))
            System.out.println(a + "," + (input - a));
        else System.out.println("the pair is not present");

        input = 60;
        if (hasPair(root,input))
            System.out.println(a + "," + (input - a));
        else System.out.println("the pair is not present");

        input = 50;
        if (hasPair(root,input))
            System.out.println(a + "," + (input - a));
        else System.out.println("the pair is not present");


    }
    static class Node{
        int val;
        Node left,right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
