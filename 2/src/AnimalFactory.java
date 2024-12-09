import java.time.LocalDate;

public interface AnimalFactory {
    AbstractAnimal createAnimal(String name, double cost, String character, LocalDate birthDate);
}

class DogFactory implements AnimalFactory {
    private final String breed;

    public DogFactory(String breed) {
        this.breed = breed;
    }

    @Override
    public AbstractAnimal createAnimal(String name, double cost, String character, LocalDate birthDate) {
        return new Dog(name, breed, cost, character, birthDate);
    }
}

class CatFactory implements AnimalFactory {
    private final String breed;

    public CatFactory(String breed) {
        this.breed = breed;
    }

    @Override
    public AbstractAnimal createAnimal(String name, double cost, String character, LocalDate birthDate) {
        return new Cat(name, breed, cost, character, birthDate);
    }
}

class TigerFactory implements AnimalFactory {
    private final String breed;

    public TigerFactory(String breed) {
        this.breed = breed;
    }

    @Override
    public AbstractAnimal createAnimal(String name, double cost, String character, LocalDate birthDate) {
        return new Tiger(name, breed, cost, character, birthDate);
    }
}

class WolfFactory implements AnimalFactory {
    private final String breed;

    public WolfFactory(String breed) {
        this.breed = breed;
    }

    @Override
    public AbstractAnimal createAnimal(String name, double cost, String character, LocalDate birthDate) {
        return new Wolf(name, breed, cost, character, birthDate);
    }
}
