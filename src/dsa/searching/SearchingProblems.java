package dsa.searching;

public class SearchingProblems {

    public static void main(String[] args) {
        int i = sqrtUsingBinarySearch(8);
        System.out.println(i);
    }

    public static int find_first_ocurrence(int arr[], int left, int right, int x) {

        int mid = (left + right) / 2;


        if (arr[mid] > x) {
            return find_first_ocurrence(arr, left, mid - 1, x);
        } else if (arr[mid] < x) {
            return find_first_ocurrence(arr, mid + 1, right, x);
        } else {
            if (mid == 0 || arr[mid - 1] != arr[mid]) {
                return mid;
            } else {
                return find_first_ocurrence(arr, left, mid - 1, x);
            }
        }
    }

    public static int countOnes(int arr[], int left, int right) {


        if (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == 0) {
                return countOnes(arr, mid + 1, right);
            } else {
                if (mid == 0 || arr[mid - 1] == 0) {
                    return arr.length - mid;
                } else {
                    return countOnes(arr, left, mid - 1);
                }
            }
        }


        return 0;
    }

    public static int sqrt(int num) {
        int i = 1;

        while (i * i <= num) {
            i++;
        }

        return i - 1;
    }

    public static int sqrtUsingBinarySearch(int num) {
        int low = 1, high = num, ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int msq = mid * mid;
            if (msq > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
                ans = mid;
            }
        }

        return ans;
    }

    // search in infinite array
    public static int search(int arr[], int k) {

        int i = 0;

        while (true) {
            if (arr[i] == k) {
                return i;
            } else if (arr[i] > k) {
                return -1;
            }

            i++;
        }
    }

    // search in infinite array
    public static int search_2(int arr[], int k) {
        if (arr[0] == k) {
            return 0;
        }

        int i = 1;

        while (arr[i] < k) {
            i = 2 * i;
        }

        if (arr[i] == k) {
            return i;
        }

        return binarySearch(arr, i / 2 + 1, i, k);

    }


    public static int binarySearch(int arr[], int low, int high, int k) {

        if (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                return binarySearch(arr, low, mid - 1, k);
            } else {
                return binarySearch(arr, mid + 1, high, k);
            }
        }
        return 0;
    }


}
