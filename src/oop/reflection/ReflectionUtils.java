package oop.reflection;

import java.lang.reflect.Member;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReflectionUtils {

    private ReflectionUtils() throws IllegalAccessException {
        throw new IllegalAccessException("Accessing this constructor is forbidden");
    }

    public static <T extends Member> Stream<T> filterMembersByName(T[] members, String filter) {
        return filterMembers(members, m -> m.getName().contains(filter));
    }

    public static <T extends Member> Stream<T> filterMembers(T[] members, Predicate<T> predicate) {
        return filterMembers(Arrays.stream(members), predicate);
    }

    public static <T extends Member> Stream<T> filterMembers(Stream<T> stream, Predicate<T> predicate) {
        return stream.filter(predicate);
    }

    public static <T extends Member> TreeSet<T> collectByName(Stream<T> stream) {
        return stream.collect(Collectors.toCollection(
                () -> new TreeSet<>(Comparator.comparing(Member::getName))));
    }

}
