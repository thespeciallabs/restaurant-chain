package org.table.booking;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Reservation;
import org.table.booking.domain.Table;
import org.table.booking.domain.TableManager;
import org.table.booking.persistence.DBBroker;

public class AssignTablesTest {

	private Table t;

	@Test // (timeout = 1000) @Skip
	public void assignTableTC1() throws SQLException, Exception {
		Table expected = new Table();
		Reservation r_expected = new Reservation();
		r_expected.set_reservationID(5);
		expected.setState("busy");
		t = TableManager.assing_table(r_expected.get_reservationID());
		assertEquals(expected.state(), t.state());
		ResultSet rs = DBBroker.getAgente()
				.read("SELECT * FROM reservation WHERE reservationID=" + r_expected.get_reservationID() + ";");
		assertEquals(rs.getRow(), 0);
	}
}