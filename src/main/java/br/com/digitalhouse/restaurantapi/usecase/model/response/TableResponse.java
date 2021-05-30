package br.com.digitalhouse.restaurantapi.usecase.model.response;

import java.util.List;

public class TableResponse {
	private Integer id;
	private List<OrderResponse> orders;
	
	public TableResponse(Integer id, List<OrderResponse> orders) {
		this.id = id;
		this.orders = orders;
	}

	public Integer getId() {
		return id;
	}

	public List<OrderResponse> getOrders() {
		return orders;
	}
	
}
