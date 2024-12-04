package aplication;

import java.util.Date;

import javax.persistence.*;

import modelo.Passeio;

public class Heranca {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Passeio p = new Passeio();
		p.setModelo("Lamborchini");
		p.setPreco(25_000_000.99);
		p.setVenda(new Date());
		p.setPortas(2);
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		System.out.println("Veiculo criado!!! "+p.getModelo());
	}
}
