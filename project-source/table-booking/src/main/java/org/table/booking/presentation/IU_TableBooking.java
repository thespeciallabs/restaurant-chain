package org.table.booking.presentation;

import java.util.Scanner;

import org.table.booking.domain.Table;
import org.table.booking.domain.TableManager;

public class IU_TableBooking {
	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		Scanner menu = new Scanner(System.in);
		byte opt = 0;
		System.out.println("-- CHOOSE AN OPTION --\n");
		System.out.println("-- 1. Assign a table --");
		System.out.println("-- 2. Attend a booking petition --");
		System.out.println("-- 3. Mark table state --");
		System.out.println("-- 4. Show tables state --");
		System.out.println("-- 5. Show turns --");
		try {
			System.out.print("Your option: ");
			opt = menu.nextByte();
			if (opt > 5 || opt < 1) {
				throw new Exception();
			} else {
				start(opt);
			}
		} catch (Exception e) {
			System.out.println("Please, choose a valid option");
			menu();
		}
	}

	public static int start(byte opt) {

		switch (opt) {
		case 1:
			opt_1();
		}

		return 0;
	}

	public static void opt_1() {
		Scanner read = new Scanner(System.in);
		System.out.print("\n-- Tell me the reservation ID of the table: ");
		Table t = new Table();
		String resID = read.next();
		t = TableManager.assing_table(resID);
		if (t == null) {
			System.out.println("-- Your reservation was cancelled");
			menu();
		} else {
			System.out.println("-- Your table [" + t.ID() + "] is ready.");
			menu();
		}
	}
}
