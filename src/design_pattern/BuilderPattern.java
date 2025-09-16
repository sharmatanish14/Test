package design_pattern;

class Student{
    String name;
    int age;
    String aggress;

    public Student(String name, int age, String aggress) {
        this.name = name;
        this.age = age;
        this.aggress = aggress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", aggress='" + aggress + '\'' +
                '}';
    }
}

class StudentBuilder{
    String name;
    int age;
    String address;

    StudentBuilder name(String name){
        this.name=name;
        return this;
    }

    StudentBuilder age(int age){
        this.age=age;
        return this;
    }

    StudentBuilder address(String address){
        this.address=address;
        return this;
    }

    Student build(){
        return new Student(this.name, this.age, address);
    }
}

public class BuilderPattern {

    public static void main(String[] args) {
        Student student = new StudentBuilder()
                .name("tanish")
                .age(21)
                .address("askn")
                .build();

        System.out.println(student);
    }
}
