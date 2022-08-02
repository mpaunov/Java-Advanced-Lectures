public class Car implements Cloneable<Car> {

    private String make;
    private String model;
    private int year;
    private String color;
    private int horsePower;

    public Car(String make, String model, int year, String color, int horsePower) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.horsePower = horsePower;
    }

    private Car(Car other) {
        this.make = other.make;
        this.model = other.model;
        this.year = other.year;
        this.color = other.color;
        this.horsePower = other.horsePower;
    }

    @Override
    public Car clone() {
        return new Car(this);
    }

}
