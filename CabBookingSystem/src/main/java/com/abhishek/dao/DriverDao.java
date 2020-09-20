/**
 * 
 */
package com.abhishek.dao;

import java.util.List;

import com.abhishek.bean.Driver;
import com.abhishek.exception.CabBookingException;

/**
 * @author abhishek
 *
 */
public interface DriverDao {
	
	/**
	 * This method is used to get all the available drivers 
	 * @return {@link List} of {@link Driver}
	 * @throws CabBookingException
	 */
	List<Driver> getAvailableDriver() throws CabBookingException;
	/**
	 * This method is used to update the most eligible drivers status to BUSY and assign the OrderId of the booking
	 * @param driverId
	 * @param orderId
	 * @return Number of rows affected
	 * @throws CabBookingException
	 */
	int updateDriver(int driverId,int orderId) throws CabBookingException;
}
