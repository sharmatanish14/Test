package dsa.sorting;

public class Sorting {

    public void intersectionOfTwoSortedArrays(int a[], int b[]) {


        for (int i = 0; i < a.length; i++) {
            if (i > 0 && a[i - 1] == a[i]) {
                continue;
            }

            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {

                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 20, 20, 40, 60};
        int b[] = {2, 20, 20, 20};


    }
}
