package system_ordering;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import junit.framework.Assert;
import system_ordering.controller.MyController;
import system_ordering.entity.OrderDetails;

public class MyControllerTest {

	MyController myController;

	@Before
	public void setUp() throws Exception {
		myController = new MyController();
	}

	@Test
	public void createOrderWithValidRequest() {
		myController.createOrder(100);

	}

	@Test
	public void createOrderWithInValidRequest() {
		myController.createOrder(-100);

	}

	@Test
	public void getOrderWithValidRequest() {
		ResponseEntity<OrderDetails> result = myController.getOrder("someValidOrderRef");
		result.getStatusCode();
		assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());

	}

	@Test
	public void getOrderWithInValidRequest() {
		ResponseEntity<OrderDetails> result = myController.getOrder("someInValidOrderRef");
		result.getStatusCode();
		assertEquals(HttpStatus.OK, result.getStatusCode());

	}

	@Test
	public void getOrdersWithValidRequest() {
		ResponseEntity<List<OrderDetails>> result = myController.getOrders();
		result.getStatusCode();
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}

}
