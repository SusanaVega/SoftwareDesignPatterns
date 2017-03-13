package FilesManagement;

import java.util.ArrayList;

public class Aircraft {

	private ArrayList<Products> products;
	
	public Aircraft(){
		products = new ArrayList<Products>();
	}

	public ArrayList<Products> getProducts() {
		return products;
	}

	public void setProducts(Products product) {
		//System.out.println("Prod ID: " + product.getProductID());
		this.products.add(product);
	}
	
	public Products popProduct(){
		Products temp = products.get(products.size()-1);
		products.remove(products.size()-1);
		return temp;
	}
	
}
