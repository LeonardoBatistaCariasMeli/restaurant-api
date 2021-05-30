package br.com.digitalhouse.restaurantapi.dataprovider;

import java.io.IOException;

import org.springframework.stereotype.Service;

import br.com.digitalhouse.restaurantapi.dataprovider.repository.DishRepository;
import br.com.digitalhouse.restaurantapi.domain.entity.Dish;
import br.com.digitalhouse.restaurantapi.domain.entity.mapper.DishMapper;
import br.com.digitalhouse.restaurantapi.domain.gateway.DishGateway;

@Service
public class DishDataProvider implements DishGateway {
	
	private DishRepository repository;

	public DishDataProvider(DishRepository repository) {
		this.repository = repository;
	}

	@Override
	public Dish findById(Integer dishId) throws IOException {
		var data = this.repository.findById(dishId);
		return DishMapper.fromDishData(data);
	}
	
	

}
