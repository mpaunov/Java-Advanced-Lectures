package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println(sum);

        System.out.println(sumArr(arr, 0));
    }

    public static int sumArr(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }

        int sum = arr[index] + sumArr(arr, index + 1);
        return sum;
    }
}
