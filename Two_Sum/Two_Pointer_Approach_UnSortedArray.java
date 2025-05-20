//TC: O(NlogN) SC: O(N)
import java.util.Arrays;

public class Two_Pointer_Approach_UnSortedArray {
    public static int[] twoSum(int[] nums, int target){
        int n = nums.length;
        // Create an array of pairs to store the original indices with value
        int[][] pairs = new int[n][2];
        for(int i=0; i<n; i++){
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        // Sort the pairs based on the first element (the value)
        Arrays.sort(pairs, (a,b) -> Integer.compare(a[0], b[0]));

        // Initialize two pointers
        int left=0, right = n-1;
        while(left<right){
            int sum= pairs[left][0] + pairs[right][0];
            if(sum == target){
                return new int[]{pairs[left][1], pairs[right][1]};
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
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
