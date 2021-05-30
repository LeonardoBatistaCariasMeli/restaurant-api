package br.com.digitalhouse.restaurantapi.usecase.model.response;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.restaurantapi.domain.entity.enums.OrderStats;

public class OrderResponse {

	private Integer id;
	private List<DishResponse> dishes = new ArrayList<>();
	private Double totalValue;
	private OrderStats stats;

	public OrderResponse(Integer id, List<DishResponse> dishes, Double totalValue, OrderStats stats) {
		this.id = id;
		this.dishes = dishes;
		this.totalValue = totalValue;
		this.stats = stats;
	}

	public Integer getId() {
		return id;
	}

	public List<DishResponse> getDishes() {
		return dishes;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public OrderStats getStats() {
		return stats;
	}

}
