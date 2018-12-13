package org.table.booking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Table;
import org.table.booking.domain.TableManager;

public class MakeReservationTest {

	private Table t;

	@Before
	public void before() {
		Table t = new Table();
	}

	@Test // (timeout = 1000) @Skip
	public void makeReservationTC1() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(-5, "21:30", -2);
		assertEquals(expected.state(), t.state());
	}

	public void makeReservationTC2() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(-5, "21:30", 2);
		assertEquals(expected.state(), t.state());
	}

	public void makeReservationTC3() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(-5, "21:30", 2);
		assertEquals(expected.state(), t.state());
	}

	public void makeReservationTC4() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(-5, "21:30", 2);
		assertEquals(expected.state(), t.state());
	}

	public void makeReservationTC5() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(-5, "21:30", 2);
		assertEquals(expected.state(), t.state());
	}

	public void makeReservationTC6() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(-5, "21:30", 2);
		assertEquals(expected.state(), t.state());
	}

	public void makeReservationTC7() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(-5, "21:30", 2);
		assertEquals(expected.state(), t.state());
	}

	public void makeReservationTC8() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(-5, "21:30", 2);
		assertEquals(expected.state(), t.state());
	}

	public void makeReservationTC9() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(-5, "21:30", 2);
		assertEquals(expected.state(), t.state());
	}

	public void makeReservationTC10() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(-5, "21:30", 2);
		assertEquals(expected.state(), t.state());
	}

	public void makeReservationTC11() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(-5, "21:30", 2);
		assertEquals(expected.state(), t.state());
	}

	public void makeReservationTC12() {
		Table expected = new Table();
		expected.setState("reserved");
		t = TableManager.make_reservation(-5, "21:30", 2);
		assertEquals(expected.state(), t.state());
	}
}
