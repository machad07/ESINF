import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class main {

    public static void main(String agrs[]) {
        List<Pair<String, Integer>> AList = new ArrayList<>();
        AList.add(new Pair<>("A", 2));
        AList.add(new Pair<>("A", 2));
        AList.add(new Pair<>("A", 5));

        List<Pair<String, Integer>> BList = new ArrayList<>();
        BList.add(new Pair<>("B", 1));
        BList.add(new Pair<>("B", 1));
        BList.add(new Pair<>("B", 2));
        BList.add(new Pair<>("B", 3));
        BList.add(new Pair<>("B", 4));
        BList.add(new Pair<>("B", 4));
        BList.add(new Pair<>("B", 5));

        System.out.println(mergeLists(AList,BList));

    }

    public static <K, E extends Comparable<E>> List<Pair<K, E>> mergeLists(List<Pair<K, E>> A, List<Pair<K, E>> B) {
        List<Pair<K, E>> mergedList = new ArrayList<>();
        Comparator comparator = new Comparator<Pair<K, E>>() {
            K lastOne = null;
            public int compare(Pair<K, E> o1, Pair<K, E> o2) {
                E o1K = o1.getValue();
                E o2K = o2.getValue();
                if (!o1K.equals(o2K))
                    return o1.getValue().compareTo(o2.getValue());
                if(!o1.getKey().equals(lastOne)) {
                    lastOne = o1.getKey();
                    return -1;
                }
                if(!o2.getKey().equals(lastOne)) {
                    lastOne = o2.getKey();
                    return 1;
                }
                return 1;
            }
        };
        mergedList.addAll(A);
        mergedList.addAll(B);
        mergedList.sort(comparator);
        return mergedList;
    }
}
