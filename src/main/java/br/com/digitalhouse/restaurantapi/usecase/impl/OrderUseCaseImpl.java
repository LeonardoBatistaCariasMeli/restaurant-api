package br.com.digitalhouse.restaurantapi.usecase.impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.OrderData;
import br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.mapper.OrderDataMapper;
import br.com.digitalhouse.restaurantapi.domain.entity.Dish;
import br.com.digitalhouse.restaurantapi.domain.entity.Order;
import br.com.digitalhouse.restaurantapi.domain.gateway.DishGateway;
import br.com.digitalhouse.restaurantapi.domain.gateway.OrderGateway;
import br.com.digitalhouse.restaurantapi.usecase.OrderUseCase;
import br.com.digitalhouse.restaurantapi.usecase.model.mapper.TableResponseMapper;
import br.com.digitalhouse.restaurantapi.usecase.model.request.OrderDishRequest;
import br.com.digitalhouse.restaurantapi.usecase.model.request.OrderRequest;
import br.com.digitalhouse.restaurantapi.usecase.model.response.TableResponse;

@Component
public class OrderUseCaseImpl implements OrderUseCase {

	private OrderGateway orderGateway;
	private DishGateway dishGateway;
	
	public OrderUseCaseImpl(OrderGateway orderGateway, DishGateway dishGateway) {
		this.orderGateway = orderGateway;
		this.dishGateway = dishGateway;
	}

	@Override
	public void registerAnOrder(OrderRequest request) {
		var data = assembleOrderDataOf(request);
		this.orderGateway.registerAnOrder(data);
	}
	
	private OrderData assembleOrderDataOf(OrderRequest request) {
		var dishes = this.findAll(request.getDishs());
		return OrderDataMapper.toOrderDataOf(request, dishes);
	}
	
	private List<Dish> findAll(List<OrderDishRequest> request) {
		return request.stream().map(r -> {
			try {
				return this.findDishById(r.getDishId());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
	}
	
	private Dish findDishById(Integer dishId) throws IOException {
		return dishGateway.findById(dishId);
	}

	@Override 
	public TableResponse getOrdersByTableId(Integer id) throws Exception {
		var listOrderFiltered = getOrderWithTableIdEquals(id);
		return TableResponseMapper.assembleTableResponseOf(listOrderFiltered);
	}
	
	private List<Order> getOrderWithTableIdEquals(Integer id) throws Exception {
		var listData = this.orderGateway.findAll();
		return listData.stream().filter(o -> o.getTableId() == id && o.getStats().getDescricao().equals("WAITING PAYMENT")).collect(Collectors.toList());
	}

	@Override
	public void closeOrdersByTableId(Integer id) throws Exception {
		this.orderGateway.closeOrdersByTableId(id);
		
	}

}
