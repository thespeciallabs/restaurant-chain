package org.table.booking.domain;

import java.sql.ResultSet;
import java.util.LinkedList;

import org.table.booking.persistence.DBBroker;

public class LoginDAO {
	public Login _login;
	public LoginDAO() {

	}

	public int read(Login aI) {
		int count = 0;
		final String sql = String.format("SELECT * FROM login WHERE user1='%s' and pass='%s';",aI.user(),aI.pass());
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read(sql);
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