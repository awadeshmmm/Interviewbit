package LeetCode;

public class PathSum {

    public static void main(String[] ar) {
        PathSum.TreeNode node = new PathSum.TreeNode(5);
        System.out.println(hasPathSum(node, 5));
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

    public static int hasPathSum(TreeNode node, int n) {
        if (node == null || n < 0) {
            return 0;
        }
        int value = n - node.val;
        if (value == 0) {
            return 1;
        }

        if (hasPathSum(node.left, value) == 1 || hasPathSum(node.right, value) == 1) {
            return 1;
        }
        return 0;

    }
}
