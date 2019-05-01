package LeetCode;

import java.util.*;

public class Anagrams {

    public static void main(String[] args) {

    }


    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {


        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

        Map<String, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {

            char[] temp = a.get(i).toCharArray();

            Arrays.sort(temp);

            String str = String.valueOf(temp);

            if (map.containsKey(str)) {
                map.get(str).add(i + 1);
            } else {
                ArrayList<Integer> list = new ArrayList<>();

                list.add(i + 1);

                map.put(str, list);
            }

        }

        for (ArrayList<Integer> arr1 : map.values()) {
            arr.add(arr1);
        }
        return arr;
    }
}
