package modelo;

import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Entity
@DiscriminatorValue("Passeio")
@Getter
@Setter
@NoArgsConstructor
public class Passeio extends Veiculo{
	@Column(name="qtd_portas")
	private int portas;

	public int getPortas() {
		return portas;
	}

	public void setPortas(int portas) {
		this.portas = portas;
	}
	
}
