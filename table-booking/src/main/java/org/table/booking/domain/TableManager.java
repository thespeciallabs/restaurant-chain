package org.table.booking.domain;

import java.util.LinkedList;

public class TableManager {

	public static Table make_reservation(int turn, int hour) {
		LinkedList<Table> freetables = new LinkedList<>();
		LinkedList<Table> aux = show_table_state();
		for (int i = 0; i < aux.size(); i++) {
			if (aux.get(i).state().equals("free")) {
				freetables.add(aux.get(i));
			}
		}

		Table free = freetables.getFirst();
		free.setState("reserved");
		free.setReserved_hour(hour);
		if (mark_table_state(free) > -1) {
			return free;
		} else {
			return null;
		}
	}

	public void cancel_reservation() {
		throw new UnsupportedOperationException();
	}

	public static Table assing_table(String resID) {
		Table t = new Table();
		t.setReservationID(resID);
		if (t._tableDAO.read(t) == -1) {
			return null;
		} else {
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
		}

		return t;
	}

	public static LinkedList<Table> show_turns() {
		return show_table_state();
	}

	public static int mark_table_state(Table t) {
		return t._tableDAO.update(t);
	}

	public static LinkedList<Table> show_table_state() {
		Table t = new Table();
		LinkedList<Table> aux = new LinkedList<>();
		if ((aux = t._tableDAO.read()) != null) {
			return aux;
		} else {
			return null;
		}
	}
}