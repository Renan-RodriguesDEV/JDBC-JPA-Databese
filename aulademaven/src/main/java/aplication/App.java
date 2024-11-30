package aplication;

import javax.persistence.*;
import java.util.Date;
import modelo.Categoria;
import modelo.Produto;

public class App {

	public static void main(String[] args) {
		Categoria category = new Categoria("Frutas");
		Produto produto = new Produto("Banana",2.99,new Date(),category);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(produto);
			//em.getTransaction().commit();
			System.out.println("Create sucess: "+produto.getDescricao());
			queryProduto(em, 10,"AK47");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	static void queryProduto(EntityManager em,int id,String nome) {
		Query q = em.createQuery("Update Produto set descricao=:nome where id=:id");
		q.setParameter("id", id);
		q.setParameter("nome", nome);
		int rows = q.executeUpdate();
		System.out.println("Produto: "+rows);
	}

}
