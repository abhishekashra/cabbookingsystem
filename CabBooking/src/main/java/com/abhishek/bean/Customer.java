/**
 * 
 */
package com.abhishek.bean;

/**
 * @author abhishek
 *
 */
public class Customer {

	private int orderId;
	private String customerName;
	private double customerLatitude;
	private double customerLongitude;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getCustomerLatitude() {
		return customerLatitude;
	}

	public void setCustomerLatitude(double customerLatitude) {
		this.customerLatitude = customerLatitude;
	}

	public double getCustomerLongitude() {
		return customerLongitude;
	}

	public void setCustomerLongitude(double customerLongitude) {
		this.customerLongitude = customerLongitude;
	}

	@Override
	public String toString() {
		return "Customer [orderId=" + orderId + ", customerName=" + customerName + ", customerLatitude="
				+ customerLatitude + ", customerLongitude=" + customerLongitude + "]";
	}

}
