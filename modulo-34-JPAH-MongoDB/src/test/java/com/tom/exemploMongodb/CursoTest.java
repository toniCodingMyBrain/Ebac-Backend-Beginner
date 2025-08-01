/**
 * 
 */
package com.tom.exemploMongodb;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.tom.exemploMongodb.dao.CursoDao;
import com.tom.exemploMongodb.dao.ICursoDao;
import com.tom.exemploMongodb.domain.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author rodrigo.pires
 *
 */
public class CursoTest {

	private ICursoDao cursoDao;
	
	public CursoTest() {
		cursoDao = new CursoDao();
	}

	@Test
	public void cadastrar() {
		Curso curso = new Curso();
		curso.setCodigo("A1");
		curso.setDescricao("CURSO TESTE - Hibernate OGM");
		curso.setNome("Curso de Java Backend");
		curso = cursoDao.cadastrar(curso);
		
		Assertions.assertNotNull(curso);
		Assertions.assertNotNull(curso.getId());
	}

	@Test
	public void connectionTest(){
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase db = mongoClient.getDatabase("ebac_mongodb01");
		System.out.println("Conectado a: " + db.getName());
	}
}