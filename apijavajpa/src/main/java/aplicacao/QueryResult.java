package aplicacao;

import javax.persistence.*;

public class QueryResult {
    public static void main(String[] args) {
        // Criar a fabrica de gerenciador de entidades
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        // Cria um gerenciador de entidades
        EntityManager em = emf.createEntityManager();
        // Dá inicio a transação
        em.getTransaction().begin();

        // Cria uma consulta para a execução
        Query query = em.createQuery("Update Produto set nome = :param where id=:id");

        // Alterar os parametros
        query.setParameter("param", "Leite piracanjuba");
        query.setParameter("id", 2);

        // Executar a senteça update sql
        int lines = query.executeUpdate();

        System.out.println("[INFO] ==== linhas afetadas :" + lines + " ==== [INFO]");

        // Encerra a transação
        em.getTransaction().commit();
        // Fecha o gerenciador de entidades
        em.close();
        // Fecha a fabrica
        emf.close();

    }
}
