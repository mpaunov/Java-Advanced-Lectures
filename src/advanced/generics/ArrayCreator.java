package advanced.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {

    @SuppressWarnings("unchecked")
    public static <T> T[] create(int length, T defValue) {
        T[] arr = (T[])Array.newInstance(defValue.getClass(), length);

        Arrays.fill(arr, defValue);

        return arr;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<T> clazz, int length, T defValue) {
        T[] arr = (T[])Array.newInstance(clazz, length);

        Arrays.fill(arr, defValue);

        return arr;
    }
}
