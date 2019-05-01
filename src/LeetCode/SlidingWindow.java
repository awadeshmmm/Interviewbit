package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindow {

    public static void main(String[] ar) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(10);
        l1.add(3);
        l1.add(4);
        l1.add(1);
        l1.add(0);
        l1.add(0);
        l1.add(1);
        l1.add(9);
        l1.add(1);
        System.out.println(slidingMaximum(l1, 3));

    }

    public static ArrayList<Integer> slidingMaximum(final List<Integer> arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && arr.get(i) >= arr.get(q.peekLast())) {
                q.removeLast();
            }

            q.addLast(i);
        }

        for (int i = k; i < arr.size(); i++) {
            res.add(arr.get(q.peek()));


            while (!q.isEmpty() && q.peek() <= i - k) {
                q.removeFirst();
            }

            while (!q.isEmpty() && arr.get(i) >= arr.get(q.peekLast())) {
                q.removeLast();
            }

            q.addLast(i);

        }

        res.add(arr.get(q.peek()));
        return res;
    }

}
