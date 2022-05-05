package br.unitins.almox.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.almox.application.RepositoryException;
import br.unitins.almox.model.Cidade;

public class CidadeRepository extends Repository<Cidade>  {
	
	public List<Cidade> findByNome(String nome) throws RepositoryException {
		try { 
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  c ");
			jpql.append("FROM ");
			jpql.append("  Cidade c ");
			jpql.append("WHERE ");
			jpql.append("  c.nome LIKE :nome ");
			
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("nome", "%" + nome + "%");
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}
	}

}
