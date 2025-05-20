//TC: O(N) SC: O(N)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReturnAllUniquePairs {
    public static List<int[]> allTwoSumPairs(int[] nums, int target){
        Set<Integer> seen = new HashSet<>();
        Set<String> addedPairs = new HashSet<>();
        List<int[]> result = new ArrayList<>();
        for(int num: nums){
            int complement = target-num;
            if(seen.contains(complement)){
                int a = Math.min(num, complement);
                int b = Math.max(num, complement);
                String pairKey = a + "," + b;
                if(!addedPairs.contains(pairKey)){
                    result.add(new int[]{a,b});
                    addedPairs.add(pairKey);
                }
            }
            seen.add(num);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2,4,3,5,6,1,2,3};
        int target = 6;
        List<int[]> pairs = allTwoSumPairs(nums, target);
        if(pairs.isEmpty()){
            System.out.println("No valid pairs found");
        } else{
            System.out.println("Pairs that sum to "+ target + ":");
            for(int[] pair:pairs){
                System.out.println(Arrays.toString(pair));
            }
        }
    }
}
