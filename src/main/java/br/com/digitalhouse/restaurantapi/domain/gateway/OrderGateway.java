package br.com.digitalhouse.restaurantapi.domain.gateway;

import java.io.IOException;
import java.util.List;

import br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.OrderData;
import br.com.digitalhouse.restaurantapi.domain.entity.Order;

public interface OrderGateway {
	void registerAnOrder(OrderData data);
	List<Order> findAll() throws Exception;
	void closeOrdersByTableId(Integer id) throws IOException, Exception;
}
