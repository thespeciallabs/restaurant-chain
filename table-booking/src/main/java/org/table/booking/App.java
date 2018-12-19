package org.table.booking;

import org.table.booking.presentation.IU_Login;
import org.table.booking.presentation.IU_TableBooking;

public class App {
	public static void main(String[] args) {
		System.out.println("-----\tRestaurant Chain Manager.\t(v1.0)\t-----\n");
		System.out.println("-----\tTABLE BOOKING\t-----");
		IU_Login.main(args);
		IU_TableBooking.main(args);
	}
}
