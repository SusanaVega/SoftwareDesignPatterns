package FilesManagement;

public class Subscribe{
	
	private String Name = "";
	private String Origin = "";
	private String Type = "";
	private int Max = 0;
	private int Min = 0;
	private int Default = 0;
	private String Operation = "";
	private String Operand1 = "";
	private String Operand2 = "";

	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getOrigin() {
		return Origin;
	}


	public void setOrigin(String origin) {
		Origin = origin;
	}


	public String getType() {
		return Type;
	}


	public void setType(String type) {
		Type = type;
	}


	public int getMax() {
		return Max;
	}


	public void setMax(int max) {
		Max = max;
	}


	public int getMin() {
		return Min;
	}


	public void setMin(int min) {
		Min = min;
	}


	public int getDefault() {
		return Default;
	}


	public void setDefault(int default1) {
		Default = default1;
	}

	public String getOperation() {
		return Operation;
	}

	public void setOperation(String operation) {
		Operation = operation;
	}

	public String getOperand1() {
		return Operand1;
	}

	public void setOperand1(String operand1) {
		Operand1 = operand1;
	}

	public String getOperand2() {
		return Operand2;
	}

	public void setOperand2(String operand2) {
		Operand2 = operand2;
	}

}
