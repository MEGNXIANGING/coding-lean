package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class headSill {
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        PriorityQueue<Integer> Maxheap = new PriorityQueue<>(Collections.reverseOrder());
        heap.add(3);
        heap.add(1);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.add(8);
        Maxheap.add(3);
        Maxheap.add(1);
        Maxheap.add(5);
        Maxheap.add(6);
        Maxheap.add(7);
        Maxheap.add(8);
        System.out.println(heap.toString());
        System.out.println(Maxheap.toString());
        while (!Maxheap.isEmpty()){
            System.out.println(Maxheap.poll());
        }
    }
}
