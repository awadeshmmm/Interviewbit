package LeetCode;

public class DuplicateNumber {
    public static void main(String[] ar) {
        int arr[] = new int[]{1, 2, 3, 4, 2};
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {

        int a = 1;
        for (int i = 0; i < nums.length; i++) {
            a = a ^ nums[i];
        }
        return a;
    }
}
