import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        Database database = Database.getInstance();

        database.create(13);

        Car car = getCar();

        Car car2 = car.clone();

        Address address = Address.builder()
                .withCity("Sofia")
                .withCountry("Bulgaria")
                .withPhoneNumber("1234")
                .withRecipientName("Martin")
                .withPostCode("1234")
                .withEmail("me@gmail.com")
                .build();

    }

    private static Car getCar() {
        return new Car("Ford", "Mustang", 2023, "Black", 245);
    }
}
