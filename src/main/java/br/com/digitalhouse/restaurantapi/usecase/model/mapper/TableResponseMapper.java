package br.com.digitalhouse.restaurantapi.usecase.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.digitalhouse.restaurantapi.domain.entity.Dish;
import br.com.digitalhouse.restaurantapi.domain.entity.Order;
import br.com.digitalhouse.restaurantapi.usecase.model.response.DishResponse;
import br.com.digitalhouse.restaurantapi.usecase.model.response.OrderResponse;
import br.com.digitalhouse.restaurantapi.usecase.model.response.TableResponse;

public interface TableResponseMapper {

	public static TableResponse assembleTableResponseOf(List<Order> orders) {
		var listOrderResponse = assembleListOrderResponseOf(orders);
		return new TableResponse(orders.get(0).getTableId(), listOrderResponse);
	}
	
	public static List<OrderResponse> assembleListOrderResponseOf(List<Order> orders) {
		return orders.stream().map(TableResponseMapper::assembleOrderResponseOf).collect(Collectors.toList());
	}
	
	public static OrderResponse assembleOrderResponseOf(Order order) {
		var listDishResponse = order.getOrderDishes().stream().map(d -> TableResponseMapper.assembleDishResponseOf(d.getDish())).collect(Collectors.toList());		
		return new OrderResponse(order.getId(), listDishResponse, order.getTotalValue(), order.getStats());
	}
	
	public static DishResponse assembleDishResponseOf(Dish dish) {
		return new DishResponse(dish.getPrice(), dish.getDescription());
	}
	
}
