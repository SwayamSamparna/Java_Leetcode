//TC: O(m*n) SC: O(m*n)
import java.util.HashMap;
import java.util.Map;

public class Top_Down_DP {
    static Map<String, Boolean> memo = new HashMap<>();
    public static boolean isMatch(String s, String p){
        return dp(0,0,s,p);
    }

    public static boolean dp(int i, int j, String s, String p){
        String key = i + ", " + j;
        if(memo.containsKey(key)) return memo.get(key);

        boolean ans;
        if(j==p.length()){
            ans = (i==s.length());
        } else {
            boolean firstMatch = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

            if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
                ans = dp(i, j+2, s, p) || (firstMatch && dp(i+1, j, s, p));
            } else {
                ans = firstMatch && dp(i+1, j+1, s, p);
            }
        }
        memo.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = ".*";
        System.out.println(isMatch(s, p));
    }
}
