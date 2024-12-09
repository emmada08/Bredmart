import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface SearchService {

    List<String> findLeapYearNames(List<AbstractAnimal> animals);


    List<AbstractAnimal> findOlderAnimal(List<AbstractAnimal> animals, int age);


    void findDuplicate(List<AbstractAnimal> animals);
}

class SearchServiceImpl implements SearchService {


    @Override
    public List<String> findLeapYearNames(List<AbstractAnimal> animals) {
        return animals.stream()
                .filter(animal -> animal.getBirthDate().isLeapYear())
                .map(AbstractAnimal::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<AbstractAnimal> findOlderAnimal(List<AbstractAnimal> animals, int age) {
        LocalDate now = LocalDate.now();
        return animals.stream()
                .filter(animal -> now.getYear() - animal.getBirthDate().getYear() > age)
                .collect(Collectors.toList());
    }

    @Override
    public void findDuplicate(List<AbstractAnimal> animals) {
        Set<AbstractAnimal> uniqueAnimals = new HashSet<>();
        animals.stream()
                .filter(animal -> !uniqueAnimals.add(animal))
                .forEach(System.out::println);
    }
}