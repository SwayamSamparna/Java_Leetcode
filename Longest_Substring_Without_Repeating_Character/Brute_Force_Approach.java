//TC: O(n^3) SC: O(min(n,m))
import java.util.HashSet;
import java.util.Set;

public class Brute_Force_Approach {
    public static int lengthOfLongestSubstring(String s){
        int maxLen = 0;
        for(int i=0; i < s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(allUnique(s,i,j)){
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }

    public static boolean allUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for(int i = start; i<=end; i++){
            if(!set.add(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        int res = lengthOfLongestSubstring(input);
        System.out.println("Length of longest substring without repeating characters: " +  res);
    }
}
