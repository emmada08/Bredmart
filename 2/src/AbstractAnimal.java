import java.time.LocalDate;
import java.util.*;


public abstract class AbstractAnimal implements Animal {
    protected String breed;
    protected String name;
    protected Double cost;
    protected String character;
    protected LocalDate birthDate;

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
        return Objects.equals(breed, that.breed) && Objects.equals(name, that.name) && Objects.equals(cost, that.cost) && Objects.equals(character, that.character) && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, name, cost, character, birthDate);
    }

    @Override
    public String toString() {
        return String.format("Животное - %s; Имя - %s; порода - %s; цена - %.2f; характер - %s;день рождения - %s;",
                this.getClass().getSimpleName(), name, breed, cost, character, birthDate);
    }
}


class CreateAnimalServiceImpl {
    private static final Random random = new Random();

    // Списки данных
    private static final String[] NAMES = {"Макс", "Белла", "Пушок", "Лаки", "Рекс"};
    private static final String[] CHARACTERS = {"Дружелюбный", "Агрессивный", "Спокойный", "Верный"};
    private static final String[] DOG_BREEDS = {"Лабрадор", "Хаски", "Чихуахуа", "Бульдог"};
    private static final String[] CAT_BREEDS = {"Британский", "Сиамский", "Бенгальский", "Мэин кун"};
    private static final String[] TIGER_BREEDS = {"Бенгальский тигр", "Сибирский Тигр", "Малайский Тигр"};
    private static final String[] WOLF_BREEDS = {"Серый волк", "Арктический волк", "Красный волк"};

    // Фабрики для каждого типа животного
    private final List<AnimalFactory> factories = new ArrayList<>();

    public CreateAnimalServiceImpl() {
        // Создаем фабрики для каждого типа животного
        for (String breed : DOG_BREEDS) factories.add(new DogFactory(breed));
        for (String breed : CAT_BREEDS) factories.add(new CatFactory(breed));
        for (String breed : TIGER_BREEDS) factories.add(new TigerFactory(breed));
        for (String breed : WOLF_BREEDS) factories.add(new WolfFactory(breed));
    }

    /**
     * Генерирует массив животных с использованием фабрики.
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

    public List<AbstractAnimal> createUniqueAnimals() {
        List<AbstractAnimal> uniqueAnimals = new ArrayList<>();
        while (uniqueAnimals.size() < 10) {
            AbstractAnimal animal2 = generateRandomAnimal();
            // Проверяем уникальность животного
            if (!uniqueAnimals.contains(animal2)) {
                uniqueAnimals.add(animal2);
                System.out.println(animal2.getInfo());
            }
        }
        return uniqueAnimals;
    }

    public List<AbstractAnimal> createAnimalsWithFor(int n) {
        List<AbstractAnimal> animalsWithFor = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            AbstractAnimal animal = generateRandomAnimal();
            animalsWithFor.add(animal);
            System.out.println(animal.getInfo());
        }
        return animalsWithFor;
    }

    public List<AbstractAnimal> createAnimalsWithDoWhile(int n) {
        List<AbstractAnimal> animalsWithDoWhile = new ArrayList<>();
        int count = 0;
        do {
            AbstractAnimal animal = generateRandomAnimal();
            animalsWithDoWhile.add(animal);
            System.out.println( animal.getInfo());
            count++;
        } while (count < n);
        return animalsWithDoWhile;
    }

    private AbstractAnimal generateRandomAnimal() {
        // Выбор случайной фабрики
        AnimalFactory factory = factories.get(random.nextInt(factories.size()));

        // Случайные данные
        String name = NAMES[random.nextInt(NAMES.length)];
        String character = CHARACTERS[random.nextInt(CHARACTERS.length)];
        double cost = 500 + random.nextDouble() * 1500;
        LocalDate birthDate = generateRandomDate();

        // Создаем животное через фабрику
        return factory.createAnimal(name, cost, character, birthDate);
    }

    private LocalDate generateRandomDate() {
        int year = random.nextInt(30) + 1990; // Год от 1990 до 2020
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(28) + 1;
        return LocalDate.of(year, month, day);
    }


}



