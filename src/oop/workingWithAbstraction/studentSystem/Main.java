package oop.workingWithAbstraction.studentSystem;

import oop.workingWithAbstraction.DayOfWeek;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        while (true) {
            String[] input = scanner.nextLine().split("\\s+");

            if (input[0].equals("Exit")) {
                break;
            }

            studentSystem.ParseCommand(input);
        }

    }
}
