package br.com.digitalhouse.restaurantapi.usecase.model.request;

import java.util.ArrayList;
import java.util.List;

public class OrderRequest {

	private Integer tableId;
	private List<OrderDishRequest> dishs = new ArrayList<>();

	public OrderRequest(Integer tableId, List<OrderDishRequest> dishs) {
		this.tableId = tableId;
		this.dishs = dishs;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public List<OrderDishRequest> getDishs() {
		return dishs;
	}

	public void setDishs(List<OrderDishRequest> dishs) {
		this.dishs = dishs;
	}

}
