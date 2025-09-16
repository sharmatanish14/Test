package dsa.recursion;

public class GuessOutput {

    public static void main(String[] args) {
        fun(12);
    }

    // this function is doing decimal ti binary conversion
    public static void fun(int n){
        if(n==0){
            return;
        }

        fun(n/2);

        System.out.print(n%2);
    }
}
