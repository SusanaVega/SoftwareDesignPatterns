package factory;

import FilesManagement.Subscribe;
import TxtHandler.Flight_Phase;

public class TestProcedureEngine implements TestProcedure{

	public TestProcedureEngine() {
	}

	@Override
	public void evaluate(Subscribe s, Flight_Phase f) {
		System.out.println("\tTest not found for engines in any phase");
	}

}
