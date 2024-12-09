import java.time.LocalDate;

// Интерфейс AnimalFactory для создания объектов животных
public interface AnimalFactory {
    // Метод для создания животного с заданными параметрами
    AbstractAnimal createAnimal(String name, double cost, String character, LocalDate birthDate);
}

// Класс DogFactory, реализующий интерфейс AnimalFactory для создания собак
class DogFactory implements AnimalFactory {
    private final String breed; // Порода собаки

    // Конструктор класса DogFactory, инициализирующий породу собаки
    public DogFactory(String breed) {
        this.breed = breed; // Установка породы
    }

    @Override
    public AbstractAnimal createAnimal(String name, double cost, String character, LocalDate birthDate) {
        // Создание и возврат объекта Dog с заданными параметрами
        return new Dog(name, breed, cost, character, birthDate);
    }
}

// Класс CatFactory, реализующий интерфейс AnimalFactory для создания кошек
class CatFactory implements AnimalFactory {
    private final String breed; // Порода кошки

    // Конструктор класса CatFactory, инициализирующий породу кошки
    public CatFactory(String breed) {
        this.breed = breed; // Установка породы
    }

    @Override
    public AbstractAnimal createAnimal(String name, double cost, String character, LocalDate birthDate) {
        // Создание и возврат объекта Cat с заданными параметрами
        return new Cat(name, breed, cost, character, birthDate);
    }
}

// Класс TigerFactory, реализующий интерфейс AnimalFactory для создания тигров
class TigerFactory implements AnimalFactory {
    private final String breed; // Порода тигра

    // Конструктор класса TigerFactory, инициализирующий породу тигра
    public TigerFactory(String breed) {
        this.breed = breed; // Установка породы
    }

    @Override
    public AbstractAnimal createAnimal(String name, double cost, String character, LocalDate birthDate) {
        // Создание и возврат объекта Tiger с заданными параметрами
        return new Tiger(name, breed, cost, character, birthDate);
    }
}

// Класс WolfFactory, реализующий интерфейс AnimalFactory для создания волков
class WolfFactory implements AnimalFactory {
    private final String breed; // Порода волка

    // Конструктор класса WolfFactory, инициализирующий породу волка
    public WolfFactory(String breed) {
        this.breed = breed; // Установка породы
    }

    @Override
    public AbstractAnimal createAnimal(String name, double cost, String character, LocalDate birthDate) {
        // Создание и возврат объекта Wolf с заданными параметрами
        return new Wolf(name, breed, cost, character, birthDate);
    }
}