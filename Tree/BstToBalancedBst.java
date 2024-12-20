package Tree;

import java.util.ArrayList;
import java.util.List;

public class BstToBalancedBst {
    
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        /*
         *         10
         *        /  \
         *       5     15  
         *     /         \
         *    2           20
         *   /
         *  1
         */

        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(2);
        root.left.left.left = new Node(1);

        root.right = new Node(15);
        root.right.right = new Node(20);

        Node balancedRoot = balanceBst(root);
        System.out.println(balancedRoot.data);
        printInorder(balancedRoot);
    }

    private static Node balanceBst(Node root) {
        List<Integer> inorderVals = new ArrayList<>();

        inorder(root, inorderVals);

        return buildBalanceBst(inorderVals, 0, inorderVals.size() - 1);
    }

    private static void inorder(Node root, List<Integer> inorderVals) {
        if(root == null) {
            return;
        }
        inorder(root.left, inorderVals);
        inorderVals.add(root.data);
        inorder(root.right, inorderVals);
    }

    private static Node buildBalanceBst(List<Integer> inorderVals, int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(inorderVals.get(mid));
        root.left = buildBalanceBst(inorderVals, start, mid - 1);
        root.right = buildBalanceBst(inorderVals, mid + 1, end);
        return root;
    }

    private static void printInorder(Node root) {
        if(root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

}
