package dsa.array;

import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);


    }

    public static int insert(int arr[], int n, int x, int cap, int pos) {
        if (n == cap) {
            return n;
        }
        int index = pos - 1;

        for (int i = n; i >= index; i++) {
            arr[i + 1] = arr[i];
        }

        arr[index] = x;
        return n;
    }

    public static int delete(int arr[], int n, int x) {

        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                index = i;
                break;
            }
        }

        for (int j = index; j < n; j++) {
            arr[j] = arr[j + 1];
        }
        return -1;
    }

    public static int maxElementIndex(int arr[]) {
        int res = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[res]) {
                res = i;
            }
        }
        return res;
    }

    public static int secondLargest(int arr[]) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;

    }

    public static void reverseArray(int arr[]) {
        int i = 0, j = arr.length - 1;

        while (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }

        System.out.println(Arrays.toString(arr));

    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int removeDuplicateFromSortedArray(int arr[]) {
        int res = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[res - 1]) {
                arr[res++] = arr[i];
            }
        }

        return res;
    }

    private static void moveAllZerosToTheEnd(int arr[]) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }

    }

    private static void rotateArray(int arr[], int n, int d) {

        int temp[] = new int[d];

        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        for (int i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }

        for (int i = 0; i < d; i++) {
            arr[n - d + i] = temp[i];
        }

    }

    private static void rotateArray_approach_3(int arr[], int n, int d) {
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);

    }

    private static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }

    }

    private static int maximumDifference(int arr[]) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (max < arr[j] - arr[i]) {
                    max = arr[j] - arr[i];
                }
            }
        }
        return max;
    }

    private static int maximumDifference_approach_2(int arr[]) {
        int minVal = arr[0], res = arr[1] - arr[0];
        for (int j = 1; j < arr.length; j++) {

            res = Math.max(res, arr[j] - minVal);
            minVal = Math.min(minVal, arr[j]);

        }
        return res;

    }

    private static void frequencies_in_sorted_array(int arr[]) {

        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                System.out.println(arr[i - 1] + " count =" + count);
                count = 1;
            }
        }

        System.out.println(arr[arr.length - 1] + " count =" + count);
    }

    private static void frequencies_in_sorted_array_approach_2(int arr[]) {
        int i = 1, freq = 1;

        while (i < arr.length) {
            while (i < arr.length && arr[i] == arr[i - 1]) {
                freq++;
                i++;
            }

            System.out.println(arr[i - 1] + " frequency is= " + freq);
            i++;
        }

        if (arr.length == 1 || arr[arr.length - 1] != arr[arr.length - 2]) {
            System.out.println(arr[arr.length - 1] + " frequency is= 1");
        }
    }

    private static int stock_buy_and_sell_approach_1(int arr[]) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (max < arr[j] - arr[i]) {
                    max = arr[j] - arr[i];
                }
            }
        }
        return max;
    }

    private static int maximum_length_even_odd_subarray(int arr[]) {
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 1;

            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] % 2 != arr[j + 1] % 2) {
                    count++;
                    maxCount = Math.max(count, maxCount);
                } else {
                    count = 1;
                    maxCount = Math.max(count, maxCount);
                    break;
                }
            }
        }

        return maxCount;
    }

    private static int maximum_length_even_odd_subarray_approach_2(int arr[]) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = 1;

            for (int j = i - 1; j < arr.length; j++) {
                if ((arr[j] % 2 == 0 && arr[j - 1] % 2 != 0) || (arr[j] % 2 != 0 && arr[j - 1] % 2 == 0)) {
                    curr++;
                } else {
                    break;
                }
            }

            res = Math.max(res, curr);
        }

        return res;
    }

    private static int maximum_length_even_odd_subarray_approach_3(int arr[]) {
        int res = 1, curr = 1;

        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0)) {
                curr++;
                res = Math.max(res, curr);
            } else {
                curr = 1;
            }
        }

        return res;
    }

    private static int majorityElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
                if (count > arr.length / 2) {
                    return i;
                }
            }
        }
        return -1;

    }

    private static int majorityElement_approach_2(int arr[]) {
        int res = 0, count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[res] == arr[i]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                res = i;
                count = 1;
            }
        }

        count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[res] == arr[i]) {
                count++;
            }
        }

        if (count <= arr.length / 2) {
            return -1;
        }

        return res;

    }

    public static void minimumGroupFlips(int arr[]) {
        int oneGroup = 0, zeroGroup = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                if (arr[i] == 0) {
                    zeroGroup++;
                } else {
                    oneGroup++;
                }
            }
        }


        if (arr[arr.length - 1] == 0) {
            zeroGroup++;
        } else {
            oneGroup++;
        }


        System.out.println("zeroGroup=" + zeroGroup);
        System.out.println("oneGroup=" + oneGroup);
    }

    public static void printGroups(int arr[]) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                if (arr[i] != arr[0]) {
                    System.out.print("From " + i + " to");
                } else {
                    System.out.print(i - 1);
                    System.out.println();
                }
            }
        }

        if (arr[arr.length - 1] != arr[0]) {
            System.out.print(arr.length - 1);
        }
    }

    public static void maximum_sum_of_k_consecutive_element(int arr[], int k) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            for (int j = i; j <= arr.length - k; j++) {
                int m = j;
                sum = 0;
                while (m < j + k) {
                    sum += arr[m];
                    m++;
                }
                max = Math.max(sum, max);
            }
        }

        System.out.println("Max= " + max);
    }

    public static void maximum_sum_of_k_consecutive_element_approach_2(int arr[], int k) {
        int res = Integer.MIN_VALUE;

        for (int i = 0; i + k - 1 < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += arr[i + j];
            }
            res = Math.max(sum, res);
        }

        System.out.println("Max=" + res);
    }

    //sliding window
    public static void maximum_sum_of_k_consecutive_element_approach_3(int arr[], int k) {
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += arr[i];
        }

        int res = curr;

        for (int i = k; i < arr.length; i++) {
            curr = curr + arr[i] - arr[i - k];
            res = Math.max(res, curr);
        }

        System.out.println("Max = " + res);
    }

    public static boolean subarray_sum_equals(int arr[], int sum) {
        int s = 0, curr = 0;
        for (int e = 0; e < arr.length; e++) {
            curr += arr[e];
            while (sum < curr) {
                curr = curr - arr[s];
                s++;
            }
            if (curr == sum) {
                return true;
            }
        }
        return false;
    }

    public static int prefix_sum(int arr[], int l, int r) {
        int sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            arr[i] = sum;
        }

        if (l == 0) {
            return arr[r];
        }

        return arr[r] - arr[l - 1];



    }



}
