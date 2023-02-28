package processoSeletivo.Exercicio04;

import java.util.Objects;

public class Faturamento {
	private String estado;
	private Double valor;
	
	public Faturamento() {
		
	}
	
	public Faturamento(String estado, Double valor) {
		this.estado = estado;
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Faturamento [estado=" + estado + ", valor=" + valor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(estado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faturamento other = (Faturamento) obj;
		return Objects.equals(estado, other.estado);
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}