package advanced.exampreparation.university;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        String result = null;

        if (getStudentCount() >= capacity) {
            result = "No seats in the advanced.exampreparation.university";
        }

        if (getStudent(student.firstName, student.lastName) != null) {
            result = "Student is already in the advanced.exampreparation.university";
        }

        if (result == null) {
            students.add(student);
            result = "Added student " + student.getFirstName() + " " + student.getLastName();
        }

        return result;
    }

    public String dismissStudent(Student student) {
        Student foundStudent = getStudent(student.getFirstName(), student.getLastName());

        if (foundStudent == null) {
            return "Student not found";
        }

        students.remove(student);

        return "Removed student " + foundStudent.getFirstName() + " " + foundStudent.getLastName();
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (firstName.equals(student.getFirstName()) && lastName.equals(student.getLastName())) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        return students.stream()
                .map(s -> String.format(
                        "==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                        s.getFirstName(), s.getLastName(), s.getBestSubject()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
