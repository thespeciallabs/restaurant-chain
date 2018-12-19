package org.table.booking.domain;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Table;

public class TableDAOReadTest {

	private Table table;
	private LinkedList<Table> list;

	@Before
	public void before() {
		table = new Table();
		list = new LinkedList<>();
	}

	@Test // (timeout = 1000) @Skip
	public void readTC1() {
		list = table.get_tableDAO().read();

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("free")
					&& table.ID().equals("-2")) {
				assertEquals("free", table.state());
				assertEquals("-2", table.ID());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readTC2() {
		list = table.get_tableDAO().read();

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("reserved")
					&& table.ID().equals("4")) {
				assertEquals("reserved", table.state());
				assertEquals("4", table.ID());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readTC3() {
		list = table.get_tableDAO().read();

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("busy")
					&& table.ID().equals("0")) {
				assertEquals("busy", table.state());
				assertEquals("0", table.ID());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readTC4() {
		list = table.get_tableDAO().read();

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("asking")
					&& table.ID().equals("5000")) {
				assertEquals("asking", table.state());
				assertEquals("5000", table.ID());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readTC5() {
		list = table.get_tableDAO().read();

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("waiting for food")
					&& table.ID().equals("-2")) {
				assertEquals("waiting for food",
						table.state());
				assertEquals("-2", table.ID());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readTC6() {
		list = table.get_tableDAO().read();

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("served")
					&& table.ID().equals("4")) {
				assertEquals("served", table.state());
				assertEquals("4", table.ID());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readTC7() {
		list = table.get_tableDAO().read();

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("waiting for the bill")
					&& table.ID().equals("0")) {
				assertEquals("waiting for the bill",
						table.state());
				assertEquals("0", table.ID());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readTC8() {
		list = table.get_tableDAO().read();

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("paying")
					&& table.ID().equals("5000")) {
				assertEquals("paying", table.state());
				assertEquals("5000", table.ID());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readTC9() {
		list = table.get_tableDAO().read();

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state().equals("in preparation")
					&& table.ID().equals("-2")) {
				assertEquals("in preparation",
						table.state());
				assertEquals("-2", table.ID());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readTC10() {
		list = table.get_tableDAO().read();

		while (!list.isEmpty()) {
			table = list.remove();
			if (table.state() == null
					&& table.ID().equals("-2")) {
				assertEquals(null, table.state());
				assertEquals("4", table.ID());
				return;
			}
		}
		fail("Test failed");

	}

}
