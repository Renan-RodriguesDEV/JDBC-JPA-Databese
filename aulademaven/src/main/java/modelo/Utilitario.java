package modelo;

import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Utilitario")
@Getter
@Setter
@NoArgsConstructor
public class Utilitario extends Veiculo{
	
	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	private int capacidade;
	
}
