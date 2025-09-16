package builder;

public class Student {

    private String name;
    private int age;
    private String rollNo;

    private Student(StudentBuilder studentBuilder) {
        this.name = studentBuilder.name;
        this.age = studentBuilder.age;
        this.rollNo = studentBuilder.rollNo;
    }


    static StudentBuilder builder(){
        return new StudentBuilder();
    }

    public static void main(String[] args) {
        Student student = Student.builder()
                .name("tanish")
                .age(28)
                .rollNo("123456789")
                .build();
    }

    static class StudentBuilder {
        private String name;
        private int age;
        private String rollNo;

        StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        StudentBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        StudentBuilder rollNo(String rollNo) {
            this.rollNo = rollNo;
            return this;
        }

        Student build() {
            return new Student(this);
        }

    }
}
