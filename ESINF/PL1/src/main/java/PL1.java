public class PL1 {

        public static void main (String[] agrs){
            System.out.println(sameOrder("ISEP"));
            System.out.println(reverseOrder("ISEP"));
            System.out.println(productOfIntegers(2,7));
            System.out.println(findBiggest(new int[] {3,7,18,4,8}));
            System.out.println(greatestCommonDivisor(75,96));
            System.out.printf("%d\n",convertStringToInteger("1234"));
            System.out.println(isPalindrome(12321));


        }

//1
    //a)
    public static String sameOrder(String s){
        if (s.length() == 0){
            return "";
        }
        return s.charAt(0) + sameOrder(s.substring(1));
    }

    //b)
    public static String reverseOrder(String s){
        if (s.length() == 0){
            return "";
        }
        return reverseOrder(s.substring(1)) + s.charAt(0);
    }

//2
    //a)
    public static int productOfIntegers(int m , int n){
        if(m<=0 || n<=0) {
            return 0;
        }
        return m+productOfIntegers(m,n-1) ;
    }

    //b)
    public static int findBiggest(int[] arr){
        return findB(arr.length-2,arr[arr.length-1],arr);
    }

    public static int findB(int pointer,int biggest,int[] arr){
        if(pointer==0){
            return biggest;
        }
        if(arr[pointer]>biggest){
            biggest=arr[pointer];
        }
        return findB(pointer-1,biggest,arr);
    }

    //c)
    public static int greatestCommonDivisor(int m, int n){
            int k =0;
            if(m<n)  k = m;
            if(m>n)  k = n;
            if(m==n)  k = m;
        return greatestCD(m,n,k);

    }

    public static int greatestCD(int m, int n, int k){
        if(m%k==0 && n%k==0){
            return k;
        }
        k--;
        return greatestCD(m,n,k);
    }

    //d)
    public static int convertStringToInteger(String i){
        return convertSToI(i,0);
    }

    public static int convertSToI(String i, int k){
            if(i.length()==0){
                return k;
            }
            k = (int) (k + (Math.pow(10,i.length()-1)*Integer.parseInt(String.valueOf(i.charAt(0)))));

            return convertSToI(i.substring(1),k);
    }

    //e)
    public static String isPalindrome(int a){
            if(isP( a,  a,  0)) return "É palindromo";
            return "Não é palindromo.";
    }

    public static boolean isP(int a, int b, int res) {
            if (b == 0) {
                return a == res;
            }
            res = res * 10 + b % 10;
            b -= b % 10;
            b = b / 10;
            return isP(a, b, res);
        }

    //f)
    public static int sumArray(int [][] a){
            return sumA(a,0,0,0);
    }

    public static int sumA(int [][] a,int b,int  c, int valor){
            if(c==a[b].length){
                return sumA(a,b++, 0, valor);
            }
            if(b==a.length){
                return valor;
            }
            valor = valor + a[b][c];

    }



}
