package org.table.booking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.table.booking.domain.Login;

public class LoginDAOreadTest {

	private Login l;

	@Before
	public void before() {
		l = new Login();
	}

	@Test // (timeout = 1000) @Skip
	public void readTC1() {
		l.setUser(null);
		l.setPass(null);
		assertEquals(-1, l._loginDAO.read(l));
	}

	@Test // (timeout = 1000) @Skip
	public void readTC2() {
		l.setUser("mandre");
		l.setPass("123");
		assertEquals(0, l._loginDAO.read(l));
	}

	@Test // (timeout = 1000) @Skip
	public void readTC3() {
		l.setUser(null);
		l.setPass(null);
		assertEquals(0, l._loginDAO.read(l));
	}

}
