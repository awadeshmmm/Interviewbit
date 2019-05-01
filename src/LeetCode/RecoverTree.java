package LeetCode;

import java.util.ArrayList;

public class RecoverTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
         node.right = new TreeNode(2);
         node.right.right = new TreeNode(3);

         System.out.println(minDepth(node));

        // System.out.println(recoverTree(node));
    }

    private static int minDepth(TreeNode node) {
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null){
            return 1;
        }

        if(node.left == null){
            return minDepth(node.right) + 1;
        }

        if(node.right == null){
           return  minDepth(node.left) + 1;
        }

        return 1 + Math.min(minDepth(node.left),minDepth(node.right));
    }

    public static ArrayList<Integer> recoverTree(TreeNode A) {

        ArrayList<Integer> arr = new ArrayList<>();



        Data data = new Data();
        data.data = Integer.MIN_VALUE;

        findElements(A, arr,data);

        return arr;
    }

    private static void findElements(TreeNode node, ArrayList<Integer> arr, Data prev) {

        if (node == null) {
            return;
        }

        findElements(node.left, arr, prev);

        if (prev.data == Integer.MIN_VALUE) {

           // prev = new Data();
            prev.data = node.val;
        } else {
            if (prev.data > node.val) {

                if (arr.size() != 2) {
                    arr.add(prev.data);
                    arr.add(node.val);
                } else {
                    arr.add(1, node.val);
                }

            }

            prev.data = node.val;
        }

        findElements(node.right, arr, prev);


    }

    static class TreeNode {
        int val;
        RecoverTree.TreeNode left;
        RecoverTree.TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    static class Data {
        int data;
    }
}
