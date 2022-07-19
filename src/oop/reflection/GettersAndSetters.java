package oop.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.TreeSet;
import java.util.function.Function;

import static oop.reflection.ReflectionUtils.collectByName;
import static oop.reflection.ReflectionUtils.filterMembersByName;

public class GettersAndSetters {
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        TreeSet<Method> getters = collectByName(filterMembersByName(methods, "get"));

        TreeSet<Method> setters = collectByName(filterMembersByName(methods, "set"));

        Function<Class<?>, String> formatType = c -> c == int.class ? "class int" : c.toString();

        getters
                .forEach(m -> System.out.printf("%s will return %s%n", m.getName(),
                        formatType.apply(m.getReturnType())));

        setters
                .forEach(m -> System.out.printf("%s and will set field of %s%n", m.getName(),
                        formatType.apply(m.getParameterTypes()[0])));
    }

}
