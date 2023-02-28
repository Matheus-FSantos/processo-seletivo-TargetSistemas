package processoSeletivo.Exercicio04;

public class BancoDados {
	private static Integer indice = -1;
	
	private Faturamento[] faturamentos;
	
	public BancoDados() {
		faturamentos = new Faturamento[1];
	}
	
	public Faturamento[] getBanco() {
		Faturamento clone[] = faturamentos;
		
		return clone;
	}
	
	public void adiciona(Faturamento faturamento) {
		if(indice + 1!= faturamentos.length) {
			indice++;
			faturamentos[indice] = faturamento;
		} else {
			aumentaCapacidade();
			adiciona(faturamento);
		}
	}
	
	private void aumentaCapacidade() {
		Faturamento clone[] = faturamentos;
		Integer index = -1;
		
		faturamentos = new Faturamento[faturamentos.length * 2];
		
		for(int i = 0; i < clone.length; i++) {
			if(clone[i] != null)
				index++;
				faturamentos[index] = clone[i];
		}
	}
}