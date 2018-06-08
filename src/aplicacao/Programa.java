package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa(null, "Bruno Oliveira", "btozetto@gmail.com");
		System.out.println(p1);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p1);
		em.getTransaction().commit();
		Pessoa p = em.find(Pessoa.class,3);
		System.out.println(p);		
		System.out.println("Pronto!");
		em.close();
		emf.close();

	}
}
