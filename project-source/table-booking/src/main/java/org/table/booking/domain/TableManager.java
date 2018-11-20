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

	public static LinkedList<Table> show_table_state() {
		Table t = new Table();
		LinkedList<Table> aux = new LinkedList<>();
		if (t._tableDAO.read(t) > 0) {
			for (int i = 0; i < t._tableDAO._tableList.size(); i++) {
				aux.add(t._tableDAO._tableList.get(i));
			}
		}
		return aux;
	}
}