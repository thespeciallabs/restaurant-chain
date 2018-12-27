package org.table.booking.domain;

import java.sql.ResultSet;
import java.util.LinkedList;

import org.table.booking.persistence.DBBroker;

/*********************************************************************
 *
 * Class Name: ReservationDAO Author/s name:
 *
 * @author Sergio Herrera Piqueras
 * @author Juan Mena Patón
 * @author Pablo Rodríguez Solera
 * @author Daniel Martínez Santiago. Release/Creation date:
 *         25/12/2018 Class version:
 * @version 1.0 Class description: This class implements all
 *          the operations related to "Reservation.java",
 *          that is our table object, and the database. We
 *          have the CRUD operations, with some "Read"
 *          operations modification.
 *
 **********************************************************************
 */
public class ReservationDAO {
	private LinkedList<Reservation> _reservationList = 
			new LinkedList<Reservation>();
	private Reservation _reservation;

	/**
	 * @return - The reservation object.
	 */
	public final Reservation get_reservation() {
		return _reservation;
	}

	/**
	 * @param _reservation - The reservation object.
	 */
	public final void set_reservation(
			final Reservation _reservation) {
		this._reservation = _reservation;
	}

	/**
	 * @return - The list of reservations.
	 */
	public final LinkedList<Reservation> get_reservationList() {
		return _reservationList;
	}

	/**
	 * @param _reservationList - The list of reservations.
	 */
	public final void set_reservationList(
			final LinkedList<Reservation> _reservationList) {
		this._reservationList = _reservationList;
	}

	/*********************************************************************
	 *
	 * Method name: delete
	 *
	 * Name of the original author (if the module author is
	 * different than the author of the file): The authors
	 * do not change.
	 *
	 * Description of the Method: The method removes a
	 * Reservation object with the information provided by
	 * the user.
	 *
	 * Calling arguments:
	 *
	 * @param aR - The reservation object that the user
	 *           wants to delete.
	 *
	 *           Return value:
	 *
	 * @return -1 - If the delete operation failed and did
	 *         not complete.
	 * 		   0 - If the operation was correct.
	 *
	 *         Required Files:
	 *
	 *         None.
	 *
	 *         List of Checked Exceptions and an indication
	 *         of when each exception is thrown.
	 *
	 * @throws Exception e - If there is any kind of failure
	 *                   with the information that we need
	 *                   to delete.
	 *********************************************************************/
	public final int delete(final Reservation aR) {
		final String sql = String.format(
				"DELETE FROM reservation "
				+ "WHERE reservationID= %d;",
				aR.get_reservationID());
		try {
			DBBroker.getAgente().delete(sql);

		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	/*********************************************************************
	 *
	 * Method name: insert
	 *
	 * Name of the original author (if the module author is
	 * different than the author of the file): The authors
	 * do not change.
	 *
	 * Description of the Method: The method creates a
	 * Reservation object with the information provided by
	 * the user, in order to add it to the Database.
	 *
	 * Calling arguments:
	 *
	 * @param aR - The reservation object that the user
	 *           wants to add to the Database.
	 *
	 *           Return value:
	 *
	 * @return -1 - If the create operation failed and did
	 *         not complete.
	 * 		   0 - If the operation was correct.
	 *
	 *         Required Files:
	 *
	 *         None.
	 *
	 *         List of Checked Exceptions and an indication
	 *         of when each exception is thrown.
	 *
	 * @throws Exception e - If there is any kind of failure
	 *                   with the information that we need
	 *                   to add.
	 *********************************************************************/
	public final int insert(final Reservation aR) {
		final String sql = String.format(
				"INSERT INTO reservation(tableID,reservation_hour"
				+ ",diners,turn) VALUES('%s','%s',%d,%d);",
				aR.get_tableID(), aR.get_reservation_hour(),
				aR.get_diners(), aR.get_turn());
		try {
			DBBroker.getAgente().create(sql);

		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	/*********************************************************************
	 *
	 * Method name: read
	 *
	 * Name of the original author (if the module author is
	 * different than the author of the file): The authors
	 * do not change.
	 *
	 * Description of the Method: The method checks if a
	 * Reservation object with the information introduced by
	 * the user already exists in the Database.
	 *
	 * Calling arguments:
	 *
	 * @param aR - The reservation object that the user
	 *           created.
	 *
	 *           Return value:
	 *
	 * @return -1 - If the read operation failed and did not
	 *         complete.
	 * 		   0 - If the operation was correct.
	 *
	 *         Required Files:
	 *
	 *         None.
	 *
	 *         List of Checked Exceptions and an indication
	 *         of when each exception is thrown.
	 *
	 * @thows Exception e - If there is any kind of failure
	 *        with the Reservation object created.
	 *********************************************************************/
	public final int read(final Reservation aR) {
		final String sql = String.format(
				"SELECT * FROM reservation "
				+ "WHERE reservationID='%s';",
				aR.get_reservationID());
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read(sql);
			while (resultado.next()) {
				aR.set_tableID(
						resultado.getString("tableID"));
				aR.set_reservation_hour(resultado
						.getString("reservation_hour"));
				aR.set_diners(resultado.getInt("diners"));
				aR.set_turn(resultado.getInt("turn"));
				this._reservationList.add(aR);
			}
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	/*********************************************************************
	 *
	 * Method name: readTable
	 *
	 * Name of the original author (if the module author is
	 * different than the author of the file): The authors
	 * do not change.
	 *
	 * Description of the Method: The method checks the list
	 * of reservations corresponding to a particular Table
	 * object, given it's ID.
	 *
	 * Calling arguments:
	 *
	 * @param tableID - The ID of the Table object that the
	 *                user wants to consult.
	 *
	 *                Return value:
	 *
	 * @return -1 - If the read operation failed and did not
	 *         complete.
	 * 		   0 - If the operation was correct.
	 *
	 *         Required Files:
	 *
	 *         None.
	 *
	 *         List of Checked Exceptions and an indication
	 *         of when each exception is thrown.
	 *
	 * @throws Exception e - If there is any kind of failure
	 *                   with the Id of the Table.
	 *********************************************************************/
	public final int readTable(final String tableID) {
		final String sql = String.format(
				"SELECT * FROM reservation WHERE tableID='%s';",
				tableID);
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read(sql);
			while (resultado.next()) {
				Reservation r = new Reservation(
						resultado.getInt("reservationID"),
						resultado.getString("tableID"),
						resultado.getString(
								"reservation_hour"),
						resultado.getInt("diners"),
						resultado.getInt("turn"));
				this._reservationList.add(r);
			}
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	/*********************************************************************
	 *
	 * Method name: read
	 *
	 * Name of the original author (if the module author is
	 * different than the author of the file): The authors
	 * do not change.
	 *
	 * Description of the Method: The method returns the
	 * list of all the reservations that the users have
	 * created.
	 *
	 * Calling arguments:
	 *
	 * None.
	 *
	 * Return value:
	 *
	 * @return -1 - If the read operation failed and did not
	 *         complete.
	 * 		   0 - If the operation was correct.
	 *
	 *         Required Files:
	 *
	 *         None.
	 *
	 *         List of Checked Exceptions and an indication
	 *         of when each exception is thrown.
	 *
	 * @throws Exception e - If there is any kind of failure
	 *                   with the information.
	 *********************************************************************/
	public final LinkedList<Reservation> read() {
		LinkedList<Reservation> aux = new LinkedList<>();
		final String sql = String
				.format("SELECT * FROM reservation ;");
		try {
			ResultSet resultado = DBBroker.getAgente()
					.read(sql);
			while (resultado.next()) {
				Reservation r = new Reservation(
						resultado.getInt("reservationID"),
						resultado.getString("tableID"),
						resultado.getString(
								"reservation_hour"),
						resultado.getInt("diners"),
						resultado.getInt("turn"));
				aux.add(r);
			}
		} catch (Exception e) {
			return null;
		}
		return aux;
	}

}
