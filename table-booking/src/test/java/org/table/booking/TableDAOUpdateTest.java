package org.table.booking;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Table;
import org.table.booking.persistence.DBBroker;

public class TableDAOUpdateTest {

	private Table table;

	@Before
	public void before() {
		table = new Table();
	}

	@Test // (timeout = 1000) @Skip
	public void updateTC1() {
		table.setState("free");
		table.setID("-2");
		table._tableDAO.update(table);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}
		try {
			resultado.next();
			table.set_maxdiners(resultado.getInt("sites"));
			table.setState(resultado.getString("state"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals("free", table.state());
		assertEquals("-2", table.ID());

	}

	@Test // (timeout = 1000) @Skip
	public void updateTC2() {
		table.setState("reserved");
		table.setID("4");
		table._tableDAO.update(table);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}
		try {
			resultado.next();
			table.set_maxdiners(resultado.getInt("sites"));
			table.setState(resultado.getString("state"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals("reserved", table.state());
		assertEquals("4", table.ID());

	}

	@Test // (timeout = 1000) @Skip
	public void updateTC3() {
		table.setState("busy");
		table.setID("0");
		table._tableDAO.update(table);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}
		try {
			resultado.next();
			table.set_maxdiners(resultado.getInt("sites"));
			table.setState(resultado.getString("state"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals("busy", table.state());
		assertEquals("0", table.ID());

	}

	@Test // (timeout = 1000) @Skip
	public void updateTC4() {
		table.setState("asking");
		table.setID("5000");
		table._tableDAO.update(table);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}
		try {
			resultado.next();
			table.set_maxdiners(resultado.getInt("sites"));
			table.setState(resultado.getString("state"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals("asking", table.state());
		assertEquals("5000", table.ID());

	}

	@Test // (timeout = 1000) @Skip
	public void updateTC5() {
		table.setState("waiting for food");
		table.setID("-2");
		table._tableDAO.update(table);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}
		try {
			resultado.next();
			table.set_maxdiners(resultado.getInt("sites"));
			table.setState(resultado.getString("state"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals("waiting for food", table.state());
		assertEquals("-2", table.ID());

	}

	@Test // (timeout = 1000) @Skip
	public void updateTC6() {
		table.setState("served");
		table.setID("4");
		table._tableDAO.update(table);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}
		try {
			resultado.next();
			table.set_maxdiners(resultado.getInt("sites"));
			table.setState(resultado.getString("state"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals("served", table.state());
		assertEquals("4", table.ID());

	}

	@Test // (timeout = 1000) @Skip
	public void updateTC7() {
		table.setState("waiting for the bill");
		table.setID("0");
		table._tableDAO.update(table);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}
		try {
			resultado.next();
			table.set_maxdiners(resultado.getInt("sites"));
			table.setState(resultado.getString("state"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals("waiting for the bill", table.state());
		assertEquals("0", table.ID());

	}

	@Test // (timeout = 1000) @Skip
	public void updateTC8() {
		table.setState("paying");
		table.setID("5000");
		table._tableDAO.update(table);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}
		try {
			resultado.next();
			table.set_maxdiners(resultado.getInt("sites"));
			table.setState(resultado.getString("state"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals("paying", table.state());
		assertEquals("5000", table.ID());

	}

	@Test // (timeout = 1000) @Skip
	public void updateTC9() {
		table.setState("in preparation");
		table.setID("-2");
		table._tableDAO.update(table);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}
		try {
			resultado.next();
			table.set_maxdiners(resultado.getInt("sites"));
			table.setState(resultado.getString("state"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals("in preparation", table.state());
		assertEquals("-2", table.ID());

	}

	@Test // (timeout = 1000) @Skip
	public void updateTC10() {
		table.setState(null);
		table.setID("4");
		table._tableDAO.update(table);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read("SELECT * FROM restaurantTables WHERE tableID='" + table.ID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}
		try {
			resultado.next();
			table.set_maxdiners(resultado.getInt("sites"));
			table.setState(resultado.getString("state"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(null, table.state());
		assertEquals("4", table.ID());

	}

}
