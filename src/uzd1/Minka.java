package uzd1;

import java.awt.Image;
import java.net.URL;
import java.time.Year;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Minka {
//Atributi
	String vards, skirne, spalvasKrasa, saimnieks;
	int vecums, medijumuSk, izsalkums;
	boolean siksnina;
	ImageIcon bilde;
	Random rand = new Random();
	
	//Konstruktors
	
	public Minka(String vards,String skirne,String spalvasKrasa,String saimnieks, int dzGads, boolean siksnina, String cels) {
		this.vards = vards;
		this.skirne = skirne;
		this.spalvasKrasa = spalvasKrasa;
		this.saimnieks = saimnieks;
		vecums = Year.now().getValue()- dzGads;
		medijumuSk = 0;
		izsalkums = kungis();
		this.siksnina = siksnina;
		bilde = iestatitBildi(cels);
	}
	
	//metodes 
	public int kungis() {
		return rand.nextInt(5)+1;
	}
	
	public ImageIcon iestatitBildi(String cels) {
		
		if(!cels.endsWith(".png"))
			cels += ".png";
		
		URL resurss = getClass().getResource("/atteli/"+cels);
		if(resurss != null)
			return new ImageIcon(new ImageIcon(resurss).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		
		else {
			JOptionPane.showMessageDialog(null, "Nevar atrast bildi: "+cels,"Brīdinājums", JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
	
	void murrat() {
			JOptionPane.showMessageDialog(null, vards + "saka 'murr murr murr'", "Paziņojums", JOptionPane.PLAIN_MESSAGE, bilde);
		}
	String nolasitAtributus() {
		return vards + "ir"+ vecums+ "gadus vecs"+ skirne+"šķirnes kaķis"+spalvasKrasa+"krāsas kažoku."
				+"\nKaķim "+((siksnina)?"ir":"nav") + "siksniņa"
				+"\nKaķa saimnieks ir "+ saimnieks 
				+"\n Medijumu skaits: "+ medijumuSk;
	}
	
	String pabarot(String ediens) {
		if(izsalkums>0) {
			bilde = iestatitBildi("cat-png-17.png");
			JOptionPane.showMessageDialog(null, "Ņam ņam, garšo"+ ediens,"Informacijas",JOptionPane.INFORMATION_MESSAGE,bilde);
			ediens ="Tukša bļoda";
			izsalkums--;
		} else {
			JOptionPane.showMessageDialog(null, "Murr... esmu pilns un "+ediens+" nevelos!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
			izsalkums = kungis();
		}
		return ediens;
	}
	
	//Metožu parslogošana
	
	void gulet() {
		JOptionPane.showMessageDialog(null, saimnieks+ "! Aizmirsi man iedot segu, nevaru pagulēt", "Kļūda", JOptionPane.ERROR_MESSAGE);
	}
	
	void gulet(String prieksmets) {
		if(prieksmets.equalsIgnoreCase("sedziņa")) {
			bilde = iestatitBildi("images.jpeg");
			JOptionPane.showMessageDialog(null, "Zzzzz...","Informācijas", JOptionPane.INFORMATION_MESSAGE);
			
		}else {
			JOptionPane.showMessageDialog(null, saimnieks+"! "+prieksmets+ " man neder gulēšanai!", "Kļūda", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	void palielinatVecumu() {
		if(vecums<20) {
			vecums++;
			bilde=iestatitBildi("canva-british-shorthair-kitten-sitting,-head-tilted,-looking-curious-MAG_0kV15eY.png");
			JOptionPane.showMessageDialog(null, vardsm+" vecums palielinās par vienu gadu!", "informācijas", JOptionPane.WARNING_MESSAGE);
			
		}else {
			JOptionPane.showMessageDialog(null, "Sasniegts max vecums!","Brīdinājums",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	void nolasitVecumu() {
		JOptionPane.showMessageDialog(null, vards+"ir"+ vecums+" vecs","informacijas",JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	
	void medit() {
		if((rand.nextInt(3))==0) {
			medijumuSk++;
			bilde= iestatitBildi("ai-generated-napoleon-cat-isolated-on-background-png.png");
			JOptionPane.showMessageDialog(null, "Medijums tika noķerts!", "Veiksme",JOptionPane.INFORMATION_MESSAGE,bilde);
			
		}else {
			bilde=iestatitBildi("3-2-cat-png-14.png");
			JOptionPane.showMessageDialog(null, "Medijums aizlaidies!","Neveiksme",JOptionPane.INFORMATION_MESSAGE,bilde);
		}
	}
}
