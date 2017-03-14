package FilesManagement;

public class Subscribe {
	
	//singleton con parámetros no es singleton 
	
	private String Name = "";
	private String Origin = "";
	private String Type = "";
	private int Max = 0;
	private int Min = 0;
	private int Default = 0;	
	

	public Subscribe() { //constructor
		// TODO Auto-generated constructor stub
	}


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

}
