import java.time.LocalDate;

public class Predator extends AbstractAnimal {
    public Predator(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
class Tiger extends Predator {
    public Tiger(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}

class Wolf extends Predator {
    public Wolf(String name, String breed, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
