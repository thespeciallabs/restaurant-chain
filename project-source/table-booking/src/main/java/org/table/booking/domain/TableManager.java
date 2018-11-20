package org.table.booking.domain;

public class TableManager {

	public void make_reservation() {
		throw new UnsupportedOperationException();
	}

	public void cancel_reservation() {
		throw new UnsupportedOperationException();
	}

	public static Table assing_table(String resID) {
		Table t = new Table();
		String state;
		t.setReservationID(resID);
		t._tableDAO.read(t);
		if (t.reserved_hour().getTime() < System.currentTimeMillis()) {
			state = "busy";
			mark_table_state(state, t);
		} else if ((System.currentTimeMillis() - t.reserved_hour().getTime()) > (20 * 60 * 1000)) {
			state = "free";
			mark_table_state(state, t);
			return null;
		}
		return t;
	}

	public void show_turns() {
		throw new UnsupportedOperationException();
	}

	public static void mark_table_state(String state, Table t) {
		t.setState(state);
	}

	public void show_table_state() {
		throw new UnsupportedOperationException();
	}
}