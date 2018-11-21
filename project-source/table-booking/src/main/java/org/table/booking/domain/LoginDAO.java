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
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read("SELECT * WHERE user=" + aI.user() + " & password=" + aI.pass() + ";");
			while (resultado.next()) {
				aI.setUser(resultado.getString("User"));
				aI.setPass(resultado.getString("Password"));
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return -1;
		}
		return 0;
	}
}