package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TesteJPA {
	public static void main(String[] args) {
		// teste de selecao em uma tabela para gerar o banco de dados.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Almox");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("Select u FROM Usuario u");
		query.getResultList();
		System.out.println("feito.");
	}
}
