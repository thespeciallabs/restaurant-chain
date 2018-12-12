package org.table.booking.domain;

import java.sql.ResultSet;
import java.util.LinkedList;

import org.table.booking.persistence.DBBroker;

public class LoginDAO {
	public Login _login;
	private LinkedList<Login> loginList;

	public LoginDAO() {

	}

	public int read(Login aI) {
		int count = 0;
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read("SELECT * FROM login WHERE user1='" + aI.user() + "' and pass='" + aI.pass() + "';");
			while (resultado.next()) {
				count++;
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return -1;
		}
		if (count > 0) {
			return 0;
		} else {
			return -1;
		}
	}
}