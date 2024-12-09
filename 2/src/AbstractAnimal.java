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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractAnimal)) return false;
        AbstractAnimal that = (AbstractAnimal) o;
        // Сравнение всех полей для проверки равенства объектов
        return Objects.equals(breed, that.breed) && Objects.equals(name, that.name) &&
                Objects.equals(cost, that.cost) && Objects.equals(character, that.character) &&
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
class CreateAnimalServiceImpl {
    private static final Random random = new Random();

    // Списки данных для генерации животных
    private static final String[] NAMES = {"Макс", "Белла", "Пушок", "Лаки", "Рекс"};
    private static final String[] CHARACTERS = {"Дружелюбный", "Агрессивный", "Спокойный", "Верный"};
    private static final String[] DOG_BREEDS = {"Лабрадор", "Хаски", "Чихуахуа", "Бульдог"};
    private static final String[] CAT_BREEDS = {"Британский", "Сиамский", "Бенгальский", "Мэин кун"};
    private static final String[] TIGER_BREEDS = {"Бенгальский тигр", "Сибирский Тигр", "Малайский Тигр"};
    private static final String[] WOLF_BREEDS = {"Серый волк", "Арктический волк", "Красный волк"};

    // Список фабрик для создания различных типов животных
    private final List<AnimalFactory> factories = new ArrayList<>();

    // Конструктор класса для инициализации фабрик животных
    public CreateAnimalServiceImpl() {
        for (String breed : DOG_BREEDS) factories.add(new DogFactory(breed));  // Добавление фабрик собак
        for (String breed : CAT_BREEDS) factories.add(new CatFactory(breed));  // Добавление фабрик кошек
        for (String breed : TIGER_BREEDS) factories.add(new TigerFactory(breed));  // Добавление фабрик тигров
        for (String breed : WOLF_BREEDS) factories.add(new WolfFactory(breed));  // Добавление фабрик волков
    }

    /**
     * Создает список животных с использованием фабрики.
     *
     * @param count количество животных.
     * @return список сгенерированных животных.
     */
    public List<AbstractAnimal> createAnimalsWithFactory(int count) {
        List<AbstractAnimal> animals = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            animals.add(generateRandomAnimal());
        }
        return animals;
    }

    /**
     * Создает 10 уникальных животных.
     *
     * @return список уникальных животных.
     */
    public List<AbstractAnimal> createUniqueAnimals() {
        List<AbstractAnimal> uniqueAnimals = new ArrayList<>();
        while (uniqueAnimals.size() < 10) {
            AbstractAnimal animal2 = generateRandomAnimal();
            if (!uniqueAnimals.contains(animal2)) {
                uniqueAnimals.add(animal2);
                System.out.println(animal2.getInfo());
            }
        }
        return uniqueAnimals;
    }

    /**
     * Создает n животных с использованием цикла for.
     *
     * @param n количество животных.
     * @return список созданных животных.
     */
    public List<AbstractAnimal> createAnimalsWithFor(int n) {
        List<AbstractAnimal> animalsWithFor = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            AbstractAnimal animal = generateRandomAnimal();
            animalsWithFor.add(animal);
            System.out.println(animal.getInfo());
        }
        return animalsWithFor;
    }

    /**
     * Создает n животных с использованием цикла do-while.
     *
     * @param n количество животных.
     * @return список созданных животных.
     */
    public List<AbstractAnimal> createAnimalsWithDoWhile(int n) {
        List<AbstractAnimal> animalsWithDoWhile = new ArrayList<>();
        int count = 0;
        do {
            AbstractAnimal animal = generateRandomAnimal();
            animalsWithDoWhile.add(animal);
            System.out.println(animal.getInfo());
            count++;
        } while (count < n);
        return animalsWithDoWhile;
    }

    /**
     * Генерация случайного животного с использованием фабрики.
     *
     * @return сгенерированное животное.
     */
    private AbstractAnimal generateRandomAnimal() {
        AnimalFactory factory = factories.get(random.nextInt(factories.size()));

        // Случайные данные для создания животного
        String name = NAMES[random.nextInt(NAMES.length)];
        String character = CHARACTERS[random.nextInt(CHARACTERS.length)];
        double cost = 500 + random.nextDouble() * 1500;
        LocalDate birthDate = generateRandomDate();

        return factory.createAnimal(name, cost, character, birthDate);
    }

    /**
     * Генерирует случайную дату рождения.
     *
     * @return случайная дата рождения.
     */
    private LocalDate generateRandomDate() {
        int year = random.nextInt(30) + 1990; // Год от 1990 до 2020
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(28) + 1;
        return LocalDate.of(year, month, day);
    }
}