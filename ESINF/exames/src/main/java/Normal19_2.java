import java.util.*;

public class Normal19_2 {

    public static void main(String[] args) {
        Set<String> aaa = new LinkedHashSet<>();
        aaa.add("ARROZ");
        aaa.add("BATATAS");
        aaa.add("PE");
        List<Character> l = misterio(aaa);
        System.out.println(l);

    }

    public static List<Character> misterio(Set<String> set) {
        List<Character> l = new LinkedList<>();
        boolean flag = true;
        int i = 0;
        while (flag) {
            flag = false;
            for (String s : set) {
                if (i < s.length()) {
                    l.add(s.charAt(i));
                    flag = true; }
            }
            i++; }
        return l; }
}
// a) intercala as letras de um set de strings ate acabar a palavra maior
// b) percorre a lista y vezes, sendo y o numero de letras da maior palavra - » O(y) ou O(ny)