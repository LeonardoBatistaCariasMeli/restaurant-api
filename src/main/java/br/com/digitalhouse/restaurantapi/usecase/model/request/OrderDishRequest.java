package br.com.digitalhouse.restaurantapi.usecase.model.request;

public class OrderDishRequest {

	private Integer dishId;
	private Integer dishQuantity;

	public OrderDishRequest(Integer dishId, Integer dishQuantity) {
		this.dishId = dishId;
		this.dishQuantity = dishQuantity;
	}

	public Integer getDishId() {
		return dishId;
	}

	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}

	public Integer getDishQuantity() {
		return dishQuantity;
	}

	public void setDishQuantity(Integer dishQuantity) {
		this.dishQuantity = dishQuantity;
	}

}
