import java.time.LocalDate;

public class Pets extends AbstractAnimal {
    public Pets(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}

class Dog extends Pets {
    public Dog(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}

class Cat extends Pets {
    public Cat(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
