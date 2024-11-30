package modelo;

import java.util.*;

import javax.persistence.*;


@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 150)
	private String descricao;
	@Column(precision=10,scale=2)
	private double preco;
	@Temporal(TemporalType.DATE)
	private Date data_de_validade;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_cat")
	private Categoria categoria;
	
	public Produto() {
		
	};
	
	public Produto(String descricao, double preco, Date data_de_validade, Categoria categoria) {
		super();
		this.descricao = descricao;
		this.preco = preco;
		this.data_de_validade = data_de_validade;
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Date getData_de_validade() {
		return data_de_validade;
	}

	public void setData_de_validade(Date data_de_validade) {
		this.data_de_validade = data_de_validade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	};
	
}
