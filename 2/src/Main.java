import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр CreateAnimalService
        CreateAnimalServiceImpl createService = new CreateAnimalServiceImpl();

        // Генерация 15 животных через фабрику
        List<AbstractAnimal>  animals= createService.createAnimalsWithFactory(5);

        // Вывод сгенерированных животных
        System.out.println("\nГенерация животных с помощью фабрики:");
        animals.forEach(System.out::println);

        System.out.println("\n=== Создание 10 уникальных животных ===");
        List<AbstractAnimal> uniqueAnimals = createService.createUniqueAnimals();

        System.out.println("\n=== N животных с использованием цикла for ===");
        List<AbstractAnimal> animalsWithFor = createService.createAnimalsWithFor(5);

        System.out.println("\n=== N животных с использованием цикла do while ===");
        List<AbstractAnimal> animalsWithDoWhile = createService.createAnimalsWithDoWhile(5);

        // Используем SearchService
        SearchServiceImpl searchService = new SearchServiceImpl();

        System.out.println("\nAnimals born in leap years:");
        searchService.findLeapYearNames(uniqueAnimals).forEach(System.out::println);

        System.out.println("\nAnimals older than 10 years:");
        searchService.findOlderAnimal(uniqueAnimals, 10).forEach(System.out::println);

        System.out.println("\n=== Дубликаты животных ===");
        searchService.findDuplicate(uniqueAnimals);
    }
}
