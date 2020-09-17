/**
 * 
 */
package com.abhishek.bean;

/**
 * @author Kishori
 *
 */
public class Booking {

	private int bookingId;
	private Driver driver;
	private Customer customer;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", driver=" + driver + ", customer=" + customer + "]";
	}
	
	
}
