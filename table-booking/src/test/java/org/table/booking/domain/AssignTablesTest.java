package org.table.booking.domain;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Reservation;
import org.table.booking.domain.Table;
import org.table.booking.domain.TableManager;

public class AssignTablesTest {

	private Table t;
	private Reservation r;

	@Before
	public void before() {
		t = new Table();
		r = new Reservation();
	}

	@Test // (timeout = 1000) @Skip
	public void assignTableTC1()
			throws SQLException, Exception {
		Reservation r_expected = new Reservation();
		r_expected.set_reservationID(-5);
		t = TableManager.assing_table(
				r_expected.get_reservationID());

		assertNull(r); // r.reservationDAO.read(r) == null
		assertEquals(-4, r_expected.get_tableID()); // r.get_tableID() == -4
		assertEquals("-2:00",
				r_expected.get_reservation_hour()); // r.get_reservation_hour()
	}

	@Test // (timeout = 1000) @Skip
	public void assignTableTC2()
			throws SQLException, Exception {
		Reservation r_expected = new Reservation();
		r_expected.set_reservationID(3);
		t = TableManager.assing_table(
				r_expected.get_reservationID());

		assertNotNull(r); // r.reservationDAO.read(r) == null
		assertEquals(2, r_expected.get_tableID()); // r.get_tableID() == -4
		assertEquals("11:00",
				r_expected.get_reservation_hour()); // r.get_reservation_hour()
	}

	@Test // (timeout = 1000) @Skip
	public void assignTableTC3()
			throws SQLException, Exception {
		Reservation r_expected = new Reservation();
		r_expected.set_reservationID(0);
		t = TableManager.assing_table(
				r_expected.get_reservationID());

		assertNull(r); // r.reservationDAO.read(r) == null
		assertEquals(0, r_expected.get_tableID()); // r.get_tableID() == -4
		assertEquals("13:30",
				r_expected.get_reservation_hour()); // r.get_reservation_hour()
	}

	@Test // (timeout = 1000) @Skip
	public void assignTableTC4()
			throws SQLException, Exception {
		Reservation r_expected = new Reservation();
		r_expected.set_reservationID(5);
		t = TableManager.assing_table(
				r_expected.get_reservationID());

		assertNotNull(r); // r.reservationDAO.read(r) == null
		assertEquals(-4, r_expected.get_tableID()); // r.get_tableID() == -4
		assertEquals("16:45",
				r_expected.get_reservation_hour()); // r.get_reservation_hour()
	}

	@Test // (timeout = 1000) @Skip
	public void assignTableTC5()
			throws SQLException, Exception {
		Reservation r_expected = new Reservation();
		r_expected.set_reservationID(3);
		t = TableManager.assing_table(
				r_expected.get_reservationID());

		assertNull(r); // r.reservationDAO.read(r) == null
		assertEquals(2, r_expected.get_tableID()); // r.get_tableID() == -4
		assertEquals("22:15",
				r_expected.get_reservation_hour()); // r.get_reservation_hour()
	}

	@Test // (timeout = 1000) @Skip
	public void assignTableTC6()
			throws SQLException, Exception {
		Reservation r_expected = new Reservation();
		r_expected.set_reservationID(0);
		t = TableManager.assing_table(
				r_expected.get_reservationID());

		assertNotNull(r); // r.reservationDAO.read(r) == null
		assertEquals(0, r_expected.get_tableID()); // r.get_tableID() == -4
		assertEquals("25:30",
				r_expected.get_reservation_hour()); // r.get_reservation_hour()
	}

	@Test // (timeout = 1000) @Skip
	public void assignTableTC7()
			throws SQLException, Exception {
		Reservation r_expected = new Reservation();
		r_expected.set_reservationID(-5);
		t = TableManager.assing_table(
				r_expected.get_reservationID());

		assertNull(r); // r.reservationDAO.read(r) == null
		assertEquals(-4, r_expected.get_tableID()); // r.get_tableID() == -4
		assertEquals("09:00",
				r_expected.get_reservation_hour()); // r.get_reservation_hour()
	}

	@Test // (timeout = 1000) @Skip
	public void assignTableTC8()
			throws SQLException, Exception {
		Reservation r_expected = new Reservation();
		r_expected.set_reservationID(3);
		t = TableManager.assing_table(
				r_expected.get_reservationID());

		assertNotNull(r); // r.reservationDAO.read(r) == null
		assertEquals(2, r_expected.get_tableID()); // r.get_tableID() == -4
		assertEquals("12:30",
				r_expected.get_reservation_hour()); // r.get_reservation_hour()
	}

	@Test // (timeout = 1000) @Skip
	public void assignTableTC9()
			throws SQLException, Exception {
		Reservation r_expected = new Reservation();
		r_expected.set_reservationID(0);
		t = TableManager.assing_table(
				r_expected.get_reservationID());

		assertNull(r); // r.reservationDAO.read(r) == null
		assertEquals(0, r_expected.get_tableID()); // r.get_tableID() == -4
		assertEquals("15:00",
				r_expected.get_reservation_hour()); // r.get_reservation_hour()
	}

	@Test // (timeout = 1000) @Skip
	public void assignTableTC10()
			throws SQLException, Exception {
		Reservation r_expected = new Reservation();
		r_expected.set_reservationID(-5);
		t = TableManager.assing_table(
				r_expected.get_reservationID());

		assertNotNull(r); // r.reservationDAO.read(r) == null
		assertEquals(-4, r_expected.get_tableID()); // r.get_tableID() == -4
		assertEquals("20:45",
				r_expected.get_reservation_hour()); // r.get_reservation_hour()
	}

	@Test // (timeout = 1000) @Skip
	public void assignTableTC11()
			throws SQLException, Exception {
		Reservation r_expected = new Reservation();
		r_expected.set_reservationID(3);
		t = TableManager.assing_table(
				r_expected.get_reservationID());

		assertNull(r); // r.reservationDAO.read(r) == null
		assertEquals(2, r_expected.get_tableID()); // r.get_tableID() == -4
		assertEquals("23:00",
				r_expected.get_reservation_hour()); // r.get_reservation_hour()
	}

	@Test // (timeout = 1000) @Skip
	public void assignTableTC12()
			throws SQLException, Exception {
		Reservation r_expected = new Reservation();
		r_expected.set_reservationID(0);
		t = TableManager.assing_table(
				r_expected.get_reservationID());

		assertNotNull(r); // r.reservationDAO.read(r) == null
		assertEquals(0, r_expected.get_tableID()); // r.get_tableID() == -4
		assertEquals("700:30",
				r_expected.get_reservation_hour()); // r.get_reservation_hour()
	}
}
