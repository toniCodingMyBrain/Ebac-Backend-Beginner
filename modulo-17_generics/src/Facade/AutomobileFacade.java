package Facade;

import factory.AutomobileService;
import factory.Factory;

public class AutomobileFacade {
    private AutomobileService<Factory> automobileList;

    public AutomobileFacade(AutomobileService<Factory> automobileList) {
        this.automobileList = automobileList;
    }

    public void addAutomobile(Factory automobile) {
        automobileList.addAutomobile(automobile);
    }

    public void getAutomobileChevrolet() {
        automobileList.getAllAutomobile().stream()
                .forEach(c -> {
                    if ("Chevrolet".equalsIgnoreCase(c.getAutoName())) {
                        System.out.println(c);
                    }
                });
    }

    public void getAutomobileFord() {
        automobileList.getAllAutomobile().stream()
                .forEach(f -> {
                    if ("Ford".equalsIgnoreCase(f.getAutoName())) {
                        System.out.println(f);
                    }
                });
    }
}
