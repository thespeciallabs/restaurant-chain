package org.table.booking.domain;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Reservation;
import org.table.booking.domain.Table;

public class ReservationDAOreadTableTest {

	private Reservation r;
	private String tableID;
	private Reservation aux;

	@Before
	public void before() {
		aux = new Reservation();
		r = new Reservation();
		tableID = "";
	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC1() {
		tableID = "-3";
		r._reservationDAO.readTable(tableID);

		while (!r._reservationDAO.get_reservationList().isEmpty()) {
			aux = r._reservationDAO.get_reservationList().remove();

			if (aux.get_reservationID() == -20 && aux.get_reservation_hour().equals("-2:00") && aux.get_diners() == -30
					&& aux.get_turn() == -40) {
				assertEquals(-20, aux.get_reservationID());
				assertEquals("-2:00", aux.get_reservation_hour());
				assertEquals(-30, aux.get_diners());
				assertEquals(-40, aux.get_turn());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC2() {
		tableID = "2";
		r._reservationDAO.readTable(tableID);

		while (!r._reservationDAO.get_reservationList().isEmpty()) {
			aux = r._reservationDAO.get_reservationList().remove();

			if (aux.get_reservationID() == 20 && aux.get_reservation_hour().equals("11:00") && aux.get_diners() == 3
					&& aux.get_turn() == 2) {
				assertEquals(20, aux.get_reservationID());
				assertEquals("11:00", aux.get_reservation_hour());
				assertEquals(3, aux.get_diners());
				assertEquals(2, aux.get_turn());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC3() {
		tableID = "0";
		r._reservationDAO.readTable(tableID);

		while (!r._reservationDAO.get_reservationList().isEmpty()) {
			aux = r._reservationDAO.get_reservationList().remove();

			if (aux.get_reservationID() == 0 && aux.get_reservation_hour().equals("13:30") && aux.get_diners() == 30
					&& aux.get_turn() == 40) {
				assertEquals(0, aux.get_reservationID());
				assertEquals("13:30", aux.get_reservation_hour());
				assertEquals(30, aux.get_diners());
				assertEquals(40, aux.get_turn());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC4() {
		tableID = "-3";
		r._reservationDAO.readTable(tableID);

		while (!r._reservationDAO.get_reservationList().isEmpty()) {
			aux = r._reservationDAO.get_reservationList().remove();

			if (aux.get_reservationID() == 1000000 && aux.get_reservation_hour().equals("16:45")
					&& aux.get_diners() == 0 && aux.get_turn() == 0) {
				assertEquals(1000000, aux.get_reservationID());
				assertEquals("16:45", aux.get_reservation_hour());
				assertEquals(0, aux.get_diners());
				assertEquals(0, aux.get_turn());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC5() {
		tableID = "2";
		r._reservationDAO.readTable(tableID);

		while (!r._reservationDAO.get_reservationList().isEmpty()) {
			aux = r._reservationDAO.get_reservationList().remove();

			if (aux.get_reservationID() == -20 && aux.get_reservation_hour().equals("22:15") && aux.get_diners() == -6
					&& aux.get_turn() == 3) {
				assertEquals(-20, aux.get_reservationID());
				assertEquals("22:15", aux.get_reservation_hour());
				assertEquals(6, aux.get_diners());
				assertEquals(3, aux.get_turn());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC6() {
		tableID = "0";
		r._reservationDAO.readTable(tableID);

		while (!r._reservationDAO.get_reservationList().isEmpty()) {
			aux = r._reservationDAO.get_reservationList().remove();

			if (aux.get_reservationID() == 20 && aux.get_reservation_hour().equals("22:45")
					&& aux.get_diners() == 1000000 && aux.get_turn() == 1000000) {
				assertEquals(20, aux.get_reservationID());
				assertEquals("25:30", aux.get_reservation_hour());
				assertEquals(1000000, aux.get_diners());
				assertEquals(1000000, aux.get_turn());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC7() {
		tableID = "-3";
		r._reservationDAO.readTable(tableID);

		while (!r._reservationDAO.get_reservationList().isEmpty()) {
			aux = r._reservationDAO.get_reservationList().remove();

			if (aux.get_reservationID() == 0 && aux.get_reservation_hour().equals("09:00") && aux.get_diners() == -30
					&& aux.get_turn() == -40) {
				assertEquals(0, aux.get_reservationID());
				assertEquals("09:00", aux.get_reservation_hour());
				assertEquals(-30, aux.get_diners());
				assertEquals(-40, aux.get_turn());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC8() {
		tableID = "2";
		r._reservationDAO.readTable(tableID);

		while (!r._reservationDAO.get_reservationList().isEmpty()) {
			aux = r._reservationDAO.get_reservationList().remove();

			if (aux.get_reservationID() == 1000000 && aux.get_reservation_hour().equals("12:30")
					&& aux.get_diners() == -30 && aux.get_turn() == -40) {
				assertEquals(1000000, aux.get_reservationID());
				assertEquals("12:30", aux.get_reservation_hour());
				assertEquals(3, aux.get_diners());
				assertEquals(2, aux.get_turn());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC9() {
		tableID = "0";
		r._reservationDAO.readTable(tableID);

		while (!r._reservationDAO.get_reservationList().isEmpty()) {
			aux = r._reservationDAO.get_reservationList().remove();

			if (aux.get_reservationID() == -20 && aux.get_reservation_hour().equals("15:00") && aux.get_diners() == -30
					&& aux.get_turn() == -40) {
				assertEquals(-20, aux.get_reservationID());
				assertEquals("15:00", aux.get_reservation_hour());
				assertEquals(30, aux.get_diners());
				assertEquals(40, aux.get_turn());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC10() {
		tableID = "-3";
		r._reservationDAO.readTable(tableID);

		while (!r._reservationDAO.get_reservationList().isEmpty()) {
			aux = r._reservationDAO.get_reservationList().remove();

			if (aux.get_reservationID() == 20 && aux.get_reservation_hour().equals("20:45") && aux.get_diners() == -30
					&& aux.get_turn() == -40) {
				assertEquals(20, aux.get_reservationID());
				assertEquals("20:45", aux.get_reservation_hour());
				assertEquals(0, aux.get_diners());
				assertEquals(0, aux.get_turn());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC11() {
		tableID = "2";
		r._reservationDAO.readTable(tableID);

		while (!r._reservationDAO.get_reservationList().isEmpty()) {
			aux = r._reservationDAO.get_reservationList().remove();

			if (aux.get_reservationID() == 0 && aux.get_reservation_hour().equals("23:00") && aux.get_diners() == -30
					&& aux.get_turn() == -40) {
				assertEquals(0, aux.get_reservationID());
				assertEquals("23:00", aux.get_reservation_hour());
				assertEquals(6, aux.get_diners());
				assertEquals(3, aux.get_turn());
				return;
			}
		}
		fail("Test failed");

	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC12() {
		tableID = "0";
		r._reservationDAO.readTable(tableID);

		while (!r._reservationDAO.get_reservationList().isEmpty()) {
			aux = r._reservationDAO.get_reservationList().remove();

			if (aux.get_reservationID() == 1000000 && aux.get_reservation_hour().equals("700:30")
					&& aux.get_diners() == -30 && aux.get_turn() == -40) {
				assertEquals(1000000, aux.get_reservationID());
				assertEquals("700:30", aux.get_reservation_hour());
				assertEquals(1000000, aux.get_diners());
				assertEquals(1000000, aux.get_turn());
				return;
			}
		}
		fail("Test failed");

	}

}
