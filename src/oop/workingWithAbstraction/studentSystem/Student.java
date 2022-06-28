package oop.workingWithAbstraction.studentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getInfo() {

        String studentInfo = String.format("%s is %s years old.", name, age);

        if (grade >= 5.00) {
            studentInfo += " Excellent student.";
        } else if (grade < 5.00 && grade >= 3.50) {
            studentInfo += " Average student.";
        } else {
            studentInfo += " Very nice person.";
        }

        return studentInfo;
    }
}
