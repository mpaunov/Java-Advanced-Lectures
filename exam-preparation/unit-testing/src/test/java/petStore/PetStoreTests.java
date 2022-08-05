package petStore;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PetStoreTests {

    private static final String SPECIE = "Dog";
    private static final int MAX_WEIGHT = 30;

    private static final double PRICE = 100.00;

    private PetStore petStore;
    private Animal animal;

    @Before
    public void setUp() {
        this.petStore = new PetStore();
        this.animal = new Animal(SPECIE, MAX_WEIGHT, PRICE);
    }


    @Test(expected = UnsupportedOperationException.class)
    public void test_GetAnimals_ShouldReturn_UnmodifiableList() {
        List<Animal> animals = petStore.getAnimals();
        animals.remove(1);
    }

    @Test
    public void test_GetCount_ShouldReturnZero_WhenEmpty_And_One_When_SingleAnimalAdded() {
        assertEquals(0, petStore.getCount());
        petStore.addAnimal(animal);
        assertEquals(1, petStore.getCount());
    }

    @Test
    public void test_FindAllAnimalsWithMaxKilograms_Should_Return_EmptyList_WhenNoSuchAnimals() {
        petStore.addAnimal(animal);
        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(MAX_WEIGHT + 10);
        assertTrue(animals.isEmpty());
    }

    @Test
    public void test_FindAllAnimalsWithMaxKilograms_Should_Return_OnlyThoseHeavier() {
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("test", MAX_WEIGHT - 2, PRICE));
        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(MAX_WEIGHT - 1);
        assertEquals(1, animals.size());
        assertEquals(animal.getSpecie(), animals.get(0).getSpecie());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddAnimal_ShouldThrow_WhenAnimal_Is_Null() {
        petStore.addAnimal(null);
    }

    @Test
    public void test_AddAnimal_ShouldIncreaseCount() {
        petStore.addAnimal(animal);
        assertEquals(1, petStore.getCount());
    }

    @Test
    public void test_GetTheMostExpensiveAnimal_Should_Return_Null_WhenEmpty() {
        Animal animal = petStore.getTheMostExpensiveAnimal();
        assertNull(animal);
    }

    @Test
    public void test_GetTheMostExpensiveAnimal_Should_Return_TheMostExpensiveOne() {
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal(SPECIE, MAX_WEIGHT, PRICE - 10));
        Animal actualAnimal = petStore.getTheMostExpensiveAnimal();
        assertEquals(animal.getPrice(), actualAnimal.getPrice(), 0.00);
    }

    @Test
    public void test_FindAllAnimalBySpecie_ShouldReturn_EmptyList_When_NoAnimals() {
        List<Animal> animals = petStore.findAllAnimalBySpecie(SPECIE);
        assertTrue(animals.isEmpty());
    }

    @Test
    public void test_FindAllAnimalBySpecie_ShouldReturn_OnlyTheRequired_SPECIE() {
        petStore.addAnimal(animal);
        petStore.addAnimal(new Animal("Goat", MAX_WEIGHT, PRICE));
        List<Animal> animals = petStore.findAllAnimalBySpecie(SPECIE);
        assertEquals(1, animals.size());
        assertEquals(SPECIE, animals.get(0).getSpecie());
    }

}

