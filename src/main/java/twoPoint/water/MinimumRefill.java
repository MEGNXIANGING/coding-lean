package twoPoint.water;

public class MinimumRefill {
    /**
     * 初始化答案 ans=0，Alice 水罐的初始水量 a=capacityA，Bob 水罐的初始水量 b=capacityB。
     * 初始化左右指针 i=0, j=n−1。
     * 循环直到 i≥j。每次循环，
     * 对于 Alice，如果 a<plants[i]，那么 Alice 需要重新灌满水罐，a 重置为 capacityA，答案加一。
     * 然后把 a 减少 plants[i]，左指针 i 加一。
     * 对于 Bob，如果 b<plants[j]，那么 Bob 需要重新灌满水罐，b 重置为 capacityB，答案加一。
     * 然后把 b 减少 plants[j]，右指针 j 减一。
     * 循环结束后，如果 i=j 且 max(a,b)<plants[i]，则需要重新灌满水罐，答案加一。
     * 返回答案。
     */
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int alice = 0;
        int bob = plants.length - 1;
        int res = 0;
        int a = capacityA;
        int b = capacityB;
        while (alice <= bob) {
            if (alice == bob) {
                if (Math.max(a, b) < plants[alice]) {
                    res++;
                }
                break;
            }
            //先处理alice
            if (a < plants[alice]) {
                res++;
                a = capacityA;
            }
            a -= plants[alice];
            alice++;

            //处理bob
            if (b < plants[bob]) {
                res++;
                b = capacityB;
            }
            b -= plants[bob];
            bob--;
        }
        return res;
    }

    public int minimumRefill3(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        int a = capacityA;
        int b = capacityB;
        int i = 0;
        int j = plants.length - 1;
        while (i < j) {
            // Alice 给植物 i 浇水
            if (a < plants[i]) {
                // 没有足够的水，重新灌满水罐
                ans++;
                a = capacityA;
            }
            a -= plants[i++];
            // Bob 给植物 j 浇水
            if (b < plants[j]) {
                // 没有足够的水，重新灌满水罐
                ans++;
                b = capacityB;
            }
            b -= plants[j--];
        }
        // Alice 和 Bob 到达同一株植物，那么当前水罐中水更多的人会给这株植物浇水
        if (i == j && Math.max(a, b) < plants[i]) {
            // 没有足够的水，重新灌满水罐
            ans++;
        }
        return ans;
    }


    public int minimumRefill2(int[] plants, int capacityA, int capacityB) {
        int alice = 0;
        int bob = plants.length - 1;
        int res = 0;
        int a = capacityA;
        int b = capacityB;
        while (alice <= bob) {
            if (alice == bob) { // 处理中间那棵植物
                if (a >= b) { // Alice负责
                    if (a < plants[alice]) {
                        res++;
                    }
                } else { // Bob负责
                    if (b < plants[bob]) {
                        res++;
                    }
                }
                break;
            }
            // 处理Alice
            if (a < plants[alice]) {
                res++;
                a = capacityA;
            }
            a -= plants[alice];
            alice++;
            // 处理Bob
            if (b < plants[bob]) {
                res++;
                b = capacityB;
            }
            b -= plants[bob];
            bob--;
        }
        return res;
    }
}
