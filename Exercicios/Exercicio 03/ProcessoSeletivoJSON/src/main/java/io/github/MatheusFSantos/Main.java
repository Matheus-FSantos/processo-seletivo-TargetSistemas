package io.github.MatheusFSantos;

/*
 * Exercicio 03
 * 
 * @author Matheus Ferreira
*/

import java.io.FileReader;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
	public static void main(String[] args) {
		JSONParser jsonParser = new JSONParser();
		Faturamento faturamentos[] = null;
		
		//Mudar o endereço de localização (Dica: substituir somente -> '/home/matheus/Documents/Spring')
		try(FileReader reader = new FileReader("/home/matheus/Documents/Spring/ProcessoSeletivoJSON/dados.json")){
			
			Object obj = jsonParser.parse(reader);
			JSONArray faturamentoListaJSON = (JSONArray) obj;
			faturamentos = new Faturamento[length(faturamentoListaJSON)];
			
			
			copiaDados(faturamentoListaJSON, faturamentos);
			
			JOptionPane.showMessageDialog(null, menorValorFaturamento(faturamentos).toString() + "\n\nMenor faturamento diferente de R$ 0");
			JOptionPane.showMessageDialog(null, maiorValorFaturamento(faturamentos).toString() + "\n\nMaior faturamento");
			JOptionPane.showMessageDialog(null, "Quantidade de dias que teve o valor diário maior que o média mensal\n\n\n"+ faturamentoAcimaDaMedia(faturamentos) + " dias");
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/*
		Calcula a quantidade de dias que teve um valor diário
		acima da média de faturamento do mês
	*/
	private static Object faturamentoAcimaDaMedia(Faturamento[] faturamentos) {
		Double media = calculoMedia(faturamentos);
		Integer dias = 0;
		
		for(Faturamento faturamento : faturamentos) {
			if(faturamento.getValor() > media && faturamento.getValor() > 0.0) {
				dias += 1;
			}
		}
		
		return dias;
	}
	

	/*
 		Método que retorna o Objeto que teve o maior faturamento
	*/
	private static Faturamento maiorValorFaturamento(Faturamento[] faturamentos) {
		Faturamento maiorFaturamentoObject = faturamentos[0];
		
		for(Faturamento faturamentoObject : faturamentos){
			if(faturamentoObject.getValor() != 0.0) {
				if(faturamentoObject.getValor() > maiorFaturamentoObject.getValor())
					maiorFaturamentoObject = faturamentoObject;
			}
		}
		
		return maiorFaturamentoObject;
	}

	
	/*
	 	Método que retorna o Objeto que teve o menor faturamento diferente de 0.0
	*/
	private static Faturamento menorValorFaturamento(Faturamento[] faturamentos) {
		Faturamento menorFaturamentoObject = faturamentos[0];
		
		
		for(Faturamento faturamentoObject : faturamentos){
			if(faturamentoObject.getValor() != 0.0) {
				if(faturamentoObject.getValor() < menorFaturamentoObject.getValor())
					menorFaturamentoObject = faturamentoObject;
			}
		}
		
		return menorFaturamentoObject;
	}
	
	
	/*
		Clona a lista de JSONArray para a lista de Faturamento
	*/
	private static void copiaDados(JSONArray faturamentosJSON, Faturamento[] faturamentosObject) {
		Integer index = 0;
		
		for(Object objectJSON : faturamentosJSON) {
			Faturamento faturamento = parseFaturamento((JSONObject) objectJSON);
			faturamentosObject[index] = faturamento;
			index++;
		}
	}
	
	
	/*
		Autoexplicativo
	*/
	private static Double calculoMedia(Faturamento[] faturamentos) {
		Double total = 0.0;
		Integer dias = 0;
		
		for(Faturamento faturamento : faturamentos) {
			if(faturamento.getValor() > 0) {
				total += faturamento.getValor();
				
				//O dia só pode ser valido para calculo, na parte de divisão, quando o valor (diário) for diferente de 0, por isso essa adição
				dias += 1;
			}
		}
		
		return total/dias;
	}
	
	
	/*
	  	Método que verifica o tamanho de uma lista JSONArray.
	*/
	private static Integer length(JSONArray faturamentoListaJSON) {
		Integer index = 0;
		
		for(Object object : faturamentoListaJSON) {
			index++;
		}
		return index;
	}

	/*
	 	Conversor de dados JSON para Objetos do tipo Faturamento 
	*/
	private static Faturamento parseFaturamento(JSONObject faturamentoJson) {
		Integer dia = Integer.parseInt(faturamentoJson.get("dia").toString());
		Double valor = Double.parseDouble(faturamentoJson.get("valor").toString());
		
		return new Faturamento(dia, valor);
	}
}