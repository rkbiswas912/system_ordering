package system_ordering.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import system_ordering.entity.OrderDetails;
import system_ordering.service.MyService;

@RestController
@RequestMapping("/order")
public class MyController {
	
	@Autowired
	MyService service;

	@RequestMapping(value="/createOrder")
	public String createOrder(int noOfBricks) {
		return service.submitOrber();

	}
	@RequestMapping("/orders/{orderReference}")
	public OrderDetails getOrder(@PathParam("orderReference") String orderReference) {
		return service.getOrder();
		

	}
	
	@RequestMapping("/orders")
	public List<OrderDetails> getOrders(String orderReference) {
		return service.getOrders();

	}

}