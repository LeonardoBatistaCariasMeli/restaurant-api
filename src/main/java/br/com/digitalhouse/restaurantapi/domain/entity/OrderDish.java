package br.com.digitalhouse.restaurantapi.domain.entity;

public class OrderDish {

	private Integer orderId;
	private Dish dish;
	private Integer quantity;

	public OrderDish(Integer orderId, Dish dish, Integer quantity) {
		this.orderId = orderId;
		this.dish = dish;
		this.quantity = quantity;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public Dish getDish() {
		return dish;
	}

	public Integer getQuantity() {
		return quantity;
	}
	
}
