
public class ProductsFactory {

	public Products getProducts(String Type) {
		// TODO Auto-generated constructor stub
		if(Type.equalsIgnoreCase("Subscribe")){
			return new Products();
		}
		else {
			return null;
			//to be fixed
		}
			
	}

}
