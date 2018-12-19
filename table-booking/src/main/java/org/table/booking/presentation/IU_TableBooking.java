package org.table.booking.presentation;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import org.table.booking.domain.Reservation;
import org.table.booking.domain.Table;
import org.table.booking.domain.TableManager;
import org.table.booking.exceptions.WrongMenuException;

public class IU_TableBooking {
	public static void main(String[] args) {
		while (menu() == -1) {
			menu();
		}
	}

	public static int menu() {
		Scanner menu = new Scanner(System.in,"UTF-8");
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
				throw new WrongMenuException("Please, choose a valid option.");
			} else {
				start(opt);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	public static int start(byte opt) {

		switch (opt) {
		case 1:
			opt_1();
			break;
		case 2:
			while (opt_2() == -1) {
				menu();
			}
			break;
		case 3:
			opt_3();
			break;
		case 4:
			opt_4();
			break;
		case 5:
			opt_5();
			break;
		default:
			break;
		}
		return 0;
	}

	private static void opt_1() {
		Scanner read = new Scanner(System.in,"UTF-8");
		System.out.print("\n-- Tell me the reservation ID of the table: ");
		Table t;
		int resID = 0;
		try {
			resID = read.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("-- Please, insert a number.");
			menu();
		}

		t = TableManager.assing_table(resID);
		if (t == null) {
			System.out.println("-- There was an error with your reservation or it was cancelled.");
			menu();
		} else {
			System.out.println("-- Your table [" + t.ID() + "] is ready.");
			menu();
		}
	}

	static int opt_2() {
		Scanner read = new Scanner(System.in,"UTF-8");
		int turn = 0, diners = 0;
		String hour, min = "-1";
		Table t;
		System.out.print("\n-- Tell me the turn ((1), (2) or (3)): ");
		turn = read.nextInt();
		while (turn > 3 || turn < 1) {
			System.out.print("\n-- Please type a valid turn ((1), (2) or (3)): ");
			turn = read.nextByte();
		}
		System.out.print(
				"\n-- Tell me your desired hour (from 9h to 12h for breakfast, from 12h to 15h for lunch and from 20h to 23h for dinner): ");
		hour = read.next();
		if (turn == 1) {
			while (Integer.parseInt(hour) < 9 || Integer.parseInt(hour) > 12) {
				System.out.print("\n-- Tell me a valid hour (from 9h to 12h for breakfast, only o'clock hours): ");
				hour = read.next();
			}
			while (Integer.parseInt(min) < 0 || Integer.parseInt(min) > 59) {
				System.out.print("\n-- Tell me a valid minute (from 0 to 59): ");
				min = read.next();
			}
		} else if (turn == 2) {
			while (Integer.parseInt(hour) < 12 || Integer.parseInt(hour) > 16) {
				System.out.print("\n-- Tell me a valid hour (from 12h to 15h for lunch, only o'clock hours): ");
				hour = read.next();

			}
			while (Integer.parseInt(min) < 0 || Integer.parseInt(min) > 59) {
				System.out.print("\n-- Tell me a valid minute (from 0 to 59): ");
				min = read.next();
			}
		} else if (turn == 3) {
			while (Integer.parseInt(hour) < 20 || Integer.parseInt(hour) > 23) {
				System.out.print("\n-- Tell me a valid hour (from 20h to 23h for dinner, only o'clock hours): ");
				hour = read.next();
			}
			while (Integer.parseInt(min) < 0 || Integer.parseInt(min) > 59) {
				System.out.print("\n-- Tell me a valid minute (from 0 to 59): ");
				min = read.next();
			}
		}

		System.out.print("\n-- Tell me the number of diners: ");
		try {
			diners = read.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("-- Please, insert a number.");
			return -1;
		}

		t = TableManager.make_reservation(turn, hour + ":" + min, diners);
		if (t == null) {
			System.out.println("\n-- There is no tables available for this turn.");
			return -1;
		} else {
			System.out.println("\n-- OK. You reserved a table for this turn.");
			return 0;
		}

	}

	private static void opt_3() {
		Scanner read = new Scanner(System.in,"UTF-8");
		System.out.print("\n-- Showing the state of the tables... ");
		LinkedList<Table> aux = TableManager.show_table_state();
		if (aux != null) {
			for (int i = 0; i < aux.size(); i++) {
				System.out.println(aux.get(i).toString());
			}
			System.out.print("\n-- Select the ID of the table to change the state: ");

			String id = read.next();
			Table t = new Table(id);
			t._tableDAO.read(t);
			System.out.print("\n-- Tell me the state to mark: ");
			t.setState(read.next());
			if (TableManager.mark_table_state(t) == -1) {
				System.out.println("\n-- There was a problem changing the state.");
			} else {
				System.out.println("\n-- State changed!");
			}

		} else {
			System.out.println("\n-- There is no tables in the list.");
			menu();
		}
	}

	private static void opt_4() {
		System.out.print("\n-- Showing the state of the tables... ");
		LinkedList<Table> aux = TableManager.show_table_state();
		if (aux != null) {
			for (int i = 0; i < aux.size(); i++) {
				System.out.println(aux.get(i).toString());
			}
		} else {
			System.out.println("\n-- There is no tables in the list.");
			menu();
		}

	}

	private static void opt_5() {
		System.out.print("\n-- Showing the turns of the tables... ");
		LinkedList<Table> aux = TableManager.show_table_state();
		if (aux != null) {
			for (int i = 0; i < aux.size(); i++) {
				System.out.println(aux.get(i).toString());
				for (Table j : aux) {
					for (Reservation k : TableManager.show_reservations(j.ID())) {
						System.out.println(k.toString());
					}
				}
			}
		} else {
			System.out.println("\n-- There is no tables in the list.");
			menu();
		}

	}

}
