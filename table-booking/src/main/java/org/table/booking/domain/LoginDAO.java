package org.table.booking.domain;

import java.sql.ResultSet;
import org.table.booking.persistence.DBBroker;

/*********************************************************************
*
* Class Name: LoginDAO
* Author/s name: 
* 				 @author Sergio Herrera Piqueras
* 				 @author Juan Mena Patón
* 				 @author Pablo Rodríguez Solera 
* 				 @author Daniel Martínez Santiago.
* Release/Creation date: 25/12/2018
* Class version: 
* 				 @version 1.0
* Class description: This class implements all the operations related to "Login.java", that is our login object, 
* 					 and the database. We have only the read operation, because the other CRUD operations are not necessary.
*
**********************************************************************
*/
public class LoginDAO {
	private Login _login;

	/**
	 *  Empty Constructor.
	 */
	public LoginDAO() {

	}

	/**
	 * @return - Login object.
	 */
	public final Login get_login() {
		return _login;
	}

	/**
	 * @param _login - Login object.
	 */
	public final void set_login(final Login _login) {
		this._login = _login;
	}

	/*********************************************************************
	*
	* Method name: read
	*
	* Name of the original author (if the module author is different
	* than the author of the file): The authors do not change.
	*
	* Description of the Method: The method checks if the user and password information introduced
	* 							 is the same that the stored in the Database.
	*
	* Calling arguments:
	* 
	* @param aI - The Login object created with the information introduced by the user on IU_Login.
	*
	* Return value:
	*
	* @return 0  - If the operation has been executed successfully.
	* @return -1 - If there was some kind of error during the login process.
	*
	* Required Files: 
	* 
	* None.
	*
	* List of Checked Exceptions and an indication of when each exception
	* is thrown.
	*
	* @throws Exception - If there was an error with the Database.
	*********************************************************************/
	public final int read(final Login aI) {
		int count = 0;
		final String sql = String.format(
				"SELECT * FROM login WHERE user1='%s' and pass='%s';",
				aI.user(), aI.pass());
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
