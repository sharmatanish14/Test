package java8.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class SecondHighestSalary {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Tanish", 10000),
                new Employee("Jay", 20000),
                new Employee("Vijay", 30000),
                new Employee("Ajay", 20000),
                new Employee("Sanjay", 40000)
        );

        // Find second highest salary employees
        List<Employee> secondHighestSalaryEmployees =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getSalary)) // group by salary
                        .keySet().stream()
                        .sorted(Comparator.reverseOrder()) // sort salaries descending
                        .skip(1) // skip the highest
                        .findFirst() // get second highest
                        .map(sal -> employees.stream()
                                .filter(emp -> emp.getSalary() == sal)
                                .collect(Collectors.toList()))
                        .orElse(Collections.emptyList());

        System.out.println("Employees with second highest salary: " + secondHighestSalaryEmployees);


    }
}

class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }
}

