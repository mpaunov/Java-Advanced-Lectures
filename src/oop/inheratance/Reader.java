package oop.inheratance;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    Scanner scanner;

    public Reader(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public int[] readIntArray(String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
