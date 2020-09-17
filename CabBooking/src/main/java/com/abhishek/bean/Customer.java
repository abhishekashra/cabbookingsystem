/**
 * 
 */
package com.abhishek.bean;

import java.io.Serializable;

/**
 * @author abhishek
 *
 */
public class Customer implements Serializable {

	private static final long serialVersionUID = -4657045381386302847L;

	private int customerId;

	private String customerName;

	private double customerLatitude;

	private double customerLongitude;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerLatitude="
				+ customerLatitude + ", customerLongitude=" + customerLongitude + "]";
	}

}
