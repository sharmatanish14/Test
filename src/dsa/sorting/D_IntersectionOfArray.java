package dsa.sorting;

public class D_IntersectionOfArray {

    public static void main(String[] args) {
        int arr1[] = {1, 2, 2, 3, 4};
        int arr2[] = {2, 2, 4, 6};
        intersectionOfTwoSortedArrays(arr1, arr2);
    }

    public static void intersectionOfTwoSortedArrays(int arr1[], int arr2[]) {
        int i = 0, j = 0;

        // Traverse both arrays until one is exhausted
        while (i < arr1.length && j < arr2.length) {

            // Skip duplicate elements in arr1 (only keep the first occurrence)
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;  // move pointer ahead to avoid infinite loop
                continue;
            }

            // If current element of arr1 is smaller, move i forward
            if (arr1[i] < arr2[j]) {
                i++;
            }
            // If current element of arr2 is smaller, move j forward
            else if (arr1[i] > arr2[j]) {
                j++;
            }
            // If both elements are equal, it's part of intersection
            else {
                System.out.print(arr1[i] + " "); // print intersection element
                i++;
                j++;
            }
        }
    }
}
