package aplicacao;

import javax.persistence.EntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Renan", 20, "123456789");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            inserePessoa(em, pessoa);
            buscarPessoa(em, 1);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }

    static void buscarPessoa(EntityManager em, int id) {
        Pessoa p = em.find(Pessoa.class, id);
        System.out.println(p);
    }

    static boolean inserePessoa(EntityManager em, Pessoa pessoa) {
        try {
            // Pega o objto e salva no banco
            em.persist(pessoa);
            // inicia uma transação com o banco de dados
            em.getTransaction().begin();
            // confirma as transaçôes
            em.getTransaction().commit();
            System.out.println("Inserido com sucesso: " + pessoa.getNome());
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + pessoa.getNome() + "\n" + e.getMessage());
            return false;
        }

    }

    static boolean deletePessoa(EntityManager em, Pessoa pessoa) {
        try {
            // deleta a pessoa
            em.remove(pessoa);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + pessoa.getNome() + "\n" + e.getMessage());
            return false;
        }
    }
}
