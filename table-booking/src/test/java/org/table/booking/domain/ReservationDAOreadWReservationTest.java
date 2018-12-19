package org.table.booking.domain;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Reservation;
import org.table.booking.persistence.DBBroker;

public class ReservationDAOreadWReservationTest {

	private Reservation r;
	private ResultSet resultado;
	private int res;

	@Before
	public void before() {
		r = new Reservation();
		resultado = null;
		res = -2;
	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC1() throws SQLException {
		r.set_reservationID(-5);

		res = r._reservationDAO.read(r);

		try {
			resultado = DBBroker.getAgente()
					.read("SELECT * FROM reservation WHERE reservationID='" + r.get_reservationID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		try {
			resultado.next();
			r.set_reservationID(resultado.getInt("reservationID"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(-1, res);
	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC2() throws SQLException {
		r.set_reservationID(7);

		res = r._reservationDAO.read(r);

		try {
			resultado = DBBroker.getAgente()
					.read("SELECT * FROM reservation WHERE reservationID='" + r.get_reservationID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		try {
			resultado.next();
			r.set_reservationID(resultado.getInt("reservationID"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(0, res);
	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC3() throws SQLException {
		r.set_reservationID(0);

		res = r._reservationDAO.read(r);

		try {
			resultado = DBBroker.getAgente()
					.read("SELECT * FROM reservation WHERE reservationID='" + r.get_reservationID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		try {
			resultado.next();
			r.set_reservationID(resultado.getInt("reservationID"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(-1, res);
	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC4() throws SQLException {
		r.set_reservationID(1000000);

		res = r._reservationDAO.read(r);

		try {
			resultado = DBBroker.getAgente()
					.read("SELECT * FROM reservation WHERE reservationID='" + r.get_reservationID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		try {
			resultado.next();
			r.set_reservationID(resultado.getInt("reservationID"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(0, res);
	}

}
