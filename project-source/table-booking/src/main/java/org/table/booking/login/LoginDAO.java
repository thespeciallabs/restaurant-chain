package org.table.booking.login;

public class LoginDAO {
	public Login _login;

	public LoginDAO() {

	}

	public int read(Login aI) {
		try {
			DBBroker.getAgente().read("SELECT * WHERE user=" + aI.user() + " & password=" + aI.pass() + ";");
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}
}