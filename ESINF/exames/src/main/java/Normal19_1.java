import javafx.util.Pair;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Normal19_1 {
    public static void main(String[] args) {
        List<Pair<String, Integer>> a2 = new LinkedList<>();
        List<Pair<String, Integer>> b2 = new LinkedList<>();

        a2.add(new Pair<>("A", 2));
        a2.add(new Pair<>("A", 2));
        a2.add(new Pair<>("A", 5));

        b2.add(new Pair<>("B", 1));
        b2.add(new Pair<>("B", 1));
        b2.add(new Pair<>("B", 2));
        b2.add(new Pair<>("B", 3));
        b2.add(new Pair<>("B", 4));
        b2.add(new Pair<>("B", 4));
        b2.add(new Pair<>("B", 5));
        System.out.println(mergeLists(a2, b2));
    }

    public static <K, E extends Comparable<E>> List<Pair<K, E>> mergeLists(List<Pair<K, E>> A, List<Pair<K, E>> B) {
        List<Pair<K, E>> C = new LinkedList<>();
        List<Pair<K, E>> D = new LinkedList<>();
        C.addAll(A);
        C.addAll(B);
        C.sort(Comparator.comparing(Pair::getValue));

        for (int i = 0; i <C.size(); i++) {
            if ( i !=0){
                if (C.get(i - 1).getKey().equals(C.get(i).getKey()) && C.get(i - 1).getValue() == C.get(i).getValue() && !C.get(i + 1).getKey().equals(C.get(i).getKey()) && C.get(i + 1).getValue() == C.get(i).getValue()) {
                    Pair<K, E> temp = new Pair<>(C.get(i + 1).getKey(), C.get(i + 1).getValue());
                    C.set(i + 1, C.get(i));
                    C.set(i, temp);
                }
            }
        }
        return C;
    }
}
