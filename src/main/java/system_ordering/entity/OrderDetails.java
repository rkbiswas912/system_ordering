package system_ordering.entity;

public class OrderDetails {
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

}
