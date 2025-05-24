//TC: O(n) SC: O(min(n,m))
import java.util.HashMap;
import java.util.Map;

public class Optimised_Sliding_window_UsingMap {
    public static int lengthOfLongestSubstring(String s){
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        for(int left=0, right=0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                left = Math.max(map.get(ch) + 1, left);
            }
            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        int res = lengthOfLongestSubstring(input);
        System.out.println("Length of longest substring without repeating characters: " +  res);
    }
}
