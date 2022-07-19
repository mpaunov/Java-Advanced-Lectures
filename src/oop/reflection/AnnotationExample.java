package oop.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationExample {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;

        Method method = clazz.getDeclaredMethod("setName", String.class);

        Annotation[][] parameterAnnotations = method.getParameterAnnotations();

        Reflection reflection = new Reflection();

        method.setAccessible(true);

        MyAnnotation myAnnotation = (MyAnnotation) parameterAnnotations[0][0];

        method.invoke(reflection, myAnnotation.name());

        System.out.println(reflection);

    }
}
