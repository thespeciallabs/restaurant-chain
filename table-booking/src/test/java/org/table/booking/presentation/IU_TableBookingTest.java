package org.table.booking.presentation;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

public class IU_TableBookingTest {

	@Test
	public void menuTC1() {
		InputStream is = new ByteArrayInputStream("a".getBytes());
		System.setIn(is);
		assertEquals(-1, IU_TableBooking.menu());
	}
	
	@Test
	public void opt2TC1() {
		String input = "1 10 30 4";
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		assertEquals(0, IU_TableBooking.opt_2());
	}
	
	@Test
	public void opt2TC2() {
		String input = "1 10 30 a";
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		assertEquals(-1, IU_TableBooking.opt_2());
	}

}
