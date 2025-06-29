package heap;

import java.util.*;

public class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String str:words){
            if (map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }else {
                map.put(str,1);
            }
        }
        // 2. 构建最大堆（按频率降序，频率相同按字母序升序）
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ?
                        a.getKey().compareTo(b.getKey()) :
                        b.getValue() - a.getValue()
        );

        maxHeap.addAll(map.entrySet());

        // 4. 提取前k个结果
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll().getKey());
        }

        return result;
    }
}
