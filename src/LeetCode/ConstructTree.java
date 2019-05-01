package LeetCode;

import java.util.ArrayList;
import java.util.List;


public class ConstructTree {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);


        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(1);
        l2.add(3);


        TreeNode node = buildTree(l1, l2);

        printInorder(node);


    }

    private static void printInorder(TreeNode node) {
        if (node == null)
            return;


        System.out.print(node.val + " ");
        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */


        /* now recur on right child */
        printInorder(node.right);
    }


    public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {


        Index index = new Index();
        index.ind = 0;


        return buildTreeUtil(B, A, 0, A.size() - 1, index);
    }


    private static TreeNode buildTreeUtil(ArrayList<Integer> A, ArrayList<Integer> B, int start, int end, Index index) {
        if (start > end) {
            return null;
        }

        int mid = searchInorder(A, start, end, B.get(index.ind));

        TreeNode node = new TreeNode(B.get(index.ind));
//        if (start == end)
//            return node;
        (index.ind)++;


        node.left = buildTreeUtil(A, B, start, mid - 1, index);
        node.right = buildTreeUtil(A, B, mid + 1, end, index);


        return node;
    }


    private static int searchInorder(ArrayList<Integer> A, int start, int end, int data) {
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (A.get(i) == data) {
                index = i;
            }
        }
        return index;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    static class Index {
        int ind;
    }

    private void findElements(TreeNode node, ArrayList<Integer> arr, TreeNode prev) {

        if (node == null) {
            return;
        }

        findElements(node.left, arr, prev);

        if (prev == null) {
            prev = node;
        } else {
            if (prev.val > node.val) {

                if (arr.size() != 2) {
                    arr.add(0, prev.val);
                    arr.add(1, node.val);
                } else {
                    arr.add(1, node.val);
                }

            }

            prev = node;
        }

        findElements(node.right, arr, prev);


    }

}
