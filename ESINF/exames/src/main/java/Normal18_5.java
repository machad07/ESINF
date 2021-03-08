import Priority_queue.Entry;
import Priority_queue.HeapPriorityQueue;

public class Normal18_5 {
    public static void main(String[] args) {
        HeapPriorityQueue<Integer, Integer> hpq = new HeapPriorityQueue();
        hpq.insert(1, 1);
        hpq.insert(2, 1);
        hpq.insert(3, 5);
        hpq.insert(8, 22);
        hpq.insert(1, 90);

        System.out.println(hpq);

        System.out.println(metodo(hpq,22));
    }
    public static int metodo(HeapPriorityQueue<Integer, Integer> hp1, int value) {
        HeapPriorityQueue<Integer,Integer> hp2 = hp1.clone();
        int a=0;
        while(!hp2.isEmpty()){
            if (hp2.removeMin().getValue()==value){
                return a;
            }else{
                a++;
            }
        }
        return 0;
    }
}
