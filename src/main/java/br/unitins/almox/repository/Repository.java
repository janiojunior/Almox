package br.unitins.almox.repository;

import javax.persistence.EntityManager;

import br.unitins.almox.application.JPAUtil;
import br.unitins.almox.model.DefaultEntity;

public class Repository<T extends DefaultEntity> {

	public Repository() {
		super();
	}

	public void save(T entity) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

}