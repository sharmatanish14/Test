package bitwiseOperator;

public class KthBit {
    public static void main(String[] args) {
        boolean b = checkKthBit4(5, 3);
        System.out.println(b);
    }

    static boolean checkKthBit(int n, int k) {
        int x = 1;

        for (int i = 0; i < k - 1; i++) {
            x = x * 2;
        }


        if ((n & x) != 0) {
            return true;
        } else {
            return false;
        }

    }

    static boolean checkKthBit2(int n, int k) {

        for (int i = 0; i < k - 1; i++) {
            n = n / 2;
        }

        if ((n & 1) != 0) {
            return true;
        } else {
            return false;
        }
    }

    static boolean checkKthBit3(int n,int k){
        int x= 1<<(k-1);

        if((n&x)!=0) {
            return true;
        }else{
            return false;
        }
    }

    static boolean checkKthBit4(int n, int k){
        n = n>>(k-1);

        if((n&1)!=0){
            return true;
        }else{
            return false;
        }
    }

    static boolean isKthBitSet(int n, int k) {
        int x= 1<<(k-1);

        if((n&x)!=0){
            return true;
        }else{
            return false;
        }
    }
}