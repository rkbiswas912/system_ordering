package system_ordering.entity;

import java.io.Serializable;

public class OrderDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6190362360325247149L;
	
	String orderReference;
	int noOfBricks;
	
	public String getOrderReference() {
		return orderReference;
	}
	public int getNoOfBricks() {
		return noOfBricks;
	}
	public void setOrderReference(String orderReference) {
		this.orderReference = orderReference;
	}
	public void setNoOfBricks(int noOfBricks) {
		this.noOfBricks = noOfBricks;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderReference=" + orderReference + ", noOfBricks=" + noOfBricks + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderReference == null) ? 0 : orderReference.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		if (orderReference == null) {
			if (other.orderReference != null)
				return false;
		} else if (!orderReference.equals(other.orderReference))
			return false;
		return true;
	}

}
