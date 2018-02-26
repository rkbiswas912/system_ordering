package system_ordering.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import system_ordering.entity.OrderDetails;
import system_ordering.service.MyService;

@RestController
@RequestMapping("/systemOrdering")
public class MyController {

	@Autowired
	MyService service;

	@RequestMapping(value = "/createOrder/{noOfBricks}")
	public String createOrder(@PathVariable("noOfBricks") String noOfBricks) throws Exception {
		
		System.out.println("#####createOrder#######");
		int i = Integer.parseInt(noOfBricks);
		return service.submitOrber(i);
	}

	@RequestMapping(value = "/orders/{orderReference}", method = RequestMethod.GET)
	public ResponseEntity<OrderDetails> getOrder(@PathVariable("orderReference") String orderReference) {
		
		System.out.println("#####getOrder#######");
		OrderDetails r = service.getOrder(orderReference);
		if (r == null) {
			r = new OrderDetails();
			r.setOrderReference(orderReference + " Is not a valid input");
			return new ResponseEntity<OrderDetails>(r, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<OrderDetails>(r, HttpStatus.FOUND);
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public ResponseEntity<List<OrderDetails>> getOrders() throws Exception, IOException {
		
		System.out.println("#####getsAllOrders#######");
		List<OrderDetails> or = service.getOrders();
		return new ResponseEntity<List<OrderDetails>>(or, HttpStatus.OK);

	}

}