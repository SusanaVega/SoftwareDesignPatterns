package Proxy;


import FilesManagement.Flight_Phase;
import src.LegacyWeatherModule;

public class ProxyWeatherTest1 implements WeatherTest{
	
	private LegacyWeatherModule legacyWeatherModule;
	private String weather;
	private String aircraftmaneuver;
	private String aircraftFamily;
	private Flight_Phase flightPhase;
	
	public ProxyWeatherTest1(String weather, String aircraftmaneuver, String aircraftFamily, Flight_Phase flightPhase){
		
		this.weather = weather;
		this.aircraftmaneuver = aircraftmaneuver;
		this.aircraftFamily = aircraftFamily;
		this.flightPhase = flightPhase;

	}

	@Override
	public String runTestWeather() {
		
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
		legacyWeatherModule.ClearParameters();
		if(testCheck){
			return("Weather test PASSED when performing " + this.aircraftmaneuver + " in " + this.weather + " during " + this.flightPhase.getPhase_Name());
		}else{
			return("Weather test FAILED when performing " + this.aircraftmaneuver + " in " + this.weather + " during " + this.flightPhase.getPhase_Name());
		}
	}
	

}
