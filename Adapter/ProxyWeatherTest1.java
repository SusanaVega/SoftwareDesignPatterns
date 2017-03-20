package Adapter;


import FilesManagement.Flight_Phase;
import FilesManagement.Products;
import FilesManagement.Subscribe;
import FilesManagement.TestCase;
import iterator.SubscribeIterator;
import src.LegacyWeatherModule;

public class ProxyWeatherTest1 implements WeatherTest{
	
	private LegacyWeatherModule legacyWeatherModule;
	private String weather;
	private String aircraftmaneuver;
	private String aircraftFamily;
	private Products parametersList;
	private Flight_Phase flightPhase;
	
	public ProxyWeatherTest1(String weather, String aircraftmaneuver, String aircraftFamily, Flight_Phase flightPhase){
		
		this.weather = weather;
		this.aircraftmaneuver = aircraftmaneuver;
		this.aircraftFamily = aircraftFamily;
		this.flightPhase = flightPhase;

	}

	@Override
	public void runTestWeather() {
		
		if(legacyWeatherModule == null){
			legacyWeatherModule = new LegacyWeatherModule();
		}
		
		legacyWeatherModule.SetCondition(this.weather);
		legacyWeatherModule.SetManeuver(this.aircraftmaneuver);
		legacyWeatherModule.SetAircraftFamily(this.aircraftFamily);
		
		for(int i =0; i<this.flightPhase.getParamNames().size();i++){
			legacyWeatherModule.AddParameter(String.valueOf(this.flightPhase.getParamNames().get(i)), String.valueOf(this.flightPhase.getParamValues().get(i)));
		}
		
		boolean testCheck = legacyWeatherModule.TestWeather();
		String status = legacyWeatherModule.Status;
		
		if(testCheck){
			System.out.println("Weather test PASSED when performing " + this.aircraftmaneuver + " in " + this.weather + " during " + this.flightPhase.getPhase_Name());
		}else{
			System.out.println("Weather test FAILED when performing " + this.aircraftmaneuver + " in " + this.weather + " during " + this.flightPhase.getPhase_Name());
		}
		
		legacyWeatherModule.ClearParameters();
	}
	

}
