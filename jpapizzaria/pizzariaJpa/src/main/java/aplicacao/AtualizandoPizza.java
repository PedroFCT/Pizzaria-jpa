package aplicacao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import dominio.Pizza;


public class AtualizandoPizza {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzariajpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		Pizza pizza = em.find(Pizza.class, 1L);
		
		System.out.println("Valor atual: " + pizza.getValor());
		pizza.setValor(pizza.getValor());
		System.out.println("Novo valor: " + pizza.getValor());

		em.getTransaction().commit();

		System.out.println("pronto!");
		em.close(); 
		emf.close();
	}

}
