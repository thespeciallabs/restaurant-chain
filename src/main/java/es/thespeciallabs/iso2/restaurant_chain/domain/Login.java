package es.thespeciallabs.iso2.restaurant_chain.domain;

public class Login {
	private String _user;
	private String _pass;
	public LoginDAO _loginDAO;

	public String user() {
		return _user;
	}

	public void setUser(String _user) {
		this._user = _user;
	}

	public String pass() {
		return _pass;
	}

	public void setPass(String _pass) {
		this._pass = _pass;
	}

	public LoginDAO loginDAO() {
		return _loginDAO;
	}

	public void setLoginDAO(LoginDAO _loginDAO) {
		this._loginDAO = _loginDAO;
	}

	public boolean check_credentials() {
		if (this._loginDAO.read(this) == 0) {
			return true;
		}

		return false;
	}
}