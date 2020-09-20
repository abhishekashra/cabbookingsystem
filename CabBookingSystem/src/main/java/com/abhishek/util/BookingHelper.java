/**
 * 
 */
package com.abhishek.util;

import org.springframework.stereotype.Component;

/**
 * @author Kishori
 *
 */
@Component
public class BookingHelper {

	/**
	 * This method is a Business logic to get the distance between the driver and customer
	 * based on driver's Latitude + Longitude and customers Latitude + Longitude
	 * 
	 * @param customerLatitude
	 * @param driverLatitude
	 * @param customerLongitude
	 * @param driverLongitude
	 * @return Distance between both Customer and Driver
	 */
	public double distance(double customerLatitude, double driverLatitude, double customerLongitude, double driverLongitude) {

		// The math module contains a function
		// named toRadians which converts from
		// degrees to radians.
		customerLongitude = Math.toRadians(customerLongitude);
		driverLongitude = Math.toRadians(driverLongitude);
		customerLatitude = Math.toRadians(customerLatitude);
		driverLatitude = Math.toRadians(driverLatitude);

		// Haversine formula
		double dlon = driverLongitude - customerLongitude;
		double dlat = driverLatitude - customerLatitude;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(customerLatitude) * Math.cos(driverLatitude) * Math.pow(Math.sin(dlon / 2), 2);

		double c = 2 * Math.asin(Math.sqrt(a));

		// Radius of earth in kilometers. Use 3956
		// for miles
		double r = 6371;

		// calculate the result
		return (c * r);
	}
}
