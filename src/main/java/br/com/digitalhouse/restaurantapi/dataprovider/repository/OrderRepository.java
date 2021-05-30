package br.com.digitalhouse.restaurantapi.dataprovider.repository;

import java.io.IOException;
import java.util.List;

import br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.OrderData;

public interface OrderRepository {
	
	public void registerAnOrder(OrderData data);
	public List<OrderData> findAll() throws Exception; 
	public void closeOrdersByTableId(Integer id) throws IOException, Exception;
	
}
