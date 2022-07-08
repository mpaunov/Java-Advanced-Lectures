package oop.interfacesAndAbstraction.borderControl;

public class Citizen extends IdentifiableImpl {

    private int age;
    private String name;

    public Citizen(String id, int age, String name) {
        super(id);
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

}
