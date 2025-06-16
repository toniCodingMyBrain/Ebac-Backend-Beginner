import CompanyContract.CompanyContract;
import Factories.HondaFactory;
import Factories.ToyotaFactory;
import Factory.AutomobileFactory;
import Manager.Manager;

public class App {
    public static void main(String[] args) throws Exception {

        // Criando fabricas
        AutomobileFactory toyotaFactory = new ToyotaFactory();
        AutomobileFactory hondaFactory = new HondaFactory();

        // Criando gerentes
        Manager managerA = new Manager("Gilbert Barrett");
        Manager managerB = new Manager("Roxie Young");

        // Comprando automóveis
        CompanyContract contract001 = managerA.addAutomobileContract(hondaFactory, "sedan", "20/03/2025");
        CompanyContract contract002 = managerB.addAutomobileContract(toyotaFactory, "SUV", "19/01/2025");
        CompanyContract contract003 = managerA.addAutomobileContract(toyotaFactory, "hatch", "04/02/2025");
        CompanyContract contract004 = managerB.addAutomobileContract(hondaFactory, "sedan", "10/01/2025");

        // Exibindo contratos Gerente A:
        System.out.printf("===========> Contratos do Gerente %s <==========\n", managerA.getName());
        System.out.println("1. Todos os contratos:");
        managerA.getContractsList().forEach(c -> {
            System.out.println(c);
            System.out.println("--------------------------------");
        });
        System.out.printf("2. Relatórios dos valores dos contratos: R$%.2f.%n", managerA.getTotalCosts());
        System.out.println("--------------------------------");
        System.out.println("3. Contratos por marca:");
        managerA.getContractsByBrand("Toyota").forEach(c -> System.out.println(c));
        managerA.getContractsByBrand("Honda").forEach(c -> System.out.println(c));
        System.out.println(
                "------------------------------------------------------------------------------------------------");

        // Exibindo contratos Gerente B:
        System.out.printf("\n===========> Contratos do Gerente %s <==========\n", managerB.getName());
        System.out.println("1. Todos os contratos:");
        managerB.getContractsList().forEach(c -> {
            System.out.println(c);
            System.out.println("--------------------------------");
        });
        System.out.printf("2. Relatórios dos valores dos contratos: R$%.2f.%n", managerB.getTotalCosts());
        System.out.println("--------------------------------");
        System.out.println("3. Contratos por marca:");
        managerB.getContractsByBrand("Toyota").forEach(c -> System.out.println(c));
        managerB.getContractsByBrand("Honda").forEach(c -> System.out.println(c));
        System.out.println(
                "------------------------------------------------------------------------------------------------");
    }
}
