package org.table.booking;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Reservation;

public class ReservationDAOreadTest {

	private Reservation r;
	private Reservation aux;
	LinkedList<Reservation> list;

	@Before
	public void before() {
		aux = new Reservation();
		r = new Reservation();
		list = new LinkedList<>();
	}

	@Test // (timeout = 1000) @Skip
	public void readTC1() {
		list = r._reservationDAO.read();

		if (list != null) {
			while (!list.isEmpty()) {
				aux = list.remove();

				if (aux.get_reservationID() == -20 && aux.get_reservation_hour().equals("-2:00")
						&& aux.get_diners() == -30 && aux.get_turn() == -40 && aux.get_tableID().equals("-10")) {
					assertEquals(-20, aux.get_reservationID());
					assertEquals("-2:00", aux.get_reservation_hour());
					assertEquals(-30, aux.get_diners());
					assertEquals(-40, aux.get_turn());
					assertEquals(-10, aux.get_tableID());
					return;
				}
			}
			fail("Test failed");
		} else {
			fail("Test failed");
		}

	}

	@Test // (timeout = 1000) @Skip
	public void readTC2() {
		list = r._reservationDAO.read();
		if (list != null) {
			while (!list.isEmpty()) {
				aux = list.remove();

				if (aux.get_reservationID() == -20 && aux.get_reservation_hour().equals("-2:00")
						&& aux.get_diners() == -30 && aux.get_turn() == -40 && aux.get_tableID().equals("10")) {
					assertEquals(-20, aux.get_reservationID());
					assertEquals("-2:00", aux.get_reservation_hour());
					assertEquals(-30, aux.get_diners());
					assertEquals(-40, aux.get_turn());
					assertEquals(10, aux.get_tableID());
					return;
				}
			}
			fail("Test failed");
		} else {
			fail("Test failed");
		}

	}

	@Test // (timeout = 1000) @Skip
	public void readTC3() {
		list = r._reservationDAO.read();
		if (list != null) {
			while (!list.isEmpty()) {
				aux = list.remove();

				if (aux.get_reservationID() == 20 && aux.get_reservation_hour().equals("11:00") && aux.get_diners() == 3
						&& aux.get_turn() == 2 && aux.get_tableID().equals("0")) {
					assertEquals(20, aux.get_reservationID());
					assertEquals("11:00", aux.get_reservation_hour());
					assertEquals(3, aux.get_diners());
					assertEquals(2, aux.get_turn());
					assertEquals(0, aux.get_tableID());
					return;
				}
			}
			fail("Test failed");
		} else {
			fail("Test failed");
		}

	}

	@Test // (timeout = 1000) @Skip
	public void readTC4() {
		list = r._reservationDAO.read();
		if (list != null) {
			while (!list.isEmpty()) {
				aux = list.remove();

				if (aux.get_reservationID() == 0 && aux.get_reservation_hour().equals("13:30") && aux.get_diners() == 30
						&& aux.get_turn() == 40 && aux.get_tableID().equals("1000000")) {
					assertEquals(0, aux.get_reservationID());
					assertEquals("13:30", aux.get_reservation_hour());
					assertEquals(30, aux.get_diners());
					assertEquals(40, aux.get_turn());
					assertEquals(1000000, aux.get_tableID());
					return;
				}
			}
			fail("Test failed");
		} else {
			fail("Test failed");
		}

	}

	@Test // (timeout = 1000) @Skip
	public void readTC5() {
		list = r._reservationDAO.read();
		if (list != null) {
			while (!list.isEmpty()) {
				aux = list.remove();

				if (aux.get_reservationID() == 1000000 && aux.get_reservation_hour().equals("16:45")
						&& aux.get_diners() == 0 && aux.get_turn() == 0 && aux.get_tableID().equals("-10")) {
					assertEquals(1000000, aux.get_reservationID());
					assertEquals("16:45", aux.get_reservation_hour());
					assertEquals(0, aux.get_diners());
					assertEquals(0, aux.get_turn());
					assertEquals(-10, aux.get_tableID());
					return;
				}
			}
			fail("Test failed");
		} else {
			fail("Test failed");
		}

	}

	@Test // (timeout = 1000) @Skip
	public void readTC6() {
		list = r._reservationDAO.read();
		if (list != null) {
			while (!list.isEmpty()) {
				aux = list.remove();

				if (aux.get_reservationID() == -20 && aux.get_reservation_hour().equals("22:15")
						&& aux.get_diners() == -6 && aux.get_turn() == 3 && aux.get_tableID().equals("10")) {
					assertEquals(-20, aux.get_reservationID());
					assertEquals("22:15", aux.get_reservation_hour());
					assertEquals(6, aux.get_diners());
					assertEquals(3, aux.get_turn());
					assertEquals(10, aux.get_tableID());
					return;
				}
			}
			fail("Test failed");
		} else {
			fail("Test failed");
		}

	}

	@Test // (timeout = 1000) @Skip
	public void readTC7() {
		list = r._reservationDAO.read();
		if (list != null) {
			while (!list.isEmpty()) {
				aux = list.remove();

				if (aux.get_reservationID() == 20 && aux.get_reservation_hour().equals("22:45")
						&& aux.get_diners() == 1000000 && aux.get_turn() == 1000000 && aux.get_tableID().equals("0")) {
					assertEquals(20, aux.get_reservationID());
					assertEquals("25:30", aux.get_reservation_hour());
					assertEquals(1000000, aux.get_diners());
					assertEquals(1000000, aux.get_turn());
					assertEquals(0, aux.get_tableID());
					return;
				}
			}
			fail("Test failed");
		} else {
			fail("Test failed");
		}

	}

	@Test // (timeout = 1000) @Skip
	public void readTC8() {
		list = r._reservationDAO.read();
		if (list != null) {
			while (!list.isEmpty()) {
				aux = list.remove();

				if (aux.get_reservationID() == 0 && aux.get_reservation_hour().equals("09:00")
						&& aux.get_diners() == -30 && aux.get_turn() == -40 && aux.get_tableID().equals("1000000")) {
					assertEquals(0, aux.get_reservationID());
					assertEquals("09:00", aux.get_reservation_hour());
					assertEquals(-30, aux.get_diners());
					assertEquals(-40, aux.get_turn());
					assertEquals(1000000, aux.get_tableID());
					return;
				}
			}
			fail("Test failed");
		} else {
			fail("Test failed");
		}

	}

	@Test // (timeout = 1000) @Skip
	public void readTC9() {
		list = r._reservationDAO.read();
		if (list != null) {
			while (!list.isEmpty()) {
				aux = list.remove();

				if (aux.get_reservationID() == 1000000 && aux.get_reservation_hour().equals("12:30")
						&& aux.get_diners() == -30 && aux.get_turn() == -40 && aux.get_tableID().equals("-10")) {
					assertEquals(1000000, aux.get_reservationID());
					assertEquals("12:30", aux.get_reservation_hour());
					assertEquals(3, aux.get_diners());
					assertEquals(2, aux.get_turn());
					assertEquals(-10, aux.get_tableID());
					return;
				}
			}
			fail("Test failed");
		} else {
			fail("Test failed");
		}

	}

	@Test // (timeout = 1000) @Skip
	public void readTC10() {
		list = r._reservationDAO.read();
		if (list != null) {
			while (!list.isEmpty()) {
				aux = list.remove();

				if (aux.get_reservationID() == -20 && aux.get_reservation_hour().equals("15:00")
						&& aux.get_diners() == -30 && aux.get_turn() == -40 && aux.get_tableID().equals("10")) {
					assertEquals(-20, aux.get_reservationID());
					assertEquals("15:00", aux.get_reservation_hour());
					assertEquals(30, aux.get_diners());
					assertEquals(40, aux.get_turn());
					assertEquals(10, aux.get_tableID());
					return;
				}
			}
			fail("Test failed");
		} else {
			fail("Test failed");
		}

	}

	@Test // (timeout = 1000) @Skip
	public void readTC11() {
		list = r._reservationDAO.read();
		if (list != null) {
			while (!list.isEmpty()) {
				aux = list.remove();

				if (aux.get_reservationID() == 20 && aux.get_reservation_hour().equals("20:45")
						&& aux.get_diners() == -30 && aux.get_turn() == -40 && aux.get_tableID().equals("0")) {
					assertEquals(20, aux.get_reservationID());
					assertEquals("20:45", aux.get_reservation_hour());
					assertEquals(0, aux.get_diners());
					assertEquals(0, aux.get_turn());
					assertEquals(0, aux.get_tableID());
					return;
				}
			}
			fail("Test failed");
		} else {
			fail("Test failed");
		}

	}

	@Test // (timeout = 1000) @Skip
	public void readTC12() {
		list = r._reservationDAO.read();
		if (list != null) {
			while (!list.isEmpty()) {
				aux = list.remove();

				if (aux.get_reservationID() == 0 && aux.get_reservation_hour().equals("23:00")
						&& aux.get_diners() == -30 && aux.get_turn() == -40 && aux.get_tableID().equals("1000000")) {
					assertEquals(0, aux.get_reservationID());
					assertEquals("23:00", aux.get_reservation_hour());
					assertEquals(6, aux.get_diners());
					assertEquals(3, aux.get_turn());
					assertEquals(1000000, aux.get_tableID());
					return;
				}
			}
			fail("Test failed");
		} else {
			fail("Test failed");
		}

	}

}
