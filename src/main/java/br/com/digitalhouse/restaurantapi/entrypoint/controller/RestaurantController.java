package br.com.digitalhouse.restaurantapi.entrypoint.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.digitalhouse.restaurantapi.usecase.OrderUseCase;
import br.com.digitalhouse.restaurantapi.usecase.model.request.OrderRequest;
import br.com.digitalhouse.restaurantapi.usecase.model.response.TableResponse;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

	private OrderUseCase orderUseCase;
	
	public RestaurantController(OrderUseCase orderUseCase) {
		this.orderUseCase = orderUseCase;
	}

	@PostMapping("/orders")
	public ResponseEntity<Void> registerAnOrder(@RequestBody OrderRequest request) {
		this.orderUseCase.registerAnOrder(request);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("")
				.buildAndExpand(request.getTableId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/tables/{id}")
	public ResponseEntity<TableResponse> getOrdersByTableId(@PathVariable Integer id) throws Exception {
		var response = this.orderUseCase.getOrdersByTableId(id);

		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping("/tables/{id}")
	public ResponseEntity<Void> closeOrdersByTableId(@PathVariable Integer id) throws Exception {
		this.orderUseCase.closeOrdersByTableId(id);
		return ResponseEntity.ok().build(); 
		
	}

}