package org.table.booking.domain;

/*********************************************************************
*
* Class Name: Reservation
* Author/s name: 
* 				 @author Sergio Herrera Piqueras
* 				 @author Juan Mena Patón
* 				 @author Pablo Rodríguez Solera 
* 				 @author Daniel Martínez Santiago.
* Release/Creation date: 25/12/2018
* Class version: 
* 				 @version 1.0
* Class description: This class holds all the parameters of our "Reservation" object.
*
**********************************************************************
*/
public class Reservation {
	private int _reservationID;
	private String _tableID;
	private int _turn;
	private int _diners;
	private String _reservation_hour;

	private ReservationDAO _reservationDAO = new ReservationDAO();

	/**
	 * @param _reservationID - The unique ID of the Reservation object.
	 * @param _tableID - The ID of the Table object that is related with the Reservation.
	 * @param _reservation_hour - The hour when the reservation is committed.
	 * @param _diners - The number of diners that are going to assist.
	 * @param _turn - The turn of the diners.
	 */
	public Reservation(final int _reservationID,
			final String _tableID,
			final String _reservation_hour,
			final int _diners, final int _turn) {
		super();
		this._reservationID = _reservationID;
		this._tableID = _tableID;
		this._turn = _turn;
		this._diners = _diners;
		this._reservation_hour = _reservation_hour;
	}

	/**
	 *  Empty constructor.
	 */
	public Reservation() {

	}

	/**
	 * @return - The ReservationDAO object.
	 */
	public final ReservationDAO get_reservationDAO() {
		return _reservationDAO;
	}

	/**
	 * @param _reservationDAO - The ReservationDAO object.
	 */
	public final void set_reservationDAO(
			final ReservationDAO _reservationDAO) {
		this._reservationDAO = _reservationDAO;
	}

	/**
	 * @return - The unique ID of the Reservation object.
	 */
	public final int get_reservationID() {
		return _reservationID;
	}

	/**
	 * @param _reservationID - The unique ID of the Reservation object.
	 */
	public final void set_reservationID(
			final int _reservationID) {
		this._reservationID = _reservationID;
	}

	/**
	 * @return - The ID of the Table object that is related with the Reservation.
	 */
	public final String get_tableID() {
		return _tableID;
	}

	/**
	 * @param _tableID - The ID of the Table object that is related with the Reservation.
	 */
	public final void set_tableID(final String _tableID) {
		this._tableID = _tableID;
	}

	/**
	 * @return - The turn of the diners.
	 */
	public final int get_turn() {
		return _turn;
	}

	/**
	 * @param _turn - The turn of the diners.
	 */
	public final void set_turn(final int _turn) {
		this._turn = _turn;
	}

	/**
	 * @return - The number of diners that are going to assist.
	 */
	public final int get_diners() {
		return _diners;
	}

	/**
	 * @param _diners - The number of diners that are going to assist.
	 */
	public final void set_diners(final int _diners) {
		this._diners = _diners;
	}

	/**
	 * @return - The hour when the reservation is committed.
	 */
	public final String get_reservation_hour() {
		return _reservation_hour;
	}

	/**
	 * @param _reservation_hour - The hour when the reservation is committed.
	 */
	public final void set_reservation_hour(
			final String _reservation_hour) {
		this._reservation_hour = _reservation_hour;
	}

}
