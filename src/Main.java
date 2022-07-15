import oop.interfacesAndAbstraction.Audi;
import oop.interfacesAndAbstraction.Car;
import oop.interfacesAndAbstraction.Seat;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        Car car = new Seat("Leon", "blue", 110, "Spain", 1_000_000.00);

        doSmthWithCar(car);

        doSmthWithCar(new Audi("A3", "Blue", 110, "Germany",1 , 10D));


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    }

    public static void doSmthWithCar(Car car) {
        System.out.println(car.toString());
    }

}
