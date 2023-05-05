package dominio;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import java.util.HashSet;

@Entity
@Table(name = "tab_pizza")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 60, nullable = false)
	private String sabor;
	
	@Column(length = 60, nullable = false)
	private String valor;
	
	@Column(name = "tipo_pizza", nullable = false)
	@Enumerated(EnumType.STRING) 
	private TipoPizza tipoPizza;
	
	@ManyToMany
	
	@JoinTable(name = "veiculo_acessorio",
	joinColumns = @JoinColumn(name = "pizza_codigo"),
	inverseJoinColumns = @JoinColumn(name = "ingrediente_codigo"))
	private Set<Ingredientes> ingredientes = new HashSet<>();

	public Pizza() {}
	
	public Pizza(Long codigo, String sabor, String valor, TipoPizza tipoPizza, Set<Ingredientes> ingredientes) {
		super();
		this.codigo = codigo;
		this.sabor = sabor;
		this.valor = valor;
		this.tipoPizza = tipoPizza;
		this.ingredientes = ingredientes;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public TipoPizza getTipoPizza() {
		return tipoPizza;
	}

	public void setTipoPizza(TipoPizza tipoPizza) {
		this.tipoPizza = tipoPizza;
	}

	public Set<Ingredientes> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<Ingredientes> ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, ingredientes, sabor, tipoPizza, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(ingredientes, other.ingredientes)
				&& Objects.equals(sabor, other.sabor) && tipoPizza == other.tipoPizza
				&& Objects.equals(valor, other.valor);
	}
	
	
}