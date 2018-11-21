package org.table.booking.presentation;

import java.util.LinkedList;
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
			break;
		case 2:
			opt_2();
			break;
		case 3:
			opt_3();
			break;
		}
		return 0;
	}

	private static void opt_1() {
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

	private static void opt_2() {
		Scanner read = new Scanner(System.in);
		int turn;
		int hour;
		Table t = new Table();
		System.out.print("\n-- Tell me the turn (lunch(1) or dinner(2)): ");
		turn = read.nextInt();
		while (turn > 3 || turn < 1) {
			System.out.print("\n-- Please type a valid turn (lunch(1) or dinner(2)): ");
			turn = read.nextByte();
		}
		System.out.print(
				"\n-- Tell me your desired hour (from 9h to 12h for breakfast, from 12h to 15h for lunch and from 20h to 23h for dinner): ");
		hour = read.nextByte();
		if (turn == 1) {
			while (hour < 9 || hour > 12) {
				System.out.print("\n-- Tell me a valid hour (from 9h to 12h for breakfast, only o'clock hours): ");
				hour = read.nextByte();
			}
		} else if (turn == 2) {
			while (hour < 12 || hour > 16) {
				System.out.print("\n-- Tell me a valid hour (from 12h to 15h for lunch, only o'clock hours): ");
				hour = read.nextByte();
			}
		} else if (turn == 3) {
			while (hour < 20 || hour > 23) {
				System.out.print("\n-- Tell me a valid hour (from 20h to 23h for dinner, only o'clock hours): ");
				hour = read.nextByte();
			}
		}
		t = TableManager.make_reservation(turn, hour);
		if (t == null) {
			System.out.println("\n-- There is no tables available for this turn.");
			menu();
		} else {
			System.out.println("\n-- OK. You reserved a table for this turn.");
			menu();
		}

	}

	private static void opt_3() {
		System.out.print("\n-- Showing the state of the tables... ");
		LinkedList<Table> aux = TableManager.show_table_state();
		for (int i = 0; i < aux.size(); i++) {
			System.out.println(aux.get(i).toString());
		}
	}
}
