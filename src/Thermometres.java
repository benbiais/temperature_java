
import java.util.ArrayList;

public class Thermometres
{
	public ArrayList<Thermometre> thermometreList = new ArrayList<Thermometre>();
	
	public Thermometres()
	{ 
	}
	public void addThermometre(String name, String address)
	{
		Thermometre thermo = new Thermometre(name, address);
		thermometreList.add(thermo);
	}
	public Thermometre fetchThermometer(String name)
	{
		for (Thermometre element : thermometreList) 
		{
			if (element.name.equalsIgnoreCase(name))
			{
					return element;
			}
		}
		return null;
	}
}