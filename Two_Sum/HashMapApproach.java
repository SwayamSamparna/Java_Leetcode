//TC: O(N) SC: O(N)
import java.util.HashMap;
import java.util.Map;
public class HashMapApproach {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            int complement = target - nums[i];
            if(numMap.containsKey(complement)){
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        if(res.length==2){
            System.out.println("Indices: " +  res[0] +", " + res[1]);
        }else{
            System.out.println("No valid pair found");
        }
    }
}
