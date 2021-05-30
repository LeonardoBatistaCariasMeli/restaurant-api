package br.com.digitalhouse.restaurantapi.usecase;

import java.io.IOException;

import br.com.digitalhouse.restaurantapi.usecase.model.request.OrderRequest;
import br.com.digitalhouse.restaurantapi.usecase.model.response.TableResponse;

public interface OrderUseCase {
	void registerAnOrder(OrderRequest request);
	TableResponse getOrdersByTableId(Integer id) throws Exception;
	void closeOrdersByTableId(Integer id) throws IOException, Exception;
}
