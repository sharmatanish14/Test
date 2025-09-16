package bitwiseOperator;

public class TwoOddOcurring {
    public static void main(String[] args) {
        int arr[] = {4, 3, 4, 4, 4, 5, 5, 7, 7, 7};
        printOddOcurringNumbers(arr);

    }

    private static void printOddOcurringNumbers(int arr[]) {

        int res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            res = res ^ arr[i];
        }


        int k = res & (~(res - 1));

        int res1 = 0, res2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & k) == 0) {
                res1 = k ^ arr[i];
            } else {
                res2 = k ^ arr[i];
            }
        }

        System.out.println("Res = " + res);
        System.out.println("res1= " + res1);
        System.out.println("res2 = " + res2);

    }
}
