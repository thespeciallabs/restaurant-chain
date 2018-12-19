package org.table.booking.presentation;

import java.util.Scanner;

import org.table.booking.domain.Login;

public class IU_Login {
	public static void main(String[] args) {
		while (start() == -1) {
			start();
		}
	}

	public static int start() {
		Scanner read = new Scanner(System.in,"UTF-8");
		String name, pass;
		Login login;

		System.out.println("\n-- LOGIN --");
		System.out.print("-- Write your Name/ID: ");
		name = read.next();
		System.out.print("-- Now your pass: ");
		pass = read.next();
		System.out.println("\n-- \tChecking credentials...\t --");
		login = new Login(name, pass);
		if (login.check_credentials()) {
			System.out.println("\n-- Welcome " + login.user() + "! --");
			return 0;
		} else {
			System.out.println("\n-- ERROR: Incorrect credentials, try again. --");
			return -1;
		}
	}
}