package dp;

public class Rob2 {
    //dfs到递推的过程
    public int rob(int[] nums) {
        int n = nums.length;
        // 用于缓存计算结果，初始值 -1 表示未计算过
        int[] cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return dfs(nums, n - 1, cache);
    }

    private int dfs(int[] nums, int i, int[] cache) {
        if (i<0){
            return 0;
        }
        if (cache[i]!=-1){
            return cache[i];
        }
        int x= Math.max(dfs(nums,i-1,cache),dfs(nums,i-2,cache)+nums[i]);
        cache[i]=x;
        return x;
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        // 用于缓存计算结果，初始值 -1 表示未计算过
        int[] f = new int[n+2];
        for (int i = 0; i < n; i++) {
            f[i+2]=Math.max(f[i+1],f[i]+nums[i]);
        }
        return f[n+1];
    }

    public int rob3(int[] nums) {
        int n = nums.length;
        // 用于缓存计算结果，初始值 -1 表示未计算过
        int f0=0,f1=0;
        for (int i = 0; i < n; i++) {
            int new_f=Math.max(f1,f0+nums[i]);
            f0=f1;
            f1=new_f;
        }
        return f1;
    }
}
