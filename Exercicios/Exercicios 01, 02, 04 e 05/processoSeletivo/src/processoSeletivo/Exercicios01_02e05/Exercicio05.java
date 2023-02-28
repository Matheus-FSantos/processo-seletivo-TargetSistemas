package processoSeletivo.Exercicios01_02e05;

import javax.swing.JOptionPane;

public class Exercicio05 {
	public static void main(String[] args) {
		String palavra = JOptionPane.showInputDialog(null, "Informe uma palavra");
		String palavraInversa = "";
		
		
		for(int i = palavra.length() - 1; i >= 0; i--) {
			palavraInversa += palavra.charAt(i) + "";
		}
		
		System.out.println("Palavra Informada: " + palavra + "\nPalavra Inversa: " +palavraInversa);
	}
}	