package es.thespeciallabs.iso2.restaurant_chain.domain;

import es.thespeciallabs.iso2.restaurant_chain.persistence.DBBroker;

public class LoginDAO {
	public Login _login;

	public int read(Login aI) {
		try {
			DBBroker.getAgente().read("SELECT * WHERE user=" + aI.user() + " & password=" + aI.pass() + ";");
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}
}