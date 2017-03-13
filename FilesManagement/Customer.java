package FilesManagement;

import java.util.ArrayList;

public class Customer {

	private ArrayList<Aircraft> aircraft;
	//private String cutomerName;
	
	public Customer(){
		aircraft = new ArrayList<Aircraft>();
	}
	
	public ArrayList<Aircraft> getAircraft() {
		return aircraft;
	}
	public void setAircraft(Aircraft aircraft) {
		this.aircraft.add(aircraft);
	}

	
}
