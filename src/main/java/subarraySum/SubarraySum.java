package subarraySum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public static void main(String[] args) {

    }
    public int subarraySum2(int[] nums, int k) {
        int ans = 0;  // 结果计数器
        int s = 0;    // 前缀和变量，初始为0
        Map<Integer, Integer> cnt = new HashMap<>(nums.length + 1); // 前缀和出现次数的哈希表
        cnt.put(0, 1); // 初始化：前缀和为0出现过1次

        for (int x : nums) {
            s += x;  // 计算当前前缀和
            // 查找是否有 s - k 的前缀和存在
            ans += cnt.getOrDefault(s - k, 0);
            // 更新当前前缀和的出现次数
            cnt.merge(s, 1, Integer::sum); // 等价于 cnt.put(s, cnt.getOrDefault(s, 0) + 1)
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        int ans=0;
        int s=0;
        Map<Integer, Integer> map = new HashMap<>(nums.length+1);
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            s+=nums[i];
            ans+=map.getOrDefault(s-k,0);
            map.put(s,map.getOrDefault(s,0)+1);
        }
        return ans;
    }

}
