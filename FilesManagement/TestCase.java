package FilesManagement;

import java.util.ArrayList;

public class TestCase {
	private String FlightType = "";
	private String ProductConfiguration = "";
	private Preflight Preflight;
	private ArrayList<Flight_Phase> Flight_Phases;
	
	public TestCase() {
		Preflight = new Preflight();
		Flight_Phases = new ArrayList<Flight_Phase>(); 
	}	
	public String getFlightType() {
		return FlightType;
	}
	public void setFlightType(String flightType) {
		FlightType = flightType;
	}
	public String getProductConfiguration() {
		return ProductConfiguration;
	}
	public void setProductConfiguration(String productConfiguration) {
		ProductConfiguration = productConfiguration;
	}
	public Preflight getPreflight() {
		return Preflight;
	}
	public void setPreflight(Preflight preflight) {
		Preflight = preflight;
	}
	public ArrayList<Flight_Phase> getFlight_Phases() {
		return Flight_Phases;
	}
	public void setFlight_Phases(Flight_Phase flight_Phases) {
		Flight_Phases.add(flight_Phases);
	} 
}
