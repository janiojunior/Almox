package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unitins.almox.model.PessoaFisica;

public class TesteJPA {
	public static void main(String[] args) {
		// teste de selecao em uma tabela para gerar o banco de dados.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Almox");
		EntityManager em = emf.createEntityManager();
		
//		Usuario usuario = new Usuario();
//		usuario.setId(1);
//		usuario.setNome("Janio Teixeira");
//		usuario.setLogin("janio");
//		usuario.setSenha("12345");
		
//		em.getTransaction().begin();
//		Usuario x = em.merge(usuario);
//		em.remove(x);
//		em.getTransaction().commit();
		
		PessoaFisica pf = new PessoaFisica();
		pf.setNome("Janio");
		pf.setEmail("janiojunior@gmail.com");
		pf.setCpf("11111111111");
		
		em.getTransaction().begin();
		em.merge(pf);
		em.getTransaction().commit();
		
		
		
//		Query query = em.createQuery("Select u FROM Usuario u");
//		query.getResultList();
		System.out.println("feito.");
	}
}
