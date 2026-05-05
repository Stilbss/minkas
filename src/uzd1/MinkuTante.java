package uzd1;

import java.io.File;
import java.time.Year;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class MinkuTante {

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
	
	
	
	
	public static void main(String[] args) {
		String izvelne, fNosaukums = System.getProperty("user.home") 
				+ File.separator+ "Desktop" + File.separator+ "minkas.txt";	
		Minka runcis = null;
		
		String[]darbibuSaraksts= {
				"Izveidot kaķi", "Izsaukt metodi",
				"Saglabāt failā", "Apskatīt saglabato kaķus","Aizvērt"
		};
		
		do {
			izvelne=(String)JOptionPane.showInputDialog(null,"Izvelies darbību","Darbības izvēle",JOptionPane.QUESTION_MESSAGE,
					null,darbibuSaraksts,darbibuSaraksts[0]);
			if(izvelne==null)
				izvelne="Aizvērt";
			
			switch(izvelne){
			case "Izveidot kaķi":
			String minkasVards, skirne, spalvasKrasa, saimnieks, cels;
			int dzGads = 0;
			boolean siksnina;
			//ievacu informaciju
			minkasVards = virknesParbaude("Ievadi kaķa vārdu!", "Rudis");
			skirne = virknesParbaude("Ievadi kaķa sķirni", "Meinkūns");
			spalvasKrasa = virknesParbaude("Ievadi kaķa kažoka krāsu", "Melns");
			dzGads = skaitluParbaude("Ievadi kaķa dzimšanas gadu"
					, (Year.now().getValue()-18), Year.now().getValue());
			saimnieks = virknesParbaude("Ievadi kaķa saimnieka vārdu", "Monta");
			int poga = JOptionPane.showConfirmDialog(null, "Vai kaķim ir siksniņa?"
					, "Kaķa siksniņas informācija", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(poga == -1) 
				break;
			
			siksnina = (poga ==0)? true:false;
			cels = virknesParbaude("Ievadi bildes nosaukumu","images.jpeg");
			//izsaucu konstruktoru
			runcis= new Minka(minkasVards,skirne,spalvasKrasa, saimnieks, dzGads, siksnina, cels);
			
			break;
			
			//case :
				
				
			//	break;
				
			//case :
				
			//	break;
				
			//case :
				
				//break;
			}
			
			
			
		}while(!izvelne.equals("Aizvērt"));
		
	
	
	
	
	
	
	}

}
