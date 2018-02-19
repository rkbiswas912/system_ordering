package system_ordering.service;

import java.util.ArrayList;
import java.util.List;

import system_ordering.entity.OrderDetails;

public class MyService {
	
	public String submitOrber(){
		long l= System.currentTimeMillis();
		String orderReference = String.valueOf(l);
		return orderReference;
	}
	
	public OrderDetails getOrder(){
		return new OrderDetails();
	}
	
	public List<OrderDetails> getOrders(){
		OrderDetails e =new OrderDetails();
		List<OrderDetails> listOfOrder = new ArrayList<OrderDetails>();
		listOfOrder.add(e);
		return listOfOrder;
	
	}

}
