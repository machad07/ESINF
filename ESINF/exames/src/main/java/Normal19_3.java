import Trees.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Normal19_3 {

    private static BST<Integer> a = new BST();

    public static void main(String[] args) {
       fabio();

    }
    public static void fabio() {
        a.insert(17);
        a.insert(5);
        a.insert(2);
        a.insert(11);
        a.insert(9);
        a.insert(7);
        a.insert(35);
        a.insert(29);
        a.insert(38);
        a.insert(16);

        System.out.println(a);
        System.out.println(inOrderSuccessor(5));
    }

    public static <E> E inOrderSuccessor(E element){
        LinkedList<E> ld = new LinkedList();
        ld.addAll((Collection<? extends E>) a.inOrder());

        int index = ld.indexOf(element);

        return ld.get(index+1);
    }
/*    public Iterable<E> inOrder(){
        List<E> snapshot = new ArrayList<>();
        if (root!=null)
            inOrderSubtree(root, snapshot);   // fill the snapshot recursively
        return snapshot;
    }
    private void inOrderSubtree(BST.Node<E> node, List<E> snapshot) {
        if (node == null)
            return;
        inOrderSubtree(node.getLeft(), snapshot);
        snapshot.add(node.getElement());
        inOrderSubtree(node.getRight(), snapshot);
    }*/

}
