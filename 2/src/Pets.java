import java.time.LocalDate;

// Класс Pets, наследующий от AbstractAnimal
public class Pets extends AbstractAnimal {
    // Конструктор класса Pets, инициализирующий поля животного
    public Pets(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate); // Вызов конструктора родительского класса
    }
}

// Класс Dog, наследующий от Pets
class Dog extends Pets {
    // Конструктор класса Dog, инициализирующий поля собаки
    public Dog(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate); // Вызов конструктора родительского класса Pets
    }
}

// Класс Cat, наследующий от Pets
class Cat extends Pets {
    // Конструктор класса Cat, инициализирующий поля кошки
    public Cat(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate); // Вызов конструктора родительского класса Pets
    }
}