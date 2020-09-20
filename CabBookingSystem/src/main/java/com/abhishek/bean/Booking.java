/**
 * 
 */
package com.abhishek.bean;

/**
 * POJO for Booking details holding details of Customer and Driver
 * @author abhishek
 *
 */
public class Booking {

	private String driverName;
	private String customerName;
	private String driverStatus;

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDriverStatus() {
		return driverStatus;
	}

	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}

	@Override
	public String toString() {
		return "Booking [driverName=" + driverName + ", customerName=" + customerName + ", driverStatus=" + driverStatus
				+ "]";
	}

}
