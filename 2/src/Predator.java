import java.time.LocalDate;
// Класс Predator, наследующий от AbstractAnimal
public class Predator extends AbstractAnimal {
    // Конструктор класса Predator, инициализирующий поля животного
    public Predator(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
// Класс Tiger, наследующий от Predator
class Tiger extends Predator {
    // Конструктор класса Tiger, инициализирующий поля тигра
    public Tiger(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
// Класс Wolf, наследующий от Predator
class Wolf extends Predator {
    // Конструктор класса Wolf, инициализирующий поля волка
    public Wolf(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
