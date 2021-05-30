package br.com.digitalhouse.restaurantapi.usecase.model.response;

public class DishResponse {

	private double price;
    private String description;
	
    public DishResponse(double price, String description) {
		this.price = price;
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}
    
}
