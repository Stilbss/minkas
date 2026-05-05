package uzd1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class DarbsArFailu {

	static void saglabat(Minka runcis, String fNosaukums) {
		try {
			FileWriter fr = new FileWriter(fNosaukums, true);
			PrintWriter pw = new PrintWriter(fr);
			pw.println(runcis.nolasitAtributus());
			pw.println("____________________________________");
			pw.close();
			JOptionPane.showMessageDialog(null, "Ieraksts ievietots: "+fNosaukums,"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			
			
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Kļūme ierakstot failā","Kļūme", JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	static void nolasit(String fNosaukums) {
		
	}
}
