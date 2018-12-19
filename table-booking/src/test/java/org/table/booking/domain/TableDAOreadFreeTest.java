package org.table.booking.domain;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Reservation;
import org.table.booking.domain.Table;

public class TableDAOreadFreeTest {

	private Table table;
	private LinkedList<Table> list;
	private Reservation r;

	@Before
	public void before() {
		table = new Table();
		list = new LinkedList<>();
		r = new Reservation();
	}

	@Test // (timeout = 1000) @Skip
	public void readFreeTC1() {
		r.set_diners(-10);
		list = table.get_tableDAO().readFree(r);

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("free")
					&& table.ID().equals("-2")
					&& table.get_maxdiners() == -3) {
				assertEquals("free", table.state());
				assertEquals("-2", table.ID());
				assertEquals(-3, table.get_maxdiners());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readFreeTC2() {
		r.set_diners(10);
		list = table.get_tableDAO().readFree(r);

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("reserved")
					&& table.ID().equals("4")
					&& table.get_maxdiners() == 5) {
				assertEquals("reserved", table.state());
				assertEquals("4", table.ID());
				assertEquals(5, table.get_maxdiners());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readFreeTC3() {
		r.set_diners(0);
		list = table.get_tableDAO().readFree(r);

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("busy")
					&& table.ID().equals("0")
					&& table.get_maxdiners() == 7) {
				assertEquals("busy", table.state());
				assertEquals("0", table.ID());
				assertEquals(7, table.get_maxdiners());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readFreeTC4() {
		list = table.get_tableDAO().readFree(r);

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("asking")
					&& table.ID().equals("5000")
					&& table.get_maxdiners() == 0) {
				assertEquals("asking", table.state());
				assertEquals("5000", table.ID());
				assertEquals(0, table.get_maxdiners());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readFreeTC5() {
		r.set_diners(10);
		list = table.get_tableDAO().readFree(r);

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("waiting for food")
					&& table.ID().equals("-2")
					&& table.get_maxdiners() == 6) {
				assertEquals("waiting for food",
						table.state());
				assertEquals("-2", table.ID());
				assertEquals(6, table.get_maxdiners());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readFreeTC6() {
		r.set_diners(15);
		list = table.get_tableDAO().readFree(r);

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("served")
					&& table.ID().equals("4")
					&& table.get_maxdiners() == 1000) {
				assertEquals("served", table.state());
				assertEquals("4", table.ID());
				assertEquals(1000, table.get_maxdiners());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readFreeTC7() {
		r.set_diners(20);
		list = table.get_tableDAO().readFree(r);

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("waiting for the bill")
					&& table.ID().equals("0")
					&& table.get_maxdiners() == -3) {
				assertEquals("waiting for the bill",
						table.state());
				assertEquals("0", table.ID());
				assertEquals(-3, table.get_maxdiners());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readFreeTC8() {
		list = table.get_tableDAO().readFree(r);

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("paying")
					&& table.ID().equals("5000")
					&& table.get_maxdiners() == 5) {
				assertEquals("paying", table.state());
				assertEquals("5000", table.ID());
				assertEquals(5, table.get_maxdiners());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readFreeTC9() {
		r.set_diners(25);
		list = table.get_tableDAO().readFree(r);

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("in preparation")
					&& table.ID().equals("-2")
					&& table.get_maxdiners() == 7) {
				assertEquals("in preparation",
						table.state());
				assertEquals("-2", table.ID());
				assertEquals(7, table.get_maxdiners());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readFreeTC10() {
		r.set_diners(30);
		list = table.get_tableDAO().readFree(r);

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state() == null
					&& table.ID().equals("4")
					&& table.get_maxdiners() == 0) {
				assertEquals(null, table.state());
				assertEquals("4", table.ID());
				assertEquals(0, table.get_maxdiners());
				return;
			}
		}
		fail("Test failed");

	}

}
