package br.com.tom;

import br.com.tom.entities.Pessoa;
import br.com.tom.enumerators.Genero;

import java.util.List;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Pessoa> db = new Pessoa().popularDados();

        /*System.out.println(db);*/

        Stream<Pessoa> meninas = db.stream()
                .filter(p -> p.getGenero().equals(Genero.FEMININO));

        meninas.forEach(p -> System.out.println(p));
    }
}