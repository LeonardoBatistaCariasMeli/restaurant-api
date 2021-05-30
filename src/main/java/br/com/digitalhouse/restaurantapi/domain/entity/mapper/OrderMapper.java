package br.com.digitalhouse.restaurantapi.domain.entity.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.OrderData;
import br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.OrderDishData;
import br.com.digitalhouse.restaurantapi.domain.entity.Order;
import br.com.digitalhouse.restaurantapi.domain.entity.OrderDish;
import br.com.digitalhouse.restaurantapi.domain.entity.enums.OrderStats;

public interface OrderMapper {
	
	public static List<Order> toListOrderOf(List<OrderData> listData) {
		return listData.stream().map(t -> {
			try {
				return toOrderOf(t);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
	}
	
	public static Order toOrderOf(OrderData data) throws Exception {
		var orderDishes = toListOrderDishOf(data.getOrderDishes());
		double totalValue = orderDishes.stream().map(o -> o.getDish().getPrice() * o.getQuantity()).reduce(Double::sum).get();
		OrderStats orderStats = OrderStats.toEnum(data.getStats());
		return new Order(data.getId(), data.getTableId(), orderDishes, totalValue, orderStats);
	}
	
	public static List<OrderDish> toListOrderDishOf(List<OrderDishData> listData) {
		return listData.stream().map(OrderMapper::toOrderDishOf).collect(Collectors.toList());
	}
	
	public static OrderDish toOrderDishOf(OrderDishData data) {
		var dish = DishMapper.fromDishData(data.getDish());
		return new OrderDish(data.getOrderId(), dish, data.getQuantity());
	}
	
	
	
}
