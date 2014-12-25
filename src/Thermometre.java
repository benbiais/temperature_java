
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Thermometre 
{
	public String 					name;
	public String 					friendlyName;
	public String 					address;
	public String					readFileName;
 	public Integer 					reading;
	
 	
 	// Constructor
	public Thermometre(String name, String address)
	{
		this.name 		    									= name;
		this.address  											= address;

		/*
		 * 
		 * pi@raspiblog /sys/bus/w1/devices $ cd 28-0000054c2ec2
		 * pi@raspiblog /sys/bus/w1/devices/28-0000054c2ec2 $ ls
		 * driver id name power subsystem uevent w1_slave
		 * pi@raspiblog /sys/bus/w1/devices/28-0000054c2ec2 $ cat w1_slave
		 * 7c 01 4b 46 7f ff 04 10 09 : crc=09 YES
		 * 7c 01 4b 46 7f ff 04 10 09 t=23750
		 * 
		 * 
		 */
		
		String prefix											= "/sys/bus/w1/devices/";
		String suffix											= "/w1_slave";

		this.readFileName										= prefix + this.address + suffix;
	}
	public Thermometre()
	{
		this.name 		    									= "nom bidon";
		this.address  											= "28-9999";
	}
	public Integer read()
	{
		String	 		tempString;
		float	 		tempFloat;
    	
    	try
		{
    		FileInputStream 	ThermoFile_InputStream 		= null;
        	ThermoFile_InputStream 							= new FileInputStream(readFileName);
 			DataInputStream 	ThermoFile_InputData 		= new DataInputStream(ThermoFile_InputStream);
			BufferedReader 		ThermoFile_InputBuffer 		= new BufferedReader(new InputStreamReader(ThermoFile_InputData));
			String 				ThermoFile_InputLine1 		= ThermoFile_InputBuffer.readLine();
			String 				ThermoFile_InputLine2 		= ThermoFile_InputBuffer.readLine();

			if (ThermoFile_InputLine1.indexOf("YES") > 0)
			{
				int posT = ThermoFile_InputLine2.indexOf("t=") + 2;
				String temp = ThermoFile_InputLine2.substring(posT , ThermoFile_InputLine2.length());			// keep only last n chars
				return Integer.parseInt(temp);
			}
			else
			{
				return -273777;	// Bad CRC return -273 degrees
			}
		}
		catch (Exception err)
		{
			return -273999; // Round to milli-degree
		}		
	}
	public String readChars()
	{
		return "x";
	}
}
