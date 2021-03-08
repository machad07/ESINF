import java.util.*;

public class Normal18_1 {
    public static void main(String[] args) {
        List<String> nomes = new LinkedList<>();
        nomes.
        nomes.add("carro");
        nomes.add("auto");
        nomes.add("auto");
        nomes.add("autocarro");
        nomes.add("carro");
        nomes.add("carro");
        nomes.add("autocarro");
        nomes.add("auto");
        System.out.println(renomear(nomes));
        System.out.println(mistery(4));
        String[] a = new String[10];
        a[0] = "<body>";
        a[1] = "</body>";
        if(a[1].contains("/") && a[1].contains(a[0].substring(1,a[0].length()-1))){
            System.out.println("olaf");
        }
    }

    static List<String> renomear(List<String> a) {
        HashMap<String, Integer> lhm = new HashMap<>();
        LinkedList<String> lk = new LinkedList<>();

        for (String aa : a) {
            if (lhm.containsKey(aa)) {
                lhm.put(aa, lhm.get(aa) + 1);
                lk.add(aa + " " + lhm.get(aa));
            } else {
                lhm.put(aa, 0);
                lk.add(aa);
            }
        }

        return lk;
    }

    static int mistery(int n) {

        int i, j, res = 0;
        for (i = n / 2; i <= n; i++)//3/4/5/6/7/
            for (j = 2; j <= n; j = j * 2)//2/4
                res = res + n / 2;

        return res;
    }

    //X*Y*Z
    //X -» n-n/2 +1
    //y -» 2^j <= n
    //z -» n/2
    //j -» numeros quadrados apartir de 2

    //n log n
}

























