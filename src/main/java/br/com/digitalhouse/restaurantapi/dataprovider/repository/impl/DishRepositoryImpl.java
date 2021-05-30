package br.com.digitalhouse.restaurantapi.dataprovider.repository.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;

import br.com.digitalhouse.restaurantapi.dataprovider.repository.DishRepository;
import br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.DishData;
import br.com.digitalhouse.restaurantapi.dataprovider.repository.impl.utils.FileUtils;

@Service
public class DishRepositoryImpl implements DishRepository {

	@Override
	public DishData findById(Integer dishId) throws IOException {
		File file = ResourceUtils.getFile("file:src/main/resources/dishes.json");

		var listData = FileUtils.getContentOf(file, new TypeReference<List<DishData>>() {
		});

		return listData.stream().filter(d -> d.getId() == dishId).findFirst().get();
	}

}
