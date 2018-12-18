package org.table.booking;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Reservation;
import org.table.booking.domain.Table;
import org.table.booking.persistence.DBBroker;

public class TableDAOReadWTableTest {

	private Table table;
	private LinkedList<Table> list;
	private Reservation r;
	private ResultSet resultado;

	@Before
	public void before() {
		table = new Table();
		r = new Reservation();
		resultado = null;
	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC1() {
		table.setID("-10");
		table._tableDAO.read(table);

		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		assertEquals("free", table.state());
		assertEquals(-3, table.get_maxdiners());

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC2() {
		table.setID("10");
		table._tableDAO.read(table);

		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		assertEquals("reserved", table.state());
		assertEquals(5, table.get_maxdiners());

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC3() {
		table.setID("0");
		table._tableDAO.read(table);

		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		assertEquals("busy", table.state());
		assertEquals(7, table.get_maxdiners());

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC4() {
		table.setID("1000000");
		table._tableDAO.read(table);

		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		assertEquals("asking", table.state());
		assertEquals(0, table.get_maxdiners());

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC5() {
		table.setID("-10");
		table._tableDAO.read(table);

		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		assertEquals("waiting for food", table.state());
		assertEquals(6, table.get_maxdiners());

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC6() {
		table.setID("10");
		table._tableDAO.read(table);

		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		assertEquals("Served", table.state());
		assertEquals(1000, table.get_maxdiners());

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC7() {
		table.setID("0");
		table._tableDAO.read(table);

		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		assertEquals("Waiting fot the bill", table.state());
		assertEquals(-3, table.get_maxdiners());

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC8() {
		table.setID("1000000");
		table._tableDAO.read(table);

		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		assertEquals("Paying", table.state());
		assertEquals(5, table.get_maxdiners());

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC9() {
		table.setID("-10");
		table._tableDAO.read(table);

		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		assertEquals("In preparation", table.state());
		assertEquals(7, table.get_maxdiners());

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC10() {
		table.setID("10");
		table._tableDAO.read(table);

		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		assertEquals("", table.state());
		assertEquals(0, table.get_maxdiners());

	}

}
