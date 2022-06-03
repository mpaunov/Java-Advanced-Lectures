package definingClasses;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carsCount = Integer.parseInt(scanner.nextLine());

        while (carsCount-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String brand = tokens[0];
            String model = tokens[1];
            int horsePower = Integer.parseInt(tokens[2]);

            Car car = new Car();

            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            System.out.println(car.carInfo());
        }
    }
}
