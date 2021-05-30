package br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.DishData;
import br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.OrderData;
import br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.OrderDishData;
import br.com.digitalhouse.restaurantapi.domain.entity.Dish;
import br.com.digitalhouse.restaurantapi.domain.entity.enums.OrderStats;
import br.com.digitalhouse.restaurantapi.usecase.model.request.OrderRequest;

public interface OrderDataMapper {
	
	public static OrderData toOrderDataOf(OrderRequest request, List<Dish> dishes) {
		var listData = DishDataMapper.toListDishDataOf(dishes);
		var orderDishesData = assembleListOrderDishDataOf(listData, request);
		
		double totalValue = orderDishesData.stream().map(o -> o.getDish().getPrice() * o.getQuantity()).reduce(Double::sum).get();
		
		return new OrderData(null, request.getTableId(), orderDishesData, totalValue, OrderStats.WAITING_PAYMENT.getCod());
	}
	
	public static List<OrderDishData> assembleListOrderDishDataOf(List<DishData> listData, OrderRequest request) {
		List<OrderDishData> listOrderDishData = new ArrayList<>();
		for(int i = 0; i < listData.size(); i++) {
			listOrderDishData.add(assembleOrderDishDataOf(listData.get(i), request.getDishs().get(i).getDishQuantity()));
		}
		return listOrderDishData;
	}
	
	public static OrderDishData assembleOrderDishDataOf(DishData data, Integer quantity) {
		return new OrderDishData(null, data, quantity);
	}
	
}
