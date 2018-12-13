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

	@Test // (timeout = 1000)
	public void make_reservationTest() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(1, "21:30", 2);
		assertEquals(expected.state(), t.state());
	}

}