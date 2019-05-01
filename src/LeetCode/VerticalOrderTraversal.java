package LeetCode;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        VerticalOrderTraversal.Node node = new VerticalOrderTraversal.Node();
        printVerticalOrder(node);
    }

    private static void printVerticalOrder(Node node) {
        TreeMap<Integer, Vector<Integer>> map = new TreeMap<>();
        int hd = 0;
        getVerticalOrder(node, hd, map);
        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Vector<Integer>> entry : map.entrySet())
        {
            ArrayList<Integer> arr = new ArrayList<>(entry.getValue());
        }
    }

    private static void getVerticalOrder(Node node, int hd, TreeMap<Integer, Vector<Integer>> map) {
        if (node == null) {
            return;
        }
        Vector<Integer> vector = map.get(hd);
        if (vector == null) {
            vector = new Vector<>();
            vector.add(node.val);
        } else {
            vector.add(node.val);
        }
        map.put(hd, vector);
        getVerticalOrder(node.left, hd - 1, map);
        getVerticalOrder(node.right, hd + 1, map);
    }

    static class Node {
        int val;
        Node left, right;
    }

}
