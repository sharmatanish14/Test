package sorting;

public class F_CountInversion {

    public static void main(String[] args) {
        // Example array: [2, 4, 1, 3, 5]
        // Expected inversions = 3 -> (2,1), (4,1), (4,3)
        int countInversion = countInv(new int[]{2, 4, 1, 3, 5}, 0, 4);
        System.out.println(countInversion); // Output = 3
    }

    // ====================== BRUTE FORCE APPROACH ======================
    // Time Complexity: O(n^2)
    // Check every pair (i, j) such that i < j and arr[i] > arr[j]
    static int countInversion(int arr[]) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++; // Found an inversion
                }
            }
        }
        return count;
    }

    // ====================== OPTIMIZED APPROACH USING MERGE SORT ======================
    // Time Complexity: O(n log n)
    // Idea: While merging, count how many elements in right subarray are smaller
    // than elements in left subarray.
    static int countInv(int arr[], int l, int r) {
        if (l >= r) {
            return 0; // Base case: single element has no inversion
        }

        int mid = l + (r - l) / 2;
        int res = 0;

        // Count inversions in left half
        res += countInv(arr, l, mid);

        // Count inversions in right half
        res += countInv(arr, mid + 1, r);

        // Count cross inversions (while merging)
        res += countAndMerge(arr, l, mid, r);

        return res;
    }

    // Merge step of merge sort that also counts inversions
    private static int countAndMerge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1; // Size of left subarray
        int n2 = r - mid;     // Size of right subarray
        int count = 0;

        int left[] = new int[n1];
        int right[] = new int[n2];

        // Copy elements into left subarray
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }

        // Copy elements into right subarray
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + i + 1];
        }

        // Merge two sorted subarrays while counting inversions
        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i]; // No inversion here
                i++;
            } else {
                arr[k] = right[j];
                j++;
                // All remaining elements in left[i..n1-1] are greater than right[j]
                // Hence, (n1 - i) inversions
                count += n1 - i;
            }
            k++;
        }

        // Copy remaining elements from left subarray
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements from right subarray
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }

        return count;
    }
}
