package io.github.MatheusFSantos;

public class Faturamento {
	private Integer dia;
	private Double valor;
	
	public Faturamento() {
		
	}
	
	public Faturamento(Integer dia, Double valor) {
		this.dia = dia;
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Faturamento [dia=" + dia + ", valor=" + valor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		return result;
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
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		return true;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}