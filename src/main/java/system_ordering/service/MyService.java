package system_ordering.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import system_ordering.entity.OrderDetails;

@Component
public class MyService {

	public String submitOrber(int noOfBricks) throws Exception {
		long l = System.currentTimeMillis();
		String orderReference = String.valueOf(l);
		OrderDetails od = new OrderDetails();
		od.setOrderReference(orderReference);
		od.setNoOfBricks(noOfBricks);
		ArrayList<OrderDetails> orders = null;

		try {
			orders = (ArrayList<OrderDetails>) getOrders();
		} catch (Exception e) {
			orders = new ArrayList<OrderDetails>();
		}
		orders.add(od);
		FileOutputStream fis = new FileOutputStream(".\\t.tmp");
		ObjectOutputStream ois = new ObjectOutputStream(fis);
		ois.writeObject(orders);
		ois.close();
		fis.close();
		return orderReference;
	}

	public OrderDetails getOrder(String s) {

		ArrayList<OrderDetails> orders = null;
		try {
			orders = (ArrayList<OrderDetails>) getOrders();
		} catch (Exception e) {
			orders = new ArrayList<OrderDetails>();
		}
		OrderDetails o = new OrderDetails();
		o.setOrderReference(s);
		if (orders.contains(o)) {
			int index = orders.lastIndexOf(o);
			return orders.get(index);
		}
		return null;
	}

	public ArrayList<OrderDetails> getOrders() throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream(".\\t.tmp");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<OrderDetails> ods = (ArrayList<OrderDetails>) ois.readObject();
		ois.close();
		fis.close();
		return ods;

	}

}
