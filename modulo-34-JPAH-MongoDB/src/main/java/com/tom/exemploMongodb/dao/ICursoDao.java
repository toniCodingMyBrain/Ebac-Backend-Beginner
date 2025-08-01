/**
 * 
 */
package com.tom.exemploMongodb.dao;

import java.util.List;

import com.tom.exemploMongodb.domain.Curso;

/**
 * @author rodrigo.pires
 *
 */
public interface ICursoDao {

	public Curso cadastrar(Curso curso);

	public void excluir(Curso cur);

	public List<Curso> buscarTodos();
}