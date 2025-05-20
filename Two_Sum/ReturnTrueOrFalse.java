//TC: O(N) SC: O(N)
import java.util.HashSet;
import java.util.Set;

public class ReturnTrueOrFalse {
    public static boolean hasTwoSum(int[] nums, int target){
        Set<Integer> seen = new HashSet<>();
        for(int num: nums){
            int complement = target - num;
            if(seen.contains(complement)){
                return true;
            }
            seen.add(num);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 7, 9};
        int target = 10;

        boolean result = hasTwoSum(nums, target);
        if (result) {
            System.out.println("A pair with the target sum exists.");
        } else {
            System.out.println("No such pair exists.");
        }
    }
}
