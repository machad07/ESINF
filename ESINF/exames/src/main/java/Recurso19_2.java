public class Recurso19_2 {
    public static void main(String[] args) {
        Integer[] C = {1,2,4,6,8,10,12,14,16,19,20};
        System.out.println(C.length);

        System.out.println(mistery (C, C.length,10  ));
    }

    public static int mistery(Integer[] a, int n, Integer x) {
//verifica extremos

        if (a[n-1] < x)
            return n;
//verifica extremos

        if (a[0] >= x)
            return 0;

        int l=0, u=n-1;
        while (l<u) {
            int m = (l+u)/2;
            if (a[m] < x)
                l = m+1;
            else
                u = m;
        }
        return l;
    }


}


/* nao sei professora. FU */
/* pior lOg(n)
* melhor O(1)*/