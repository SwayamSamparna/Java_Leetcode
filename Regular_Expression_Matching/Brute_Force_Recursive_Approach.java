//TC: O(2^(m+n)) SC : O(m+n)
public class Brute_Force_Recursive_Approach {
    public static boolean isMatch(String s, String p){
        if(p.isEmpty()) return s.isEmpty();
        boolean firstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if(p.length() >= 2 && p.charAt(1) == '*'){
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }    
    public static void main(String[] args) {
        String s = "aa";
        String p = ".*";
        System.out.println(isMatch(s, p)); // Output: true
    }
}