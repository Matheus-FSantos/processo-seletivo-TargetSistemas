package processoSeletivo.Exercicios01_02e05;

public class Exercicio01 {
	public static void main(String[] args) {
		Integer indice = 13, soma = 0, k = 0;
		
		while(k < indice) {
			k += 1;
			soma = soma + k;
		}
		
		System.out.println(soma);
	}
}