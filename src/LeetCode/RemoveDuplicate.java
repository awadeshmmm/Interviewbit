package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(5000);
        list.add(5000);
        list.add(5000);
        removeDuplicates(list);

        String str = "pGpEusuCSWEaPOJmamlFAnIBgAJGtcJaMPFTLfUfkQKXeymydQsdWCTyEFjFgbSmknAmKYFHopWceEyCSumTyAFwhrLqQXbWnXSn";


        // System.out.println(removeDuplicates(list));
        System.out.println(solve(str));
    }

    public static int removeDuplicates(ArrayList<Integer> a) {

        int n = a.size();

        if (n == 0 || n == 1) {
            return n;
        }
        int j = 0;

        for (int i = 0; i < n - 1; i++) {
            if (!a.get(i).equals(a.get(i + 1))) {
                a.set(j, a.get(i));
                j = j + 1;
            }
        }
        a.set(j, a.get(n - 1));
        return j + 1;

    }


    public static int solve(String str) {
        int n = str.length();

        Set<String> set = new HashSet<>();
        int count = 0;




        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String s = str.substring(i, j);
                if (!set.contains(s) && (s.charAt(0) == 'A' || s.charAt(0) == 'B' || s.charAt(0) == 'C' || s.charAt(0) == 'D' || s.charAt(0) == 'E' || s.charAt(0) == 'a' || s.charAt(0) == 'b' || s.charAt(0) == 'c' || s.charAt(0) == 'd' || s.charAt(0) == 'e')) {
                    count = count + 1;
                    set.add(s);
                }
            }
        }
        return count ;
    }
}
