package pkgCompactador;

import java.util.ArrayList;
import java.util.List;

public class Compactador {
	private List<Byte> 		dicionario = 		new ArrayList<Byte>();
	private List<Byte> 		frase_compactada = 	new ArrayList<Byte>();
	private List<Integer> 	qnt_bits =			new ArrayList<Integer>();
	private byte 	tamanho_dicionario;
	private int 	bits_frase_completa;
	private int 	bits_frase_compactada;
	private double 	pct_reducao;
	private String 	frase;
	
	
	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}
		
	public List<Byte> getDicionario() {
		return dicionario;
	}

	public void setDicionario(List<Byte> dicionario) {
		this.dicionario = dicionario;
	}

	public List<Byte> getFrase_compactada() {
		return frase_compactada;
	}

	public void setFrase_compactada(List<Byte> frase_compactada) {
		this.frase_compactada = frase_compactada;
	}
	
	public byte incrementa_dicionario(char c){
		for(byte i = 0; i < tamanho_dicionario; i++){
			if(dicionario.get(i) == c) {
				return i; 
		    }
		}
			dicionario.add(tamanho_dicionario, (byte) c);
			return tamanho_dicionario;
	}
	
	public void compactar(){
		for(byte i = 0; i < frase.length(); i++){
			char c = frase.charAt(i);
			byte k = incrementa_dicionario(c);
			frase_compactada.add(i, k); 
			if(k == tamanho_dicionario)
				this.tamanho_dicionario++;
		}
	}
	
	public void calculo_bits() {
		for(int i = 0; i < frase_compactada.size(); i++) {
			if(frase_compactada.get(i) == 0) {
				qnt_bits.add(i, 1);
			}
			if(frase_compactada.get(i) >= 1 && frase_compactada.get(i) <= 4) {
				qnt_bits.add(i, 2);
			}
			if(frase_compactada.get(i) >= 4 && frase_compactada.get(i) <= 8) {
				qnt_bits.add(i, 3);
			}
			if(frase_compactada.get(i) >= 8 && frase_compactada.get(i) <= 16) {
				qnt_bits.add(i, 4);
			}
			if(frase_compactada.get(i) >= 16 && frase_compactada.get(i) <= 32) {
				qnt_bits.add(i, 5);
			}
			bits_frase_completa += 8;
			bits_frase_compactada += qnt_bits.get(i);
		}
		bits_frase_completa =  bits_frase_completa * 2048;
		bits_frase_compactada = bits_frase_compactada * 2048;
		
		pct_reducao = 100 - (((double)bits_frase_compactada / (double)bits_frase_completa) * 100);
		
		while(qnt_bits.size() > frase_compactada.size()){
			qnt_bits.remove(qnt_bits.size()-1);
		}
	}
	
	public void imprime_dados(){
		System.out.println("[Relatório]\n");
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}
		System.out.print("Dicionário: ");
		for(int i = 0; i < dicionario.size(); i++) {
			byte b = dicionario.get(i);
			System.out.print((char) b);
		}
		
		System.out.println();
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}
		
		System.out.print("Frase Compactada:        ");
		for(int i = 0; i < frase_compactada.size(); i++) {
			System.out.print(frase_compactada.get(i) + " ");
		}
		
		System.out.println("\n");
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}
		
		System.out.print("Quantos bits por número: ");
		for(int i = 0; i < qnt_bits.size(); i++) {
			System.out.print(qnt_bits.get(i) + " ");
		}
		
		System.out.println("\n");
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}

		System.out.println("Tamanho do Dicionário: " + dicionario.size());
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}
		
		System.out.println("Tamanho da Frase Compactada: " + frase_compactada.size());
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}
		
		System.out.println("\nrepetindo --* " + frase + " *--  2048 vezes...\n");
		try { Thread.sleep (2000); } catch (InterruptedException ex) {}
		
		System.out.println("Quantidade de bits da frase completa:   " + bits_frase_completa);
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}
		
		System.out.println("Quantidade de bits da frase compactada: " + bits_frase_compactada);
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}
		
		System.out.printf("\nProporção da redução: %.1f", pct_reducao);
		System.out.println("%");
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}
	}
}