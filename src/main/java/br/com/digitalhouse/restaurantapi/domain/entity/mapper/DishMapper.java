package br.com.digitalhouse.restaurantapi.domain.entity.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.DishData;
import br.com.digitalhouse.restaurantapi.domain.entity.Dish;

public interface DishMapper {
	
	public static List<Dish> fromListDishData(List<DishData> listData) {
		return listData.stream().map(DishMapper::fromDishData).collect(Collectors.toList());
	}
	
	public static Dish fromDishData(DishData data) {
        return new Dish(data.getId(), data.getPrice(), data.getDescription());

    }
	
}
