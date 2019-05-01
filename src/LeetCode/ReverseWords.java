package LeetCode;

import java.time.LocalDateTime;
import java.util.*;

public class ReverseWords {
    public static void main(String[] ar) {
        char[] arr = new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y'};
        reverseWords(arr);
        System.out.println(Arrays.toString(arr));


    }


    public static void reverseWords(char[] s) {
        int n = s.length - 1;

        int l = 0;
        while (l < n) {
            char temp = s[l];
            s[l] = s[n];
            s[n] = temp;
            l++;
            n--;
        }
        n = s.length - 1;
        l = 0;
        for (int i = 0; i <= n; i++) {
            if (s[i] == ' ' || i == n) {
                int high;
                if (i != n) {
                    high = i - 1;
                } else {
                    high = i;
                }
                int low = i - l;
                while (low < high) {
                    char temp = s[low];
                    s[low] = s[high];
                    s[high] = temp;
                    low++;
                    high--;
                }
                l = 0;
            } else {
                l++;
            }
        }
    }


    Map<Long, Long> count(Map<String, UserStats>... visits) {
        Map<Long, Long> map = new HashMap<>();
        for (Map<String, UserStats> mapPerService : visits) {
            try {
//                Set<String> set = mapPerService.keySet();
//                System.out.println("-----------" + set);
//                Iterator<String> it = set.iterator();
//                while (it.hasNext()) {
//                    String s = it.next();
//                    System.out.println("Key: "+ s + ", value: " + mapPerService.get(s));
//
//                    Long k = Long.parseLong(s);
//                    if(mapPerService.get(s).visitCount.isPresent()){
//                        Optional<Long> count = mapPerService.get(s).visitCount;
//                        if (!map.containsKey(k)) {
//                            map.put(k, count.get());
//                        } else {
//
//                            map.put(k, map.get(k) + count.get());
//                        }
//                    }
//
//                }


                for(Map.Entry<String, UserStats> entry: mapPerService.entrySet()){
                    String key = entry.getKey();
                    UserStats userStats = entry.getValue();
                    Long k = Long.parseLong(key);
                    if(mapPerService.get(key).visitCount.isPresent()){
                        Optional<Long> count = mapPerService.get(key).visitCount;
                        if (!map.containsKey(k)) {
                            map.put(k, count.get());
                        } else {

                            map.put(k, map.get(k) + count.get());
                        }
                    }
                }
            } catch (Exception e) {

            }

            System.out.println("-----------" + mapPerService.keySet());
            System.out.println("-----------" + mapPerService.keySet());

        }
        return map;
    }

    public class UserStats {
        public Optional<Long> visitCount;
    }
}
