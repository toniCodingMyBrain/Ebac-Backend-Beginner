package Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Automobile.Automobile;
import CompanyContract.CompanyContract;
import Factory.AutomobileFactory;

public class Manager {
    private String name;
    private List<CompanyContract> contractsList;
    /* private static String managerId; */

    public Manager(String name) {
        this.name = name;
        this.contractsList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public CompanyContract addAutomobileContract(AutomobileFactory factory, String type, String data) {
        Automobile automobile = factory.createAutomobile(type);
        CompanyContract contract = new CompanyContract(automobile, this.name, data);
        contractsList.add(contract);
        return contract;
    }

    public List<CompanyContract> getContractsList() {
        return new ArrayList<>(contractsList);
    }

    public List<CompanyContract> getContractsByBrand(String brand) {
        return getContractsList().stream().filter(c -> c.getAutomobile().getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    public Double getTotalCosts() {
        return getContractsList().stream().mapToDouble(c -> c.getAutomobile().getPrice()).sum();
    }
}
