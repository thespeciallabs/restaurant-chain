package org.table.booking;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Reservation;
import org.table.booking.domain.Table;

public class TableDAOReadWTableTest {

	private Table table;
	private LinkedList<Table> list;
	private Reservation r;

	@Before
	public void before() {
		table = new Table();
		list = new LinkedList<>();
		r = new Reservation();
	}

	@Test // (timeout = 1000) @Skip
	public void readWTableTC1() {

	}

}
