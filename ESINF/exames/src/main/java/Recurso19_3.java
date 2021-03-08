import Trees.BST;

import java.util.*;

public class Recurso19_3 {
    private static BST<Integer> a = new BST();

    public static void main(String[] args) {
        a.insert(80);
        a.insert(70);
        a.insert(60);
        a.insert(75);
        a.insert(73);
        a.insert(89);
        a.insert(85);
        a.insert(82);
        a.insert(81);
        a.insert(87);
        a.insert(88);
        a.insert(95);
        a.insert(93);
        a.insert(115);
        a.insert(150);

        Set<Integer> ap = new HashSet<>();

        ap.add(60);
        ap.add(81);
        ap.add(115);
        System.out.println(a.findLCA(ap));
    }



    //Response:   não sou o Linus Torvalds
}
// https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/