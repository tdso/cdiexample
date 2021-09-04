package br.com.tdso.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.tdso.model.Configuracao;

public class ConfiguracaoDao {
	
	@PersistenceContext
	private EntityManager em;

	public void salvaConfiguracao(Configuracao c) {
		em.persist(c);	
	}

	public Configuracao getConfiguracao(Long id) {
		return em.find(Configuracao.class, id);
	}

}
