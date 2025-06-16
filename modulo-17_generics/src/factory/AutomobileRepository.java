package factory;

import java.util.ArrayList;
import java.util.List;

public class AutomobileRepository<T extends Factory> {
    private List<T> automobiles = new ArrayList<>();

    public void addAutomobile(T automobile) {
        automobiles.add(automobile);
    }

    public List<T> getAutomobileList() {
        return automobiles;
    }
}
