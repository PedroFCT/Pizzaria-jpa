package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Ingredientes;
import dominio.Pizza;
import dominio.TipoPizza;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzariajpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Ingredientes queijo = new Ingredientes();
		Ingredientes calabresa = new Ingredientes();
		Ingredientes frango = new Ingredientes();
		Ingredientes catupiry = new Ingredientes();
		Ingredientes molhoDeTomate = new Ingredientes();
		Ingredientes peperoni = new Ingredientes();
		Ingredientes brigadeiro = new Ingredientes();
		Ingredientes morango = new Ingredientes();
		
		em.persist(queijo);
		em.persist(calabresa);
		em.persist(frango);
		em.persist(catupiry);
		em.persist(molhoDeTomate);
		em.persist(peperoni);
		em.persist(brigadeiro);
		em.persist(morango);

		Pizza pizza1 = new Pizza();
		pizza1.setSabor("Mussarela");
		pizza1.setTipoPizza(TipoPizza.Salgada);
		pizza1.setValor("R$ 25,00");
		pizza1.getIngredientes().add(queijo);
		pizza1.getIngredientes().add(molhoDeTomate);
		
		Pizza pizza2 = new Pizza();
		pizza2.setSabor("Frango com catupiry");
		pizza2.setTipoPizza(TipoPizza.Salgada);
		pizza2.setValor("R$ 30,00");
		pizza2.getIngredientes().add(frango);
		pizza2.getIngredientes().add(catupiry);
		
		Pizza pizza3 = new Pizza();
		pizza3.setSabor("Brigadeiro com morango");
		pizza3.setTipoPizza(TipoPizza.Doce);
		pizza3.setValor("R$ 27,00");
		pizza3.getIngredientes().add(brigadeiro);
		pizza3.getIngredientes().add(morango);
		
		em.persist(pizza1);
		em.persist(pizza2);
		em.persist(pizza3);
		
		em.getTransaction().commit();
		
		System.out.println("pronto!");
		em.close();
		emf.close();
	}

}
