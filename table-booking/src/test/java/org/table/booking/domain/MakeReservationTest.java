package org.table.booking.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Reservation;
import org.table.booking.domain.Table;
import org.table.booking.domain.TableManager;

public class MakeReservationTest {

	private Table t;
	private Reservation r;

	@Before
	public void before() {
		t = new Table();
		r = new Reservation();
	}

	@Test // (timeout = 1000) @Skip
	public void makeReservationTC1() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(-5, "-2:00", -2);

		assertNull(t);
		if (t != null) {
			assertEquals(expected.state(), t.state());
		}

	}

	@Test // (timeout = 1000) @Skip
	public void makeReservationTC2() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(2, "11:00", 3);

		assertNotNull(t);
		assertEquals(expected.state(), t.state());
	}

	@Test // (timeout = 1000) @Skip
	public void makeReservationTC3() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(4, "13:30", 7);

		assertNull(t);
		if (t != null) {
			assertEquals(expected.state(), t.state());
		}
	}

	@Test // (timeout = 1000) @Skip
	public void makeReservationTC4() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(0, "16:45", 0);

		assertNotNull(t);
		assertEquals(expected.state(), t.state());
	}

	@Test // (timeout = 1000) @Skip
	public void makeReservationTC5() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(3, "22:15", 6);

		assertNull(t);
		if (t != null) {
			assertEquals(expected.state(), t.state());
		}

	}

	@Test // (timeout = 1000) @Skip
	public void makeReservationTC6() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(2000, "25:30", 2000);

		assertNotNull(t);
		assertEquals(expected.state(), t.state());
	}

	@Test // (timeout = 1000) @Skip
	public void makeReservationTC7() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(-5, "09:00", 2);

		assertNull(t);
		if (t != null) {
			assertEquals(expected.state(), t.state());
		}

	}

	@Test // (timeout = 1000) @Skip
	public void makeReservationTC8() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(2, "13:30", 3);

		assertNotNull(t);
		assertEquals(expected.state(), t.state());
	}

	@Test // (timeout = 1000) @Skip
	public void makeReservationTC9() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(4, "15:00", 7);

		assertNull(t);
		if (t != null) {
			assertEquals(expected.state(), t.state());
		}

	}

	@Test // (timeout = 1000) @Skip
	public void makeReservationTC10() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(0, "20:45", 0);

		assertNotNull(t);
		assertEquals(expected.state(), t.state());
	}

	@Test // (timeout = 1000) @Skip
	public void makeReservationTC11() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(3, "23:00", 6);

		assertNull(t);
		if (t != null) {
			assertEquals(expected.state(), t.state());
		}
	}

	@Test // (timeout = 1000) @Skip
	public void makeReservationTC12() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(2000, "700:30", 2000);

		assertNotNull(t);
		assertEquals(expected.state(), t.state());
	}
}
