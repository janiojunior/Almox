package br.unitins.almox.repository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.unitins.almox.application.RepositoryException;
import br.unitins.almox.model.Usuario;

public class UsuarioRepository extends Repository<Usuario>  {
	
	public List<Usuario> findByNome(String nome) throws RepositoryException {
		try { 
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Usuario u ");
			jpql.append("WHERE ");
			jpql.append("  u.pessoaFisica.nome LIKE :nome ");
			
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("nome", "%" + nome + "%");
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}
	}
	
	public Usuario findByIdPessoaFisica(int id) throws RepositoryException {
		try { 
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  u ");
			jpql.append("FROM ");
			jpql.append("  Usuario u ");
			jpql.append("WHERE ");
			jpql.append("  u.pessoaFisica.id = :id ");
			
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("id", id);
			
			return (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;
	
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome.");
		}		
	}

}
