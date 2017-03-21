package factory;

import FilesManagement.Flight_Phase;
import FilesManagement.Subscribe;

public class TestProcedureEngine implements TestProcedure{

	public TestProcedureEngine() {
	}

	@Override
	public String evaluate(Subscribe s, Flight_Phase f) {
		return("\tTest not found for engines in any phase");
	}

}
