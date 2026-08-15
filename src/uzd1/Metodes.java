package uzd1;

import java.util.LinkedList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Metodes {
	static String virknesParbaude(String zinojums, String noklusejumas) {
		String virkne;
		
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejumas);
				if(virkne==null)
					return null;
				
				virkne = virkne.trim();
				
				
		}while(!Pattern.matches("^[\\p{L} ]+$", virkne));
		
		return virkne;
	}
	
	static int skaitluParbaude(String zinojums, int min, int max) {
		String ievade;
		int sk;
		while(true) {
			ievade=JOptionPane.showInputDialog(zinojums, min);
			if(ievade==null)
				return -1;
			
			try {
				sk = Integer.parseInt(ievade);
				if(sk<min||sk>max) {
					JOptionPane.showMessageDialog(null, "Norādītais skaitlis ir nederīgā itervālā!"
							, "Nekorekti dati", JOptionPane.WARNING_MESSAGE);
					continue;
				}
				
				return sk;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Netika ievadīts vesels skaitlis!",
						"Nekorekti dati", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	static int meklet(LinkedList<Minka> minkuSaraksts, String vards) {
		for (int i=0; i<minkuSaraksts.size(); i++) {
			if(minkuSaraksts.get(i).apskatitVardu().equalsIgnoreCase(vards)) {
				return i;
				
			}
		}
		
		JOptionPane.showMessageDialog(null, "Kaķis ar vārdu: " + vards 
				+ " netika atrasts!", "Informacija", JOptionPane.WARNING_MESSAGE);
		
		return -1;
	}
	
}
