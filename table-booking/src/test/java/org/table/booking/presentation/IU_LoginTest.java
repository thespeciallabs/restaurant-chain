package org.table.booking.presentation;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

public class IU_LoginTest {

	@Test
	public void startTestTC1() {
		String input = "mandre 123";
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		assertEquals(0, IU_Login.start());
	}

	@Test
	public void startTestTC2() {
		String input = "user 5423";
		InputStream is = new ByteArrayInputStream(input.getBytes());
		System.setIn(is);
		assertEquals(-1, IU_Login.start());
	}

}
