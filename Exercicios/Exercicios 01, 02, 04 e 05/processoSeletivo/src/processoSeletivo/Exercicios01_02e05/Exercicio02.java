package processoSeletivo.Exercicios01_02e05;

import javax.swing.JOptionPane;

public class Exercicio02 {
	
	public static void main(String[] args) {
		Integer numeroInformado = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe um numero", "Input", JOptionPane.INFORMATION_MESSAGE));
		print(numeroInformado, numeroInformado);
	}
	
	private static Integer fibonacci(Integer numero) {
		if(numero == 0 || numero == 1)
			return numero;
		else {
			return fibonacci(numero - 1) + fibonacci(numero - 2);
		}
	}
	
	private static void print(Integer index, Integer numeroInformado) {
		boolean teste = false;
		
		System.out.println("---- Números da sequecia ----\n\n");
		
		while(true) {
			Integer numero = fibonacci(index);
			
			if(numero == numeroInformado)
				teste = true;
			
			System.out.print(numero + " ");
			index --;
			
			if(index==0)
				break;
		}
		
		if(teste)
			JOptionPane.showMessageDialog(null, "O numero informado pertence a sequencia");
		else
			JOptionPane.showMessageDialog(null, "O numero informado não pertence a sequencia");
	}
}