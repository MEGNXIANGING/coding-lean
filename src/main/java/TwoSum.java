import java.util.HashMap;
import java.util.Map;
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> tmp = new HashMap();
        for(int i=0;i<=nums.length;i++){
            if (tmp.containsKey(target-nums[i])){
                return new int[]{tmp.get(target-nums[i]),i};
            }else {
                tmp.put(nums[i],i );
            }
        }
        return null;
    }

    public static void main(String[] args) {
        twoSum(new int[]{2,7,11,15},9);
    }
}