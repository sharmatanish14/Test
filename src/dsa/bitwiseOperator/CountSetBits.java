package dsa.bitwiseOperator;

public class CountSetBits {

    public static void main(String[] args) {
        int count = lookUpTable(10);
        System.out.println(count);
    }


    static int countSetBits(int n){
        int count=0;

        while(n>0){
            count += n&1;
            n = n>>1;
            n >>= 1;
        }
        return count;
    }

    static int countSetBitsUsingBrianAlgorithm(int n){
        int count=0;

        while(n>0){
            n = n & (n-1);
            count++;
        }
        return count;
    }

    static int lookUpTable(int n){
        int table[] =new int[256];

        for(int i=1;i<256;i++){
            table[i] = table[i & (i-1)]+1;
        }


        return table[n & 255] + table[(n>>8) &255 ] + table [(n>>16) &255] + table[(n>>24) & 255];
     }

}
