package modelo;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;

	public Categoria(String nome) {
		super();
		this.nome = nome;
	};

}
