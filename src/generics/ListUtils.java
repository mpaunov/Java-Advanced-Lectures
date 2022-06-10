package generics;

import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> elements) {
        return elements.stream()
                .min(T::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Empty collection"));
    }

    public static <T extends Comparable<T>> T getMax(List<T> elements) {
        return elements.stream()
                .max(T::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Empty collection"));
    }
}
