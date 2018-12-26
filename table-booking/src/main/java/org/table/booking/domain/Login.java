package org.table.booking.domain;
/*********************************************************************
*
* Class Name: Login
* Author/s name: 
* 				 @author Sergio Herrera Piqueras
* 				 @author Juan Mena Patón
* 				 @author Pablo Rodríguez Solera 
* 				 @author Daniel Martínez Santiago.
* Release/Creation date: 25/12/2018
* Class version: 
* 				 @version 1.0
* Class description: This class creates a login object, that will contain the parameters for the login process
* 					 as final private variables.
*
**********************************************************************
*/
public class Login {
	private String _user;
	private String _pass;
	private LoginDAO _loginDAO = new LoginDAO();

	/**
	 * @param _user
	 * @param _pass
	 */
	public Login(final String _user, final String _pass) {
		super();
		this._user = _user;
		this._pass = _pass;
	}

	/**
	 * @return
	 */
	public final LoginDAO get_loginDAO() {
		return _loginDAO;
	}

	/**
	 * @param _loginDAO
	 */
	public final void set_loginDAO(
			final LoginDAO _loginDAO) {
		this._loginDAO = _loginDAO;
	}

	/**
	 * 
	 */
	public Login() {
		super();
	}

	public final String user() {
		return _user;
	}

	public final void setUser(final String _user) {
		this._user = _user;
	}

	public final String pass() {
		return _pass;
	}

	public final void setPass(final String _pass) {
		this._pass = _pass;
	}

	public final LoginDAO loginDAO() {
		return _loginDAO;
	}

	public final void setLoginDAO(
			final LoginDAO _loginDAO) {
		this._loginDAO = _loginDAO;
	}

	public final boolean check_credentials() {
		if (this._loginDAO.read(this) == 0) {
			return true;
		}
		return false;
	}
}
