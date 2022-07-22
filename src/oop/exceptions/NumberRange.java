package oop.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberRange {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int start = 1;

        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 10) {

            int number;

            try {
                number = readNumber(start, 100, scanner);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());

                continue;
            }

            start = number;
            numbers.add(number);
        }

        System.out.println(
                numbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "))
        );
    }

    public static int readNumber(int start, int end, Scanner scanner) {

        String input = scanner.nextLine();

        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid Number!");
        }

        if (number <= start || number >= end) {
            throw new IllegalStateException("Your number is not in range " + start + " - 100!");
        }

        return number;
    }

}
