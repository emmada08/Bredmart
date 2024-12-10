import java.util.ArrayList;
import java.util.List;

public interface CreateAnimalService {

    /**
     * Создает 10 уникальных животных с использованием цикла while.
     *
     * @return список созданных животных.
     */
    default List<AbstractAnimal> createUniqueAnimals() {
        CreateAnimalServiceImpl impl = new CreateAnimalServiceImpl();
        return impl.createUniqueAnimals();
    }
}


