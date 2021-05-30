package br.com.digitalhouse.restaurantapi.dataprovider.repository.entity;

public class DishData {
	
	private Integer id;
    private double price;
    private String description;

    public DishData() {
    }

    public DishData(Integer id, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
