package system_ordering.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import system_ordering.entity.OrderDetails;
import system_ordering.service.MyService;

@RestController
@RequestMapping("/order")
public class MyController {

	@Autowired
	MyService service;

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String createOrder(int noOfBricks) {
		return service.submitOrber();

	}

	@RequestMapping(value = "/orders/{orderReference}", method = RequestMethod.GET)
	public ResponseEntity<OrderDetails> getOrder(@PathParam("orderReference") String orderReference) {

		OrderDetails r = service.getOrder();
		if (r == null) {
			r.setOrderReference(orderReference + " Is not a valid input");
			return new ResponseEntity<OrderDetails>(r, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<OrderDetails>(r, HttpStatus.FOUND);

	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public ResponseEntity<List<OrderDetails>> getOrders() {
		List<OrderDetails> or = service.getOrders();
		return new ResponseEntity<List<OrderDetails>>(or, HttpStatus.OK);

	}

}