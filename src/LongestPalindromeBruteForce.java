public class LongestPalindromeBruteForce {

    public static void main(String[] ar) {
        String s = "bananghjfgfhgdhgdfhdaaaaaa";
        String palin = "";
        int maxcount = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isSubString(sub) && sub.length() > maxcount) {
                    palin = sub;
                    maxcount = sub.length();
                }
            }
        }
        System.out.println(palin);
        usingDp(s);
    }

    private static void usingDp(String s) {
        int n = s.length();
        boolean[][] arr = new boolean[n][n];
        int maxlen = 1;
        int start = 0;
        for (int i = 0; i < n; i++) {
            arr[i][i] = true;
            start = i;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                arr[i][i + 1] = true;
                start = i;
                maxlen = 2;
            }
        }
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (arr[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    arr[i][j] = true;
                    if (k > maxlen) {
                        maxlen = k;
                        start = i;
                    }
                }
            }
        }
        System.out.println(s.substring(start, start + maxlen));

    }

    private static boolean isSubString(String sub) {
        int l = 0;
        int h = sub.length() - 1;
        while (h > l) {
            if (sub.charAt(l) != sub.charAt(h)) {
                return false;
            }
            h--;
            l++;
        }
        return true;
    }
}
