package dominio;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String nome;

    @Column(precision = 10, scale = 2)
    private double preco;

    @Temporal(TemporalType.DATE)
    private Date validade;

    public Produto() {

    }

    public Produto(String nome, double preco, Date validade) {
        this();
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

}
