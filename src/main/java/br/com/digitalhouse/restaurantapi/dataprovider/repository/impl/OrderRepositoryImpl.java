package br.com.digitalhouse.restaurantapi.dataprovider.repository.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.digitalhouse.restaurantapi.dataprovider.repository.OrderRepository;
import br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.CashBoxData;
import br.com.digitalhouse.restaurantapi.dataprovider.repository.entity.OrderData;
import br.com.digitalhouse.restaurantapi.dataprovider.repository.impl.utils.FileUtils;
import br.com.digitalhouse.restaurantapi.domain.entity.enums.OrderStats;

@Service
public class OrderRepositoryImpl implements OrderRepository {

	@Override
	public void registerAnOrder(OrderData data) {
		try {
			File file = ResourceUtils.getFile("file:src/main/resources/orders.json");

			List<OrderData> listData = null;

			try {
				listData = FileUtils.getContentListOf(file, new TypeReference<List<OrderData>>() {
				});
			} catch (Exception e) {
				listData = new ArrayList<OrderData>();
			}

			Integer nextIndex = listData.size() + 1;
			data.setId(nextIndex);
			data.getOrderDishes().stream().forEach(o -> o.setOrderId(nextIndex));
			listData.add(data);

			ObjectMapper objectMapper = new ObjectMapper();
			var json = objectMapper.writeValueAsString(listData);

			FileUtils.writeFile(file, json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderData> findAll() throws Exception {
		File file = ResourceUtils.getFile("file:src/main/resources/orders.json");

		try {
			return FileUtils.getContentListOf(file, new TypeReference<List<OrderData>>() {
			});
		} catch (Exception e) {
			return new ArrayList<OrderData>();
		}
	}

	@Override
	public void closeOrdersByTableId(Integer id) throws Exception {
		var listData = this.findAll();

		List<OrderData> newListData = listData.stream()
				.filter(d -> d.getTableId() == 1 && d.getStats() == OrderStats.WAITING_PAYMENT.getCod())
				.collect(Collectors.toList());

		newListData.stream().forEach(n -> {
			n.setStats(OrderStats.PAID.getCod());
		});

		ObjectMapper objectMapper = new ObjectMapper();
		var json = objectMapper.writeValueAsString(newListData);
		File file = ResourceUtils.getFile("file:src/main/resources/orders.json");
		FileUtils.writeFile(file, json);
		
		Double totalValue = newListData.stream().map(n -> n.getTotalValue()).reduce(Double::sum).get();			
		
		file = ResourceUtils.getFile("file:src/main/resources/cash-box.json");
		var cashBoxData = FileUtils.getContentOf(file, new TypeReference<CashBoxData>() {
		});
		
		cashBoxData.setTotalInBox(cashBoxData.getTotalInBox() + totalValue);;
		
		json = objectMapper.writeValueAsString(cashBoxData);
		
		FileUtils.writeFile(file, json);
	}

}
