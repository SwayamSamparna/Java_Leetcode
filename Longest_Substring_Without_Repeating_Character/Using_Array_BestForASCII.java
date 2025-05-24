// TC: O(n) SC: O(128) = O(1)
public class Using_Array_BestForASCII {
    public static int lengthOfLongestSubstring(String s){
        int[] index = new int[128];
        int maxLen = 0;
        for(int left =0, right=0; right<s.length(); right++){
            char ch = s.charAt(right);
            left = Math.max(index[ch], left);
            maxLen = Math.max(maxLen, right-left+1);
            index[ch] = right + 1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        int res = lengthOfLongestSubstring(input);
        System.out.println("Length of longest substring without repeating characters: " +  res);
    }
}
