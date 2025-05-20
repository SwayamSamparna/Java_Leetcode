//TC: O(N^2) SC:O(1)
public class brute_force{
    public static int[] twoSum(int[] nums, int target){
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums, target);
        if(res.length==2){
            System.out.println("Indices: " +  res[0] +", " + res[1]);
        }else{
            System.out.println("No valid pair found");
        }
    }
}

