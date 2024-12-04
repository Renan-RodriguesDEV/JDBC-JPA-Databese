package modelo;

import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="Veiculo_tbl")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dType",discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@NoArgsConstructor
public class Veiculo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_veic",nullable = false)
	private long id;
	@Column(length = 50)
	private String modelo;
	@Column(precision = 10,scale=2)
	private Double preco;
	@Column(name="dataVenda")
	@Temporal(TemporalType.DATE)
	private Date venda;
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Date getVenda() {
		return venda;
	}
	public void setVenda(Date venda) {
		this.venda = venda;
	}
	
	
}

