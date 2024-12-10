import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateAnimalServiceImpl implements CreateAnimalService {
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
     * Создает 10 животных с использованием цикла while.
     *
     * @return список созданных животных.
     */
    public List<AbstractAnimal> createUniqueAnimals() {
        List<AbstractAnimal> animals = new ArrayList<>();
        int count = 0;
        while (count < 10) {
            animals.add(generateRandomAnimal());
            count++;
        }
        return animals;
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
     * Создает n животных с использованием цикла for.
     *
     * @param names количество животных.
     * @return список созданных животных.
     */
    public List<AbstractAnimal> createAnimalsWithFor(String[] names) {
        List<AbstractAnimal> animalsWithFor = new ArrayList<>(); // Список для хранения уникальных животных
        for (String name : names) { // Проходим по всем именам
            AbstractAnimal animal = generateAnimalWithName(name); // Генерируем животное с указанным именем
            // Проверяем, есть ли уже такое животное
            if (!animalsWithFor.contains(animal)) {
                animalsWithFor.add(animal); // Добавляем животное, если оно уникальное
                System.out.println(animal.getInfo()); // Выводим информацию о животном
            }
        }
        return animalsWithFor; // Возвращаем список уникальных животных
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
    public AbstractAnimal generateRandomAnimal() {
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

    private AbstractAnimal generateAnimalWithName(String name) {
        AnimalFactory factory = factories.get(random.nextInt(factories.size()));
        String character = CHARACTERS[random.nextInt(CHARACTERS.length)];
        double cost = 500 + random.nextDouble() * 1500;
        LocalDate birthDate = generateRandomDate();
        return factory.createAnimal(name, cost, character, birthDate);
    }
}