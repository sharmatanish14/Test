package dsa.sorting;

import java.util.Arrays;

public class G_QuickSort {
    //naive partition
    static void partition(int arr[], int low, int high, int pivot) {
        int temp[] = new int[high - low + 1];
        int index = 0;

        for (int i = low; i <= high; i++) {
            if (arr[i] <= arr[pivot] && i != pivot) {
                temp[index++] = arr[i];
            }
        }

        temp[index++] = arr[pivot];

        for (int i = low; i <= high; i++) {
            if (arr[i] > arr[pivot]) {
                temp[index++] = arr[i];
            }
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        System.out.println(Arrays.toString(arr));

    }

    // Lomuto partition
    static int lomutoPartition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        System.out.println(Arrays.toString(arr));
        return i + 1;
    }

    // QuickSort function
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivotIndex = lomutoPartition(arr, low, high);

            // Recursively sort left and right subarrays
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }


}




