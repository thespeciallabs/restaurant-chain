package org.table.booking.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TableManager {

	public static Table make_reservation(int turn,
			String hour, int diners) {
		Reservation r = new Reservation();
		r.set_reservation_hour(hour);
		r.set_diners(diners);
		r.set_turn(turn);
		LinkedList<Table> freetables = show_free_table_state(
				r);
		Table free;
		try {
			free = freetables.removeFirst();
		} catch (NoSuchElementException e) {
			return null;
		}
		free.setState("reserved");

		mark_table_state(free);
		r.set_tableID(free.ID());
		createReservation(r);
		return free;
	}

	private static void createReservation(Reservation r) {
		r.get_reservationDAO().insert(r);
	}

	public void cancel_reservation() {
		throw new UnsupportedOperationException();
	}

	public static Table assing_table(int resID) {
		Table t = new Table();
		Reservation r = new Reservation();
		r.set_reservationID(resID);
		if (r.get_reservationDAO().read(r) == -1) {
			return null;
		} else {
			t.setID(r.get_tableID());
			t.get_tableDAO().read(t);
			Calendar calendar = new GregorianCalendar();

			int s_hour = calendar.get(Calendar.HOUR_OF_DAY);
			int s_min = calendar.get(Calendar.MINUTE);
			String s_time = "";
			if (s_min < 10) {
				s_time = "" + s_hour + "0" + s_min;
			} else {
				s_time = "" + s_hour + s_min;
			}
			if (s_hour < 10) {
				s_time = "0" + s_time;
			}
			String r_time = "";

			try {
				r_time = r.get_reservation_hour()
						.substring(0, 2)
						+ r.get_reservation_hour()
								.substring(3, 5);
			} catch (NullPointerException e) {
				return null;
			}
			if (Integer.parseInt(r_time) >= Integer
					.parseInt(s_time)
					|| Integer.parseInt(s_time) - Integer
							.parseInt(r_time) < 20) {
				t.setState("busy");
				mark_table_state(t);
				r.get_reservationDAO().delete(r);
			} else {
				t.setState("free");
				r.get_reservationDAO().delete(r);
				mark_table_state(t);
				return null;
			}
		}

		return t;
	}

	public static LinkedList<Table> show_turns() {
		return show_table_state();
	}

	public static int mark_table_state(Table t) {
		return t.get_tableDAO().update(t);
	}

	public static LinkedList<Reservation> show_reservations(
			String tableID) {
		Reservation r = new Reservation();
		LinkedList<Reservation> aux;
		r.get_reservationDAO().readTable(tableID);
		aux = r.get_reservationDAO()
				.get_reservationList();
		if (aux!= null) {
			return aux;
		} else {
			return null;
		}
	}

	public static LinkedList<Table> show_table_state() {
		Table t = new Table();
		LinkedList<Table> aux;
		aux = t.get_tableDAO().read();
		if (aux != null) {
			return aux;
		} else {
			return null;
		}
	}

	public static LinkedList<Table> show_free_table_state(
			Reservation r) {
		Table t = new Table();
		LinkedList<Table> aux;
		aux = t.get_tableDAO().readFree(r);
		if (aux != null) {
			return aux;
		} else {
			return null;
		}
	}
}
