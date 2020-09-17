/**
 * 
 */
package com.abhishek.dao;

import java.util.List;

import com.abhishek.bean.Driver;

/**
 * @author Kishori
 *
 */
public interface DriverDao {
	
	List<Driver> getAvailableDriver();
	int updateDriverStatus(int driverId);
}
