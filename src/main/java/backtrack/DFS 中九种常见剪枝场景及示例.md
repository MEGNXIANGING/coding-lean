# 《DFS 中九种常见剪枝场景及示例》

深度优先搜索（DFS）中的剪枝是优化算法效率的关键技术，通过避免搜索无效或冗余的路径来减少时间复杂度。以下是常见的 DFS 剪枝场景及解决方案，结合具体例子说明：


### **一、可行性剪枝**

**场景**：当前路径不可能满足条件，直接终止该路径的搜索。


**解决方案**：在递归前检查条件，不满足则返回。

**示例**：


在目标和问题中，若当前和已超过目标值，无需继续搜索。




```
// 剪枝逻辑：若当前和已超过target，直接返回

if (currentSum > target) {

 return;


}
```

### **二、最优性剪枝（分支限界）**

**场景**：若当前路径的代价已超过已知最优解，无需继续搜索。


**解决方案**：维护全局最优解，比较当前路径代价。


**示例**：


在旅行商问题（TSP）中，若当前路径长度已超过已知最短路径，剪枝。




```
// 剪枝逻辑：若当前路径长度 >= 已知最短路径，返回


if (currentPathLength >= minPathLength) {


   return;


}
```

### **三、重复路径剪枝**

**场景**：不同路径可能到达相同状态，导致重复计算。


**解决方案**：使用哈希表记录已访问状态，避免重复搜索。


**示例**：


在棋盘问题中，记录已访问的位置和状态。




```
// 剪枝逻辑：若当前状态已访问，跳过


Set\<String> visited = new HashSet<>();


String state = currentRow + "," + currentCol + "," + currentDirection;


if (visited.contains(state)) {


   return;


}


visited.add(state);
```

### **四、顺序无关剪枝（组合问题）**

**场景**：组合问题中，顺序不同但元素相同的组合视为重复。


**解决方案**：每次递归从当前元素的下一个位置开始，避免回头。


**示例**：


在组合总和问题中，使用`start`参数控制选择范围。




```
// 剪枝逻辑：每次递归从start开始，避免重复组合


for (int i = start; i < candidates.length; i++) {


   dfs(candidates, target, i + 1, path, currentSum + candidates\[i]);


}
```

### **五、重复元素剪枝（排列 / 组合问题）**

**场景**：数组中有重复元素，生成排列 / 组合时会产生重复结果。


**解决方案**：排序后，跳过同一层中相邻的重复元素。


**示例**：


在含重复元素的组合问题中，排序后剪枝。




```
Arrays.sort(nums);


// 剪枝逻辑：跳过同一层中的重复元素


for (int i = start; i < nums.length; i++) {


   if (i > start && nums\[i] == nums\[i - 1]) {


       continue; // 剪枝


   }


   dfs(nums, target, i + 1, path, currentSum + nums\[i]);


}
```

### **六、对称性剪枝**

**场景**：问题存在对称性，某些路径本质相同。


**解决方案**：只搜索对称路径中的一条。


**示例**：


在棋盘放置问题中，若棋盘对称，只需搜索右上部分。




```
// 剪枝逻辑：若棋盘对称，只搜索右上部分


if (row >= col) { // 假设对称性条件


   dfs(row, col + 1); // 只向右搜索


}
```

### **七、预处理剪枝（预处理无效数据）**

**场景**：输入数据中存在无效元素，影响搜索效率。


**解决方案**：预处理数据，过滤无效元素。


**示例**：


在寻找递增子序列中，过滤不可能构成递增序列的元素。




```
// 预处理：统计每个元素的出现次数


Map\<Integer, Integer> countMap = new HashMap<>();


for (int num : nums) {


   countMap.put(num, countMap.getOrDefault(num, 0) + 1);


}


// 剪枝：若元素出现次数不足，不考虑


if (countMap.get(num) < minRequired) {


   continue;


}
```

### **八、记忆化搜索（Memoization）**

**场景**：存在大量重叠子问题。


**解决方案**：使用哈希表记录子问题结果，避免重复计算。


**示例**：


在斐波那契数列中，用缓存优化。




```
Map\<Integer, Integer> memo = new HashMap<>();


public int fib(int n) {


   if (n <= 1) return n;


   if (memo.containsKey(n)) return memo.get(n);


   int result = fib(n - 1) + fib(n - 2);


   memo.put(n, result);


   return result;


}
```

### **九、可行性约束剪枝**

**场景**：问题存在特定约束条件，提前判断路径是否满足。


**解决方案**：在递归前检查约束条件。


**示例**：


在 N 皇后问题中，检查当前位置是否与已放置的皇后冲突。




```
// 剪枝逻辑：检查当前位置(row, col)是否合法


private boolean isValid(int row, int col, int\[] cols) {


   for (int i = 0; i < row; i++) {


       if (cols\[i] == col || Math.abs(row - i) == Math.abs(col - cols\[i])) {


           return false; // 冲突，剪枝


       }


   }


   return true;


}
```

### **总结**

剪枝的核心思想是**尽早发现并终止无效路径**，常见策略包括：




1.  **预处理数据**，过滤无效输入。


2.  **记录已访问状态**，避免重复计算。


3.  **维护最优解**，剪枝非最优路径。


4.  **利用问题特性**（对称性、顺序无关性等）减少搜索空间。


选择合适的剪枝策略需要结合问题特性，通过分析搜索树的结构和冗余路径来设计高效的剪枝条件。

