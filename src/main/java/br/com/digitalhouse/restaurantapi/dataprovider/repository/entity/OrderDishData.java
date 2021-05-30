package br.com.digitalhouse.restaurantapi.dataprovider.repository.entity;

public class OrderDishData {
	
	private Integer orderId;
	private DishData dish;
	private Integer quantity;
	
	public OrderDishData() {
	}
	
	public OrderDishData(Integer orderId, DishData dish, Integer quantity) {
		this.orderId = orderId;
		this.dish = dish;
		this.quantity = quantity;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public DishData getDish() {
		return dish;
	}

	public void setDish(DishData dish) {
		this.dish = dish;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
