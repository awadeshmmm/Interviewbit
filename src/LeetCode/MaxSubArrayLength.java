package LeetCode;

import java.util.HashMap;

public class MaxSubArrayLength {
    public static void main(String[] ar) {
        int[] arr = new int[]{-2, -1, 2, 1};
        int ans = maxSubArrayLen(arr, 1);
        System.out.println(ans);
    }


    public static int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) {
                maxLen = i + 1;
            }
            int diff = sum - k;
            if (map.containsKey(diff)) {
                maxLen = Math.max(maxLen, i-map.get(diff));;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;

//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//        int max = 0;
//
//        int sum=0;
//        for(int i=0; i<nums.length; i++){
//            sum += nums[i];
//
//            if(sum==k){
//                max = Math.max(max, i+1);
//            }
//
//            int diff = sum-k;
//
//            if(map.containsKey(diff)){
//                max = Math.max(max, i-map.get(diff));
//            }
//
//            if(!map.containsKey(sum)){
//                map.put(sum, i);
//            }
//        }
//
//
//        return max;
    }
}
