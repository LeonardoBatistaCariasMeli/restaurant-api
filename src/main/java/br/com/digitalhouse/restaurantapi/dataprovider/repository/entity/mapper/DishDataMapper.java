package br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.DishData;
import br.com.digitalhouse.restaurantapi.domain.entity.Dish;

public interface DishDataMapper {
	
	public static List<DishData> toListDishDataOf(List<Dish> dishes) {
		return dishes.stream().map(DishDataMapper::toDishDataOf).collect(Collectors.toList());
	}
	
	public static DishData toDishDataOf(Dish dish) {
		return new DishData(dish.getId(), dish.getPrice(), dish.getDescription());
	}
	
}
