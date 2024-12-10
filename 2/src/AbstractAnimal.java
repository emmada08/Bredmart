import java.time.LocalDate;
import java.util.*;

// Абстрактный класс для животных, реализующий интерфейс Animal
public abstract class AbstractAnimal implements Animal {
    protected String breed;      // Порода животного
    protected String name;       // Имя животного
    protected Double cost;       // Стоимость животного
    protected String character;  // Характер животного
    protected LocalDate birthDate; // Дата рождения животного

    // Конструктор для инициализации полей животного
    public AbstractAnimal(String breed, String name, Double cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    // Метод для получения информации о животном в виде строки
    public String getInfo() {
        return String.format(
                "Животное - %s; Имя - %s; Порода - %s; Цена - %.2f; Характер - %s; Дата рождения - %s;",
                this.getClass().getSimpleName(), name, breed, cost, character, birthDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractAnimal that = (AbstractAnimal) obj;
        return Double.compare(that.cost, cost) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(breed, that.breed) &&
                Objects.equals(character, that.character) &&
                Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        // Генерация хэш-кода на основе полей животного для использования в коллекциях
        return Objects.hash(breed, name, cost, character, birthDate);
    }

    @Override
    public String toString() {
        // Строковое представление объекта для удобства вывода информации о животном
        return String.format("Животное - %s; Имя - %s; порода - %s; цена - %.2f; характер - %s; день рождения - %s;",
                this.getClass().getSimpleName(), name, breed, cost, character, birthDate);
    }
}

// Класс для создания животных с использованием фабрики
