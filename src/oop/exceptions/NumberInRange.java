package oop.exceptions;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class NumberInRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int begin = range[0];
        int end = range[1];

        System.out.println("Range: [" + begin + "..." + end + "]");

        String input = scanner.nextLine();

        boolean isInRange = false;

        while (!isInRange) {

            Optional<Integer> number;

            try {
                number = Optional.of(Integer.parseInt(input));
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }  finally {
                System.out.println("I am always executed!");
            }

            if (number.get() < begin || number.get() > end) {
                System.out.println("Invalid number: " + input);
                input = scanner.nextLine();
            } else {
                isInRange = true;
            }
        }

        System.out.println("Valid number: " + input);

    }

}
