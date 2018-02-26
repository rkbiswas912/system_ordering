package system_ordering;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import system_ordering.controller.MyController;

public class MyControllerTest {

	MyController myController;

	@Before
	public void setUp() throws Exception {
		myController = new MyController();
	}

	@Test
	public void createOrderWithValidRequest() throws IOException {
		// myController.createOrder(100);
		// fail("Not yet implemented");

	}

	@Test
	public void createOrderWithInValidRequest() throws IOException {
		// myController.createOrder(-100);

	}

	@Test
	public void getOrderWithValidRequest() {
		/*
		 * ResponseEntity<OrderDetails> result =
		 * myController.getOrder("someValidOrderRef"); result.getStatusCode();
		 * assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
		 */

	}

	@Test
	public void getOrderWithInValidRequest() {
		/*
		 * ResponseEntity<OrderDetails> result =
		 * myController.getOrder("someInValidOrderRef"); result.getStatusCode();
		 * assertEquals(HttpStatus.OK, result.getStatusCode());
		 */

	}

	@Test
	public void getOrdersWithValidRequest() {
		// ResponseEntity<List<OrderDetails>> result = myController.getOrders();
		// result.getStatusCode();
		// assertEquals(HttpStatus.OK, result.getStatusCode());
	}

}
