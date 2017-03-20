package FilesManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TxtHandlerClass {

	public TestCase txtReader(String file) {
			String string;
			FileReader f;
			TestCase TC = null;
			Preflight PF = new Preflight();
			Flight_Phase FP = null;
			//ArrayList<Flight_Phase> FPArray = new ArrayList<Flight_Phase>(); 
			try {
				f = new FileReader(file);
				BufferedReader b = new BufferedReader(f);
				while((string = b.readLine())!=null) {
					String labelContent = string.substring(string.indexOf("[")+1,string.indexOf("]"));
					String labelValue = string.substring(string.indexOf("=")+1,string.length());
					switch(labelContent){
						case "FLIGHT_TYPE": 
							TC = new TestCase();
							TC.setFlightType(labelValue);
							break;
						case "PRE_FLIGHT":
							SetPreflightParameterValue(PF,labelValue);
							break;
						case "PRODUCT_CONFIGURATION": 
							TC.setProductConfiguration(labelValue);
							break;
						case "FLIGHT_PHASE": 
							if (FP != null)
								TC.setFlight_Phases(FP);
							FP = new Flight_Phase(); 
							FP.setPhase_Name(string.substring(string.indexOf("=")+1, string.length()));
							break;
						case "AIRCRAFT_MANEUVER": 
							if (FP != null)
								FP.setAircraft_Maneuver(string.substring(string.indexOf("=")+1, string.length()));
							else
								System.out.println("Flight phase not detected for AIRCRAFT_MANEUVER");
							break;
						case "FLIGHT_PARAMETER":
							if (FP != null)
								SetFlightParameterValue(FP,labelValue); 
							else
								System.out.println("Flight phase not detected for FLIGHT_PARAMETER");
							break;
						default : 
							break;
					}
				}
				TC.setFlight_Phases(FP);
				TC.setPreflight(PF);
				b.close();
	        
			} catch (IOException e) {
				System.out.println("Something failed");
			}
		//}
			return TC;
	}
	private static void SetFlightParameterValue(Flight_Phase obj, String value)
	{
		String attributeName = value.substring(0,value.indexOf(":"));
		String attibuteValue = value.substring(value.indexOf(":")+1,value.length());
		switch(attributeName)
		{
		case "Duration": obj.setDuration(Integer.parseInt(attibuteValue));break;
		case "VerticalSpeed": obj.setVerticalSpeed(Integer.parseInt(attibuteValue));break;
		case "WindSpeed": obj.setWindSpeed(Integer.parseInt(attibuteValue));break;
		case "Latitude_Change": obj.setLatitude_Change(Float.parseFloat(attibuteValue));break;
		case "Longitude_Change": obj.setLongitude_Change(Float.parseFloat(attibuteValue));break;
		default: System.out.println("Parameter " + attributeName + " not supported");
		}
	}
	private static void SetPreflightParameterValue(Preflight obj, String value)
	{
		String attributeName = value.substring(0,value.indexOf(":"));
		String attibuteValue = value.substring(value.indexOf(":")+1,value.length());
		switch(attributeName)
		{
		case "Latitude_Change": obj.setPreflight_Latitude_Change(Float.parseFloat(attibuteValue));break;
		case "Longitude_Change": obj.setPreflight_Longitude_Change(Float.parseFloat(attibuteValue));break;
		case "Weather": obj.setPreflight_Weather(attibuteValue);break;
		default: System.out.println("Preflight parameter " + attributeName + " not supported");
		}
	}
}
