package java8;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problems {


    public static void main(String[] args) {
        palindromeString();
    }


    // separate odd and even numbers
    public static void separateOddAndEvenNumbers(List<Integer> integerList) {

        Map<Boolean, List<Integer>> collect = integerList.stream().collect(Collectors.partitioningBy(integer -> integer % 2 == 0));

        System.out.println(collect);

        List<Integer> even = integerList.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());
        List<Integer> odd = integerList.stream().filter(integer -> integer % 2 != 0).collect(Collectors.toList());
        System.out.println(even);
        System.out.println(odd);


        Map<String, List<Integer>> result = integerList.stream()
                .collect(Collectors.groupingBy(n -> (n % 2 == 0) ? "Even" : "Odd"));

    }

    // frequency of each character in the string
    public static void frequencyOfEachCharacterInTheString() {
        String s = "tanishsharma";

        Map<Character, Long> collect = s.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);

    }

    // sort the list in the reverse order
    public static void sortListInReverseOder() {
        Arrays.asList("tanish", "jay", "vijay").stream().sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    // print multiple of 5
    public static void printMultipleOfFive() {
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream().filter(num -> num % 5 == 0).forEach(System.out::println);
    }

    // merge two unsorted array
    public static void mergeTwoUnsortedArray() {
        int arr1[] = {10, 20, 30, 69, 85};
        int arr2[] = {14, 25, 63, 98, 97};

        int[] array = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .sorted().toArray();
        System.out.println(Arrays.toString(array));
    }

    // 3 min max from an array

    public static void minMax() {
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 2, 344, 222, 55, 100)
                .stream().sorted().limit(3).forEach(System.out::println);

        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 2, 344, 222, 55, 100).stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);

    }

    // sort strings based on their length
    public static void sortStringBasedOnLength() {
        List<String> collect = Arrays.asList("tanish", "sharma", "jay", "vijay")
                .stream().sorted(Comparator.comparing(s -> s.length())).collect(Collectors.toList());

        System.out.println(collect);
    }

    // sum and average
    public static void sumAndAverage() {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int sum = Arrays.stream(arr).sum();
        double average = Arrays.stream(arr).average().getAsDouble();
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
    }

    // reverse an integer array
    public static void reverseAnIntegerArray() {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] array = IntStream.rangeClosed(0, arr.length - 1).map(value -> arr[arr.length - 1 - value]).toArray();

        System.out.println(Arrays.toString(array));
    }

    // palindrome string
    public static void palindromeString() {
        String s = "madam";

        boolean noneMatch = IntStream.range(0, s.length() / 2)
                .noneMatch(i -> s.charAt(i) != s.charAt(s.length() - i - 1));       // nothing should match with this predicate thats why nonMatch
        System.out.println(noneMatch);
    }

    // age of person in years
    public static void ageInYears() {
        LocalDate birthYear = LocalDate.of(1997, 12, 14);
        LocalDate now = LocalDate.now();
        long age = ChronoUnit.YEARS.between(birthYear, now);
        System.out.println(age);

    }

    //remove duplicate elements from the list
    public static void removeDuplicateElement() {
        Set<Integer> collect = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8).stream().collect(Collectors.toSet());
        List<Integer> col = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8).stream().distinct().collect(Collectors.toList());
        System.out.println(col);
    }

    // frequency of each element in an array
    public static void frequencyOfElement() {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 1, 2, 4, 5};

        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 1, 2, 4, 5).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // check if two strings are same
    public static void anagramString() {
        String s1 = "tanish";
        String s2 = "shtani";

        String s3 = s1.chars().mapToObj(value -> String.valueOf((char) value)).sorted().collect(Collectors.joining());
        String s4 = s2.chars().mapToObj(value -> String.valueOf((char) value)).sorted().collect(Collectors.joining());

        System.out.println(s3.equals(s4));
    }

    // sum of digits of a string
    public static void sumOfDigits() {
        int num = 1234;

        String[] split = String.valueOf(num).split("");
        Integer sum = Arrays.stream(split).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println(sum);

        AtomicInteger s = new AtomicInteger();
        Arrays.stream(split).forEach(s1 -> s.addAndGet(Integer.parseInt(s1)));
    }

    // second largest
    public static void secondLargest() {
        Integer i = Arrays.asList(1, 2, 3, 4, 5)
                .stream().sorted(Comparator.naturalOrder()).skip(1).findFirst().get();
        System.out.println(i);
    }

    // reverse each work of a string
    public static void reverseEachWord() {
        String s = "my name is tanish";

        String collected = Arrays.stream(s.split(" ")).map(s1 -> new StringBuffer(s1).reverse()).collect(Collectors.joining(" "));
        System.out.println(collected);
    }

    // print duplicate elements in the set
    public static void printDuplicateElements() {
        Set<Integer> set = new HashSet<>();

        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4)
                .stream().filter(integer -> !set.add(integer)).forEach(System.out::println);
    }

    public static void removeDeplicateFromTheString() {
        String s = "tanishsharma";

        // approach 1
        String collected = s.chars().distinct().mapToObj(value -> String.valueOf((char) value)).collect(Collectors.joining());

        //approach 2
        String collected1 = s.chars().mapToObj(value -> String.valueOf((char) value)).collect(Collectors.toCollection(LinkedHashSet::new))
                .stream().collect(Collectors.joining());
    }

}




