package aplication;

import javax.persistence.*;

public class Aplication {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager manager = factory.createEntityManager();

        try {
            manager.getTransaction().begin();
            String querySql = "delete from Produto where id =:id";
            Query query = manager.createQuery(querySql);
            query.setParameter("id", 1L);
            int linhasAfetadas = query.executeUpdate();
            manager.getTransaction().commit();
            System.out.printf("Update realizado, linhas afetadas %d", linhasAfetadas);
        } catch (Exception e) {
            System.out.println("Erro ao realizar update");
            e.printStackTrace();
        } finally {
            manager.close();
            factory.close();
        }
    }
}
