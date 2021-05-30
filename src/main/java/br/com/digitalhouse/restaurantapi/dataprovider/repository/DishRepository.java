package br.com.digitalhouse.restaurantapi.dataprovider.repository;

import java.io.IOException;

import br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.DishData;

public interface DishRepository {
	
	public DishData findById(Integer dishId) throws IOException;
	
}
