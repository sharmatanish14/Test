package dsa.sorting;

import java.util.Arrays;

public class A_SelectionSort {

    /*
     * -------------------------------
     * Selection Sort (Definition)
     * -------------------------------
     * Selection Sort is a simple comparison-based dsa.sorting algorithm.
     *
     * - Idea: Repeatedly find the minimum element from the unsorted part
     *   of the array and place it at the beginning.
     *
     * Steps:
     * 1. Start from the first index.
     * 2. Find the smallest element in the remaining unsorted part.
     * 3. Swap it with the current index.
     * 4. Repeat until the entire array is sorted.
     *
     * Characteristics:
     * - Time Complexity: O(n^2) (for all cases: best, average, worst)
     * - Space Complexity: O(1) (in-place dsa.sorting)
     * - Not stable (relative order of equal elements may change)
     * - Suitable for small arrays, but not efficient for large datasets.
     */

    // Selection Sort implementation using an extra array
    public static void selectionSort(int arr[]) {
        int temp[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            // Find the minimum element in the remaining unsorted array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            // Copy the found minimum to the temp array
            temp[i] = arr[minIndex];

            // Mark element as used
            arr[minIndex] = Integer.MAX_VALUE;
        }

        System.out.println(Arrays.toString(temp));
    }

    // Optimized Selection Sort (in-place, no extra array)
    public static void selectionSortOptimised(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            // Find the index of the smallest element
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            // Swap smallest element with element at current index
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
