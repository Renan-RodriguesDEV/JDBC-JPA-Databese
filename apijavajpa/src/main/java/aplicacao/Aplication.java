package aplicacao;

import java.util.Date;
import dominio.Produto;

import javax.persistence.*;

public class Aplication {

    public static void main(String[] args) {

        Date data = new Date(20241225);
        Produto objProduto = new Produto("Leite", 6.50, data);

        // obtem uma fabrica de gerenciador de entidades
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

        // obtem uma fabrica de entidades
        EntityManager manager = emf.createEntityManager();

        // dá inicio a uma transação do dados
        manager.getTransaction().begin();

        // persiste em um objeto criado para a transação do dados
        manager.persist(objProduto);

        // confirma a transação do dados
        manager.getTransaction().commit();

        System.out.println("transição realizada!");
    }
}
