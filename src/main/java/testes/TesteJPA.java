package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.unitins.almox.model.Usuario;

public class TesteJPA {
	public static void main(String[] args) {
		// teste de selecao em uma tabela para gerar o banco de dados.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Almox");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNome("Janio Teixeira");
		usuario.setLogin("janio");
		usuario.setSenha("123456");
		
		em.getTransaction().begin();
		usuario = em.merge(usuario);
		em.getTransaction().commit();
		
		
		
//		Query query = em.createQuery("Select u FROM Usuario u");
//		query.getResultList();
		System.out.println("feito.");
	}
}
