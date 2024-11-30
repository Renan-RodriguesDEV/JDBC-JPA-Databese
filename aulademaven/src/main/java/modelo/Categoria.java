package modelo;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;

	public Categoria() {

	};

	public Categoria(String nome) {
		super();
		this.nome = nome;
	};

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
