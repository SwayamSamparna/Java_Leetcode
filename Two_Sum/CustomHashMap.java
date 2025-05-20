//TC: O(N^2) SC: O(N)
import java.util.List;
import java.util.ArrayList;
class Pair{
    int key;
    int value;
    Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class MyMap{
    List<Pair> list = new ArrayList<>();

    void put(int key, int value){
        for(Pair p : list){
            if(p.key == key){
                p.value = value;
                return;
            }
        }
        list.add(new Pair(key, value));
    }

    Integer get(int key){
        for(Pair p : list){
            if(p.key == key) return p.value;
        }
        return null;
    }
    boolean containsKey(int key){
        for(Pair p : list){
            if(p.key == key) return true;
        }
        return false;
    }
}
public class CustomHashMap {
    public static int[] twoSum(int[] nums, int target){
        MyMap numMap = new MyMap();
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
