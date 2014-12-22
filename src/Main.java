
import java.io.IOException;
import java.text.DecimalFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


//--------------------------------------------------------------|---------------------------|--------------------------------------------------------------------
public class Main
{
    public static int xx;
    
	
	
	public static void main(String[] args) 																							
	{
    	//============================================================
		//
		// Instantiate this class (required for JNI)
    	// and Set the current thread name
		//
    	
//		@SuppressWarnings("unused")
//		Control 												Me 							= new Control();
//		Thread.currentThread().setName("Thread_Main");
		
    	
    	
    	Thermometre thermo = new Thermometre("SdB", "28-000");
    	Integer maTemp = thermo.read();
    	// et pour affichage
    	String  maTemp1 = thermo.readChars();
    	
    	
    	Thermometres maListe = new Thermometres();
    	maListe.addThermometre("Salle de bain", "28-000");
    	maListe.addThermometre("Cuisine", "28-990");
    	
    	for (Thermometre element : maListe.thermometreList) 
		{

			System.out.println ("La température de la " + element.name + " est de " + element.read() + " °C");

		}
    	
    	
		//
		//============================================================
		

	}
	public static void affichage(String texte)
	{
		System.out.println (texte);
	}
 }