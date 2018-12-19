package org.table.booking.domain;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Reservation;
import org.table.booking.persistence.DBBroker;

public class ReservationDAODeleteTest {

	private Reservation r;
	private ResultSet resultado;

	@Before
	public void before() {
		r = new Reservation();
		resultado = null;
	}

	@Test // (timeout = 1000) @Skip
	public void deleteReservationTC1() {
		r.set_reservationID(-5);
		r._reservationDAO.delete(r);

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

		assertEquals(-5, r.get_reservationID());
	}

	@Test // (timeout = 1000) @Skip
	public void deleteReservationTC2() {
		r.set_reservationID(7);
		r._reservationDAO.delete(r);

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

		assertEquals(7, r.get_reservationID());
	}

	@Test // (timeout = 1000) @Skip
	public void deleteReservationTC3() {
		r.set_reservationID(0);
		r._reservationDAO.delete(r);

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

		assertEquals(0, r.get_reservationID());
	}

	@Test // (timeout = 1000) @Skip
	public void deleteReservationTC4() {
		r.set_reservationID(1000000);
		r._reservationDAO.delete(r);

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

		assertEquals(1000000, r.get_reservationID());
	}

}
