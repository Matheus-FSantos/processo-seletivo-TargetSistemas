package processoSeletivo.Exercicio04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Double total = 0.0;
		
		Map<String, Double> porcentagens = new HashMap<String, Double>();
		
		Faturamento sp = new Faturamento("São Paulo", 67.836);
		Faturamento rj = new Faturamento("Rio de Janeiro", 36.678);
		Faturamento mg = new Faturamento("Minas Gerais", 29.229);
		Faturamento es = new Faturamento("Espirito Santo", 27.165);
		Faturamento outros = new Faturamento("Outros", 19.849);
		
		BancoDados bancoDados = new BancoDados();
		
		bancoDados.adiciona(sp);
		bancoDados.adiciona(rj);
		bancoDados.adiciona(mg);
		bancoDados.adiciona(es);
		bancoDados.adiciona(outros);
		
		total = calculaTotal(bancoDados.getBanco());
		
		porcentagens = calculoPorcentagens(bancoDados.getBanco(), total);
		
		print(porcentagens);
	}
	
	private static void print(Map<String, Double> lista) {
		Integer index = -1;
		String faturamentos[] = new String[length(lista)];
		
		for(Map.Entry<String, Double> faturamento : lista.entrySet()) {
			if(faturamento != null) {
				index++;
				faturamentos[index] = faturamento.getKey() + " -> " + faturamento.getValue() + "%";
			}
		}
		
		System.out.println(Arrays.toString(faturamentos));
	}

	private static int length(Map<String, Double> lista) {
		Integer index = 0;
		
		for(Map.Entry<String, Double> object : lista.entrySet()) {
			if(object != null) {
				index++;
			}
		}
		
		return index;
	}

	private static Map<String, Double> calculoPorcentagens(Faturamento[] faturamentos, Double total) {
		Map<String, Double> porcentagens = new HashMap<>();
		
		Double valor;
		
		for(Faturamento faturamento : faturamentos) {
			if(faturamento != null) {
				valor = (100 * faturamento.getValor()) /total;
				
				porcentagens.put(faturamento.getEstado(), valor);
			}
		}
		
		return porcentagens;
	}

	private static Double calculaTotal(Faturamento[] faturamentos) {
		Double total = 0.0;
		
		for(Faturamento faturamento : faturamentos) {
			if(faturamento != null) {
				total += faturamento.getValor();
			}
		}
		
		return total;
	}
}