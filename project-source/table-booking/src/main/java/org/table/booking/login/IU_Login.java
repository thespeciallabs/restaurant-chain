package org.table.booking.login;

import java.util.Scanner;

public class IU_Login {
	public static void main(String[] args) {
		System.out.println("-----\tRestaurant Chain Manager.\t(v0.0.1)\t-----");
		while (start() == -1) {
			start();
		}
	}

	public static int start() {
		Scanner read = new Scanner(System.in);
		String name, pass;
		Login login = new Login();

		System.out.println("\n-- LOGIN --");
		System.out.print("-- Write your Name/ID: ");
		name = read.next();
		System.out.print("-- Now your pass: ");
		pass = read.next();
		System.out.println("\n-- \tChecking credentials...\t --");
		login = new Login(name, pass);
		if (login.check_credentials()) {
			System.out.println("\n-- Welcome " + login.user() + "! --");
		} else {
			System.out.println("\n-- ERROR: Incorrect credentials, try again. --");
			return -1;
		}

		return 0;
	}
}