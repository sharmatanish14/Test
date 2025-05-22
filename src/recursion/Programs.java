package recursion;

public class Programs {

    public static void main(String[] args) {
        int factorial = tailRecursiveFactorial(5, 1);
        System.out.println(factorial);
    }

    // printing 1 to N
    public static void fun(int n) {
        if (n == 0) {
            return;
        }

        fun(n - 1);
        System.out.print(n + " ");
    }

    //printing N to 1
    public static void printNTo1(int n) {
        if (n == 0) {
            return;
        }

        System.out.print(n + " ");
        printNTo1(n - 1);
    }

    // tail recursive for 1 to N
    public static void tailRecursiveFor1ToN(int n, int k) {
        if (n == 0) {
            return;
        }

        System.out.print(k + " ");
        tailRecursiveFor1ToN(n - 1, k + 1);
    }


    // factorial
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    // tail recursive factorial
    public static int tailRecursiveFactorial(int n, int k) {
        if (n == 1) {
            return k;
        }
        return tailRecursiveFactorial(n - 1, k * n);
    }

    //Fibonacci number using recursion:
    public static int calculateFabonacciNumber(int n) {
        if (n <= 1) {
            return n;
        }
        return calculateFabonacciNumber(n - 1) + calculateFabonacciNumber(n - 2);

    }

    // sum of natural number using recursion
    public static int sumOfNaturalNumber(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumOfNaturalNumber(n - 1);

    }

    // check if a string is palindrome
    public static boolean isStringPalindrome(String s, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return true;
        }

        if (s.charAt(leftIndex) != s.charAt(rightIndex)) {
            return false;
        }

        return isStringPalindrome(s, leftIndex + 1, rightIndex - 1);
    }

    //sum of digits using recursion
    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }

        return n % 10 + sumOfDigits(n / 10);

    }

    // rope cutting problem
    public static int maxPieces(int n, int a, int b, int c) {
        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return -1;
        }

        int res = Integer.max(maxPieces(n - a, a, b, c), Math.max(maxPieces(n - b, a, b, c), maxPieces(n - c, a, b, c)));

        if (res == -1) {
            return -1;
        }

        return res + 1;

    }

    // generate subset of string
    public static void generateSubsets(String input, String output, int index) {
        if (input.length() == index) {
            System.out.println(output);
            return;
        }
        generateSubsets(input, output, index + 1);
        generateSubsets(input, output + input.charAt(index), index + 1);

    }

    // tower of hanoi
    static void toh(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("move 1 from " + a + " to " + c);
            return;
        }

        toh(n - 1, a, c, b);
        System.out.println("Move " + n + " from " + a + " to " + c);
        toh(n - 1, b, a, c);
    }

    // Josephus problem using recursion.
    static int josephus(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (josephus(n - 1, k) + k) % n;
    }

    // subsets sum problem
    static int subsetSumProblem(int arr[], int n, int sum) {
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }
        return subsetSumProblem(arr, n - 1, sum) + subsetSumProblem(arr, n - 1, sum - arr[n - 1]);
    }

    // Swap characters at position i and j in the string
    public static String swap(String s, int i, int j) {
        if (i == j) return s;

        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        return new String(chars);
    }

    // Recursive function to generate permutations
    public static void permute(String s, int i) {
        if (i == s.length() - 1) {
            System.out.println(s);
            return;
        }

        for (int j = i; j < s.length(); j++) {
            // swap i and j
            s = swap(s, i, j);
            // recurse with i+1
            permute(s, i + 1);
            // backtrack (swap back)
            s = swap(s, i, j); // Important: backtrack to original state
        }

    }

}
