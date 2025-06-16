package br.com.tom;

import br.com.tom.entities.Pessoa;
import br.com.tom.enumerators.Genero;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
public class GetFeminineTest {
    private List<Pessoa> db;
    @Before
    public void setUp(){
         db = new Pessoa().popularDados();
    }

    @Test
    public void testListaTemDezElementos(){
        assertEquals("A lista deve conter 10 pessoas.", 10, db.size());
    }

    @Test
    public void testFiltrarPorMulheres(){
        List<Pessoa> meninas = db.stream()
                .filter(p -> p.getGenero().equals(Genero.FEMININO))
                .toList();
        assertEquals("Deve conter apenas 6 elementos.", 6, meninas.size());
    }
}