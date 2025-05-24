// TC : O(2n) = O(n) SC: O(min(n,m))
import java.util.HashSet;
import java.util.Set;

public class Sliding_Window_Approach_WithSet {
    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int left=0, right=0, maxLen= 0;
        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                maxLen = Math.max(maxLen, set.size());
            } else{
                set.remove(s.charAt(left++));
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        int res = lengthOfLongestSubstring(input);
        System.out.println("Length of longest substring without repeating characters: " +  res);
    }
}
