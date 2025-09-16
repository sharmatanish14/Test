package dsa.bitwiseOperator;

public class PowerSet {

    public static void main(String[] args) {
//        printPowerSet("ab");
        System.out.println(1<<0);
    }

    private static void printPowerSet(String str) {

        int n = str.length();
        int psize = 1 << n;

        for (int i = 0; i < psize; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.println(" i=" + i + " j=" + j);
                    System.out.print(str.charAt(j));
                }
            }
            System.out.println();
        }
    }


}
