package br.com.digitalhouse.restaurantapi.dataprovider;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.digitalhouse.restaurantapi.dataprovider.repository.OrderRepository;
import br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.OrderData;
import br.com.digitalhouse.restaurantapi.domain.entity.Order;
import br.com.digitalhouse.restaurantapi.domain.entity.mapper.OrderMapper;
import br.com.digitalhouse.restaurantapi.domain.gateway.OrderGateway;

@Service
public class OrderDataProvider implements OrderGateway {

	private OrderRepository repository;

	public OrderDataProvider(OrderRepository repository) {
		this.repository = repository;
	}

	@Override
	public void registerAnOrder(OrderData data) {
		this.repository.registerAnOrder(data);

	}

	@Override
	public List<Order> findAll() throws Exception {
		var listData = this.repository.findAll();
		
		return OrderMapper.toListOrderOf(listData);
	}

	@Override
	public void closeOrdersByTableId(Integer id) throws Exception {
		this.repository.closeOrdersByTableId(id);
	}

}
