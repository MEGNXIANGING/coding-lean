package hash;

import java.util.*;

public class GroupAnagrams {
    /**
     * 字母异位词分组，记得排序
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String c : strs) {
            char[] chars = c.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
            orDefault.add(c);
            map.put(key,orDefault);
        }
        return new ArrayList<>(map.values());

    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m= new HashMap();
        for(int i=0;i<nums.length;i++){
            if(m.get(target-nums[i])!=null){
                return new int[]{m.get(target-nums[i]),i};
            }
            m.put(nums[i],i);
        }
        return new int[2];
    }
}
