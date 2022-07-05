package oop.inheratance;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.eat();
        dog.bark();

        Cat cat = new Cat();

        cat.eat();
        cat.meow();

        RandomArrayList list = new RandomArrayList();

        list.add(13);
        list.add(42);
        list.add(73);
        list.add(69);
        list.add(51);

        System.out.println(list.getRandomElement());

        Reader reader = new Reader(System.in);

        System.out.println(Arrays.toString(reader.readIntArray("\\s+")));

        MyStack strings = new MyStack();

        strings.push("my-solution");
        System.out.println(strings.pop());
    }
}
