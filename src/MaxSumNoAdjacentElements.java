import java.util.HashMap;
import java.util.Map;

public class MaxSumNoAdjacentElements {

    public static void main(String[] ar) {
        int[] arr = new int[]{5, 5, 10, 100, 10, 5};
        int sum = findMaxSum(arr);
        System.out.println(sum);
        Map map = new HashMap<>();
    }

    private static int findMaxSum(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return -1;
        }
        int incl_sum = arr[0];
        int excl_sum = 0;
        int excl_new;
        for (int i = 1; i < n; i++) {
            excl_new = Math.max(incl_sum, excl_sum);
            incl_sum = excl_sum + arr[i];
            excl_sum = excl_new;
        }
        return Math.max(incl_sum, excl_sum);
    }
}
