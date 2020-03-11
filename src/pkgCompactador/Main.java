package pkgCompactador;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Compactador compactador = new Compactador();
		
		
		try {
			String leitura = JOptionPane.showInputDialog("Digite uma frase desejada: ");
			compactador.setFrase(leitura);
			
			compactador.compactar();
			
			compactador.calculo_bits();
			
			compactador.imprime_dados();
	
		}catch(java.lang.StringIndexOutOfBoundsException e){
			JOptionPane.showMessageDialog(null, "Digite uma frase com menos de 256 caracteres!", "Error", 2);
		}
	}
}