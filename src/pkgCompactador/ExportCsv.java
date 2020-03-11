package pkgCompactador;
import java.io.FileWriter;
import java.io.IOException;

public class ExportCsv extends Compactador{

	public void generateCsvFile(String sFileName, String fraseMultiplicada) {

		try {
	     FileWriter writer = new FileWriter(sFileName);
	     //Compactador c = new Compactador();
	     
	     writer.append("Frase Desejada");
	     writer.append(',');
	     //writer.append('\n');
	
	     writer.append(fraseMultiplicada);
	     writer.append('\n');
	
	     writer.flush();
	     writer.close();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		} 
	}
}
