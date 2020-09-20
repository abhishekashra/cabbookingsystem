/**
 * 
 */
package com.abhishek.bean;

import java.io.Serializable;

/**
 * @author abhishek
 *
 */
public class Driver implements Serializable {

	private static final long serialVersionUID = -7045346581386302847L;

	private int driverId;
	private String driverName;
	private double currentLatitude;
	private double currentLogitude;
	private String status;
	private int orderId;

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public double getCurrentLatitude() {
		return currentLatitude;
	}

	public void setCurrentLatitude(double currentLatitude) {
		this.currentLatitude = currentLatitude;
	}

	public double getCurrentLogitude() {
		return currentLogitude;
	}

	public void setCurrentLogitude(double currentLogitude) {
		this.currentLogitude = currentLogitude;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", driverName=" + driverName + ", currentLatitude=" + currentLatitude
				+ ", currentLogitude=" + currentLogitude + ", status=" + status + ", orderId=" + orderId + "]";
	}

}
