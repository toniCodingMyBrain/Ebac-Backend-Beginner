package factory;

import java.util.List;

public class AutomobileService<T extends Factory> {
    private AutomobileRepository<T> automobileRepository;

    public AutomobileService(AutomobileRepository<T> automobileRepository) {
        this.automobileRepository = automobileRepository;
    }

    public void addAutomobile(T automobile) {
        automobileRepository.addAutomobile(automobile);
        System.out.printf("Automobile added: %s, %s, %s, %s, %s.%n",
                automobile.getAutoName(),
                automobile.getAutoModel(),
                automobile.getAutoColor(),
                automobile.getAutoYear(),
                automobile.getAutoEngine());
    }

    public List<T> getAllAutomobile() {
        return automobileRepository.getAutomobileList();
    }
}
