package sorting;

import java.util.Arrays;

public class C_InsertionSort {

    /*
     * -------------------------------
     * Insertion Sort (Definition)
     * -------------------------------
     * Insertion Sort is a simple sorting algorithm that builds the sorted
     * array one element at a time by inserting elements into their correct position.
     *
     * Idea:
     * - Take one element from the unsorted part and insert it into the correct
     *   position in the already sorted part of the array.
     *
     * Steps:
     * 1. Start from the second element (index 1), as the first element is trivially sorted.
     * 2. Compare the current element (key) with elements in the sorted part.
     * 3. Shift all elements that are greater than key one step to the right.
     * 4. Insert the key into its correct position.
     *
     * Characteristics:
     * - Time Complexity:
     *      Best case: O(n) when array is already sorted
     *      Average case: O(n^2)
     *      Worst case: O(n^2) when array is reverse sorted
     * - Space Complexity: O(1) (in-place sorting)
     * - Stable algorithm (maintains relative order of equal elements)
     * - Efficient for small arrays and nearly sorted arrays
     */

    public static void insertionSort(int arr[]) {

        // Start from the second element (index 1) because
        // the first element [0] is already "sorted"
        for (int i = 1; i < arr.length; i++) {

            // Current element to be inserted in the sorted part
            int key = arr[i];

            // j points to the last element of the sorted portion
            int j = i - 1;

            // Shift elements of the sorted part that are greater than key
            // one position ahead to make space for key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--; // move left in the sorted portion
            }

            // Place key at its correct position in the sorted part
            arr[j + 1] = key;
        }

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }
}
