package org.table.booking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Table;
import org.table.booking.domain.TableManager;

public class TableManagerTest {

	private Table t;

	@Before
	public void before() {
		Table t = new Table();
	}

	@Test(timeout = 1000)
	public void make_reservationTest() {

		Table expected = null;
		t = TableManager.make_reservation(1, "9", 4);
		assertEquals(expected, t);
	}

}
