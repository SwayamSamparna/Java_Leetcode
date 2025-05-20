//TC: O(N) SC: O(N)
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FunctionalJavaStream {
    public static boolean twoSum(int[] nums, int target){
        Set<Integer> seen = new HashSet<>();
        return Arrays.stream(nums).anyMatch(num -> {
            if(seen.contains(target - num)) return true;
            seen.add(num);
            return false;
        });
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 1, 8};
        int target = 9;
        boolean result = twoSum(nums, target);
        if(result){
            System.out.println("A pair exists that sums to " + target);
        } else{
            System.out.println("No such pair exists");
        }
    }
}
