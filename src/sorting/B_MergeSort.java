package sorting;

import java.util.Arrays;

public class B_MergeSort {

    /*
     * -------------------------------
     * Merge Sort (Definition)
     * -------------------------------
     * Merge Sort is a divide-and-conquer sorting algorithm.
     *
     * Idea:
     * 1. Divide: Split the array into two halves.
     * 2. Conquer: Recursively sort the two halves.
     * 3. Combine: Merge the two sorted halves into one sorted array.
     *
     * Characteristics:
     * - Time Complexity: O(n log n) (for best, average, and worst case)
     * - Space Complexity: O(n) (uses temporary arrays while merging)
     * - Stable sorting algorithm (preserves the order of equal elements)
     * - Efficient for large datasets
     */

    // Recursive function to divide the array
    public static void mergeSort(int arr[], int low, int high) {
        if (low < high) {
            // Find the middle index
            int mid = (low + high) / 2;

            // Recursively sort the left half
            mergeSort(arr, low, mid);

            // Recursively sort the right half
            mergeSort(arr, mid + 1, high);

            // Merge the two sorted halves
            merge(arr, low, mid, high);
        }
    }

    // Function to merge two sorted subarrays into a single sorted array
    public static void merge(int arr[], int low, int mid, int high) {
        int n1 = mid - low + 1;  // size of left subarray
        int n2 = high - mid;     // size of right subarray

        int left[] = new int[n1];
        int right[] = new int[n2];

        // Copy elements into left subarray
        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }

        // Copy elements into right subarray
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = low;

        // Merge elements from left[] and right[]
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from left[], if any
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements from right[], if any
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    // Driver code to test merge sort
    public static void main(String[] args) {
        int arr[] = { 38, 27, 43, 3, 9, 82, 10 };

        System.out.println("Original Array: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:   " + Arrays.toString(arr));
    }
}
