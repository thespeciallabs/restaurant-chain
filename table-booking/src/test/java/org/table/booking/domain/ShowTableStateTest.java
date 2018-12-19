package org.table.booking.domain;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Table;
import org.table.booking.domain.TableManager;

public class ShowTableStateTest {

	private LinkedList<Table> list;

	@Before
	public void before() {
		list = new LinkedList<>();
	}

	@Test // (timeout = 1000) @Skip
	public void showTableStateTC1() {
		list = TableManager.show_table_state();
		assertNull(list);
	}

	@Test // (timeout = 1000) @Skip
	public void showTableStateTC2() {
		list = TableManager.show_table_state();
		assertNotNull(list);
	}

}
