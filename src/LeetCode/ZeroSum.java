package LeetCode;

import java.util.*;

public class ZeroSum {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(-2);
        l1.add(4);
        l1.add(-4);
        System.out.println(lszero(l1));

        ArrayList<ArrayList<Integer>> B = null;

    }


    public static ArrayList<Integer> lszero(ArrayList<Integer> A) {

        int start = -1;
        int end = -1;
        int maxlength = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        ArrayList<Integer> ans = new ArrayList<Integer>();

        int sum = 0;
        map.put(0,-1);

        for(int i = 0; i<A.size();i++){
            sum += A.get(i);

            if(map.containsKey(sum)){
                if(maxlength < i-map.get(sum)){
                    start = map.get(sum) +1;
                    end = i;
                    maxlength = i-map.get(sum);
                }
            }else{
                map.put(sum,i);
            }

        }
        if(start != -1 && end != -1){

            for(int i = start; i<= end;i++){
                ans.add(A.get(i));
            }
        }

        return ans;
    }
}
