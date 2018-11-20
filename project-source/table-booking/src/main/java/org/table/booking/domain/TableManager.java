package org.table.booking.domain;

public class TableManager {

	public static Table make_reservation(int turn, int hour) {
		Table[] freetables = show_table_state();
		if (freetables == null) {
			return null;
		} else {
			freetables[0].setState("reserved");
			freetables[0].setReserved_hour(hour);
			if (mark_table_state(freetables[0]) > -1) {
				return freetables[0];
			} else {
				return null;
			}

		}
	}

	public void cancel_reservation() {
		throw new UnsupportedOperationException();
	}

	public static Table assing_table(String resID) {
		Table t = new Table();
		t.setReservationID(resID);
		t._tableDAO.read(t);
		if (t.reserved_hour().getTime() < System.currentTimeMillis()) {
			t.setState("busy");
			t.setReserved_hour((System.currentTimeMillis() / 1000 / 60));
			mark_table_state(t);
		} else if ((System.currentTimeMillis() - t.reserved_hour().getTime()) > (20 * 60 * 1000)) {
			t.setState("free");
			t.setReserved_hour(0);
			mark_table_state(t);
			return null;
		}
		return t;
	}

	public void show_turns() {
		throw new UnsupportedOperationException();
	}

	public static int mark_table_state(Table t) {
		return t._tableDAO.update(t);
	}

	public static Table[] show_table_state() {

		return null;
	}
}