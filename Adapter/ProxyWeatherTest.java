package Adapter;

import java.lang.reflect.Proxy;
import java.util.ArrayList;

import FilesManagement.Flight_Phase;
import FilesManagement.Products;
import FilesManagement.Subscribe;
import iterator.SubscribeIterator;
import src.LegacyWeatherModule;

public class ProxyWeatherTest implements WeatherTest{
	
	private LegacyWeatherModule legacyWeatherModule;
	private String weather;
	private String aircraftmaneuver;
	private String aircraftFamily;
	private Products parametersList;
	
	public ProxyWeatherTest(String weather, String aircraftmaneuver, String aircraftFamily, Products parameters){
		
		this.weather = weather;
		this.aircraftmaneuver = aircraftmaneuver;
		this.aircraftFamily = aircraftFamily;
		this.parametersList = parameters;
		
		//legacyWeatherModule.AddParameter(parameterName, parameterValue);
		
	}

	@Override
	public void runTestWeather() {
		
		if(legacyWeatherModule == null){
			legacyWeatherModule = new LegacyWeatherModule();
		}z
		
		legacyWeatherModule.SetCondition(this.weather);
		legacyWeatherModule.SetManeuver(this.aircraftmaneuver);
		legacyWeatherModule.SetAircraftFamily(this.aircraftFamily);
		
		for(SubscribeIterator iter = parametersList.getSubscribeIterator(); iter.hasNext();){
			Subscribe S = new Subscribe();
			S = (Subscribe) iter.next();
			legacyWeatherModule.AddParameter(S.getName(), String.valueOf(S.getMin()));
		}
		
		legacyWeatherModule.TestWeather();
		String status = legacyWeatherModule.Status;
		
	}
	

}
