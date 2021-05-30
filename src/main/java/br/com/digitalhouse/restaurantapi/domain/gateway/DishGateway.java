package br.com.digitalhouse.restaurantapi.domain.gateway;

import java.io.IOException;

import br.com.digitalhouse.restaurantapi.domain.entity.Dish;

public interface DishGateway {
	
	public Dish findById(Integer dishId) throws IOException;
	
}
