package etc;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Movie implements Comparable<Movie> {

    private double rating;
    private String name;
    private int year;

    public Movie(double rating, String name, int year) {
        this.rating = rating;
        this.name = name;
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(Movie o) {
        return this.year - o.year;
    }

    @Override
    public String toString() {
        return "Rating = " + rating + " year = " + year + " name= " + name;
    }
}

class Test {
    public static void main(String[] args) {
        NavigableSet<Movie> movieList = new TreeSet<>();   // treeSet can take comparator as an arguments

        movieList.add(new Movie(8.15, "Bahubali", 2015));
        movieList.add(new Movie(8.7, "Mr India", 1980));
        movieList.add(new Movie(8.8, "Amar akbar", 1983));

        System.out.println(movieList);

    }
}
