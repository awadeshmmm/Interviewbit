import java.util.Deque;
import java.util.LinkedList;

public class TestClass {
    public static void main(String[] args) {
        System.out.println("hello world");
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        maxElement(arr, arr.length, k);
    }

    private static void maxElement(int[] arr, int n, int k) {
        Deque<Integer> q = new LinkedList<Integer>();
        int i;
        for (i = 0; i < k; i++) {
            while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
        }


        for (; i < n; i++) {
            System.out.print(arr[q.peek()] + " ");
            while ((!q.isEmpty()) && q.peek() <= i - k)
                q.removeFirst();

            while ((!q.isEmpty()) && arr[i] >= arr[q.peekLast()])
                q.removeLast();

            q.addLast(i);

        }

        System.out.print(arr[q.peek()] + " ");
    }
}
