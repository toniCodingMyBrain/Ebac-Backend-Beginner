
import java.lang.reflect.Constructor;

import Annotation.Tabela;
import Annotation.TabelaTeste;

public class App {
    public static void main(String[] args) throws Exception {
        Class<TabelaTeste> clazz = TabelaTeste.class;
        System.out.println();
        if (clazz.isAnnotationPresent(Tabela.class)) {
            // * obtendo anotação da classe
            Tabela tabelaClasse = clazz.getAnnotation(Tabela.class);
            System.out.println("Anotação na classe: ");
            System.out.println("Nome completo: " + String.join(", ", tabelaClasse.nomeCompleto()));
            System.out.println("Cidade: " + tabelaClasse.cidade());

            // * obtendo anotação do construtor
            Constructor<TabelaTeste> constructor = clazz.getConstructor();
            if (constructor.isAnnotationPresent(Tabela.class)) {
                Tabela tabelaConstructor = constructor.getAnnotation(Tabela.class);
                System.out.println("Anotação do construtor: ");
                System.out.println("Nome completo: " + String.join(", ", tabelaConstructor.nomeCompleto()));
                System.out.println("Cidade: " + tabelaConstructor.cidade());
            }
        } else {
            System.out.println("A classe não tem anotação Tabela");
        }
    }
}
