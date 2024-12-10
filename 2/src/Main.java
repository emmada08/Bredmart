import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр CreateAnimalService
        CreateAnimalServiceImpl createService = new CreateAnimalServiceImpl();

        // Вывод Созданных 10 уникальных животных
        System.out.println("\n=== Вывод Созданных 10 уникальных животных ===");
        List<AbstractAnimal> uniqueAnimals = createService.createUniqueAnimals();
        uniqueAnimals.forEach(System.out::println);
        // Генерация 5 животных через фабрику
        List<AbstractAnimal> animals = createService.createAnimalsWithFactory(5);
        System.out.println("\nГенерация животных с помощью фабрики:");
        animals.forEach(System.out::println);
        //Вывод Созданных N животных с использованием цикла for
        System.out.println("\n=== N животных с использованием цикла for ===");
        List<AbstractAnimal> animalsWithFor = createService.createAnimalsWithFor(new String[]{"Лаки","Белла", "Пушок"});
        animalsWithFor.forEach(System.out::println);
        //Вывод Созданных N животных с использованием цикла do while
        System.out.println("\n=== N животных с использованием цикла do while ===");
        List<AbstractAnimal> animalsWithDoWhile = createService.createAnimalsWithDoWhile(5);
        animalsWithDoWhile.forEach(System.out::println);
        // Используем SearchService
        SearchServiceImpl searchService = new SearchServiceImpl();
        //Вывод Животных родившиеся в високосный год
        System.out.println("\n=== Животные родившиеся в високосный год ===:");
        searchService.findLeapYearNames(uniqueAnimals).forEach(System.out::println);
        //Вывод Животных старше 10 лет:
        System.out.println("\n=== Животные старше 10 лет:");
        searchService.findOlderAnimal(uniqueAnimals, 10).forEach(System.out::println);
        //Вывод Дубликатов животных
        System.out.println("\n=== Дубликаты животных ===");
        searchService.findDuplicate(uniqueAnimals);
    }
}
