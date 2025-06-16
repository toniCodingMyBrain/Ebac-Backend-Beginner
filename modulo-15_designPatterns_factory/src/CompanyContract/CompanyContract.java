package CompanyContract;

import Automobile.Automobile;
import java.util.UUID;

public class CompanyContract {
    private String id;
    private Automobile automobile;
    private String clientName;
    private String data;

    public CompanyContract(Automobile automobile, String clientName, String data) {
        this.id = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.automobile = automobile;
        this.clientName = clientName;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public Automobile getAutomobile() {
        return automobile;
    }

    public String getClientName() {
        return clientName;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contrato #" + this.getId() +
                ".\nAutomóvel: {" + this.automobile.getBrand() + ", "
                + this.automobile.getModel(this.automobile.getBrand()) + ", "
                + this.automobile.getPrice() + "}" +
                ".\nNome do Cliente: " + this.clientName +
                ".\nData de Vencimento: " + this.data);

        return sb.toString();
    }
}
