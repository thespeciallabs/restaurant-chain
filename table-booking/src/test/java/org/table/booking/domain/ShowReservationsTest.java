package org.table.booking.domain;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Reservation;
import org.table.booking.domain.Table;
import org.table.booking.domain.TableManager;

public class ShowReservationsTest {

	private LinkedList<Reservation> list;
	private Table t;
	private String tableID;

	@Before
	public void before() {
		list = new LinkedList<>();
		t = new Table();
		tableID = "";
	}

	@Test // (timeout = 1000) @Skip
	public void showTableStateTC1() {
		tableID = "-5";
		list = TableManager.show_reservations(tableID);
		assertNull(list);
	}

	@Test // (timeout = 1000) @Skip
	public void showTableStateTC2() {
		tableID = "2";
		list = TableManager.show_reservations(tableID);
		assertNotNull(list);
	}

	@Test // (timeout = 1000) @Skip
	public void showTableStateTC3() {
		tableID = "0";
		list = TableManager.show_reservations(tableID);
		assertNull(list);
	}

}
