package br.com.digitalhouse.restaurantapi.dataprovider.repository.entity;

import java.util.ArrayList;
import java.util.List;

public class OrderData {
	
	private Integer id;
	private Integer tableId;
	private List<OrderDishData> orderDishes = new ArrayList<>();
	private Double totalValue;
	private Integer stats;
	
	public OrderData() {
	}
	
	public OrderData(Integer id, Integer tableId, List<OrderDishData> orderDishes, Double totalValue, Integer stats) {
		this.id = id;
		this.tableId = tableId;
		this.orderDishes = orderDishes;
		this.totalValue = totalValue;
		this.stats = stats;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public List<OrderDishData> getOrderDishes() {
		return orderDishes;
	}

	public void setOrderDishes(List<OrderDishData> orderDishes) {
		this.orderDishes = orderDishes;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public Integer getStats() {
		return stats;
	}

	public void setStats(Integer stats) {
		this.stats = stats;
	}

}
