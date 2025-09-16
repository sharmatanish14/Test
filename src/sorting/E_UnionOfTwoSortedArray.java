package sorting;

import java.util.ArrayList;
import java.util.List;

public class E_UnionOfTwoSortedArray {

    public static void main(String[] args) {

    }
    public static List<Integer> findUnion(int a[], int b[]) {
        int i = 0, j = 0; // two pointers to traverse both arrays
        List<Integer> list = new ArrayList<>(); // to store the final union

        // Traverse both arrays together
        while (i < a.length && j < b.length) {

            // Skip duplicate elements in array a
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }

            // Skip duplicate elements in array b
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }

            // If current element of a[] is smaller, add it and move i
            if (a[i] < b[j]) {
                list.add(a[i++]);
            }
            // If current element of b[] is smaller, add it and move j
            else if (a[i] > b[j]) {
                list.add(b[j++]);
            }
            // If both are equal, add only once and move both pointers
            else {
                list.add(a[i]);
                i++;
                j++;
            }
        }

        // Process remaining elements of array a (skip duplicates)
        while (i < a.length) {
            if (i == 0 || a[i] != a[i - 1]) {
                list.add(a[i]);
            }
            i++;
        }

        // Process remaining elements of array b (skip duplicates)
        while (j < b.length) {
            if (j == 0 || b[j] != b[j - 1]) {
                list.add(b[j]);
            }
            j++;
        }

        return list; // return the union of both arrays
    }


}
