package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class HotelReviews {

    public static void main(String [] ar){
        String A = "cool_ice_wifi_l...";
        ArrayList<String> B = new ArrayList<>(Arrays.asList("c_w_i", "water_is_cool", "cold_ice_drink", "i_w_c_l", "cool_wifi_speed"));
        System.out.println(solve(A,B));
    }

    public static ArrayList<Integer> solve(String A, ArrayList<String> B) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        final HashSet<String> goodWords = new HashSet<String>(Arrays.asList(A.split("_")));
        for(int i=0;i<B.size();i++){
            result.add(i);
        }

        Collections.sort(result, (a, b)->{
            int a_count = 0;
            int b_count = 0;

            for(String a_w: B.get(a).split("_")){
                if(goodWords.contains(a_w)){
                    a_count++;
                }
            }

            for(String b_w: B.get(b).split("_")){
                if(goodWords.contains(b_w)){
                    b_count++;
                }
            }
            return b_count - a_count;

        });
        return result;
    }
}
