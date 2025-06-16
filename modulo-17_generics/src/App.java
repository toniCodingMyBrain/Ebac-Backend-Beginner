import Facade.AutomobileFacade;
import factory.AutomobileRepository;
import factory.AutomobileService;
import factory.Factory;
import factory.automobile.C14;
import factory.automobile.F100;
import factory.automobile.Galaxie;
import factory.automobile.Opala;

public class App {

    /**
     * @author antonio
     * 
     *         Exercício: criar um projeto de gerenciar lista que
     *         aceite classes de carros de diferentes tipos ou marcas
     *         usando Generics, padão de facade e injeção de dependências.
     */

    public static void main(String[] args) throws Exception {
        // Criando repositório
        AutomobileRepository<Factory> automobileRepository = new AutomobileRepository<>();

        // Criando os serviços com injeção de dependências
        AutomobileService<Factory> automobileService = new AutomobileService<>(automobileRepository);

        // Criando o Facade
        AutomobileFacade autoFacade = new AutomobileFacade(automobileService);

        // Adicionando os automoveis
        autoFacade.addAutomobile(new C14());
        autoFacade.addAutomobile(new Galaxie());
        autoFacade.addAutomobile(new Opala());
        autoFacade.addAutomobile(new F100());

        // listando carros chevrolet
        System.out.println("\nListando carros Chevrolet:");
        autoFacade.getAutomobileChevrolet();

        // listando carros Ford
        System.out.println("\nListando carros Ford:");
        autoFacade.getAutomobileFord();
    }
}
