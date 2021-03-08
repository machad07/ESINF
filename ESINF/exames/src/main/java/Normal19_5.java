import Priority_queue.AbstractPriorityQueue;
import Priority_queue.Entry;
import Priority_queue.HeapPriorityQueue;

import javax.swing.*;

public class Normal19_5 {
    public static void main(String[] args) {
        HeapPriorityQueue<Integer, Integer> hpq = new HeapPriorityQueue();
        HeapPriorityQueue<Integer, Integer> hpq2 = new HeapPriorityQueue();
        hpq.insert(1, 1);
        hpq.insert(2, 1);
        hpq2.insert(3, 5);
        hpq2.insert(8, 22);
        hpq2.insert(1, 90);

        System.out.println(mergeHeaps(hpq, hpq2).toString());
    }

    public static HeapPriorityQueue<Integer, Integer> mergeHeaps(HeapPriorityQueue<Integer, Integer> hp1, HeapPriorityQueue<Integer, Integer> hp2) {
        HeapPriorityQueue<Integer, Integer> h3 = new HeapPriorityQueue();
        Entry<Integer, Integer> e = null;
        while (!hp1.isEmpty()){
             e = hp1.removeMin();
             h3.insert(e.getKey(), e.getValue());
        }
        while (!hp2.isEmpty()){
            e = hp2.removeMin();
            h3.insert(e.getKey(), e.getValue());
        }
        return h3;
    }
}
