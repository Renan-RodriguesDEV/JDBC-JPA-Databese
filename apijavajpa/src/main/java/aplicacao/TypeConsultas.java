package aplicacao;

import java.util.List;

import javax.persistence.*;

import dominio.Pessoa;

public class TypeConsultas {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

        EntityManager gerenciador = emf.createEntityManager();

        gerenciador.getTransaction()
                .begin();

        TypedQuery<Pessoa> query = gerenciador.createQuery("SELECT p FROM Pessoa p WHERE p.id = :id", Pessoa.class);

        query.setParameter("id", 1);
        List<Pessoa> pessoas = query.getResultList();
        if (!pessoas.isEmpty()) {
            for (Pessoa pessoa : pessoas) {
                System.out.println(pessoa.getNome());
            }
        } else {
            System.out.println("Nenhuma pessoa encontrada");
        }
        gerenciador.close();
        emf.close();
    }
}
