package br.com.digitalhouse.restaurantapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.restaurantapi.domain.entity.enums.OrderStats;

public class Order {

	private Integer id;
	private Integer tableId;
	private List<OrderDish> orderDishes = new ArrayList<>();
	private Double totalValue;
	private OrderStats stats;
	
	public Order(Integer id, Integer tableId, List<OrderDish> orderDishes, Double totalValue, OrderStats stats) {
		this.id = id;
		this.tableId = tableId;
		this.orderDishes = orderDishes;
		this.totalValue = totalValue;
		this.stats = stats;
	}

	public Integer getId() {
		return id;
	}

	public Integer getTableId() {
		return tableId;
	}

	public List<OrderDish> getOrderDishes() {
		return orderDishes;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public OrderStats getStats() {
		return stats;
	}

}
