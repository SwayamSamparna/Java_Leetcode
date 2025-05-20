//TC: O(N) SC: O(1)
public class Two_Pointer_Approach_SortedArray {
    public static boolean twoSum(int[] nums, int target){
        int left =0, right = nums.length-1;
        while(left<right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                System.out.println("Pair found: " + nums[left] + ", " + nums[right] + " at indices " + left + ", " + right);
                return true;
            } else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,4,6,10};
        int target = 6;
        boolean found = twoSum(nums, target);
        if(!found){
            System.out.println("No valid pair found");
        }
    }
}
