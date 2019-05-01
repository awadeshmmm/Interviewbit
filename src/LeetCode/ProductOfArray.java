package LeetCode;

import java.util.Arrays;

public class ProductOfArray {
    public static void main(String ar[]) {

//        Input:  [1,2,3,4]
//        Output: [24,12,8,6]
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));


    }

    public static int[] productExceptSelf(int[] nums) {
        int arr[] = new int[nums.length];
        int[] t1 = new int[nums.length];
        int[] t2 = new int[nums.length];

        t1[0] = 1;
        t2[nums.length - 1] = 1;

        //scan from left to right
        for (int i = 0; i < nums.length - 1; i++) {
            t1[i + 1] = nums[i] * t1[i];
        }

        //scan from right to left
        for (int i = nums.length - 1; i > 0; i--) {
            t2[i - 1] = t2[i] * nums[i];
        }

        //multiply
        for (int i = 0; i < nums.length; i++) {
            arr[i] = t1[i] * t2[i];
        }

        return arr;
    }
}
