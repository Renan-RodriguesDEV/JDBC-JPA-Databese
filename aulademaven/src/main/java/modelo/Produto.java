package modelo;

import java.util.*;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 150)
	private String descricao;
	@Column(precision = 10, scale = 2)
	private double preco;
	@Temporal(TemporalType.DATE)
	private Date data_de_validade;
	// Muitos Produto para Uma Categoria (ManyToOne)
	// O relacionamento é a partir da classe atual
	@ManyToOne(cascade = CascadeType.ALL)
	// Nome a qual será dado a coluna de join da foreign key
	@JoinColumn(name = "id_cat")
	private Categoria categoria;

	public Produto(String descricao, double preco, Date data_de_validade, Categoria categoria) {
		super();
		this.descricao = descricao;
		this.preco = preco;
		this.data_de_validade = data_de_validade;
		this.categoria = categoria;
	}

}
