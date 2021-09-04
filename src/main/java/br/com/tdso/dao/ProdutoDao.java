package br.com.tdso.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.tdso.model.Produto;

public class ProdutoDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Produto p) {
		em.persist(p);
		
	}

}
