package LeetCode;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] ar) {
        String test = "/../";
        System.out.println(simplifyPath(test));
    }


    public static String simplifyPath(String str) {
        String res = "";
        Stack<String> s = new Stack<>();
        String[] arr = str.split("/");
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].isEmpty()) {
                if (arr[i].equals("..")) {
                    if (!s.isEmpty()) {
                        s.pop();
                    }
                } else if (!arr[i].equals(".")) {
                    s.push(arr[i]);
                }
            }
        }
        if(s.isEmpty()){
            return "/";
        }
        for (String obj : s) {
            res += "/" + obj;
        }
        return res;
    }
}
