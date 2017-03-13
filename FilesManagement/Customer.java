package FilesManagement;

import java.util.ArrayList;

public class Customer {

	private ArrayList<Aircraft> aircraft;
	//private String cutomerName;
	private static Customer customer = new Customer();
	
	private Customer(){
		aircraft = new ArrayList<Aircraft>();
	}
	
	public ArrayList<Aircraft> getAircraft() {
		return aircraft;
	}
	public void setAircraft(Aircraft aircraft) {
		this.aircraft.add(aircraft);
	}
	
	public void release(){
		aircraft = new ArrayList<Aircraft>();
	}
	
	public static Customer getCustomerInst(){
	      return customer;
	   }

	
}
