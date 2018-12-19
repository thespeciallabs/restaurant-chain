package org.table.booking.domain;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Reservation;
import org.table.booking.persistence.DBBroker;

public class ReservationDAOInsertTest {

	private Reservation r;

	@Before
	public void before() {
		r = new Reservation();
	}

	@Test // (timeout = 1000) @Skip
	public void insertReservationTC1() {
		r.set_reservationID(-3);
		r.set_reservation_hour("-2:00");
		r.set_diners(-3);
		r.set_turn(-4);
		r.get_reservationDAO().insert(r);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read(
					"SELECT * FROM reservation WHERE reservationID='"
							+ r.get_reservationID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		try {
			resultado.next();
			r.set_reservationID(
					resultado.getInt("reservationID"));
			r.set_reservation_hour(resultado
					.getString("reservation_hour"));
			r.set_diners(resultado.getInt("diners"));
			r.set_turn(resultado.getInt("turn"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(-3, r.get_reservationID());
		assertEquals("-2:00", r.get_reservation_hour());
		assertEquals(-3, r.get_diners());
		assertEquals(-4, r.get_turn());
	}

	@Test // (timeout = 1000) @Skip
	public void insertReservationTC2() {
		r.set_reservationID(2);
		r.set_reservation_hour("11:00");
		r.set_diners(4);
		r.set_turn(1);
		r.get_reservationDAO().insert(r);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read(
					"SELECT * FROM reservation WHERE reservationID='"
							+ r.get_reservationID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		try {
			resultado.next();
			r.set_reservationID(
					resultado.getInt("reservationID"));
			r.set_reservation_hour(resultado
					.getString("reservation_hour"));
			r.set_diners(resultado.getInt("diners"));
			r.set_turn(resultado.getInt("turn"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(2, r.get_reservationID());
		assertEquals("11:00", r.get_reservation_hour());
		assertEquals(4, r.get_diners());
		assertEquals(1, r.get_turn());
	}

	@Test // (timeout = 1000) @Skip
	public void deleteReservationTC3() {
		r.set_reservationID(0);
		r.set_reservation_hour("13:30");
		r.set_diners(7);
		r.set_turn(4);
		r.get_reservationDAO().insert(r);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read(
					"SELECT * FROM reservation WHERE reservationID='"
							+ r.get_reservationID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		try {
			resultado.next();
			r.set_reservationID(
					resultado.getInt("reservationID"));
			r.set_reservation_hour(resultado
					.getString("reservation_hour"));
			r.set_diners(resultado.getInt("diners"));
			r.set_turn(resultado.getInt("turn"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(0, r.get_reservationID());
		assertEquals("13:30", r.get_reservation_hour());
		assertEquals(7, r.get_diners());
		assertEquals(4, r.get_turn());
	}

	@Test // (timeout = 1000) @Skip
	public void deleteReservationTC4() {
		r.set_reservationID(-3);
		r.set_reservation_hour("16:45");
		r.set_diners(0);
		r.set_turn(0);
		r.get_reservationDAO().insert(r);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read(
					"SELECT * FROM reservation WHERE reservationID='"
							+ r.get_reservationID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		try {
			resultado.next();
			r.set_reservationID(
					resultado.getInt("reservationID"));
			r.set_reservation_hour(resultado
					.getString("reservation_hour"));
			r.set_diners(resultado.getInt("diners"));
			r.set_turn(resultado.getInt("turn"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(-3, r.get_reservationID());
		assertEquals("16:45", r.get_reservation_hour());
		assertEquals(0, r.get_diners());
		assertEquals(0, r.get_turn());
	}

	@Test // (timeout = 1000) @Skip
	public void insertReservationTC5() {
		r.set_reservationID(2);
		r.set_reservation_hour("22:15");
		r.set_diners(6);
		r.set_turn(3);
		r.get_reservationDAO().insert(r);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read(
					"SELECT * FROM reservation WHERE reservationID='"
							+ r.get_reservationID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		try {
			resultado.next();
			r.set_reservationID(
					resultado.getInt("reservationID"));
			r.set_reservation_hour(resultado
					.getString("reservation_hour"));
			r.set_diners(resultado.getInt("diners"));
			r.set_turn(resultado.getInt("turn"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(2, r.get_reservationID());
		assertEquals("22:15", r.get_reservation_hour());
		assertEquals(6, r.get_diners());
		assertEquals(3, r.get_turn());
	}

	@Test // (timeout = 1000) @Skip
	public void insertReservationTC6() {
		r.set_reservationID(0);
		r.set_reservation_hour("25:30");
		r.set_diners(2000);
		r.set_turn(2000);
		r.get_reservationDAO().insert(r);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read(
					"SELECT * FROM reservation WHERE reservationID='"
							+ r.get_reservationID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		try {
			resultado.next();
			r.set_reservationID(
					resultado.getInt("reservationID"));
			r.set_reservation_hour(resultado
					.getString("reservation_hour"));
			r.set_diners(resultado.getInt("diners"));
			r.set_turn(resultado.getInt("turn"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(0, r.get_reservationID());
		assertEquals("25:30", r.get_reservation_hour());
		assertEquals(2000, r.get_diners());
		assertEquals(2000, r.get_turn());
	}

	@Test // (timeout = 1000) @Skip
	public void insertReservationTC7() {
		r.set_reservationID(-3);
		r.set_reservation_hour("09:00");
		r.set_diners(-3);
		r.set_turn(-4);
		r.get_reservationDAO().insert(r);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read(
					"SELECT * FROM reservation WHERE reservationID='"
							+ r.get_reservationID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		try {
			resultado.next();
			r.set_reservationID(
					resultado.getInt("reservationID"));
			r.set_reservation_hour(resultado
					.getString("reservation_hour"));
			r.set_diners(resultado.getInt("diners"));
			r.set_turn(resultado.getInt("turn"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(-3, r.get_reservationID());
		assertEquals("09:00", r.get_reservation_hour());
		assertEquals(-3, r.get_diners());
		assertEquals(-4, r.get_turn());
	}

	@Test // (timeout = 1000) @Skip
	public void insertReservationTC8() {
		r.set_reservationID(2);
		r.set_reservation_hour("12:30");
		r.set_diners(4);
		r.set_turn(1);
		r.get_reservationDAO().insert(r);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read(
					"SELECT * FROM reservation WHERE reservationID='"
							+ r.get_reservationID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		try {
			resultado.next();
			r.set_reservationID(
					resultado.getInt("reservationID"));
			r.set_reservation_hour(resultado
					.getString("reservation_hour"));
			r.set_diners(resultado.getInt("diners"));
			r.set_turn(resultado.getInt("turn"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(2, r.get_reservationID());
		assertEquals("12:30", r.get_reservation_hour());
		assertEquals(4, r.get_diners());
		assertEquals(1, r.get_turn());
	}

	@Test // (timeout = 1000) @Skip
	public void insertReservationTC9() {
		r.set_reservationID(0);
		r.set_reservation_hour("15:00");
		r.set_diners(7);
		r.set_turn(4);
		r.get_reservationDAO().insert(r);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read(
					"SELECT * FROM reservation WHERE reservationID='"
							+ r.get_reservationID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		try {
			resultado.next();
			r.set_reservationID(
					resultado.getInt("reservationID"));
			r.set_reservation_hour(resultado
					.getString("reservation_hour"));
			r.set_diners(resultado.getInt("diners"));
			r.set_turn(resultado.getInt("turn"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(0, r.get_reservationID());
		assertEquals("15:00", r.get_reservation_hour());
		assertEquals(7, r.get_diners());
		assertEquals(4, r.get_turn());
	}

	@Test // (timeout = 1000) @Skip
	public void insertReservationTC10() {
		r.set_reservationID(-3);
		r.set_reservation_hour("20:45");
		r.set_diners(0);
		r.set_turn(0);
		r.get_reservationDAO().insert(r);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read(
					"SELECT * FROM reservation WHERE reservationID='"
							+ r.get_reservationID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		try {
			resultado.next();
			r.set_reservationID(
					resultado.getInt("reservationID"));
			r.set_reservation_hour(resultado
					.getString("reservation_hour"));
			r.set_diners(resultado.getInt("diners"));
			r.set_turn(resultado.getInt("turn"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(-3, r.get_reservationID());
		assertEquals("20:45", r.get_reservation_hour());
		assertEquals(0, r.get_diners());
		assertEquals(0, r.get_turn());
	}

	@Test // (timeout = 1000) @Skip
	public void insertReservationTC11() {
		r.set_reservationID(2);
		r.set_reservation_hour("23:00");
		r.set_diners(6);
		r.set_turn(3);
		r.get_reservationDAO().insert(r);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read(
					"SELECT * FROM reservation WHERE reservationID='"
							+ r.get_reservationID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		try {
			resultado.next();
			r.set_reservationID(
					resultado.getInt("reservationID"));
			r.set_reservation_hour(resultado
					.getString("reservation_hour"));
			r.set_diners(resultado.getInt("diners"));
			r.set_turn(resultado.getInt("turn"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(2, r.get_reservationID());
		assertEquals("23:00", r.get_reservation_hour());
		assertEquals(6, r.get_diners());
		assertEquals(3, r.get_turn());
	}

	@Test // (timeout = 1000) @Skip
	public void insertReservationTC12() {
		r.set_reservationID(0);
		r.set_reservation_hour("700:30");
		r.set_diners(2000);
		r.set_turn(2000);
		r.get_reservationDAO().insert(r);

		ResultSet resultado = null;
		try {
			resultado = DBBroker.getAgente().read(
					"SELECT * FROM reservation WHERE reservationID='"
							+ r.get_reservationID() + "';");
		} catch (Exception e) {
			fail("Test failed.");
		}

		try {
			resultado.next();
			r.set_reservationID(
					resultado.getInt("reservationID"));
			r.set_reservation_hour(resultado
					.getString("reservation_hour"));
			r.set_diners(resultado.getInt("diners"));
			r.set_turn(resultado.getInt("turn"));
		} catch (SQLException e) {
			fail("Test failed.");
		}

		assertEquals(0, r.get_reservationID());
		assertEquals("700:30", r.get_reservation_hour());
		assertEquals(2000, r.get_diners());
		assertEquals(2000, r.get_turn());
	}

}
